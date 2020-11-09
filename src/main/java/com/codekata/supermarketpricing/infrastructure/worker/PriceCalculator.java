package com.codekata.supermarketpricing.infrastructure.worker;

import com.codekata.supermarketpricing.infrastructure.convert.ConvertCurrency;
import com.codekata.supermarketpricing.infrastructure.helper.CalculatePrice;
import com.codekata.supermarketpricing.infrastructure.promotion.ApplyPromotion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class PriceCalculator {
    @Autowired
    CalculatePrice calculatePrice;

    @Autowired
    ApplyPromotion applyPromotion;

    @Autowired
    ConvertCurrency convertCurrency;

    public Mono<Double> getTotal(double price, double numOfItems, String promoName, double x, double y, String converterName){
        return applyPromotion.getPromotionPrice(promoName, price, numOfItems, x, y)
                .map(promoPrice -> calculatePrice.calculatePrice(promoPrice, numOfItems))
                .doOnNext(promoPrice -> log.info("the promoprice is: {}", promoPrice))
                .map(totalPrice -> convertCurrency.getConvertedCurrency(converterName, totalPrice))
                .doOnError(error -> log.error("the error is: {}", error));
    }
}

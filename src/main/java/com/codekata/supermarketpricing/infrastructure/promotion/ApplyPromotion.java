package com.codekata.supermarketpricing.infrastructure.promotion;

import com.codekata.supermarketpricing.factory.PromotionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class ApplyPromotion {
    @Autowired
    private PromotionFactory promotionFactory;

    public Mono<Double> getPromotionPrice(String promoName, double price, double numOfItems, double x, double y){
        if(promoName.equalsIgnoreCase("na")) return Mono.just(price);
        promoName = "com.codekata.supermarketpricing.promotiontype." + promoName;
        return promotionFactory.getPromotion(promoName).promoPrice(price, numOfItems, x, y);
    }
}

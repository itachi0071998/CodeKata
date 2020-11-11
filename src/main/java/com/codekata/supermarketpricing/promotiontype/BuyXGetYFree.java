package com.codekata.supermarketpricing.promotiontype;

import com.codekata.supermarketpricing.interfaces.Promotions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
public class BuyXGetYFree implements Promotions {

    @Override
    public Mono<Double> promoPrice(double price, double numOfItems, double xItem, double yItem) {
        if (xItem >= numOfItems) return Mono.just(price);
        int freeUnits = (int) ((int) (numOfItems/(xItem+yItem))*yItem);
        return Mono.just((numOfItems*price - freeUnits*price));
    }

    @Override
    public Class getpromo() {
        return BuyXGetYFree.class;
    }
}

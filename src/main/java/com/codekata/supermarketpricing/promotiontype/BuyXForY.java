package com.codekata.supermarketpricing.promotiontype;

import com.codekata.supermarketpricing.interfaces.Promotions;
import reactor.core.publisher.Mono;

public class BuyXForY implements Promotions {
    @Override
    public Mono<Double> promoPrice(double price, double numOfItems, double x, double y) {
        if(numOfItems<x) return Mono.just(price);
        return Mono.just((((int) (numOfItems/x)) * y) + ((numOfItems - ((int) (numOfItems/x))*x) * price));
    }

    @Override
    public Class getpromo() {
        return BuyXForY.class;
    }
}

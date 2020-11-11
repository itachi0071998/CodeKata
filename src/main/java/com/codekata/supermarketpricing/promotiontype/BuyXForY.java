package com.codekata.supermarketpricing.promotiontype;

import com.codekata.supermarketpricing.interfaces.Promotions;
import reactor.core.publisher.Mono;

public class BuyXForY implements Promotions {
    @Override
    public Mono<Double> promoPrice(double price, double numOfItems, double x, double y) {
        if(numOfItems<x) return Mono.just(price);
        int offerUnits = (int) (numOfItems/x);
        double priceForOneUnit = ((offerUnits * y) + ((numOfItems - offerUnits*x) * price));
        return Mono.just(priceForOneUnit);
    }

    @Override
    public Class getpromo() {
        return BuyXForY.class;
    }
}

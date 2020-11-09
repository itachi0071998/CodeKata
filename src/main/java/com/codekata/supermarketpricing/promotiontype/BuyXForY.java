package com.codekata.supermarketpricing.promotiontype;

import com.codekata.supermarketpricing.interfaces.Promotions;
import reactor.core.publisher.Mono;

public class BuyXForY implements Promotions {
    @Override
    public Mono<Double> promoPrice(double price, double numOfItems, double x, double y) {
        return null;
    }

    @Override
    public Class getpromo() {
        return BuyXForY.class;
    }
}

package com.codekata.supermarketpricing.interfaces;


import reactor.core.publisher.Mono;

public interface Promotions {
    Mono<Double> promoPrice(double price, double numOfItems, double x, double y);

    Class getpromo();
}

package com.codekata.supermarketpricing.controller;

import com.codekata.supermarketpricing.infrastructure.worker.PriceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RequestMapping("/Price")
@RestController
public class PriceController {

    @Autowired
    private PriceCalculator priceCalculator;

    @PostMapping("/calulcatePrice")
    public Mono<ResponseEntity<String>> totalPrice(@RequestParam(value = "price") double price,
                                                       @RequestParam(value = "numOfItems") double numOfItems,
                                                       @RequestParam(value = "promo") String promoType,
                                                       @RequestParam(value = "x") double x,
                                                       @RequestParam(value = "y") double y,
                                                       @RequestParam(value = "currency") String currencyType){
        return priceCalculator.getTotal(price, numOfItems, promoType, x, y, currencyType)
                .map(result -> ResponseEntity.ok().body("Total Price is: " + result + "$"));
    }
}

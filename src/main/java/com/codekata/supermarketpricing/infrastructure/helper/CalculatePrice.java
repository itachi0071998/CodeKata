package com.codekata.supermarketpricing.infrastructure.helper;

import org.springframework.stereotype.Component;

@Component
public class CalculatePrice {
    public Double calculatePrice(double price, double numOfItems){
        return (price*numOfItems);
    }
}

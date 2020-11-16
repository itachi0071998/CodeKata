package com.codekata.supermarketpricing.infrastructure.convert;

import com.codekata.supermarketpricing.factory.ConverterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConvertCurrency {
    @Autowired
    private ConverterFactory converterFactory;

    public Double getConvertedCurrency(String currencyName, double price){
        if(currencyName.equalsIgnoreCase("dollar")) return price;
        currencyName = "com.codekata.supermarketpricing.convertertype." + currencyName +"ToDollar";
        return converterFactory.getWhichConverter(currencyName).convert(price);
    }
}

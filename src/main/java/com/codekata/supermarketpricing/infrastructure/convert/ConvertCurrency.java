package com.codekata.supermarketpricing.infrastructure.convert;

import com.codekata.supermarketpricing.factory.ConverterFactory;
import com.codekata.supermarketpricing.interfaces.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class ConvertCurrency {
    @Autowired
    private ConverterFactory converterFactory;

    public Double getConvertedCurrency(String currencyName, double price){
        if(currencyName.equalsIgnoreCase("dollar")) return price;
        currencyName = "com.codekata.supermarketpricing.convertertype." + currencyName +"ToDollar";
        Converter converter = converterFactory.getWhichConverter(currencyName);
        return converter.convert(price);
    }
}

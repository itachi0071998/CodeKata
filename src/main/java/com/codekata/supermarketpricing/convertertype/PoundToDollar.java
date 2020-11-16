package com.codekata.supermarketpricing.convertertype;

import com.codekata.supermarketpricing.interfaces.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class PoundToDollar implements Converter {
    @Override
    public Double convert(double price) {
        return price*1.99;
    }

    @Override
    public Class getConverter() {
        return PoundToDollar.class;
    }
}

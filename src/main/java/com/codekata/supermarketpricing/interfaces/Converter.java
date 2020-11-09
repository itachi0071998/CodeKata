package com.codekata.supermarketpricing.interfaces;

import reactor.core.publisher.Mono;

public interface Converter {
    Double convert(double price);

    Class getConverter();
}

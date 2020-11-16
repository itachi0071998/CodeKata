package com.codekata.karatechop.helper;

import reactor.core.publisher.Mono;

import java.util.ArrayList;

public interface Search {
    Mono<Integer> searchIndex(ArrayList<Integer> arr, Integer integerToFind);

    Class getSearch();
}

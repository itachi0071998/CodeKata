package com.codekata.karatechop.helper;

import reactor.core.publisher.Mono;

import java.util.List;

public interface Search {
    Mono<Integer> searchIndex(List<Integer> arr, Integer integerToFind);

    Class getSearch();
}

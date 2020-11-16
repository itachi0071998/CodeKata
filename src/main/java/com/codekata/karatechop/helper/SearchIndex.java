package com.codekata.karatechop.helper;

import com.codekata.karatechop.factory.SearchFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SearchIndex {
    @Autowired
    private SearchFactory searchFactory;

    public Mono<Integer> getIndex(List<Integer> arr, int integerToFind, String type){
        String searchName = "com.codekata.karatechop.searchtype." + type;
        return searchFactory.getSearch(searchName).searchIndex(arr, integerToFind);
    }
}

package com.codekata.karatechop.searchtype;

import com.codekata.karatechop.helper.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SimpleSearch implements Search {

    @Override
    public Mono<Integer> searchIndex(List<Integer> arr, Integer integerToFind) {
        for(int i = 0; i<arr.size(); i++){
            if(arr.get(i) == integerToFind) return Mono.just(i+1);
        }
        return Mono.just(-1);
    }

    @Override
    public Class getSearch() {
        return Search.class;
    }
}

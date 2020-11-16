package com.codekata.karatechop.searchtype;

import com.codekata.karatechop.helper.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


import java.util.List;


@Component
@RequiredArgsConstructor
public class BinarySearchType1 implements Search {
    @Override
    public Mono<Integer> searchIndex(List<Integer> arr, Integer integerToFind) {
        int l = 0;
        int r = arr.size()-1;
        while(r>l){
            if(arr.get((l+r)/2) == integerToFind) return Mono.just((l+r)/2 + 1);
            if(arr.get((l+r)/2)>integerToFind) r = (l+r)/2 - 1;
            if(arr.get((l+r)/2)<integerToFind) l = (l+r)/2 + 1;
        }
        return Mono.just(-1);
    }

    @Override
    public Class getSearch() {
        return BinarySearchType1.class;
    }
}

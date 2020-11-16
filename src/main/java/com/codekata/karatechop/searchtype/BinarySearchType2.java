package com.codekata.karatechop.searchtype;

import com.codekata.karatechop.helper.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BinarySearchType2 implements Search {
    @Override
    public Mono<Integer> searchIndex(List<Integer> arr, Integer integerToFind) {
        return Mono.just(binary(arr, arr.size(), 0, integerToFind));
    }

    @Override
    public Class getSearch() {
        return BinarySearchType2.class;
    }

    private int binary(List<Integer> arr, int r, int l, int integerToFind){
        if(arr.get((l+r)/2) == integerToFind) return (l+r)/2 + 1;
        if(arr.get((l+r)/2) > integerToFind) return binary(arr,(l+r)/2 - 1, l, integerToFind);
        if(arr.get((l+r)/2) < integerToFind) return binary(arr, r,(l+r)/2 + 1, integerToFind);
        return -1;
    }
}

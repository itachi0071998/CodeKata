package com.codekata.karatechop.searchtype;

import com.codekata.karatechop.helper.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class BinarySearchType2 implements Search {
    @Override
    public Mono<Integer> searchIndex(ArrayList<Integer> arr, Integer integerToFind) {
        return Mono.just(binary(arr, arr.size(), 0, integerToFind));
    }

    @Override
    public Class getSearch() {
        return BinarySearchType2.class;
    }

    private int binary(ArrayList<Integer> arr, int r, int l, int integerToFind){
        int mid = (l+r)/2;
        if(arr.get(mid) == integerToFind) return mid+1;
        if(arr.get(mid) > integerToFind) return binary(arr,mid-1, l, integerToFind);
        if(arr.get(mid) < integerToFind) return binary(arr, r,mid+1, integerToFind);
        return -1;
    }
}

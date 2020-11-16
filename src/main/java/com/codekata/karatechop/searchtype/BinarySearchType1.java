package com.codekata.karatechop.searchtype;

import com.codekata.karatechop.helper.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;


@Component
@RequiredArgsConstructor
public class BinarySearchType1 implements Search {
    @Override
    public Mono<Integer> searchIndex(ArrayList<Integer> arr, Integer integerToFind) {
        int mid = arr.size()/2;
        int l = 0;
        int r = arr.size()-1;
        while(r>l){
            mid = (l+r)/2;
            if(arr.get(mid) == integerToFind) return Mono.just(mid+1);
            if(arr.get(mid)>integerToFind) r = mid-1;
            if(arr.get(mid)<integerToFind) l = mid+1;
        }
        return Mono.just(-1);
    }

    @Override
    public Class getSearch() {
        return BinarySearchType1.class;
    }
}

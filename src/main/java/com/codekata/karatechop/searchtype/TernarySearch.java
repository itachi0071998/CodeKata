package com.codekata.karatechop.searchtype;

import com.codekata.karatechop.helper.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class TernarySearch implements Search {
    @Override
    public Mono<Integer> searchIndex(ArrayList<Integer> arr, Integer integerToFind) {
        int l = 0;
        int r = arr.size();
        int mid1 = l + (r-l)/3;
        int mid2 = r - (r-l)/3;
        while(r>l){
            mid1 = l + (r-l)/3;
            mid2 = r - (r-l)/3;
            if(arr.get(mid1) == integerToFind) return Mono.just(mid1+1);
            if(arr.get(mid2) == integerToFind) return Mono.just(mid2+1);
            if(arr.get(mid1)<integerToFind) l = mid1+1;
            if(arr.get(mid1)>integerToFind) r = mid1-1;
            if(arr.get(mid2)<integerToFind) l = mid2+1;
            if(arr.get(mid2)>integerToFind) r = mid2-1;

        }
        return null;
    }

    @Override
    public Class getSearch() {
        return null;
    }
}

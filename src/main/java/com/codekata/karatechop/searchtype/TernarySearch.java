package com.codekata.karatechop.searchtype;

import com.codekata.karatechop.helper.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TernarySearch implements Search {
    @Override
    public Mono<Integer> searchIndex(List<Integer> arr, Integer integerToFind) {
        int l = 0;
        int r = arr.size();
        while(r>l){
            if(arr.get(l + (r-l)/3) == integerToFind) return Mono.just(l + (r-l)/3 + 1);
            if(arr.get(r - (r-l)/3) == integerToFind) return Mono.just(r - (r-l)/3 + 1);
            if(arr.get(l + (r-l)/3)<integerToFind) l = l + (r-l)/3 + 1;
            if(arr.get(l + (r-l)/3)>integerToFind) r = l + (r-l)/3 - 1;
            if(arr.get(r - (r-l)/3)<integerToFind) l = r - (r-l)/3 + 1;
            if(arr.get(r - (r-l)/3)>integerToFind) r = r - (r-l)/3 - 1;

        }
        return null;
    }

    @Override
    public Class getSearch() {
        return TernarySearch.class;
    }
}

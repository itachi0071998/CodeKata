package com.codekata.karatechop.factory;


import com.codekata.karatechop.helper.Search;
import com.codekata.supermarketpricing.interfaces.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class SearchFactory {
    private final List<Search> searches;

    private final Map<String, Search> searchMap = new HashMap<>();
    @PostConstruct
    public void initializeCache(){
        for(Search search: searches){
            searchMap.put(search.getSearch().getName(), search);
        }
    }

    public Search getSearch(String type){
        return searchMap.get(type);
    }
}

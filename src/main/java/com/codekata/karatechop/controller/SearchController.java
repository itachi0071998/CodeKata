package com.codekata.karatechop.controller;

import com.codekata.karatechop.helper.SearchIndex;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RequestMapping("/search")
@RestController
@Slf4j
public class SearchController {

    @Autowired
    private SearchIndex searchIndex;

    @GetMapping
    public Mono<ResponseEntity<Integer>> searchResult(@RequestParam(value = "arr") List<Integer> arr,
                                                      @RequestParam(value = "integer")Integer integer,
                                                      @RequestParam(value = "type") String type){
        return searchIndex.getIndex(arr, integer, type)
                .map(result -> ResponseEntity.ok(result))
                .doOnError(error -> log.error("the error is "+ error));
    }
}

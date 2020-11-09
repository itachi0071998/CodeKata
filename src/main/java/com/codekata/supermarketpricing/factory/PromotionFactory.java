package com.codekata.supermarketpricing.factory;

import com.codekata.supermarketpricing.interfaces.Promotions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class PromotionFactory {

    private final List<Promotions> promotions;

    private final Map<String, Promotions> promotionMap = new HashMap<>();

    @PostConstruct
    public void initializeCache(){
        for(Promotions promo: promotions){
            promotionMap.put(promo.getpromo().getName(), promo);
        }
    }

    public Promotions getPromotion(String type){
        return promotionMap.get(type);
    }
}

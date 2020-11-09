package com.codekata.supermarketpricing.factory;

import com.codekata.supermarketpricing.interfaces.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ConverterFactory {

    private final List<Converter> converters;

    private final Map<String, Converter> converterMap = new HashMap<>();

    @PostConstruct
    public void initializeCache(){
        for(Converter converter: converters){
            converterMap.put(converter.getConverter().getName(), converter);
        }
    }

    public Converter getWhichConverter(String type){
        return converterMap.get(type);
    }
}

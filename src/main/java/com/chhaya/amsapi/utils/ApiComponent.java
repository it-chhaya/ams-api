package com.chhaya.amsapi.utils;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApiComponent {
    
    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }

}
package com.hubizict.bootmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
public class MappingJacksonConfiguration {
    
    //jsonView 빈네임 설정을 통해, jsonView가 리턴될 때, JSON형태의 데이터로 매핑   
    @Bean(name="jsonView")
    public MappingJackson2JsonView jsonView() {

        return new MappingJackson2JsonView();
    }
}

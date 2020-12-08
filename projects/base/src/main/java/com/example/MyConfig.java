package com.example;

import io.micronaut.context.annotation.ConfigurationInject;
import io.micronaut.context.annotation.ConfigurationProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@ConfigurationProperties("myconfig")
public class MyConfig {

    private String en;
    private String de;

    @ConfigurationInject
    public MyConfig(String de, String en){
        this.de = de;
        this.en = en;
    }


}

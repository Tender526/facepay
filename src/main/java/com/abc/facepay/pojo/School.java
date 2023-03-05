package com.abc.facepay.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value="custom.properties", encoding = "utf-8")
@ConfigurationProperties("school")
@Data
public class School {
    private Depart[] departs;
}



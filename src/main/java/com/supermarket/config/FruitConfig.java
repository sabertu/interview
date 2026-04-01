package com.supermarket.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 水果配置类
 */
@Data
@Component
@ConfigurationProperties(prefix = "fruit.price")
public class FruitConfig {

    private Double apple;

    private Double strawberry;

    private Double mango;
}

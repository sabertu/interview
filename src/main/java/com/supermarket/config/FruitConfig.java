package com.supermarket.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 水果配置类
 */
@Data
@Component
@ConfigurationProperties(prefix = "fruit.price")
public class FruitConfig {

    private BigDecimal apple;

    private BigDecimal strawberry;

    private BigDecimal mango;
}

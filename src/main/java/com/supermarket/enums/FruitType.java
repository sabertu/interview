package com.supermarket.enums;

import com.supermarket.config.FruitConfig;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * 水果类型枚举
 */
@Getter
public enum FruitType {

    APPLE, STRAWBERRY, MANGO;

    public static BigDecimal getPrice(FruitType type, FruitConfig config) {
         switch (type){
             case APPLE:
                 return config.getApple();
             case STRAWBERRY:
                 return config.getStrawberry();
             case MANGO:
                 return config.getMango();
             default:
                 throw new IllegalArgumentException("未知的水果类型: " + type);
         }
    }
}

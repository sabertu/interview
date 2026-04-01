package com.supermarket.enums;

import java.math.BigDecimal;
import java.util.function.Function;


/**
 * 促销策略枚举
 */
public enum PromotionStrategy {

    NONE(total -> total),

    //满100-10
    FULL_100_MINUS_10(total -> {
        int compareResult = total.compareTo(new BigDecimal("100"));
        if (compareResult >= 0) {
            return total.subtract(new BigDecimal("10"));
        } else {
            return total;
        }
    });

    private final Function<BigDecimal,BigDecimal> function;


    PromotionStrategy(Function<BigDecimal, BigDecimal> function) {
        this.function = function;
    }

    public BigDecimal apply(BigDecimal total) {
        return function.apply(total);
    }
}

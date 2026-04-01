package com.supermarket.enums;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * 折扣策略枚举
 */
public enum DiscountStrategy {

    NORMAL(price -> price),//不打折

    EIGHT_DISCOUNT(price -> price.multiply(new BigDecimal("0.8"))); //8折

    private final Function<BigDecimal, BigDecimal> function;

    DiscountStrategy(Function<BigDecimal, BigDecimal> function) {
        this.function = function;
    }

    public BigDecimal apply(BigDecimal price) {
        return function.apply(price);
    }
}

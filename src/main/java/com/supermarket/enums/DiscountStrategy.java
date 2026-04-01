package com.supermarket.enums;

import java.util.function.Function;

/**
 * 折扣策略枚举
 */
public enum DiscountStrategy {

    NORMAL(price -> price),//不打折

    EIGHT_DISCOUNT(price -> price * 0.8); //8折

    private final Function<Double, Double> function;

    DiscountStrategy(Function<Double, Double> function) {
        this.function = function;
    }

    public double apply(double price) {
        return function.apply(price);
    }
}

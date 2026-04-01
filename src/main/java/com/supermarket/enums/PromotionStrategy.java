package com.supermarket.enums;

import java.util.function.Function;


/**
 * 促销策略枚举
 */
public enum PromotionStrategy {

    NONE(total -> total),
    FULL_100_MINUS_10(total -> total >=100? total-10: total);

    private final Function<Double,Double> function;


    PromotionStrategy(Function<Double, Double> function) {
        this.function = function;
    }

    public double apply(double total) {
        return function.apply(total);
    }
}

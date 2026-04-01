package com.supermarket.vo;

import com.supermarket.enums.DiscountStrategy;
import com.supermarket.enums.FruitType;
import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * 购买项
 */
@Data
@AllArgsConstructor
public class PurchaseItem {

    /**
     * 水果类型
     */
    private FruitType fruitType;

    /**
     * 重量
     */
    private int weight;

    /**
     * 折扣
     */
    private DiscountStrategy discount;
}

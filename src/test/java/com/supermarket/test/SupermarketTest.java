package com.supermarket.test;

import com.supermarket.enums.DiscountStrategy;
import com.supermarket.enums.FruitType;
import com.supermarket.enums.PromotionStrategy;
import com.supermarket.service.CheckoutService;
import com.supermarket.vo.PurchaseItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SupermarketTest {

    @Autowired
    private CheckoutService checkoutService;

    //题目1：苹果+草莓，无折扣
    @Test
    void testA() {
        List<PurchaseItem> items = new ArrayList<>();
        items.add(new PurchaseItem(FruitType.APPLE, 2, DiscountStrategy.NORMAL));
        items.add(new PurchaseItem(FruitType.STRAWBERRY, 3, DiscountStrategy.NORMAL));

        double res = checkoutService.checkout(items, PromotionStrategy.NONE);
        System.out.println("A = " + res); // 预期55
    }

    //题目2：加芒果
    @Test
    void testB() {
        List<PurchaseItem> items = new ArrayList<>();
        items.add(new PurchaseItem(FruitType.APPLE, 2, DiscountStrategy.NORMAL));
        items.add(new PurchaseItem(FruitType.STRAWBERRY, 3, DiscountStrategy.NORMAL));
        items.add(new PurchaseItem(FruitType.MANGO, 1, DiscountStrategy.NORMAL));

        double res = checkoutService.checkout(items, PromotionStrategy.NONE);
        System.out.println("B = " + res); // 预期75
    }

    //题目3：草莓8折，其他不打折
    @Test
    void testC() {
        List<PurchaseItem> items = new ArrayList<>();
        items.add(new PurchaseItem(FruitType.APPLE, 5, DiscountStrategy.NORMAL));
        items.add(new PurchaseItem(FruitType.STRAWBERRY, 5, DiscountStrategy.EIGHT_DISCOUNT)); // 仅草莓打折
        items.add(new PurchaseItem(FruitType.MANGO, 2, DiscountStrategy.NORMAL));

        double res = checkoutService.checkout(items, PromotionStrategy.NONE);
        System.out.println("C = " + res); // 预期132
    }

    //题目4：草莓8折 + 满100减10
    @Test
    void testD() {
        List<PurchaseItem> items = new ArrayList<>();
        items.add(new PurchaseItem(FruitType.APPLE, 10, DiscountStrategy.NORMAL));
        items.add(new PurchaseItem(FruitType.STRAWBERRY, 10, DiscountStrategy.EIGHT_DISCOUNT));
        items.add(new PurchaseItem(FruitType.MANGO, 5, DiscountStrategy.NORMAL));

        double res = checkoutService.checkout(items, PromotionStrategy.FULL_100_MINUS_10);
        System.out.println("D = " + res); // 预期274
    }
}
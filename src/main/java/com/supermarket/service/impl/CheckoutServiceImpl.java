package com.supermarket.service.impl;

import com.supermarket.config.FruitConfig;
import com.supermarket.enums.FruitType;
import com.supermarket.enums.PromotionStrategy;
import com.supermarket.service.CheckoutService;
import com.supermarket.vo.PurchaseItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final FruitConfig fruitConfig;

    @Override
    public double checkout(List<PurchaseItem> items, PromotionStrategy promotion) {
        double total = 0.0;

        // 每个水果 独立折扣 计算
        for (PurchaseItem item : items) {
            double price = FruitType.getPrice(item.getFruitType(), fruitConfig);
            double realPrice = item.getDiscount().apply(price);
            total += realPrice * item.getWeight();
        }

        // 应用全局促销
        return promotion.apply(total);
    }
}

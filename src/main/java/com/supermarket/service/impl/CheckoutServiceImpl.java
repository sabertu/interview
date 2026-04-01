package com.supermarket.service.impl;

import com.supermarket.config.FruitConfig;
import com.supermarket.enums.FruitType;
import com.supermarket.enums.PromotionStrategy;
import com.supermarket.service.CheckoutService;
import com.supermarket.vo.PurchaseItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final FruitConfig fruitConfig;

    @Override
    public BigDecimal checkout(List<PurchaseItem> items, PromotionStrategy promotion) {
        BigDecimal total = BigDecimal.valueOf(0.0);

        // 每个水果 独立折扣 计算
        for (PurchaseItem item : items) {
            if (item.getWeight() < 0) {
                throw new IllegalArgumentException("水果重量不能为负数！当前重量：" + item.getWeight());
            }

            BigDecimal price = FruitType.getPrice(item.getFruitType(), fruitConfig);
            BigDecimal realPrice = item.getDiscount().apply(price);
            total = total.add(realPrice.multiply(BigDecimal.valueOf(item.getWeight())));
        }

        // 应用全局促销
        return promotion.apply(total);
    }
}

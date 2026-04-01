package com.supermarket.service;

import com.supermarket.enums.PromotionStrategy;
import com.supermarket.vo.PurchaseItem;

import java.util.List;

//结账服务接口
public interface CheckoutService {

   double checkout(List<PurchaseItem> items, PromotionStrategy promotion);
}

package com.sky.service;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    /**
     * 添加购物车
     * @param shoppingCartDTO
     */
    void addShoppingCart(ShoppingCartDTO shoppingCartDTO);

    /**
     * 查看购物车
     */
    List<ShoppingCart> listShoppingCart();

    /**
     * 清除购物车
     * @param userId
     */
    void clean(Long userId);

    /**
     * 删除一个购物车中的商品
     * @param shoppingCartDTO
     */
    void subOneGood(ShoppingCartDTO shoppingCartDTO);
}

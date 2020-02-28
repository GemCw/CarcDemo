package com.carc.demo.service;

import com.carc.demo.domain.pojo.Product;

import java.util.List;

/**
 * @Author Gem
 * @Date 2020/2/28 10:17
 */
public interface ProductService {

    /**查询商品列表*/
    List<Product> findAll();

    /**查询单个商品详情*/
    Product findOne(String productId);

    /**删除商品*/
    Integer delete(String productId);

    /**添加产品*/
    Integer add(Product product);

    /**修改产品*/
    Integer modify(Product product);
}

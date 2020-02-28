package com.carc.demo.service.impl;/**
 * @Author Gem
 * @Date 2020/2/28 10:35
 */

import com.carc.demo.domain.pojo.Product;
import com.carc.demo.enums.ResultEnum;
import com.carc.demo.repository.ProductRepository;
import com.carc.demo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：Gem
 * @description：TODO
 * @date ：2020/2/28 10:35
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;


    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findOne(String productId) {

        //查找商品
        Product product = repository.findOne(productId);
        //判断商品是否存在
        if(null == product){
            log.error("【查询商品】商品不存在,product={}",productId);
            return null;
        }
        return  product;
    }

    @Override
    public Integer delete(String productId) {
        //查找商品
        Product product = repository.findOne(productId);
        //判断商品是否存在
        if(null == product){
            log.error("【删除商品】商品不存在,product={}",productId);
              return ResultEnum.PRODUCT_NOT_EXIST.getCode();
        }
        repository.delete(product);
        return ResultEnum.SUCCESS_PRODUCT_DELETE.getCode();
    }

    @Override
    public Integer add(Product product) {
        //查找商品
        Product result = repository.findOne(product.getProductId());
        //若商品已存在
        if(null!=result){
            log.error("【添加商品】商品已存在,product={}",product.getProductId());
            return ResultEnum.PRODUCT_EXIST.getCode();
        }
        repository.save(product);
        return ResultEnum.SUCCESS_PRODUCT_ADD.getCode();
    }

    @Override
    public Integer modify(Product product) {
        //查找商品
        Product result = repository.findOne(product.getProductId());
        //判断商品是否存在
        if(null == result){
            log.error("【更改商品】商品不存在,product={}",product);
            return ResultEnum.PRODUCT_NOT_EXIST.getCode();
        }
        Integer executeResult = repository.modify(product.getProductName(),
                product.getProductPrice(),
                product.getProductStock(),
                product.getProductDescription(),
                product.getProductIcon(),
                product.getCategoryType(),
                result.getProductId());
        if(executeResult==1){
            return ResultEnum.SUCCESS_MODIFY.getCode();
        }else {
            return ResultEnum.ERROR_MODIFY.getCode();
        }
    }

}

package com.carc.demo.service.impl;

import com.carc.demo.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author Gem
 * @Date 2020/2/28 11:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    ProductService productService;

    private final String PRODUCT_ID = "123";

    @Test
    public void delete() {
        productService.delete(PRODUCT_ID);

    }
}
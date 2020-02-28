package com.carc.demo.converter;/**
 * @Author Gem
 * @Date 2020/2/28 14:46
 */

import com.carc.demo.domain.form.ProductForm;
import com.carc.demo.domain.pojo.Product;
import org.springframework.beans.BeanUtils;

/**
 * @author ：Gem
 * @description：TODO
 * @date ：2020/2/28 14:46
 */
public class ProductForm2ProductConverter {

    public static Product convert(ProductForm productForm){
        Product product = new Product();
        BeanUtils.copyProperties(productForm,product);
        return product;
    }
}

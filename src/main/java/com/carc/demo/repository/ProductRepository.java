package com.carc.demo.repository;

import com.carc.demo.domain.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @Author Gem
 * @Date 2020/2/28 10:44
 */
public interface ProductRepository extends JpaRepository<Product,String> {

    @Modifying
    @Transactional
    @Query(value = "update product p set p.product_name=?1," +
            "p.product_price=?2," +
            "p.product_stock=?3," +
            "p.product_description=?4," +
            "p.product_icon=?5," +
            "p.category_type=?6 where p.product_id=?7",nativeQuery=true)
    Integer modify(String productName,
                   BigDecimal productPrice,
                   Integer productStock,
                   String productDescription,
                   String productIcon,
                   Integer categoryType,
                   String productId);


}

package com.carc.demo.domain.form;/**
 * @Author Gem
 * @Date 2020/2/28 12:44
 */

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author ：Gem
 * @description：TODO
 * @date ：2020/2/28 12:44
 */
@Data
public class ProductForm {

    @NotEmpty(message = "商品编号必填")
    private String productId;

    @NotEmpty(message = "商品名称必填")
    private String productName;

    @NotNull(message = "商品价格必填")
    private BigDecimal productPrice;

    @NotNull(message = "商品库存必填")
    private Integer productStock;

    @NotEmpty(message = "商品描述必填")
    private String productDescription;

    @NotEmpty(message = "商品小图链接必填")
    private String productIcon;

    @NotNull(message = "商品类目必填")
    private Integer categoryType;
}

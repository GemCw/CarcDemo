package com.carc.demo.enums;/**
 * @Author Gem
 * @Date 2020/2/28 10:55
 */

import lombok.Getter;

/**
 * @author ：Gem
 * @description：TODO
 * @date ：2020/2/28 10:55
 */
@Getter
public enum ResultEnum {
    /***/
    SUCCESS(0,"成功"),

    PRODUCT_NOT_EXIST(1,"商品不存在"),

    SUCCESS_PRODUCT_DELETE(2,"商品删除成功"),

    PRODUCT_EXIST(3,"商品已存在"),

    SUCCESS_PRODUCT_ADD(4,"商品添加成功"),

    PARAM_ERROR(5,"参数错误"),

    PRODUCTID_EXIST(6,"商品ID重复"),

    SUCCESS_MODIFY(7,"商品修改成功"),

    ERROR_MODIFY(8,"商品修改失败"),

    PRODUCT_EMPTY(9,"商品添加为空"),

        ;


    private Integer code;

    private String message;

    ResultEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}

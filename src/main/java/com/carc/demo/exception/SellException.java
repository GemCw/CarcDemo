package com.carc.demo.exception;/**
 * @Author Gem
 * @Date 2020/2/28 10:54
 */

import com.carc.demo.enums.ResultEnum;

/**
 * @author ：Gem
 * @description：TODO
 * @date ：2020/2/28 10:54
 */
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
    public SellException(Integer code,String msg){
        super(msg);
        this.code = code;
    }

}

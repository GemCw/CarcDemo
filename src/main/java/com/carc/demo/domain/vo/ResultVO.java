package com.carc.demo.domain.vo;/**
 * @Author Gem
 * @Date 2020/2/28 10:20
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author ：Gem
 * @description：TODO
 * @date ：2020/2/28 10:20
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)//过滤掉结果为null的字段
public class ResultVO<T> {

    /**错误码*/
    private Integer code;

    /**提示信息*/
    private String msg;

    /**具体内容*/
    private T data;
}

package com.carc.demo.utils;/**
 * @Author Gem
 * @Date 2020/2/28 12:02
 */

import com.carc.demo.domain.vo.ResultVO;

/**
 * @author ：Gem
 * @description：TODO
 * @date ：2020/2/28 12:02
 */
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO error(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("失败");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(){
        return error(null);
    }
}

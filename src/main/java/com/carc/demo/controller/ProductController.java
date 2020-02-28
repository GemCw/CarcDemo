package com.carc.demo.controller;/**
 * @Author Gem
 * @Date 2020/2/28 10:17
 */

import com.carc.demo.converter.ProductForm2ProductConverter;
import com.carc.demo.domain.form.ProductForm;
import com.carc.demo.domain.pojo.Product;
import com.carc.demo.domain.vo.ResultVO;
import com.carc.demo.enums.ResultEnum;
import com.carc.demo.exception.SellException;
import com.carc.demo.service.ProductService;
import com.carc.demo.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author ：Gem
 * @description：TODO
 * @date ：2020/2/28 10:17
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    /**查询商品列表*/
    @GetMapping("/list")
    public ResultVO<List<Product>> list(){
        List<Product> productList = productService.findAll();
        return ResultVOUtil.success(productList);
    }

    /**查询单个商品详情*/
    @GetMapping("/detail")
    public ResultVO<Product> detail(@RequestParam("productId") String productId){

        Product product = productService.findOne(productId);
        if(null!=product) {
            return ResultVOUtil.success(product);
        }else{
            return ResultVOUtil.error();
        }
    }

    /**删除产品*/
    @PostMapping("/delete")
    public ResultVO delete(@RequestParam("productId") String productId){

        if(productService.delete(productId).equals(ResultEnum.SUCCESS_PRODUCT_DELETE)){
            return ResultVOUtil.success();
        }else{
            return ResultVOUtil.error(ResultEnum.PRODUCT_NOT_EXIST.getMessage());
        }
    }

    /**添加产品*/
    @PostMapping("/add")
    public ResultVO add(@Valid ProductForm productForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【商品添加】参数不正确，productForm={}",productForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        Product product = ProductForm2ProductConverter.convert(productForm);
        if(null==product){
            log.error("【商品添加】商品添加不能为空");
            throw new SellException(ResultEnum.PRODUCT_EMPTY);
        }
        Integer addResult = productService.add(product);
        if(addResult.equals(ResultEnum.PRODUCT_EXIST.getCode())){
            return ResultVOUtil.error(ResultEnum.PRODUCTID_EXIST.getMessage());
        }
        return ResultVOUtil.success();

    }

    /**修改产品*/
    @PostMapping("/modify")
    public ResultVO modify(@Valid ProductForm productForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【商品添加】参数不正确，productForm={}",productForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        Product product = ProductForm2ProductConverter.convert(productForm);
        if(null==product){
            log.error("【商品添加】商品修改不能为空");
            throw new SellException(ResultEnum.PRODUCT_EMPTY);
        }
        Integer result = productService.modify(product);
        if(result.equals(ResultEnum.SUCCESS_MODIFY.getCode())){
            return ResultVOUtil.success(ResultEnum.SUCCESS_MODIFY.getMessage());
        }else{
            return ResultVOUtil.error(ResultEnum.ERROR_MODIFY.getMessage());
        }
    }




}

package com.orion.v13centreweb.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.dubbo.config.annotation.Reference;
import com.orion.v13.api.IProductService;
import com.orion.v13.entity.TProduct;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Orion
 */
@Controller
@RequestMapping("product")
public class ProductController {

    @Reference
    private IProductService productService;

    @RequestMapping("list")
    public String list(){
        System.out.println("0000");
        return "product/list";
    }

    @RequestMapping("get/{id}")
    @ResponseBody
    public TProduct getById(@PathVariable("id") Long id){
        return productService.selectByPrimaryKey(id);
    }


}

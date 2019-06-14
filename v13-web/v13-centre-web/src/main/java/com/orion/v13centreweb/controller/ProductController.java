package com.orion.v13centreweb.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.orion.v13.api.IProductService;
import com.orion.v13.entity.TProduct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Orion
 */
@Controller
@RequestMapping("product")
public class ProductController {

    @Reference
    private IProductService productService;

    @RequestMapping("list")
    public String list(Model model){
        System.out.println("0000");
        //1、读取数据
        List<TProduct> list = productService.list();
        //2、保存数据到Model
        model.addAttribute("list",list);
        System.out.println("0000");
        //3、页面展示
        return "product/list";
    }

    @RequestMapping("get/{id}")
    @ResponseBody
    public TProduct getById(@PathVariable("id") Long id){
        return productService.selectByPrimaryKey(id);
    }
    @RequestMapping("page/{pageIndex}/{pageSize}")
    public String page(@PathVariable("pageIndex") Integer pageIndex,
                       @PathVariable("pageSize") Integer pageSize,
                       Model model){

        PageInfo<TProduct> page = productService.page(pageIndex, pageSize);
        model.addAttribute("page",page);
        return "product/list";
    }


}

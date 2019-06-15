package com.orion.v13centreweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.orion.v13.api.IProductService;
import com.orion.v13.common.pojo.ResultBean;
import com.orion.v13.entity.TProduct;
import com.orion.v13.pojo.TProductVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("add")
    public String add(TProductVO vo){

        Long id =productService.save(vo);

        return "redirect:/product/page/1/1";
    }

    //统一规范返回数据的格式
    //json统一抽象成一个ResultBean类
    @PostMapping("delById/{id}")
    @ResponseBody
    public ResultBean delById(@PathVariable("id") Long id){
        int count = productService.deleteByPrimaryKey(id);
        if(count>0){
            return new ResultBean("200","删除成功");
        }
        return new ResultBean("404","删除失败！");
    }

    //批量删除
    @PostMapping("batchDel")
    @ResponseBody
    public ResultBean batchDel(@RequestParam List<Long> ids){
        long count = productService.batchDel(ids);
        if(count>0){
            return new ResultBean("200","批量删除成功");
        }
        return new ResultBean("404","批量删除失败！");

    }

}

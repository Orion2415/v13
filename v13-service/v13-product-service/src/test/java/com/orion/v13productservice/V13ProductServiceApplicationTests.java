package com.orion.v13productservice;

import com.github.pagehelper.PageInfo;
import com.orion.v13.api.IProductService;
import com.orion.v13.entity.TProduct;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class V13ProductServiceApplicationTests {
    @Autowired
    private IProductService productService;

    @Test
    public void contextLoads() {
        TProduct product = productService.selectByPrimaryKey(1l);
        System.out.println(product.getName());
    }
    @Test
    public void contextLoads2() {
        List<TProduct> list = productService.list();
        Assert.assertEquals(list.size(),1);
    }
    @Test
    public void contextLoads3() {
        PageInfo<TProduct> page = productService.page(1, 1);
        System.out.println(page.getList().size());
    }

}

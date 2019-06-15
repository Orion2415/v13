package com.orion.v13productservice;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.github.pagehelper.PageInfo;
import com.orion.v13.api.IProductService;
import com.orion.v13.entity.TProduct;
import com.orion.v13.pojo.TProductVO;
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
        TProduct product = new TProduct();
        product.setFlag(true);
        //name, price、sale_price, images, sale_point,type_id, type_name, flag
        product.setName("天王盖地虎");
        product.setPrice(100000l);
        product.setSalePrice(1000l);
        product.setImages("sajdakdjalks");
        product.setSalePoint("招牌皇子");
        product.setTypeId(1l);
        product.setTypeName("码农");
        product.setFlag(true);


        TProductVO vo = new TProductVO();
        vo.setProduct(product);
        vo.setProductDesc("叶师傅的皇子，carray全场");

        long saveId = productService.save(vo);
        System.out.println(saveId);
    }
    @Test
    public void contextLoads3() {
        PageInfo<TProduct> page = productService.page(1, 1);
        System.out.println(page.getList().size());
    }

}

package com.orion.v13productservice.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orion.v13.api.IProductService;
import com.orion.v13.common.base.BaseServiceImpl;
import com.orion.v13.common.base.IBaseDao;
import com.orion.v13.entity.TProduct;
import com.orion.v13.entity.TProductDesc;
import com.orion.v13.mapper.TProductDescMapper;
import com.orion.v13.mapper.TProductMapper;
import com.orion.v13.pojo.TProductVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Orion
 * @Date 2019/6/12
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<TProduct> implements IProductService {

    @Autowired
    private TProductMapper productMapper;
    @Autowired
    private TProductDescMapper productDescMapper;
    @Override
    public IBaseDao<TProduct> getBaseDao() {
        return productMapper;
    }

    @Override
    public PageInfo<TProduct> page(Integer pageIndex, Integer pageSize) {
        //设置分页参数
        PageHelper.startPage(pageIndex,pageSize);
        //获取数据
        List<TProduct> list =list();
        //构建一个分页对象
        PageInfo<TProduct> pageInfo = new PageInfo<TProduct>(list,2);
        return pageInfo;
    }

    @Override
    public long save(TProductVO vo) {
        TProduct product = vo.getProduct();

        product.setFlag(true);
        //主键回传
        int count = productMapper.insert(product);
        //保存描述信息
        String productDesc = vo.getProductDesc();
        TProductDesc desc = new TProductDesc();
        desc.setProductDesc(productDesc);
        desc.setProductId(product.getId());
        productDescMapper.insert(desc);

        return product.getId();
    }

    @Override
    public long batchDel(List<Long> ids) {
        //update t_product set flag=0 where id in (1,2,3)

        return productMapper.batchUpdateFlag(ids);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        TProduct product = new TProduct();
        product.setId(id);
        product.setFlag(false);
        return productMapper.updateByPrimaryKeySelective(product);

    }
}

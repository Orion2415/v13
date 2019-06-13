package com.orion.v13productservice.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.orion.v13.api.IProductService;
import com.orion.v13.common.base.BaseServiceImpl;
import com.orion.v13.common.base.IBaseDao;
import com.orion.v13.entity.TProduct;
import com.orion.v13.mapper.TProductMapper;
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
    @Override
    public IBaseDao<TProduct> getBaseDao() {
        return productMapper;
    }

}

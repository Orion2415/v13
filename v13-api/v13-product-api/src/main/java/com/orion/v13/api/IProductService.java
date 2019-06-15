package com.orion.v13.api;

import com.github.pagehelper.PageInfo;
import com.orion.v13.common.base.IBaseService;
import com.orion.v13.entity.TProduct;
import com.orion.v13.pojo.TProductVO;

import java.util.List;

/**
 * @author Orion
 * @Date 2019/6/12
 */

public interface IProductService extends IBaseService<TProduct> {
    //单独扩展特殊的方法
    public PageInfo<TProduct> page(Integer pageIndex, Integer pageSize);

    //添加页面保存，返回新增商品的id
    public long save(TProductVO vo);

}

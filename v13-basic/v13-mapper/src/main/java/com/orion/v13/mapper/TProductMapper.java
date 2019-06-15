package com.orion.v13.mapper;

import com.orion.v13.common.base.IBaseDao;
import com.orion.v13.entity.TProduct;

import java.util.List;

public interface TProductMapper extends IBaseDao<TProduct> {
    long batchUpdateFlag(List<Long> ids);
}
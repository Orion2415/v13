package com.orion.v13.common.base;

/**
 * @author Orion
 * @Date 2019/6/12
 */

public abstract class BaseServiceImpl<T> implements IBaseService<T> {

    //子类实现这个抽象方法时，注入具体的mapper
    public abstract IBaseDao<T> getBaseDao();

    public int deleteByPrimaryKey(Long id) {

        return getBaseDao().deleteByPrimaryKey(id);
    }

    public int insert(T record) {
        return getBaseDao().insert(record);
    }

    public int insertSelective(T record) {
        return getBaseDao().insertSelective(record);
    }

    public T selectByPrimaryKey(Long id) {

        return getBaseDao().selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(T record) {

        return getBaseDao().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKeyWithBLOBs(T record)
    {
        return getBaseDao().updateByPrimaryKeyWithBLOBs(record);
    }

    public int updateByPrimaryKey(T record) {

        return getBaseDao().updateByPrimaryKey(record);
    }
}

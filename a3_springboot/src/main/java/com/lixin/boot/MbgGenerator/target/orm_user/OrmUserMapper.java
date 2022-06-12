package com.lixin.boot.MbgGenerator.target.orm_user;

import com.lixin.boot.MbgGenerator.target.orm_user.OrmUser;

public interface OrmUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrmUser record);

    int insertSelective(OrmUser record);

    OrmUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrmUser record);

    int updateByPrimaryKey(OrmUser record);
}
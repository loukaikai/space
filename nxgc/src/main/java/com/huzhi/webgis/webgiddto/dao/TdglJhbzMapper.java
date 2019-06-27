package com.huzhi.webgis.webgiddto.dao;

import com.huzhi.webgis.webgiddto.domain.TdglJhbz;

public interface TdglJhbzMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(TdglJhbz record);

    int insertSelective(TdglJhbz record);

    TdglJhbz selectByPrimaryKey(Long oid);

    int updateByPrimaryKeySelective(TdglJhbz record);

    int updateByPrimaryKey(TdglJhbz record);
}
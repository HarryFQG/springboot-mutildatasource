package com.tangcheng.datasource.notaop.mapper.ext;

import com.tangcheng.datasource.notaop.model.UsrDepartment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsrDepartmentMapper {
    int deleteByPrimaryKey(String id);

    int insert(UsrDepartment record);

    int insertSelective(UsrDepartment record);

    UsrDepartment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UsrDepartment record);

    int updateByPrimaryKey(UsrDepartment record);
}
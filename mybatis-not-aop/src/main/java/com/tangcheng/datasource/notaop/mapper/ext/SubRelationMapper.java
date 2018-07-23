package com.tangcheng.datasource.notaop.mapper.ext;

import com.tangcheng.datasource.notaop.model.SubRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SubRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(SubRelation record);

    int insertSelective(SubRelation record);

    SubRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SubRelation record);

    int updateByPrimaryKey(SubRelation record);

    List<SubRelation> likeRelativeByParentId(@Param("id") String id);

    void batchPrimaryKey(List<SubRelation> collect);
}
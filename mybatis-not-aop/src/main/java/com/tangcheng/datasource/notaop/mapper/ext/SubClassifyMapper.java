package com.tangcheng.datasource.notaop.mapper.ext;

import com.tangcheng.datasource.notaop.model.SubClassify;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SubClassifyMapper {
    int deleteByPrimaryKey(String id);

    int insert(SubClassify record);

    int insertSelective(SubClassify record);

    SubClassify selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SubClassify record);

    int updateByPrimaryKey(SubClassify record);
/**  <select id="listByUsrOrg" resultMap="BaseResultMap" parameterMap="java.lang.String">
 select
 <include refid="Base_Column_List" />
 from cms_sub_classify
 where usr_org=#{usrOrg}
 </select>
    List<SubClassify> listByUsrOrg(@Param("usrOrg") String usrOrg);
*/
    /**
     *
     * @param usrOrg
     * @return
     */
    SubClassify getClassifyByNo(@Param("usrOrg") String usrOrg);
}
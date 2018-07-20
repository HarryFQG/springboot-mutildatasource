package com.tangcheng.datasource.notaop.mapper.test2;

import com.tangcheng.datasource.notaop.model.UserDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by tang.cheng on 2017/3/16.
 */
@Mapper
public interface UserDetailMapper {

    List<UserDetail> listUserDetail();


}

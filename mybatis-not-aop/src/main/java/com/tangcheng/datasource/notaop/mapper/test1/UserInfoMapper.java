package com.tangcheng.datasource.notaop.mapper.test1;

import com.tangcheng.datasource.notaop.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by tang.cheng on 2017/3/16.
 */
@Mapper
public interface UserInfoMapper {

    List<UserInfo> listUserInfo();

}

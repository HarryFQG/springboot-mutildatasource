package com.tangcheng.datasource.notaop.controller;

import com.tangcheng.datasource.notaop.mapper.test1.UserInfoMapper;
import com.tangcheng.datasource.notaop.mapper.test2.UserDetailMapper;
import com.tangcheng.datasource.notaop.model.UserDetail;
import com.tangcheng.datasource.notaop.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author fengqg
 * @description
 * @date 2018/7/19 20:53
 **/

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserDetailMapper userDetailMapper;

    @RequestMapping("/listUserInfo")
    public List<UserInfo> listUserInfo() {
        System.out.println("------------数据源1-----------");
        return userInfoMapper.listUserInfo();
    }

    @RequestMapping("/listUserDetail")
    public List<UserDetail> listUserDetail() {
        System.out.println("------------数据源2-----------");
        return userDetailMapper.listUserDetail();
    }

    @PostConstruct
    public void a(){
        List<UserInfo> userInfos = userInfoMapper.listUserInfo();
        List<UserDetail> userDetails = userDetailMapper.listUserDetail();
        System.out.println(userInfos+"----------------------"+userDetails);
    }


}
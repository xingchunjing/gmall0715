package com.studio.jxc.gmall.usermanage.service.impl;

import com.studio.jxc.gmall.bean.UserInfo;
import com.studio.jxc.gmall.usermanage.mapper.UserInfoMapper;
import com.studio.jxc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> selectAllUserInfo() {
        return userInfoMapper.selectAll();
    }
}

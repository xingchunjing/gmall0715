package com.studio.jxc.gmall.usermanage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.studio.jxc.gmall.bean.UserAddress;
import com.studio.jxc.gmall.bean.UserInfo;
import com.studio.jxc.gmall.usermanage.mapper.UserAddressMapper;
import com.studio.jxc.gmall.usermanage.mapper.UserInfoMapper;
import com.studio.jxc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public List<UserInfo> selectAllUserInfo() {
        return userInfoMapper.selectAll();
    }

    @Override
    public List<UserAddress> selectUserAddressByUserId(String userId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        List<UserAddress> userAddressList = userAddressMapper.select(userAddress);
        return userAddressList;
    }
}

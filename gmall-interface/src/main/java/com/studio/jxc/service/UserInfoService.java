package com.studio.jxc.service;

import com.studio.jxc.gmall.bean.UserAddress;
import com.studio.jxc.gmall.bean.UserInfo;

import java.util.List;

public interface UserInfoService {
    public List<UserInfo> selectAllUserInfo();

    public List<UserAddress> selectUserAddressByUserId(String userId);
}

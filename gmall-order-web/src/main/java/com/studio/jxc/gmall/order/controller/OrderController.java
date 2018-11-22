package com.studio.jxc.gmall.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.studio.jxc.gmall.bean.UserAddress;
import com.studio.jxc.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @Reference
    private UserInfoService userInfoService;

    @RequestMapping("/selectUserAddressByUserId")
    @ResponseBody
    public List<UserAddress> selectUserAddressByUserId(String userId){
        return userInfoService.selectUserAddressByUserId(userId);
    }
}

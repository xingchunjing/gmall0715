package com.studio.jxc.gmall.usermanage.controller;

import com.studio.jxc.gmall.bean.UserInfo;
import com.studio.jxc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/userInfoList")
    @ResponseBody
    public List<UserInfo> userInfoList(){
        return userInfoService.selectAllUserInfo();
    }
}

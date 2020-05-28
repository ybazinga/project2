package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.LoginBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/auth")
public class AuthController {

    //@RequestMapping("admin/auth/login")
    //public Object login(@RequestBody Map){
    //
    //}
    @RequestMapping("login")
    public BaseRespVo login(@RequestBody LoginBean loginBean){
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setData("859062cc-d49d-4730-b561-c2ff944023de");
        objectBaseRespVo.setErrno(0);
        objectBaseRespVo.setErrmsg("成功");
        return objectBaseRespVo;
    }

    @RequestMapping("info")
    public String info(){

        return "{\"errno\":0,\"data\":{\"roles\":[\"超级管理员\"],\"name\":\"admin123\",\"perms\":[\"*\"],\"avatar\":\"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif\"},\"errmsg\":\"成功\"}";
    }
}
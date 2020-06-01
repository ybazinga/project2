package com.cskaoyan.cskaoyanmall.controller.wx;

import com.cskaoyan.cskaoyanmall.bean.BaseRespVo;
import com.cskaoyan.cskaoyanmall.bean.LoginBean;
import com.cskaoyan.cskaoyanmall.bean.WxLoginRespDataVo;
import com.cskaoyan.cskaoyanmall.bean.WxUserInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author: Lee et
 *@Date: Created in 15:50 2020/6/1
 */
@RestController
@RequestMapping("wx/auth")
public class WxAuthController {

    @RequestMapping("login")
    public BaseRespVo wxUserLogin(@RequestBody LoginBean loginBean) {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        WxLoginRespDataVo wxLoginRespDataVo = new WxLoginRespDataVo();
        WxUserInfo wxUserInfo = new WxUserInfo();
        wxUserInfo.setNickname("test1");
        wxUserInfo.setAvatarUrl("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif?imageView2/1/w/80/h/80");
        wxLoginRespDataVo.setUserInfo(wxUserInfo);
        wxLoginRespDataVo.setTokenExpire("2020-06-02T15:46:25.203");
        wxLoginRespDataVo.setToken("wxkbfg3hdvpc31ufrsazv3cqfhqwscmm");

        respVo.setData(wxLoginRespDataVo);
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        return respVo;
    }
}

package org.qydata.controller;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.qydata.entity.Admin;
import org.qydata.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/11/20.
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    private final Logger log = Logger.getLogger(this.getClass());

    @Autowired
    AdminService adminService;
    /**
     * 登录
     * @return
     */
    @RequestMapping("/loginUrl")
    public String loginUrl() { return "view/login";}
    /**
     * 未授权
     * @return
     */
    @RequestMapping("/unauthUrl")
    public String unauthUrl() {
        return "view/role";
    }
    /**
     * 登录成功
     * @return
     */
    @RequestMapping("/successUrl")
    public String successUrl() {
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.getSession().getId()); //取得sessionId
        System.out.println(subject.getPrincipal()); //取得用户名
        System.out.println(subject.getSession().getHost());//取得主机名
        System.out.println(subject.getSession().getTimeout());//
        System.out.println(subject.getSession().getStartTimestamp());//
        System.out.println(subject.getSession().getLastAccessTime());//
        //subject.getSession().touch();//更新会话
        //subject.getSession().stop();//停止会话
        return "view/welcome";
    }
    /**
     * @param uid
     * @param password
     * @return
     */
    @RequestMapping("/shiroLogin")
    public ModelAndView login(HttpServletRequest request,String uid, String password) {
        ModelAndView mav = new ModelAndView();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(uid, password);
        Admin admin = null;
        try {
            admin = adminService.get(uid);
            request.getSession().setAttribute("adminInfo",admin);
            subject.login(token);
            mav.setViewName("view/welcome");
        } catch (Exception e) {
            e.printStackTrace();
            mav.setViewName("view/login");
        }
        return mav;
    }
}

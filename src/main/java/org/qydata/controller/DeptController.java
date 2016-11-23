package org.qydata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/11/20.
 */
@Controller
@RequestMapping("/dept")
public class DeptController {

    /**
     *
     * @return
     */
    @RequestMapping("/list")
    public String list(){
        return "dept/list";
    }
    /**
     *
     * @return
     */
    @RequestMapping("/edit")
    public String edit(){ return "dept/edit"; }
    /**
     *
     * @return
     */
    @RequestMapping("/add")
    public String add(){ return "dept/add"; }
}

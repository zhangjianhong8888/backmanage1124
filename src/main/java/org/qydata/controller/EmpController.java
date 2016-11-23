package org.qydata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/11/19.
 */
@Controller
@RequestMapping("/emp")
public class EmpController {
    /**
     *
     * @return
     */
    @RequestMapping("/list")
    public String list(){
        return "emp/list";
    }
    /**
     *
     * @return
     */
    @RequestMapping("/edit")
    public String edit(){ return "emp/edit"; }
    /**
     *
     * @return
     */
    @RequestMapping("/add")
    public String add(){ return "emp/add"; }
    /**
     *
     * @return
     */
    @RequestMapping("/remove")
    public String remove(){ return "emp/remove"; }
}

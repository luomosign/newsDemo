package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController
{
    @RequestMapping({"/","/login.html","index"})
    public String index(){
        return "login.html";
    }
}

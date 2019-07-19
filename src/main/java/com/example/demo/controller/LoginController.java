package com.example.demo.controller;
import com.mapper.ManagerMapper;
import com.utils.utils;
import com.entity.Manager;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@RestController
public class LoginController {



    @RequestMapping(value = "/newsDemo/login",method = RequestMethod.POST)
    public String login(@RequestParam("manager_id")String manager_id,@RequestParam("manager_pwd")String manager_pwd) throws IOException {
        System.out.println("jinlai21e3rf24erf234f2354t24t5");
        //数据准备
//        String manager_id = request.getParameter("manager_id");
//        String manager_pwd = request.getParameter("manager_pwd");
        Manager manager = new Manager();
        manager.setManager_id(manager_id);
        manager.setManager_pwd(manager_pwd);
        //数据验证
        if(null == manager_id || "".equals(manager_id) || null == manager_pwd || "".equals(manager_pwd)){
            return "false";
        }
        //获取连接会话
        SqlSession session = new utils().getSessionFactory().openSession(true);
        try{
            ManagerMapper mapper = session.getMapper(ManagerMapper.class);
            Manager resultManager = mapper.queryManagerByEntity(manager);
            if(null != resultManager ){
                System.out.println("okokok");
                return "true";
            }
        }
        finally {
            session.close();
        }
        return "false";
    }
}

package com.example.demo.controller;

import com.entity.Manager;
import com.mapper.ManagerMapper;
import com.utils.utils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ManagerController {
    @RequestMapping(value = "/queryAllManager",method = RequestMethod.POST)
    @ResponseBody
    public String QueryAllManager() throws IOException {
        List<Manager> manager_list = new ArrayList<Manager>();
        //获取连接会话
        SqlSession session = new utils().getSessionFactory().openSession(true);
        try{
            ManagerMapper mapper = session.getMapper(ManagerMapper.class);
            manager_list = mapper.queryAllManager();
        }
        finally {
            session.close();
        }
        //list 转 json
        return new utils().List2Json(manager_list);
    }
    @RequestMapping(value = "/addManager",method = RequestMethod.POST)
    @ResponseBody
    public String AddManager(HttpServletRequest request) throws IOException {
        Manager manager = new Manager();
        manager.setManager_id(request.getParameter("manager_id"));
        manager.setManager_name(request.getParameter("manager_name"));
        manager.setManager_pwd(request.getParameter("manager_pwd"));
        SqlSession session = new utils().getSessionFactory().openSession(true);
        try{
            ManagerMapper mapper = session.getMapper(ManagerMapper.class);
            mapper.addManager(manager);
        }catch (Exception e){
            return "false";
        }
        finally {
            session.close();
        }
        return "true";
    }
    @RequestMapping(value = "/updateManager",method = RequestMethod.POST)
    @ResponseBody
    public String UpdateManager(HttpServletRequest request) throws IOException {
        Manager manager = new Manager();
        manager.setManager_id(request.getParameter("manager_id"));
        manager.setManager_name(request.getParameter("manager_name"));
        manager.setManager_pwd(request.getParameter("manager_pwd"));
        SqlSession session = new utils().getSessionFactory().openSession(true);
        try{
            ManagerMapper mapper = session.getMapper(ManagerMapper.class);
            mapper.updateManager(manager);
        }catch (Exception e){
            return "false";
        }
        finally {
            session.close();
        }
        //返回flag
        return "true";
    }
    @RequestMapping(value = "/deleteManager",method = RequestMethod.POST)
    @ResponseBody
    public String DeleteManager(HttpServletRequest request) throws IOException {
        Manager manager = new Manager();
        manager.setManager_id(request.getParameter("manager_id"));
        manager.setManager_name(request.getParameter("manager_name"));
        manager.setManager_pwd(request.getParameter("manager_pwd"));
        SqlSession session = new utils().getSessionFactory().openSession(true);
        try{
            ManagerMapper mapper = session.getMapper(ManagerMapper.class);
            mapper.deleteManager(manager);
        }catch (Exception e){
            return "false";
        }
        finally {
            session.close();
        }
        //返回flag
        return "true";
    }
}

package com.example.demo.controller;

import com.entity.Nav;
import com.mapper.NavMapper;
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
public class NavController {
    @RequestMapping(value = "/queryAllNav",method = RequestMethod.POST)
    @ResponseBody
    public String QueryAllNav() throws IOException {
        List<Nav> nav_list = new ArrayList<Nav>();
        //获取连接会话
        SqlSession session = new utils().getSessionFactory().openSession(true);
        try{
            NavMapper mapper = session.getMapper(NavMapper.class);
            nav_list = mapper.queryAllNav();
        }
        finally {
            session.close();
        }
        //list 转 json
        return new utils().List2Json(nav_list);
    }
    @RequestMapping(value = "/addNav",method = RequestMethod.POST)

    @ResponseBody
    public String AddNav(HttpServletRequest request) throws IOException {
        Nav nav = new Nav();
        nav.setNav_id(new utils().getID());
        nav.setNav_name(request.getParameter("nav_name"));
        nav.setNav_feight(Integer.parseInt(request.getParameter("nav_feight")));
        SqlSession session = new utils().getSessionFactory().openSession(true);
        try{
            NavMapper mapper = session.getMapper(NavMapper.class);
            mapper.addNav(nav);
        }catch (Exception e){
            return "false";
        }
        finally {
            session.close();
        }
        //返回flag
        return "true";
    }
    @RequestMapping(value = "/updateNav",method = RequestMethod.POST)
    @ResponseBody
    public String UpdateNav(HttpServletRequest request) throws IOException {
        Nav nav = new Nav();
        nav.setNav_id(request.getParameter("nav_id"));
        nav.setNav_name(request.getParameter("nav_name"));
        nav.setNav_feight(Integer.parseInt(request.getParameter("nav_feight")));
        SqlSession session = new utils().getSessionFactory().openSession(true);
        try{
            NavMapper mapper = session.getMapper(NavMapper.class);
            mapper.updateNav(nav);
        }catch (Exception e){
            return "false";
        }
        finally {
            session.close();
        }
        //返回flag
        return "true";
    }
    @RequestMapping(value = "/deleteNav",method = RequestMethod.POST)
    @ResponseBody
    public String DeleteNav(HttpServletRequest request) throws IOException {
        Nav nav = new Nav();
        nav.setNav_id(request.getParameter("nav_id"));

        SqlSession session = new utils().getSessionFactory().openSession(true);
        try{
            NavMapper mapper = session.getMapper(NavMapper.class);
            mapper.deleteNav(nav);
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

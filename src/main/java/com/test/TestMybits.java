package com.test;

import com.entity.Article;
import com.entity.Manager;
import com.mapper.ArticleMapper;
import com.mapper.ManagerMapper;
import com.utils.utils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestMybits {
    public SqlSessionFactory getSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory  = new SqlSessionFactoryBuilder().build(in);
        System.out.println("successful session factory");
        return factory;
    }
    public static void main(String[] args) throws IOException {
//        Manager manager = new Manager();
//        manager.setManager_id("zhangsan");
//        manager.setManager_pwd("123456");

//        SqlSessionFactory sessionFactory = new TestMybits().getSessionFactory();
//        System.out.println("building session");
//        SqlSession session = new utils().getSessionFactory().openSession(true);
//        System.out.println("session ok");
//        try{
//            ManagerMapper mapper = session.getMapper(ManagerMapper.class);
//            System.out.println("building mapper successful");
//            List<Manager> resultManager = mapper.queryAllManager();
//            System.out.println(resultManager.size());
//        }
//        finally {
//            session.close();
//        }
        SqlSession session = new utils().getSessionFactory().openSession(true);
        //获取连接会话

        try{
            Manager manager = new Manager();
            manager.setManager_id("jier");
//            manager.setManager_name("jier222");
//            manager.setManager_pwd("jier");
//            ManagerMapper mapper = session.getMapper(ManagerMapper.class);
//            mapper.addManager(manager);
//            session.close();
//            ManagerMapper mapper = session.getMapper(ManagerMapper.class);
//            mapper.updateManager(manager);
            ManagerMapper mapper = session.getMapper(ManagerMapper.class);
            Manager m = mapper.queryManagerByEntity(manager);
            session.close();
            System.out.println("OK");
            System.out.println(null != m);
        }
        finally {
            session.close();
        }

    }
}

package com.example.demo.controller;

import com.entity.Article;
import com.mapper.ArticleMapper;
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
public class ArticleController {

    @RequestMapping(value = "/queryAllArticle",method = RequestMethod.POST)
    @ResponseBody
    public String QueryAllArticle() throws IOException {
        List<Article> article_list = new ArrayList<Article>();
        //获取连接会话
        SqlSession session = new utils().getSessionFactory().openSession(true);
        try{
            ArticleMapper mapper = session.getMapper(ArticleMapper.class);
            article_list = mapper.queryAllArticle();
        }
        finally {
            session.close();
        }
        //list 转 json
        return new utils().List2Json(article_list);
    }
    @RequestMapping(value = "/queryArticleByTitle",method = RequestMethod.POST)
    @ResponseBody
    public String QueryArticleByTitle(HttpServletRequest request) throws IOException {
        List<Article> article_list = new ArrayList<Article>();
        Article article = new Article();

        article.setArticle_title(request.getParameter("article_title"));
        article.setNav_name(request.getParameter("nav_name"));
        //获取连接会话
        SqlSession session = new utils().getSessionFactory().openSession(true);
        try{
            ArticleMapper mapper = session.getMapper(ArticleMapper.class);
            article_list = mapper.queryArticleByTitle(article);
        }
        finally {
            session.close();
        }
        //list 转 json
        return new utils().List2Json(article_list);
    }
    @RequestMapping(value = "/addArticle",method = RequestMethod.POST)
    @ResponseBody
    public String AddArticle(HttpServletRequest request) throws IOException {
        Article article = new Article();
        article.setArticle_id(new utils().getID());
        article.setArticle_title(request.getParameter("article_title"));
        article.setArticle_date(request.getParameter("article_date"));
        article.setArticle_content(request.getParameter("article_content"));
        article.setNav_name(request.getParameter("nav_name"));
        SqlSession session = new utils().getSessionFactory().openSession(true);
        try{
            ArticleMapper mapper = session.getMapper(ArticleMapper.class);
            mapper.addArticle(article);
        }catch (Exception e){
            return "false";
        }
        finally {
            session.close();
        }
        //返回flag
        return "true";
    }
    @RequestMapping(value = "/updateArticle",method = RequestMethod.POST)
    @ResponseBody
    public String UpdateArticle(HttpServletRequest request) throws IOException {
        Article article = new Article();
        article.setArticle_title(request.getParameter("article_title"));
        article.setArticle_id(request.getParameter("article_id"));
        article.setArticle_date(request.getParameter("article_date"));
        article.setArticle_date(request.getParameter("article_content"));
        article.setNav_id(request.getParameter("nav_id"));
        SqlSession session = new utils().getSessionFactory().openSession(true);
        try{
            ArticleMapper mapper = session.getMapper(ArticleMapper.class);
            mapper.updateArticle(article);
        }catch (Exception e){
            return "false";
        }
        finally {
            session.close();
        }
        //返回flag
        return "true";
    }
    @RequestMapping(value = "/deleteArticle",method = RequestMethod.POST)
    @ResponseBody
    public String DeleteArticle(HttpServletRequest request) throws IOException {
        Article article = new Article();
        article.setArticle_id(request.getParameter("article_id"));

        SqlSession session = new utils().getSessionFactory().openSession(true);
        try{
            ArticleMapper mapper = session.getMapper(ArticleMapper.class);
            mapper.deleteArticle(article);
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

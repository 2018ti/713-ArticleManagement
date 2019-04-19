package com.hubu713.controller;
import com.hubu713.pojo.Article;
import com.hubu713.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * @Description 根据用户名查询用户的所有的文章
     * @Date 2019/4/8
     * @Param HttpSession session 获取user，进而得到username
     * @Author 龚佳民
     **/
    @RequestMapping("/selArticles")
    @ResponseBody
    public HashMap<String, Object> selArticles(HttpSession session) {
        HashMap<String,Object> map = new HashMap<>();
        String username = (String) session.getAttribute("username");
        List<Article> articleList = articleService.showArticles(username);
        map.put("articleList",articleList);
        return map;
    }

    /**
     * @Description 根据文章id，查询文章信息，
     * @Date  2019/4/8
     * @Param int id，由前端获取id值，拼接在url后
     * @Author 龚佳民
     **/
    @RequestMapping("/show")
    @ResponseBody
    public Map<String, Object> showArticle(int id){
        HashMap<String,Object> map = new HashMap<>();
        Article article = articleService.showArticle(id);
        map.put("article",article);
        return map;
    }

    /**
     * @Description 根据文章id,查询文章信息，将文章信息以txt的格式下载到本地
     * @Date  2019/4/8
     * @Param   int id，由前端获取id值，拼接在url后
     * @Param   int id，由动态main.html中 session.article.id获取id值
     * @Author 龚佳民
     **/
    @RequestMapping("/download")
    @ResponseBody
    public HashMap<String,Object> downloadArticle(int id, HttpServletResponse res,HttpServletRequest req) throws IOException {
        HashMap<String,Object> map = new HashMap<>();
        //查询文章信息
        Article article = articleService.showArticle(id);
        String content = article.getContent();
        //设置文件名的编码格式
        String fileName=new String(article.getTitle().getBytes("UTF-8"),"ISO8859-1");
        res.setHeader("Content-Disposition","attachment;filename="+fileName+".txt");
        //将输出流相应给浏览器
        ServletOutputStream outputStream = res.getOutputStream();
        System.out.println(outputStream);
        byte[] bytes = content.getBytes();
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();

        return map;
    }

    /**
     *
     * @Author 梁山
     * @date 2019年4月10日 21:53:19
     * 更新文章
     */
    @PostMapping("/updateArticle")
    @ResponseBody
    public HashMap<String,Object> updateArticle(@RequestParam("id")int id,@RequestParam("content")String content){
        HashMap<String,Object> map=new HashMap<>();
        articleService.updateArticle(content,new Timestamp(new Date().getTime()),id);
        map.put("msg","文章更新成功！");
        return map;
    }

    /**
     *
     * @Author 梁山
     * @date 2019年4月10日 21:53:19
     * 插入文章
     *
     */
    @PostMapping("/insert")
    @ResponseBody
    public HashMap<String,Object> insertArticle(@RequestParam("author") String author,
                                                @RequestParam("title")String title,
                                                @RequestParam("content")String content,
                                                HttpSession session){ //得到session中的user,绑定文章所属者
        System.out.println("进入");
        HashMap<String,Object> map=new HashMap<>();
        String username= (String)session.getAttribute("username");
        articleService.insertArticle(username,author,title,content,new Timestamp(new Date().getTime()), new Timestamp(new Date().getTime()),0);
        map.put("msg","插入文章成功");
        return map;
    }

}

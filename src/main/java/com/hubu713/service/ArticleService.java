package com.hubu713.service;

import com.hubu713.mapper.ArticleMapper;
import com.hubu713.pojo.Article;
import com.hubu713.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;


import java.util.List;

@Service
public class ArticleService {


    @Autowired
    private ArticleMapper articleMapper;

    /**
     * @Description 根据用户名username获取用户所有的文章 在main主页要显示的所有文章
     * @Date  2019/4/8
     * @Param String username
     * @return  List<Article>
     * @Author 龚佳民
     **/
    public List<Article> showArticles(String username){
        List<Article> article = articleMapper.selArticlesByUsername(username);
        return article;
    }

    /**
     * @Description 根据文章id获取文章信息
     * @Date  2019/4/8
     * @Param int id
     * @return Article
     * @Author 龚佳民
     **/
    public Article showArticle(int id){
        Article article = articleMapper.selArticleById(id);
        return article;
    }

    /**
     * @Author 梁山
     * @Date 2019年4月10日 19:03:35
     * 文章更新
     *
     */
    public void updateArticle(String content, Date updateTime, int ArticleId) {
        articleMapper.updateArticle(content,updateTime,ArticleId);
    }

    /**
     * @author 梁山
     * @Date 2019年4月10日 19:08:03
     * 文章插入
     */
    public void insertArticle( String username, String author, String title,
                              String content,  Timestamp creat_time, Timestamp update_time,int isDelete){
        articleMapper.insArticle(username,author,title,content,creat_time,update_time,isDelete);
    }
}


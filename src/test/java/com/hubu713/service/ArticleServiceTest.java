package com.hubu713.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    ArticleService articleService;
    @Test
    public void checkUser() {
    }

    @Test
    public void showArticles() {
    }

    @Test
    public void showArticle() {
    }

    @Test
    public void updateArticle() {
    }

    @Test
    public void insertArticle() {
        articleService.insertArticle("azure","azure","测试","文章内容测试",
                new Timestamp(new Date().getTime()), new Timestamp(new Date().getTime()),1);
    }
}
package com.hubu713.article_management_system;

import com.hubu713.mapper.ArticleMapper;
import com.hubu713.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleManagementSystemApplicationTests {

    @Autowired
    private ArticleService articleService;
    @Resource
    private ArticleMapper articleMapper;
    @Test
    public void contextLoads() {
    }

}

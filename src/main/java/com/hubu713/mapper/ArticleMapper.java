package com.hubu713.mapper;
import com.hubu713.pojo.Article;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Mapper
public interface ArticleMapper {
    /**
     * @Description 根据用户名查询该用户的所有文章信息
     * @Date  2019/4/8
     * @return List<Article>
     * @Author 龚佳民
     **/
    @Select("select * from article_table where username=#{username}")
    List<Article> selArticlesByUsername(@Param("username") String username);


    /**
     * @Description 根据文章id查询文章信息
     * @Date  2019/4/8
     * @return Article
     * @Author 龚佳民
     **/
    @Select("select * from article_table where id=#{id}")
    Article selArticleById(@Param("id") int id);

    //添加文章
    @Insert("insert into article_table (id,username,author,title,content,creat_time,update_time,is_delete) values(default,#{username},#{author},#{title}," +
            "#{content},#{creatTime},#{updateTime},#{isDelete})")
    void insArticle( @Param("username") String username, @Param("author") String author,
                     @Param("title") String title, @Param("content") String content,
                     @Param("creatTime") Timestamp creatTime, @Param("updateTime") Timestamp updateTime,
                     @Param("isDelete") int isDelete);
    /**
     *
     * @Author 梁山
     * @date  2019年4月10日 18:59:10
     * 根据文章id修改文章内容
     */
    @Update("update article_table set content=#{content},update_time=#{updateTime} where id=#{id}")
    void updateArticle(@Param("content") String content, @Param("updateTime") Date updateTime, @Param("id") int id);
}

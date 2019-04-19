package com.hubu713.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @Description null
 * @Author 李家辉
 * @Date: 2019/4/10 22:07
 * @Version 1.0
 */
@Mapper
public interface TxtMapper {

    //主页或详情页删除文章是根据id更改tIsTxtDelete
    @Update(" update article_table set is_delete=1 where id=#{id}")
    int deleteTxtById(int id);

    //回收站还原返回id根据id更改tIsTxtDelete
    @Update(" update article_table set is_delete=0 where id=#{id}")
    int recycleTxtById(int id);
}

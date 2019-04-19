package com.hubu713.mapper;
import com.hubu713.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;

@Mapper
public interface UserMapper {
        @Select("select * from user_table where username=#{username} and password=#{password}")
        User findUserByNameAndPswd(@Param("username") String username, @Param("password") String password);

        @Insert("insert into user_table values(default,#{username},#{password},#{telephone},#{age},#{creatTime},#{updateTime},null,null,null)")
        void addUser(@Param("username") String username, @Param("password") String password,
                     @Param("telephone") String telephone, @Param("age") int age,
                     @Param("creatTime") Timestamp creatTime, @Param("updateTime") Timestamp updateTime);

        @Select("select * from user_table where username=#{username}")
        User findUserByName(@Param("username") String username);
    }

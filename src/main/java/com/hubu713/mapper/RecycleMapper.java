package com.hubu713.mapper;


import com.hubu713.pojo.Recyclebin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RecycleMapper {

       //向回收表中插入被删除的数据
       @Insert("insert into recyclebin" +
               " (t_name,t_user_name,t_number,t_create_time,t_update_time," +
               "t_delete_time,t_txt_create_time,t_is_delete,t_txt_id)" +
               " values (#{tName},#{tUserName},#{tNumber},#{tCreateTime}," +
               "#{tUpdateTime},#{tDeleteTime},#{tTxtCreateTime},#{tIsDelete},#{tTxtId})")
       int insertDeleteTxt(Recyclebin recyclebin);

       //用户进入回收站查看到被删除文章简略信息
       @Select("select t_id,t_name,t_user_name" +
               " from recyclebin" +
               " where t_is_delete=0 and t_user_name=#{tUserName}")
       List<Recyclebin> selectAllTxtSimpleInfo(String username);



       //对某一文章进行查看或编辑
       @Select("select t_name,t_user_name,t_number,t_txt_create_time,t_delete_time" +
               " from recyclebin" +
               " where t_id=#{id}")
       Recyclebin selectSpecificInfo(Integer id);

       //在回收站彻底删除文章
       @Update("update recyclebin" +
               " set t_is_delete=1,t_update_time=curdate()" +
               " where t_id=#{id}")
       int deleteAticleTotally(Integer id);

       //用于主页后端根据文章id恢复文章
       @Select("select t_txt_id" +
               " from recyclebin" +
               " where t_id=#{id}")
       int returnAticleId(Integer id);

       //用于更新超过30天删除的文章数据
       @Update("update recyclebin" +
               " set t_is_delete=1,t_update_time=curdate() where DATE_SUB(CURDATE(), INTERVAL 30 DAY) > t_delete_time")
       int overThirtyDays();
}

package com.hubu713.service;

import com.hubu713.pojo.Recyclebin;
import com.hubu713.mapper.RecycleMapper;
import com.hubu713.mapper.TxtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description null
 * @Author 李家辉
 * @Date: 2019/4/5 11:42
 * @Version 1.0
 */
@Service
public class RecycleServiceImpl {
    @Autowired
    RecycleMapper recycleMapper;

    @Autowired
    TxtMapper txtMapper;

    public boolean insertDeleteTxt(Recyclebin recyclebin) {
        if(recyclebin!=null)
        {
            //创建插入被删除文章的插入时间
            Date date=new Date();
            recyclebin.settCreateTime(date);
            recyclebin.settUpdateTime(date);
            recyclebin.settDeleteTime(date);
            //插入的数据tIsDelete设为false,表示回收站的文章处于待还原或待删除状态
            recyclebin.settIsDelete(false);
            return (recycleMapper.insertDeleteTxt(recyclebin)==1)?true:false;
        }
        else
            return false;

    }

    //添加session中的user的username
    public List<Recyclebin> selectAllTxtSimpleInfo(String username) {

        return recycleMapper.selectAllTxtSimpleInfo(username);
    }



    public Recyclebin selectSpecificInfo(Integer id) {
        if(id!=null)
        {
            return recycleMapper.selectSpecificInfo(id);
        }
        else
            return null;

    }

    public boolean deleteAticleTotally(Integer id) {
        if(id!=null)
        {
            return (recycleMapper.deleteAticleTotally(id)==1)?true:false;
        }
        else
            return false;

    }

    public int returnAticleId(Integer id) {
        if(id!=null)
        {
            //先彻底删除，再返回文章id
            if(recycleMapper.deleteAticleTotally(id)==1)
            {
                return recycleMapper.returnAticleId(id);
            }
            else
                return 0;
        }
        else
            return 0;

    }

    public boolean overThirtyDays() {


        return (recycleMapper.overThirtyDays()==1)?true:false;

    }

    public boolean deleteTxtById(int id) {
        return (txtMapper.deleteTxtById(id)==1)?true:false;
    }

    public boolean recycleTxtById(int id) {
        return (txtMapper.recycleTxtById(id)==1)?true:false;
    }
}

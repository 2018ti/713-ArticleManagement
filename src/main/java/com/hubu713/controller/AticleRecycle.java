package com.hubu713.controller;

import com.hubu713.pojo.Msg;
import com.hubu713.pojo.Recyclebin;
import com.hubu713.service.RecycleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description 文章被删除记录到回收站的相关拦截方法
 * @Author 李家辉
 * @Date: 2019/4/5 11:55
 * @Version 1.0
 */
@Controller
//@EnableAutoConfiguration
public class AticleRecycle {

    @Autowired
    RecycleServiceImpl recycleService;


    //主页或详情页删除文章是根据id更改tIsTxtDelete
    @RequestMapping(value = "/deleteTxtById")
    @ResponseBody
    public  Msg deleteTxtById(int id)
    {
        boolean b=recycleService.deleteTxtById(id);
        if(b)
            return Msg.success();
        else
            return Msg.fail().addFailMessage("文章删除失败");
    }


    //回收站还原返回id根据id更改tIsTxtDelete
    @RequestMapping(value = "/recycleTxtById")
    @ResponseBody
    public  Msg recycleTxtById(int id)
    {
        boolean b=recycleService.recycleTxtById(id);
        if(b)
            return Msg.success();
        else
            return Msg.fail().addFailMessage("文章还原失败");
    }


    //处理从主页上被删除的文章，将信息插入到数据库中
    //传入t_name,t_user_name,t_number,t_txt_create_time,t_txt_id
    @RequestMapping(value = "/insertRecycleAticle")
    @ResponseBody
    public Msg insertRecycleAticle(Recyclebin recyclebin) {

        if(recycleService.insertDeleteTxt(recyclebin))
        {
            return  Msg.success();
        }
        else
            return Msg.fail().addFailMessage("插入被删除文章信息失败");

    }


    //用于更新超过30天删除的文章数据,在进入回收站之前更新
    @ResponseBody
    @RequestMapping(value = "/updateInfo")
    public Msg updateInfo() {

        boolean b=recycleService.overThirtyDays();
        return Msg.success();

    }

    //进入回收站查询些简单信息
    //返回t_id,t_name,t_user_name
    @RequestMapping(value = "/querySimpleInfo")
    @ResponseBody
    public Msg querySimpleInfo(HttpSession session) {
        //只能进入本人回收站
        String username = (String) session.getAttribute("username");
        List<Recyclebin> list=recycleService.selectAllTxtSimpleInfo(username);
        if(list!=null)
        {
            return Msg.success().add("allRecycleInfo",list);
        }
        else
           return Msg.fail().addFailMessage("获取文章信息失败");
    }


    //根据传入id查看某一文章具体信息或对其进行操作
    //传入t_id
    //传出t_name,t_user_name,t_number,t_txt_create_time,t_delete_time
    @RequestMapping(value = "/querySpecificInfo")
    @ResponseBody
    public Msg querySpecificInfo(Integer id) {
        Recyclebin recyclebin=recycleService.selectSpecificInfo(id);
        if(recyclebin!=null)
        {
            return Msg.success().add("recycleInfo",recyclebin);
        }
        else
             return Msg.fail().addFailMessage("文章查看具体信息失败");
    }

    //在回收站彻底删除文章
    //传入t_id
    @RequestMapping(value = "/deletetotally")
    @ResponseBody
    public Msg deletetotally(Integer id) {
        if(recycleService.deleteAticleTotally(id))
        {
            return Msg.success();
        }
        else
           return Msg.fail().addFailMessage("文章彻底删除失败");
    }

    //返回当前文章的唯一id用于还原文章，前端获取文章的id后交给后端处理文章更新类似isDelete字段为false
    //传入t_id
    //传出t_txt_id
    @RequestMapping(value = "/restore")
    @ResponseBody
    public Msg restore(Integer id) {
        int txtId=recycleService.returnAticleId(id);
        if(txtId!=0)
        {
            return Msg.success().add("txtId",txtId);
        }
        else
            return Msg.fail().addFailMessage("文章还原失败");
    }



}

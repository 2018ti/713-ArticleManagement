package com.hubu713.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Description 用来记录被删除文章
 * @Author  李家辉
 * @Date: 2019/4/5 10:22
 * @Version 1.0
 */

public class Recyclebin {
    //回收文章id
    private int tId;

    //文章被删除前唯一id
    private int tTxtId;
    //回收文章名称
    private String tName;
    //文章创建者
    private String tUserName;
    //文章包含字数
    private int tNumber;
    //记录创建时间
    private Date tCreateTime;
    //记录更新时间
    private Date tUpdateTime;
    //文章删除时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date tDeleteTime;
    //文章创建时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date tTxtCreateTime;
    //标记文章是否在回收站被删除
    private boolean tIsDelete;

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettUserName() {
        return tUserName;
    }

    public void settUserName(String tUserName) {
        this.tUserName = tUserName;
    }

    public int gettNumber() {
        return tNumber;
    }

    public void settNumber(int tNumber) {
        this.tNumber = tNumber;
    }

    public Date gettCreateTime() {
        return tCreateTime;
    }

    public void settCreateTime(Date tCreateTime) {
        this.tCreateTime = tCreateTime;
    }

    public Date gettUpdateTime() {
        return tUpdateTime;
    }

    public void settUpdateTime(Date tUpdateTime) {
        this.tUpdateTime = tUpdateTime;
    }

    public Date gettDeleteTime() {
        return tDeleteTime;
    }

    public void settDeleteTime(Date tDeleteTime) {
        this.tDeleteTime = tDeleteTime;
    }

    public Date gettTxtCreateTime() {
        return tTxtCreateTime;
    }

    public void settTxtCreateTime(Date tTxtCreateTime) {
        this.tTxtCreateTime = tTxtCreateTime;
    }

    public boolean istIsDelete() {
        return tIsDelete;
    }

    public void settIsDelete(boolean tIsDelete) {
        this.tIsDelete = tIsDelete;
    }


    public int gettTxtId() {
        return tTxtId;
    }

    public void settTxtId(int tTxtId) {
        this.tTxtId = tTxtId;
    }

}

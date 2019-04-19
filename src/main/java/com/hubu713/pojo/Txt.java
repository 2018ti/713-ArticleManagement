package com.hubu713.pojo;

/**
 * @Description null
 * @Author 李家辉
 * @Date: 2019/4/10 22:04
 * @Version 1.0
 */
public class Txt {
    //文章标识id
    private int id;

    //判断文章是否删除
    private boolean isDelete;

    public int gettTxtId() {
        return id;
    }

    public void settTxtId(int tTxtId) {
        this.id = tTxtId;
    }

    public boolean istTxtIsDelete() {
        return isDelete;
    }

    public void settTxtIsDelete(boolean tTxtIsDelete) {
        this.isDelete = tTxtIsDelete;
    }
}

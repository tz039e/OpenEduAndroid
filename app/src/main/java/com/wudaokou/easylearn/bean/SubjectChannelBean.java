package com.wudaokou.easylearn.bean;

public class SubjectChannelBean {
    public String topicid;

    // 设置该标签是否可编辑，如果出现在我的频道中，且值为1，则可在右上角显示删除按钮
    public int editStatus;

    public String cid;
    public String tname;
    public String ename;

    // 标签类型，显示是我的频道还是更多频道
    public int tabType;

    public String tid;
    public String column;

    public SubjectChannelBean(){}

    public SubjectChannelBean(String tname, String tid){
        this.tname = tname;
        this.tid = tid;
    }

    public SubjectChannelBean(String tname, String column, String tid){
        this.tname = tname;
        this.column = column;
        this.tid = tid;
    }

    public String getTopicid() {
        return topicid;
    }

    public void setTopicid(String topicid) {
        this.topicid = topicid;
    }

    public int getEditStatus() {
        return editStatus;
    }

    public void setEditStatus(int editStatus) {
        this.editStatus = editStatus;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getTabType() {
        return tabType;
    }

    public void setTabType(int tabType) {
        this.tabType = tabType;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }
}

package com.softtanck.framework.bean;

import java.util.List;

/**课程和报名的父Bean
 * Created by herui on 8/27/2015.
 */
public class CourseAndSignUpInfo {
    /**
     * 父标题类型
     */
    private String parentType;
    /**
     * 父标题时间
     */
    private String parentTime;
    /**
     * 父标题内容
     */
    private String parentContent;
    /**
     * 父标题阅读的百分比
     */
    private int parentPercent;
    /**
     * 父标题包含的子类集合
     */
    private List<ChildCourseAndSignUpInfo> list;
    public List<ChildCourseAndSignUpInfo> getList() {
        return list;
    }

    public void setList(List<ChildCourseAndSignUpInfo> list) {
        this.list = list;
    }


    public String getParentType() {
        return parentType;
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
    }

    public String getParentTime() {
        return parentTime;
    }

    public void setParentTime(String parentTime) {
        this.parentTime = parentTime;
    }

    public String getParentContent() {
        return parentContent;
    }

    public void setParentContent(String parentContent) {
        this.parentContent = parentContent;
    }

    public int getParentPercent() {
        return parentPercent;
    }

    public void setParentPercent(int parentPercent) {
        this.parentPercent = parentPercent;
    }
}

package com.softtanck.framework.bean;

import java.util.List;

/**�γ̺ͱ����ĸ�Bean
 * Created by herui on 8/27/2015.
 */
public class CourseAndSignUpInfo {
    /**
     * ����������
     */
    private String parentType;
    /**
     * ������ʱ��
     */
    private String parentTime;
    /**
     * ����������
     */
    private String parentContent;
    /**
     * �������Ķ��İٷֱ�
     */
    private int parentPercent;
    /**
     * ��������������༯��
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

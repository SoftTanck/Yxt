package com.softtanck.framework.bean;

/**课程和报名展开的Bean
 * Created by herui on 8/27/2015.
 */
public class ChildCourseAndSignUpInfo  {

    /**
     * 子标题的内容
     */
    private String childContent;

    /**
     * 子标题类型
     */
    private int childType;
    /**
     * 子标题播放状态
     */
    private int childPlayStatus;

    public String getChildContent() {
        return childContent;
    }

    public void setChildContent(String childContent) {
        this.childContent = childContent;
    }

    public int getChildType() {
        return childType;
    }

    public void setChildType(int childType) {
        this.childType = childType;
    }

    public int getChildPlayStatus() {
        return childPlayStatus;
    }

    public void setChildPlayStatus(int childPlayStatus) {
        this.childPlayStatus = childPlayStatus;
    }
}
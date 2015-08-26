package com.softtanck.framework.bean;

/**排名信息
 * Created by herui on 8/26/2015.
 */
public class RankInfo {

    /**
     * 序号
     */
    private String number;
    /**
     * 工号
     */
    private String staffNumber;
    /**
     * 姓名
     */
    private String staffName;
    /**
     * 分值
     */
    private String score;

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getNumber() {

        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

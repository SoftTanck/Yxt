package com.softtanck.framework.bean;

/**������Ϣ
 * Created by herui on 8/26/2015.
 */
public class RankInfo {

    /**
     * ���
     */
    private String number;
    /**
     * ����
     */
    private String staffNumber;
    /**
     * ����
     */
    private String staffName;
    /**
     * ��ֵ
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

package ajava_EE.message.rmi;

import java.io.Serializable;

public class UserInfos implements Serializable {
    private String userName;
    private String userDesc;
    private Integer userAge;
    private Boolean userSex;

    @Override
    public String toString() {
        return "UserInfos{" +
                "userName='" + userName + '\'' +
                ", userDesc='" + userDesc + '\'' +
                ", userAge=" + userAge +
                ", userSex=" + userSex +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Boolean getUserSex() {
        return userSex;
    }

    public void setUserSex(Boolean userSex) {
        this.userSex = userSex;
    }
}

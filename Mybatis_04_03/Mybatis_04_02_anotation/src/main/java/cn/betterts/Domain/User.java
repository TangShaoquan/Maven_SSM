package cn.betterts.Domain;

import java.io.DataInput;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer Id;
    private String userName;
    private String Sex;
    private Date Birthday;
    private String Address;

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", userName='" + userName + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Birthday=" + Birthday +
                ", Address='" + Address + '\'' +
                '}';
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}

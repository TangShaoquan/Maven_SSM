package cn.betterts.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String name;
    private String passd;
    private Date birthday;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", passd='" + passd + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassd() {
        return passd;
    }

    public void setPassd(String passd) {
        this.passd = passd;
    }
}

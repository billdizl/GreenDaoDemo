package com.fsp.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by kaifa on 2017/6/28.
 */
@Entity
public class UserInfo {
    @Id(autoincrement =true)
    private Long id;
    private String name;
    private int age;
    private int sex;
    //以下内容是自动产生的
    @Generated(hash = 1968140991)
    public UserInfo(Long id, String name, int age, int sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    @Generated(hash = 1279772520)
    public UserInfo() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getSex() {
        return this.sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
}

package com.fys.music.model;

import java.util.List;

/**
 * 用户实体类
 */
public class User {
    private int id; //用户内部id

    private String username; //用户账号
    private String password; //用户密码
    private String email; //电子邮箱
    private String url;  //找回密码的url
    private Integer state; //账号是否激活 1表示激活 0表示未激活
    private String sex; //性别
    private Integer age; //年龄
    private String phone; //手机号
    private String birthday; //生日
    private String hobby; //爱好
    private String address; //地址
    private List<Music> musicList; //歌单
    private String signature; //个性签名

    private String lastLoginTime; //最后一次登陆的时间

    public String getSignature() {
        return signature;
    }


    public User() {

    }

    public User(int id, String username, String password, String email, String url, Integer state, String sex, Integer age, String phone, String birthday, String hobby, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.url = url;
        this.state = state;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.birthday = birthday;
        this.hobby = hobby;
        this.address = address;
    }

    public User(String username, String password, String email, String sex, Integer age, String phone, String birthday, String hobby, String address) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.birthday = birthday;
        this.hobby = hobby;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}

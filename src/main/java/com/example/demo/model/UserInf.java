package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author hujing
 * @since 2019-05-11
 */
public class UserInf implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("USER_ID")
    private String userId;

    /**
     * 名字
     */
    @TableField("NAME")
    private String name;

    /**
     * 昵称
     */
    @TableField("NICK_NAME")
    private String nickName;

    /**
     * 账号
     */
    @TableField("ACCOUNT_NUMBER")
    private String accountNumber;

    /**
     * 加密密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 明文密码
     */
    @TableField("PASSWORDV")
    private String passwordv;

    /**
     * 男
     */
    @TableField("SEX")
    private String sex;

    /**
     * 年龄
     */
    @TableField("AGE")
    private String age;

    /**
     * 电话号
     */
    @TableField("PHOTO")
    private String photo;

    /**
     * 邮箱
     */
    @TableField("EMAIL")
    private String email;

    /**
     * 地址
     */
    @TableField("ADRESS")
    private String adress;

    /**
     * 权限
     */
    @TableField("POWER")
    private String power;

    /**
     * 有效
     */
    @TableField("EFFECTIVE")
    private Integer effective;

    /**
     * 原因
     */
    @TableField("RESASON")
    private String resason;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordv() {
        return passwordv;
    }

    public void setPasswordv(String passwordv) {
        this.passwordv = passwordv;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public Integer getEffective() {
        return effective;
    }

    public void setEffective(Integer effective) {
        this.effective = effective;
    }

    public String getResason() {
        return resason;
    }

    public void setResason(String resason) {
        this.resason = resason;
    }

    @Override
    public String toString() {
        return "UserInf{" +
        "userId=" + userId +
        ", name=" + name +
        ", nickName=" + nickName +
        ", accountNumber=" + accountNumber +
        ", password=" + password +
        ", passwordv=" + passwordv +
        ", sex=" + sex +
        ", age=" + age +
        ", photo=" + photo +
        ", email=" + email +
        ", adress=" + adress +
        ", power=" + power +
        ", effective=" + effective +
        ", resason=" + resason +
        "}";
    }
}

package org.demo.spring.model;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
public class User {
    public Long id;
    public String username;
    public String password;
    public String tel;
    public String regtime;
    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setTel(String tel){
        this.tel = tel;
    }
    public String getTel(){
        return this.tel;
    }
    public void setRegtime(String regtime){
        this.regtime = regtime;
    }
    public String getRegtime(){
        return this.regtime;
    }
}

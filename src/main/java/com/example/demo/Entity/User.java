package com.example.demo.Entity;


import java.sql.Date;
/**
 * @author xinYing
 * @date 2019/7/4 21:16
 */
public class User {
    private Integer id;
    private Long account;
    private String password;
    private String username;
    private Integer state;
    private String url;
    private Date registerDate;
    public User(){

    }
    public User(Integer id, Long account, String password, String username, Integer state, String url, Date registerDate) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.username = username;
        this.state = state;
        this.url = url;
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account=" + account +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", state=" + state +
                ", url='" + url + '\'' +
                ", registerDate=" + registerDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}

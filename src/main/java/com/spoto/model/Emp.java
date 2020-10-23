package com.spoto.model;

public class Emp {
    private Integer id;
    private String role;
    private String username;
    private String uname;
    private String passwd;
    private String status;
    private String others;

    public Emp() {
    }

    public Emp(Integer id, String role, String username, String uname, String passwd, String status, String others) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.uname = uname;
        this.passwd = passwd;
        this.status = status;
        this.others = others;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", username='" + username + '\'' +
                ", uname='" + uname + '\'' +
                ", passwd='" + passwd + '\'' +
                ", status='" + status + '\'' +
                ", others='" + others + '\'' +
                '}';
    }
}

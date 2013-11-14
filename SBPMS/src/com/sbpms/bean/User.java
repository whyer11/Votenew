package com.sbpms.bean;

/**
 *Bean for save the user
 * 
 * @author IanLi
 */
public class User {

    private String pre_password;
    private Integer id;
    private String name;
    private String password;
    private String e_mail;
    private String role;
    private String report_to;
    
    
    
    public String getPre_password() {
        return pre_password;
    }

    
    public void setPre_password(String pre_password) {
        this.pre_password = pre_password;
    }

    
    public Integer getId() {
        return id;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public String getPassword() {
        return password;
    }

    
    public void setPassword(String password) {
        this.password = password;
    }

    
    public String getE_mail() {
        return e_mail;
    }

    
    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    
    public String getRole() {
        return role;
    }

    
    public void setRole(String role) {
        this.role = role;
    }

    
    public String getReport_to() {
        return report_to;
    }

    
    public void setReport_to(String report_to) {
        this.report_to = report_to;
    }

    @Override
    public String toString()
    {
        return name+"  "+password;
    }

}

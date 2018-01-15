package net.lddhappy.data.model.common;

import java.util.Date;

public class TbUser {
    private Integer ID;

    private String account;

    private String name;

    private String password;

    private String company;

    private String department;

    private String position;

    private String email;

    private String cellPhone;

    private String phone;

    private String address;

    private Boolean isOnLine;

    private Date lastOnLine;

    private Boolean isAdmin;

    private Integer allowAccessType;

    private Integer companyID;

    private String headPhotoPath;

    private Integer warnLevel;

    private Boolean userEnable;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getIsOnLine() {
        return isOnLine;
    }

    public void setIsOnLine(Boolean isOnLine) {
        this.isOnLine = isOnLine;
    }

    public Date getLastOnLine() {
        return lastOnLine;
    }

    public void setLastOnLine(Date lastOnLine) {
        this.lastOnLine = lastOnLine;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Integer getAllowAccessType() {
        return allowAccessType;
    }

    public void setAllowAccessType(Integer allowAccessType) {
        this.allowAccessType = allowAccessType;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public String getHeadPhotoPath() {
        return headPhotoPath;
    }

    public void setHeadPhotoPath(String headPhotoPath) {
        this.headPhotoPath = headPhotoPath;
    }

    public Integer getWarnLevel() {
        return warnLevel;
    }

    public void setWarnLevel(Integer warnLevel) {
        this.warnLevel = warnLevel;
    }

    public Boolean getUserEnable() {
        return userEnable;
    }

    public void setUserEnable(Boolean userEnable) {
        this.userEnable = userEnable;
    }

    @Override
    public String toString() {
        return "TbUser{" +
                "ID=" + ID +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", company='" + company + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", isOnLine=" + isOnLine +
                ", lastOnLine=" + lastOnLine +
                ", isAdmin=" + isAdmin +
                ", allowAccessType=" + allowAccessType +
                ", companyID=" + companyID +
                ", headPhotoPath='" + headPhotoPath + '\'' +
                ", warnLevel=" + warnLevel +
                ", userEnable=" + userEnable +
                '}';
    }
}
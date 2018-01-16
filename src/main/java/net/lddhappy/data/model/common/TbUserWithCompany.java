package net.lddhappy.data.model.common;

/**
 * Created by ldd on 18-1-16.
 */
public class TbUserWithCompany {
    private Integer ID;

    private String account;

    private String name;

    private TbCompany company;

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

    public TbCompany getCompany() {
        return company;
    }

    public void setCompany(TbCompany company) {
        this.company = company;
    }
}

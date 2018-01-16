package net.lddhappy.data.model.common;

/**
 * Created by ldd on 18-1-16.
 */
public class TbUserReadOnly {
    private Integer ID;

    private String account;

    private String name;

    public TbUserReadOnly(Integer ID, String account, String name) {
        this.ID = ID;
        this.account = account;
        this.name = name;
    }

    public Integer getID() {
        return ID;
    }

    public String getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TbUserReadOnly{" +
                "ID=" + ID +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

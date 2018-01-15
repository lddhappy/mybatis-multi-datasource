package net.lddhappy.data.model.parameter;

/**
 * Created by ldd on 18-1-16.
 */
public class TbUserQueryParameter {
    private String tableName;
    private int userID;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}

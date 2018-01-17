package net.lddhappy.data.model.common;

import net.lddhappy.util.StringUtil;

import java.util.stream.Stream;

/**
 * Created by Liudongdong on 18/1/17.
 */
public class DbConfig {
    private String server;
    private String db;
    private String uid;
    private String pwd;
    private int port;

    public DbConfig() {
        port = 3306;
    }

    //jdbc:mysql://test.shmedo.cn:3306/mdm_common_db?useUnicode=true&amp;characterEncoding=UTF-8
    public String getUrl() {
        return "jdbc:mysql://" + this.server + ":" + this.port + "/" + this.db + "?useUnicode=true&characterEncoding=UTF-8";
    }


    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    //server=localhost;user id=root;password=420529;database=mdm_59_db;port=3306
    public static DbConfig parseConfig(String conn) {
        if (StringUtil.isNullOrEmpty(conn))
            return null;
        DbConfig config = new DbConfig();
        String[] parts = conn.split(";");
        Stream.of(parts).forEach(s -> {
            String[] twoParts = s.split("=");
            if (twoParts != null && (twoParts.length == 2)) {
                if (twoParts[0].toLowerCase().contains("server"))
                    config.server = twoParts[1];
                if (twoParts[0].toLowerCase().contains("user"))
                    config.uid = twoParts[1];
                if (twoParts[0].toLowerCase().contains("password"))
                    config.pwd = twoParts[1];
                if (twoParts[0].toLowerCase().contains("database"))
                    config.db = twoParts[1];
                if (twoParts[0].toLowerCase().contains("port"))
                    config.port = Integer.parseInt(twoParts[1]);
            }
        });
        return config;
    }
}

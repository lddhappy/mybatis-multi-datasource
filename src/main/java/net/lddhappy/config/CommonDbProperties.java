package net.lddhappy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Liudongdong on 18/1/15.
 */
@Configuration
@PropertySource(value = "classpath:common_db.properties", encoding = "utf-8")
public class CommonDbProperties {
    @Value("${commondb.driver}")
    private String driver;
    @Value("${commondb.url}")
    private String url;
    @Value("${commondb.uid}")
    private String uid;
    @Value("${commondb.pwd}")
    private String pwd;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
}

package net.lddhappy.util;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * Created by Liudongdong on 18/1/17.
 */
public class DbUtil {
    public static DruidDataSource initDruidDataSource(String driver, String url, String uid, String pwd) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(uid);
        dataSource.setPassword(pwd);

        dataSource.setInitialSize(3);
        dataSource.setMaxActive(100);
        dataSource.setMinIdle(3);
        dataSource.setValidationQuery("select 1");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setMaxWait(60000);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(30000);
        return dataSource;
    }

}

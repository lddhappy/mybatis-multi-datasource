package net.lddhappy.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Liudongdong on 18/1/15.
 */
@Configuration
public class CommonDbBean {
    @Bean("commonDbDataSource")
    public DataSource commonDbDataSource(@Autowired CommonDbProperties commonDbProperties) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(commonDbProperties.getDriver());
        dataSource.setUrl(commonDbProperties.getUrl());
        dataSource.setUsername(commonDbProperties.getUid());
        dataSource.setPassword(commonDbProperties.getPwd());

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

    @Bean("commonDataSourceTransactionManager")
    public DataSourceTransactionManager commonDataSourceTransactionManager(
            @Autowired @Qualifier("commonDbDataSource") DataSource dataSource) {
        DataSourceTransactionManager transactionManager =
                new DataSourceTransactionManager(dataSource);
        return transactionManager;
    }

    @Bean("commonSqlSessionFactoryBean")
    public SqlSessionFactoryBean commonSqlSessionFactoryBean(
            @Autowired @Qualifier("commonDbDataSource") DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean("commonMapperScannerConfigurer")
    public MapperScannerConfigurer commonMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("commonSqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage("net.lddhappy.data.mapper.common");
        return mapperScannerConfigurer;
    }

    @Bean
    public MyBatisCursorItemReader commonMyBatisCursorItemReader(@Autowired @Qualifier("commonSqlSessionFactoryBean") SqlSessionFactoryBean sqlSessionFactoryBean) {
        try {
            MyBatisCursorItemReader itemReader = new MyBatisCursorItemReader();
            itemReader.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
            itemReader.setQueryId("net.lddhappy.data.mapper.common.TbUserMapper.selectAllReturnCursor");
            return itemReader;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}

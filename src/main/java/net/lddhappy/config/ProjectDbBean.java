package net.lddhappy.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Liudongdong on 18/1/17.
 */
@Configuration
public class ProjectDbBean {
    @Bean("mdnetDataSourceTransactionManager")
    public DataSourceTransactionManager transactionManager(
            @Autowired @Qualifier("mdnetDataSource") DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        return transactionManager;
    }

    @Bean("mdnetSqlSessionFactoryBean")
    public SqlSessionFactoryBean mdnetSqlSessionFactoryBean(
            @Autowired @Qualifier("mdnetDataSource") DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean("mdnetMapperScannerConfigurer")
    public MapperScannerConfigurer mdnetMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("mdnetSqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage("net.lddhappy.data.mapper.proj");
        return mapperScannerConfigurer;
    }
}

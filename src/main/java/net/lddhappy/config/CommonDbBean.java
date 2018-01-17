package net.lddhappy.config;

import com.alibaba.druid.pool.DruidDataSource;
import net.lddhappy.util.DbUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Liudongdong on 18/1/15.
 */
@Configuration
public class CommonDbBean {
    @Primary
    @Bean("commonDbDataSource")
    public DataSource commonDbDataSource(@Autowired CommonDbProperties commonDbProperties) {
        return DbUtil.initDruidDataSource(commonDbProperties.getDriver()
                , commonDbProperties.getUrl(), commonDbProperties.getUid(), commonDbProperties.getPwd());
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
        sqlSessionFactoryBean.setConfigLocation(
                new ClassPathResource("mybatis-config.xml")
        );
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

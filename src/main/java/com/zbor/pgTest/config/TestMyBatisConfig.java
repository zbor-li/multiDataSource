package com.zbor.pgTest.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.zbor.pgTest.mapper.test", sqlSessionFactoryRef = "testSqlSessionFactory")
public class TestMyBatisConfig {
    @Bean
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("dataSourceTest")DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager testTransactionManager(@Qualifier("dataSourceTest")DataSource dataSource) {
        return  new DataSourceTransactionManager(dataSource);
    }
}

package com.zbor.pgTest.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.zbor.pgTest.mapper.test2", sqlSessionFactoryRef = "test2SqlSessionFactory")
public class Test2MyBatisConfig {
    @Bean
    public SqlSessionFactory test2SqlSessionFactory(@Qualifier("dataSourceTest2")DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager test2TransactionManager(@Qualifier("dataSourceTest2") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}

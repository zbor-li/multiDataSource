package com.zbor.pgTest.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceTest2Config {
    @Bean(name = "dataSourceTest2")
    @ConfigurationProperties(prefix = "spring.datasource.b")
    public DataSource dataSourceTest2() {
        return new DruidDataSource();
    }
}

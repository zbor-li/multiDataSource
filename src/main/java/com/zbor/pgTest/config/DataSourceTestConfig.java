package com.zbor.pgTest.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class DataSourceTestConfig {
    @Bean(name = "dataSourceTest")
    @ConfigurationProperties(prefix = "spring.datasource.a")
    public DataSource dataSourceTest() {
        return new DruidDataSource();
    }
}

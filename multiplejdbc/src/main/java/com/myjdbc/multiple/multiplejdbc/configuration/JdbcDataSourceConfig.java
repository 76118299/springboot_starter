package com.myjdbc.multiple.multiplejdbc.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 多数据源配置
 */
@Configuration
public class JdbcDataSourceConfig {

    @Bean( name = "db1DataSourceProperties")
    @Primary
    @ConfigurationProperties(prefix = "app.datasource.db1")
    public DataSourceProperties db1DataSourceProperties(){
        return  new DataSourceProperties();
    }

    @Bean(name = "db2DataSourceProperties")
    @ConfigurationProperties(prefix = "app.datasource.db2")
    public DataSourceProperties db2DataSourceProperties(){
        return  new DataSourceProperties();
    }
    @Primary
    @Bean(name ="db1DataSource" )
    public DataSource db1DataSource(){
        return  db1DataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name ="db2DataSource" )
    public DataSource db2DataSource(){
        return  db2DataSourceProperties().initializeDataSourceBuilder().build();
    }
    @Bean(name = "db1JdbcTemplate")
    public JdbcTemplate db1JdbcTemplate(){
        return  new JdbcTemplate( db1DataSource());
    }

    @Bean(name = "db2JdbcTemplate")
    public JdbcTemplate db2JdbcTemplate(){
        return  new JdbcTemplate( db2DataSource());
    }

}

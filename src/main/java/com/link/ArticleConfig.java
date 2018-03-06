package com.link;

import com.link.startup.MenuGenerator;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/5 14:50
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.link"})
public class ArticleConfig {

    //mybatis配置数据源
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource primaryDataSource(){
        return DataSourceBuilder.create().build();
    }
    //配置SessionFactory
    @Bean
    public SqlSessionFactory myBatisSqlSessionFactory(DataSource primaryDataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(primaryDataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/com/link/db/mapper/*.xml"));
        return bean.getObject();
    }
    @Bean
    public MenuGenerator menuGenerator(){
        return new MenuGenerator();
    }
}

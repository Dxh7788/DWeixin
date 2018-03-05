package com.link;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Copyright (C) 2017-2018 https://www.dw.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/5 14:39
 */
@SpringBootApplication
@EnableAutoConfiguration
@MapperScan(value = {"com.link.db"})
@Import(value = ArticleConfig.class)
public class MicroArticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroArticleApplication.class, args);
    }
}

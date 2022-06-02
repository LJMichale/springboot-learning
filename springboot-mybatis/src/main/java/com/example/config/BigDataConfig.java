package com.example.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;

@EnableConfigurationProperties(MybatisProperties.class)
@MapperScan(basePackages = BigDataConfig.PACKAGE, sqlSessionFactoryRef = "bigdataSqlSessionFactory")
public class BigDataConfig {

    static final String PACKAGE = "com.example.mapper.bigdata";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ResourceLoader resourceLoader = new DefaultResourceLoader();

    @Bean(name = "bigdataDataSource")
    @Qualifier("bigdataDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.bigdata")
    public DataSource bigdataDataSource() {
        logger.info("-------------------- bigdataDataSource init ---------------------");
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "bigdataSqlSessionFactory")
    public SqlSessionFactory bigdataSqlSessionFactory(@Qualifier("bigdataDataSource") DataSource bigdataDataSource,
                                                      MybatisProperties mybatisProperties) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(bigdataDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/bigdata/*.xml"));
        sessionFactory.setConfigLocation(resourceLoader.getResource(mybatisProperties.getConfigLocation()));
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate autoSqlSessionTemplate(@Qualifier("bigdataSqlSessionFactory") SqlSessionFactory
                                                             sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        return template;
    }


}

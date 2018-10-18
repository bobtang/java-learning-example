package com.example.demoreactiveweb.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author liupei
 * @date 2018/10/15 11:03
 */
@Configuration
public class MyBatisConfig {
    
    
    @Autowired
    private DataSource dataSource;
    
    /*@Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean getSqlSessionFactoryBean() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //        bean.setCache();
        Resource[] resources = {new ClassPathResource("classpath*:mappers/**//*.xml")};
        /*bean.setMapperLocations(resources);
        // 事务
        ManagedTransactionFactory transactionFactory = new ManagedTransactionFactory();
        bean.setTransactionFactory(transactionFactory);
        // 别名设置
        bean.setTypeAliasesPackage("com.com.example.demoreactiveweb.module.*.model");
        return bean;
    }*/
    
    /*@Bean
    public PlatformTransactionManager createDataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
        //        return new DataSourceTransactionManager();
    }*/
    
    /*@Bean
    public MapperScannerConfigurer createMapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.example.demoreactiveweb.module.*.repository");
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return configurer;
    }*/
}

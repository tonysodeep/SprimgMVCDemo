/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tony.configs;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 *
 * @author hyngu
 */
@Configurable
@PropertySource("classpath:database.properties")
public class HibernateConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        factoryBean.setPackagesToScan(new String[]{
            "com.tony.pojos"
        });
        factoryBean.setDataSource(dataSource());
        factoryBean.setHibernateProperties(hibernateProperties());

        try {
            factoryBean.afterPropertiesSet();
        } catch (IOException ex) {
            Logger.getLogger(HibernateConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        return factoryBean;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource d = new DriverManagerDataSource();
        d.setDriverClassName(env.getProperty("hibernate.connection.driverClass"));
        d.setUsername(env.getProperty("hibernate.connection.username"));
        d.setPassword(env.getProperty("hibernate.connection.password"));
        d.setUrl(env.getProperty("hibernate.connection.url"));
        return d;
    }

    private Properties hibernateProperties() {
        Properties props = new Properties();
        props.put(AvailableSettings.SHOW_SQL, env.getProperty("hibernate.showSql"));
        props.put(AvailableSettings.DIALECT, env.getProperty("hibernate.dialect"));
        return props;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        //SessionFactory sessionFactory = getSessionFactory().getObject();
        //System.out.println("session Factory" + sessionFactory);
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        //transactionManager.afterPropertiesSet();
        return transactionManager;
    }
}

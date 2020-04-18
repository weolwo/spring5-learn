package com.poplar.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * Create BY poplar ON 2020/4/16
 */
@Configuration
@PropertySource("classpath:application.properties")
public class DataSourceConfig implements EmbeddedValueResolverAware {

    @Value("${db.driver}")
    private String driver;

    @Value("${db.username}")
    private String userName;

    private String url;

    @Autowired
    Environment environment;

    @Profile("dev")
    @Bean
    public DataSource dataSourceDev(@Value("${db.password}") String password) {
        DruidDataSource dataSource = new DruidDataSource();
        String userName = environment.getProperty("db.username");
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setDriverClassName(driver);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Profile("prop")
    @Bean
    public DataSource dataSourceProp(@Value("${password}") String password) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setDriverClassName(driver);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        url = resolver.resolveStringValue("${db.url}");
    }
}

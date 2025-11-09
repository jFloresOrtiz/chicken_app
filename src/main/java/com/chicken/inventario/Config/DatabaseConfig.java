package com.chicken.inventario.Config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://dpg-d45chq6uk2gs73cehqf0-a.virginia-postgres.render.com:5432/bd_sodexo");
        dataSource.setUsername("johan");
        dataSource.setPassword("jFF5PSMc29yuEcyOqP4h6CMUDS1cxt7p");
        return dataSource;
    }
}

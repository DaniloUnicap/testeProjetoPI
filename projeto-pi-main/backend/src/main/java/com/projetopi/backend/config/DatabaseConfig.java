package com.projetopi.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl("jdbc:postgresql://bubble.db.elephantsql.com/fiasiwrh");
    dataSource.setUsername("fiasiwrh");
    dataSource.setPassword("jpePsW_1iOPJTXi3OnynmFWBDxPhUHat");
    return dataSource;
  }
}

package com.sl.student.primary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DbConfig {
    String connectionString;
    String url;
    String password;
    String userId;

    public DbConfig(String connectionString, String url, String password, String userId) {
    }

    @Bean
    public DbConfig dbConfig(String connectionString,String url, String password,String userId){
      return new DbConfig(connectionString,url,password,userId);
    }


}

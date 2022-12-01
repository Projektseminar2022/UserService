package com.example.userservice;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@SpringBootApplication
@EnableR2dbcRepositories("com.example.userservice.repositories")
//@ComponentScan(basePackages = "com.example.userservice")
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    public ConnectionFactory connectionFactory(){
        return new PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration.builder()
                        .host("localhost")
                        .database("seminardb")
                        .username("postgres")
                        .password("saad123")
                        .build()
        );
    }
    @Bean
    ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
        return initializer;
    }

}

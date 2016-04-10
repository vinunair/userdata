package com.github.vinunair.userdata.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.github.vinunair.userdata.domain"})
@EnableJpaRepositories(basePackages = {"com.github.vinunair.userdata.repository"})
@EnableTransactionManagement
public class UserRepositoryConfiguration {

}

package com.example.FoodProject.RepositoryTestConfig;


import com.example.FoodProject.repositories.OrderRepository;
import com.example.FoodProject.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.jws.soap.SOAPBinding;

import static org.mockito.Mockito.mock;

@Profile("test")
@Configuration
public class UserRepositoryTestConfig {

    @Bean
    @Primary
    public UserRepository customUserRepo() {
        return mock(UserRepository.class);
    }

}

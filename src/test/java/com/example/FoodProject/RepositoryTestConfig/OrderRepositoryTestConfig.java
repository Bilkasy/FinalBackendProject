package com.example.FoodProject.RepositoryTestConfig;

import com.example.FoodProject.repositories.MenuItemRepository;
import com.example.FoodProject.repositories.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import static org.mockito.Mockito.mock;

@Profile("test")
@Configuration

public class OrderRepositoryTestConfig {

    @Bean
    @Primary
    public OrderRepository customOrderRepo() {
        return mock(OrderRepository.class);
    }

}

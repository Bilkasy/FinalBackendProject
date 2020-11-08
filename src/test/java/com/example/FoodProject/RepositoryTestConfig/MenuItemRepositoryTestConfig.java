package com.example.FoodProject.RepositoryTestConfig;


import com.example.FoodProject.model.MenuItem;
import com.example.FoodProject.repositories.MenuItemRepository;
import com.example.FoodProject.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import static org.mockito.Mockito.mock;

@Profile("test")
@Configuration
public class MenuItemRepositoryTestConfig {

    @Bean
    @Primary
    public MenuItemRepository customMenuItemRepo() {
        return mock(MenuItemRepository.class);
    }


}

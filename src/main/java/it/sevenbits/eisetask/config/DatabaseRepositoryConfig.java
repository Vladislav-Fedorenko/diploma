package it.sevenbits.eisetask.config;

import it.sevenbits.eisetask.core.repository.DatabaseItemsRepository;
import it.sevenbits.eisetask.core.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Config a repository database.
 */
@Configuration
public class DatabaseRepositoryConfig {
    @Bean
    public ItemsRepository itemsRepository(
            @Qualifier("itemsJdbcTemplate")
                    JdbcTemplate jdbcTemplate) {
        return new DatabaseItemsRepository(jdbcTemplate);
    }

}

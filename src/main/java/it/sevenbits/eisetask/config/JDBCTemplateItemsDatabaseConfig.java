package it.sevenbits.eisetask.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Config for database items(data source).
 */
@Configuration
public class JDBCTemplateItemsDatabaseConfig {
    @Bean
    @Qualifier("itemsJdbcTemplate")
    public JdbcTemplate itemsJdbcTemplate(@Qualifier("itemsDataSource") DataSource itemsDataSource) {
        return new JdbcTemplate(itemsDataSource);
    }

}

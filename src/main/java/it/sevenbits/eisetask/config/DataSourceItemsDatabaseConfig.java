package it.sevenbits.eisetask.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config for database items(data source).
 */
@Configuration
public class DataSourceItemsDatabaseConfig {
    @Bean
    @Qualifier("itemsDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.items")
    public javax.sql.DataSource itemsDataSource() {
        return DataSourceBuilder.create().build();
    }

}

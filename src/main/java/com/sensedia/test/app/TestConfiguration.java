package com.sensedia.test.app;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sensedia.api.app.TestEnvironment;

@Configuration
public class TestConfiguration {
	@Bean
	@TestEnvironment
	public FlywayMigrationStrategy cleanMigrateStrategy() {
	    return new FlywayMigrationStrategy() {
	        @Override
	        public void migrate(Flyway flyway) {
	            flyway.clean();
	            flyway.migrate();
	        }
	    };
	}
}

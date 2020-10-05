package com.github.patriquejarry;

import java.util.HashMap;
import java.util.Map;

import org.testcontainers.containers.MySQLContainer;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

public class DatabaseLifecycle implements QuarkusTestResourceLifecycleManager {

	// private static MySQLContainer<?> MYSQL = new
	// MySQLContainer<>("mysql/mysql-server:8.0.19");
	private static MySQLContainer<?> MYSQL = new MySQLContainer<>("mysql/mysql-server");

	@Override
	public Map<String, String> start() {
		MYSQL.withExtraHost("host.docker.internal", "192.168.0.38");
		MYSQL.start();

		Map<String, String> properties = new HashMap<>();
		properties.put("quarkus.datasource.url", MYSQL.getJdbcUrl());
		properties.put("quarkus.datasource.username", MYSQL.getUsername());
		properties.put("quarkus.datasource.password", MYSQL.getPassword());
		return properties;
	}

	@Override
	public void stop() {
		if (MYSQL != null) {
			MYSQL.stop();
		}
	}

}

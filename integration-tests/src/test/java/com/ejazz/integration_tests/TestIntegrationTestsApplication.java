package com.ejazz.integration_tests;

import org.springframework.boot.SpringApplication;

public class TestIntegrationTestsApplication {

	public static void main(String[] args) {
		SpringApplication.from(IntegrationTestsApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

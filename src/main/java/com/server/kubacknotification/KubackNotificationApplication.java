package com.server.kubacknotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.server.kubacknotification.infra.jpa.repositoryImpl")
public class KubackNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(KubackNotificationApplication.class, args);
	}

}

package com.cloud.stream;

import com.cloud.stream.service.Sender;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudMessagingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudMessagingApplication.class, args);
	}


	@Bean
	ApplicationRunner applicationRunner(Sender sender) {
		return args -> {
			sender.sendSyncEvent();
		};
	}
}

package io.pivotal.SpringCloudServiceRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudServiceRegistryApplication.class, args);
	}

}

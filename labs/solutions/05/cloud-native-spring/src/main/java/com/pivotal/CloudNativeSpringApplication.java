package io.pivotal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudNativeSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudNativeSpringApplication.class, args);
	}

	@Order(105)
	@Profile("!cloud")
	@Configuration
	static class ApplicationSecurityOverride extends WebSecurityConfigurerAdapter {

		@Override
		public void configure(HttpSecurity web) throws Exception {
			web.authorizeRequests().antMatchers("/**").permitAll();
			web.csrf().disable();

		}
		
	}
}

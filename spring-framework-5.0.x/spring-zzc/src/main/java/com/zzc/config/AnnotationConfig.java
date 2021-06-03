package com.zzc.config;

import com.zzc.vo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.zzc")
public class AnnotationConfig {
	@Bean
	public User user1(){
		return new User();
	}
}

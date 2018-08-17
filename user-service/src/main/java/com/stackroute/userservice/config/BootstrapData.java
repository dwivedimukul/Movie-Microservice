package com.stackroute.userservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.ContextRefreshedEvent;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;


@Primary
@Configuration
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent>{
	
	
	private UserRepository userRepository;
	
	@Autowired
	public BootstrapData(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		User user1 = new User(1,"Karl",3.0f);
		userRepository.save(user1);
		User user2 = new User(2,"John",3.0f);
		userRepository.save(user2);
		
		User user3 = User.builder()
				 .userName("Antman")
				 .userRating(3.5f)
				 .build();
		userRepository.save(user3);
		
		Logger logger = LoggerFactory.getLogger("Controller");
		logger.debug("debug");
		logger.error("error");
		logger.warn("warm");
		logger.info("info");
		logger.trace("trace");
		
		
	}

}

package com.exam.examservice;

import com.exam.examservice.models.Role;
import com.exam.examservice.models.User;
import com.exam.examservice.models.UserRole;
import com.exam.examservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
//@EnableJpaRepositories
public class ExamServiceApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(ExamServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting code running by command line runner interface");
	/*	User user = new User();
		user.setFirstName("daniyakula");
		user.setLastName("kavya");
		user.setUserName("kavya7744");
		user.setEmail("kavya@Gmail.com");
		user.setPhoneNumber("9390401544");
		user.setProfile("default.png");
		user.setPassword("123");

		Role role = new Role();
		role.setRoleId(11L);
		role.setRoleName("ADMIN");

		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);

		Set<UserRole> userRoleSet = new HashSet<>();
		userRoleSet.add(userRole);
		this.userService.createUser(user,userRoleSet);*/

	}
}

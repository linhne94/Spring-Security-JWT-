package com.example.authen2;

import com.example.authen2.Entity.Role;
import com.example.authen2.Entity.User;
import com.example.authen2.Repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
@RequiredArgsConstructor
public class Authen2Application {

	@Autowired
	private final UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(Authen2Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return runner -> find(userRepo);
	}

	private void find(UserRepo userRepo) {
		Optional<User> user = userRepo.findByUsername("linhadmin");
		System.out.println(user.toString());
		System.out.println(user.get().getRole().toString());
		Collection<String> roleNames = user.get().getRole().stream()
				.map(Role::getRoleName)
				.collect(Collectors.toList());

		roleNames.forEach(System.out::println);
	}


}

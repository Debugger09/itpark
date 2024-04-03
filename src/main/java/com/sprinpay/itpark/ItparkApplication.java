package com.sprinpay.itpark;

import com.sprinpay.itpark.domain.User;
import com.sprinpay.itpark.domain.enums.ROLE;
import com.sprinpay.itpark.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ItparkApplication implements CommandLineRunner {
	private final UserRepository userRepository;

	@Autowired // Injection de dépendance
	public ItparkApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ItparkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<User> users = new ArrayList<>();
		User user1 = new User();
		user1.setName("lulu");
		user1.setPassword("123");
		user1.setLogin("lulu");
		user1.setStatus(true);
		user1.setRole(ROLE.ADMIN);
		users.add(user1);
		User user2 = new User();
		user2.setName("admin");
		user2.setPassword("123");
		user2.setLogin("admin");
		user2.setStatus(true);
		user2.setRole(ROLE.ADMIN);

		users.add(user2);


		users.add(user1);
		User user22 = new User();
		user22.setName("tech");
		user22.setPassword("123");
		user22.setLogin("tech");
		user22.setStatus(true);
		user22.setRole(ROLE.TECHNICIEN);

		users.add(user22);
		if (userRepository.count() == 0) {
			userRepository.saveAll(users);
		}
	}

}

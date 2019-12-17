package lab.spring.data.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lab.spring.data.rest.entity.Person;
import lab.spring.data.rest.service.PersonService;

@SpringBootApplication
public class PeopleManagementSpringBootDataAppApplication implements CommandLineRunner {

	@Autowired
	private PersonService userService;

	public static void main(String[] args) {
		SpringApplication.run(PeopleManagementSpringBootDataAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createUser();
	}

	private void createUser() {
		Person user = new Person("Niranjan", "Netherland");
		userService.createUser(user);
	}

}

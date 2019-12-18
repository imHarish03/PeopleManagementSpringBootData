package lab.spring.data.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lab.spring.data.rest.entity.Person;
import lab.spring.data.rest.service.PersonService;

@SpringBootApplication
public class PeopleManagementSpringBootDataAppApplication implements CommandLineRunner {

	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(PeopleManagementSpringBootDataAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// createPerson();
		// createPersons();
		getPersonsById();
	}

	private void getPersonsById() {
		personService.getPersonsById();

	}

	private void createPersons() {
		List<Person> personList = Arrays.asList(new Person("Hari", "India"), new Person("Ruban", "USA"));
		Iterable<Person> out = personService.createPersons(personList);
		for (Person p : out) {
			System.out.println(p);
		}

	}

	private void createPerson() {
		Person person = new Person("Niranjan", "Netherland");
		personService.createPerson(person);
	}

}

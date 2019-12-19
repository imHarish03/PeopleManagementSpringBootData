package lab.spring.data.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

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

		//// InBuilt Method
		/* createPerson(); */
		/* createPersons(); */
		/* getPersonsById(); */
		/* getListPersonByID(); */
		/* deletePersonEntity(); */
		/* updatePersonCountryById(); */

		/* CustomQueires */
		/* findByFirstName(); */
		/* readByFirstNameOrLastName(); */
		/* getTopByCountry(); */
		/* getByCountry(); */

		/* findByLastNameOrderByFirstNameAsc(); */

		/* getPersonByLastName(); */
		/* likeHarish(); */

		findByCountry();
	}

	private void findByCountry() {
		Pageable pg = PageRequest.of(0, 4, Direction.DESC, "lastName");

		personService.findByCountry("India", pg);
	}

	private void likeHarish() {
		personService.likeHarish("manjunath");
	}

	private void getPersonByLastName() {
		personService.getPersonByLastName("manjunath");

	}

	private void findByLastNameOrderByFirstNameAsc() {
		personService.findByLastNameOrderByFirstNameAsc("manjunath");
	}

	private void getByCountry() {
		personService.getByCountry("India");
	}

	private void getTopByCountry() {
		personService.getTopByCountry("India");
	}

	private void readByFirstNameOrLastName() {
		personService.readByFirstNameOrLastName("niranjan", "manjath");
	}

	private void findByFirstName() {
		personService.findByFirstName("niranJan");

	}

	private void updatePersonCountryById() {
		personService.updatePersonCountryById(1, "India");

	}

	private void deletePersonEntity() {
		Person p = new Person();
		p.setId(2);

		personService.deletePersonEntity(p);

	}

	private void getListPersonByID() {
		List<Integer> userIDs = new ArrayList<Integer>();
		userIDs.add(1);
		userIDs.add(2);
		personService.getListPersonByID(userIDs);

	}

	private void getPersonsById() {
		personService.getPersonsById();

	}

	private void createPersons() {
		List<Person> personList = Arrays.asList(new Person("Hari", "haran", "India"),
				new Person("Vinodh", "George", "USA"));
		Iterable<Person> out = personService.createPersons(personList);
		for (Person p : out) {
			System.out.println(p);
		}

	}

	private void createPerson() {
		Person person = new Person("Gowtham", "Nishanth", "India");
		personService.createPerson(person);
	}

}

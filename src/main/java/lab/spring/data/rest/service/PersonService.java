package lab.spring.data.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import lab.spring.data.rest.dao.PersonDAO;
import lab.spring.data.rest.entity.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDAO personDAO;

	public void createPerson(Person user) {
		try {
			personDAO.save(user);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Iterable<Person> createPersons(List<Person> personList) {
		try {
			Iterable<Person> saved = personDAO.saveAll(personList);
			return saved;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public void getPersonsById() {
		Optional<Person> person = personDAO.findById(1);
		System.out.println(person.get().toString());
	}

	public void getListPersonByID(List<Integer> userIDs) {

		Iterable<Person> personList = personDAO.findAllById(userIDs);

		for (Person person : personList) {
			System.out.println(person);
		}

	}

	public void deletePersonEntity(Person p) {
		personDAO.delete(p);
	}

	public void updatePersonCountryById(int id, String country) {
		try {
			Optional<Person> optionalPerson = personDAO.findById(id);
			Person person = optionalPerson.orElseGet(null);

			if (id == person.getId()) {
				person.setCountry(country);
			}

			personDAO.save(person);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void findByFirstName(String firstName) {
		try {
			Person p = personDAO.findByFirstNameIgnoreCase(firstName);
			System.out.println(p);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void readByFirstNameOrLastName(String firstName, String lastName) {
		try {
			Person p = personDAO.readByFirstNameOrLastName(firstName, lastName);
			System.out.println(p);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void getTopByCountry(String country) {

		try {
			Person p = personDAO.getTopByCountry(country);
			System.out.println(p);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void getByCountry(String country) {

		try {
			Iterable<Person> personList = personDAO.getByCountry(country);
			for (Person person : personList) {
				System.out.println(person);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void findByLastNameOrderByFirstNameAsc(String lastName) {
		List<Person> personList = personDAO.findByLastNameOrderByFirstNameAsc(lastName);
		for (Person person : personList) {
			System.out.println(person);
		}
	}

	public void getPersonByLastName(String lastName) {
		/* List<Person> personList = personDAO.hari(string); */
		List<Person> personList = personDAO.harishWith(lastName);

		personList.forEach(System.out::println);
	}

	public void likeHarish(String lastName) {
		List<Person> personList = personDAO.loadHarish(lastName);

		personList.forEach(System.out::println);
	}

	public void findByCountry(String lastName, Pageable pageable) {

		List<Person> personList = personDAO.findByCountry(lastName, pageable);

		personList.forEach(System.out::println);

	}

	public void updatePersonLastNameById(String lastName, int id) {
		try {
			personDAO.updatePersonLastNameById(lastName, id);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/*
	 * @Cacheable(value = "personCache") public Person getById(Integer id) { return
	 * personDAO.findById(id).orElse(null); }
	 */

	@Cacheable(value = "personCache")
	public List<Person> getAllPerson() {
		Iterable<Person> peronList = personDAO.findAll();

		ArrayList<Person> data = new ArrayList<Person>();
		for (Person p : peronList) {
			data.add(p);
		}
		return data;
	}

	@Cacheable(value = "personCache", key = "#id")
	public Person getPersonById(Integer id) {
		return personDAO.findById(id).orElse(null);
	}

	@CacheEvict(value = "personCache", key = "#id")
	public void deletebyId(Integer id) {
		personDAO.deleteById(id);
	}

}

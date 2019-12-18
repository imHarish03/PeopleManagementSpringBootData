package lab.spring.data.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}

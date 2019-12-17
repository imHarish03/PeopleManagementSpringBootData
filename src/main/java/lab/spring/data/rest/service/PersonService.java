package lab.spring.data.rest.service;

import java.util.List;

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

}

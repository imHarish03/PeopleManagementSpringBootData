package lab.spring.data.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.data.rest.dao.PersonDAO;
import lab.spring.data.rest.entity.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDAO userDAO;

	public void createUser(Person user) {
		try {
			userDAO.save(user);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

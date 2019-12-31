package lab.spring.data.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lab.spring.data.rest.entity.Person;
import lab.spring.data.rest.service.PersonService;

@RestController
@RequestMapping(value = "/Person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping(value = "/{Id}")
	public Person getById(@PathVariable("Id") Integer Id) {
		return personService.getById(Id);
	}

}

/**
 * 
 */
package com.example.demo.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

/**
 * @author BassemIbrahem
 *
 */
@CrossOrigin(origins = "http://localhost:5500/")
@RequestMapping("/api/v1/person")
@RestController
public class PersonController {

	Logger logger = LoggerFactory.getLogger(PersonController.class);
	private final PersonService personService;
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping
	public List<Person> getAllPeople(){
		logger.trace("EVERY THING IS OKAY");
		return personService.getAllPeople();
	}
	
	@GetMapping(path = "{id}")
	public Person getPersonById(@PathVariable("id") int id) {
		return personService.getPersonById(id);
	}
	 	
	  @DeleteMapping(path= "{id}")
	  public void deletePersonById(@PathVariable("id") int id){
		  personService.deletePersonById(id);
	  }		
			
	  @PostMapping
		public void addPerson(@RequestBody Person person) {
			personService.addPerson(person);		
		}
		
	  @PutMapping (path="{id}")
	  public void updatePersonById (@PathVariable("id") int id,  @RequestBody Person newPerson) {
		  personService.updatePersonById(id, newPerson);
	  }	
	
}
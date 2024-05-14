/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

/**
 * @author BassemIbrahem
 *
 */
@Service
public class PersonService {
	Logger logger = LoggerFactory.getLogger(PersonService.class);
	private final PersonDao personDao;

	/**
	 * 
	 */
	@Autowired
	public PersonService(PersonDao personDao) {
		System.out.println("adf");
		this.personDao = personDao;
	}
	
	
	
	
	public void addPerson (Person person) {
    	System.out.println("adding data to  the server");
		personDao.add(person);
	}
	
	
	
	
    @Cacheable("people")
	public List<Person> getAllPeople(){
    	System.out.println("Getting data from the server");
		return personDao.getAllPeople();
	}
    
    
    
    
    
	public Person getPersonById(int id) {
		logger.info("getting it from database");
		Person person = personDao.getPersonById(id);
		return person;
		
	}
	public void deletePersonById(int id) {
		logger.info("inside delete method");
		personDao.deletePersonById(id);
	}
	public void updatePersonById(int id, Person newPerson) {
		logger.info("inside update method");
		personDao.updatePersonById(id, newPerson);
	}
		
}


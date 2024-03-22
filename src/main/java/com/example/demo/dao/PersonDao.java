/**
 * 
 */
package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Person;

/**
 * @author BassemIbrahem
 *
 */
public interface PersonDao {
	
	public void add(Person person);
	List<Person> getAllPeople();
	Person getPersonById(int id);
	void deletePersonById(int id);
	void updatePersonById(int id, Person newPerson);
}

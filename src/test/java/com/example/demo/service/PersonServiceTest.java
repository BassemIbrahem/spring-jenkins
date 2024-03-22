/**
 * 
 */
package com.example.demo.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

/**
 * @author BassemIbrahem
 *
 */
@SpringBootTest
public class PersonServiceTest {

	
	@Test
	public void addPersonTest() {
		Person person1 = new Person("GEDO");
		PersonDao personDaoMoke = mock(PersonDao.class);
		personDaoMoke.add(person1);
		verify(personDaoMoke, times(1)).add(any (Person.class));		
	}

	
	
	
	
	@Test
	public void deletePersonTest() {
		int i= 1;
		PersonDao personDaoMoke = mock(PersonDao.class);
		personDaoMoke.deletePersonById(i);
		verify(personDaoMoke, times(1)).deletePersonById(1);
		verify(personDaoMoke, times(1)).deletePersonById(1);
		

	}

	@Test
	public void getPersonTest() {
		int i= 1;
		Person person = new Person("bassem");
		PersonDao personDaoMoke = mock(PersonDao.class);
		
		PersonService pesonService = new PersonService(personDaoMoke);
		
		when(personDaoMoke.getPersonById(i)).thenReturn(person);
				
		pesonService.getPersonById(i);
		
		verify(personDaoMoke, times(1)).getPersonById(i);
	}



}


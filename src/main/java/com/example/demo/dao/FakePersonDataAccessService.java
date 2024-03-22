/**
 * 
 */
package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 * @author BassemIbrahem
 *
 */

@Repository
public class FakePersonDataAccessService implements PersonDao {

	@PersistenceContext
	private EntityManager em;


	/*
	 * add Person 
	 */
	@Override
	@Transactional
	public void add(Person person) {
		em.persist(person);
	}

	/*
	 * to get all Person from database
	 */	
	@Override
	@Transactional
	public List<Person> getAllPeople() {
		return em.createQuery("from Person").getResultList();
	}

	/* to get person with id 
	 * @param id 
	 * 
	 * */
	@Override
	public Person getPersonById(int id) {
		return em.find(Person.class, id);
	}


	/*
	 * delete person wit specfic id  
	 */
	@Override
	@Transactional
	public void deletePersonById(int id) {
		Person p = em.find(Person.class, id);
		em.remove(p);
	}

	@Override 
	@Transactional
	public void updatePersonById(int id, Person newPerson) { 
		Query updateQ = em.createQuery("UPDATE Person SET name =:name WHERE id=:id");
		updateQ.setParameter("name", newPerson.getName());
		updateQ.setParameter("id", id);
		int rowUpdate =updateQ.executeUpdate();
		System.out.println(rowUpdate);
		
	  }

}
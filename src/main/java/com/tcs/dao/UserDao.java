package com.tcs.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.dto.User;

@Repository
public class UserDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	public User saveUser(User user)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		
		return user;
	}
	
	public User getUserByEmail(String email)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("Select s from User s where s.email=?1",User.class);
		query.setParameter(1, email);
		return (User)query.getSingleResult();
	}
}

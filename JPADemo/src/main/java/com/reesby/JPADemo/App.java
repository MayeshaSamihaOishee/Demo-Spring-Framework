package com.reesby.JPADemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
    	EntityManager em = emf.createEntityManager();
    	
    	Employee e = em.find(Employee.class, 1.0);
    	
    	 System.out.println(e);
    	
    }
}

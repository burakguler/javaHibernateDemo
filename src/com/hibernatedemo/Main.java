package com.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class)
				.buildSessionFactory();
		
		//unit of work design pattern
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
				
				// example HQL query -> "from City c where c.countryCode='TUR' AND c.district='Ankara'"
				// example query -> "from City c where c.name LIKE 'kar%'"
				/* Select operation
				 * List<City> cities =
				 * session.createQuery("from City c group by c.name ").
				 * getResultList();
				 * 
				 * for(City city:cities) { System.out.println(city.getName()); }
				 */
//				Insert operation
//			 	City city = new City();
//			 	city.setName("Bursa 16");
//			 	city.setCountryCode("TUR");
//			 	city.setDistrict("Marmara");
//			 	city.setPopulation(30000000);
//			 	session.save(city);
			
//				Update operation
//				City city = session.get(City.class, 4084); // getting city that id=4084
//				city.setPopulation(20000000);
//				session.save(city);
				
//				Delete operation
				City city = session.get(City.class, 4084);
				session.delete(city);
				
			 	session.getTransaction().commit();
			 	System.out.println("");
		}finally {
			factory.close();
		}
		
	}

}

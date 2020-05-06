
package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entity.Address;
import entity.Person;


public class HelloWorldClient {
	public static void main(String[] args) {
		
				Session session = HibernateUtil.getSessionFactory().openSession();
        		Transaction txn = session.getTransaction();
        		try {
        			txn.begin();
        	
        			Address homeAddress = new Address("200 E Main St", "Seattle", "85123");
        			
        			Address billingAddress = new Address("200 E Central Park", "Zonka", "9876");
        			Person person = new Person("Ruby", homeAddress, billingAddress);
        	
        			session.save(person);
	        
	        		txn.commit();
        		}	catch(Exception e) {
	        			e.printStackTrace();
        		}	finally {
        				if(session != null) { session.close(); }
        		}
	
	}
}













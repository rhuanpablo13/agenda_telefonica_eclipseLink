package pacote.persistence;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {
	
	
	
	public static EntityManager createEntityManagerFactory(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_UNIT");
		EntityManager manager = factory.createEntityManager();		
		//factory.close();
		return manager;
	}
	
}

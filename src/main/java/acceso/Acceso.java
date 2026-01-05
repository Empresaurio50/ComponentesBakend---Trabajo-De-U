package acceso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class Acceso {
	
	protected static EntityManager em = null;
	protected static EntityManagerFactory entityManagerFactory = null;

	
	public static void startEntityManagerFactory(String persistenceUnit) throws Exception {
		if (entityManagerFactory == null) {
			try {
				entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);
 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
 
	public static void stopEntityManagerFactory() throws Exception {
 
		if (entityManagerFactory != null) {
			if (entityManagerFactory.isOpen()) {
				try {
					entityManagerFactory.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			entityManagerFactory = null;
		}
	}
}

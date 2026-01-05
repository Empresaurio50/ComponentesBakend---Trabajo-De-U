package acceso;

import entidades.Eventos;
import java.util.ArrayList;
import java.util.List;

public class ServicioEvento extends Acceso{


    public void guardar(Eventos evento) {
    	
    	try {
    		startEntityManagerFactory("ComponentesBakend");
    		em = entityManagerFactory.createEntityManager();
    		em.getTransaction().begin();
            em.persist(evento);
            em.getTransaction().commit();
            stopEntityManagerFactory();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public List<Eventos> listar() {
    	List<Eventos> lista = new ArrayList<Eventos>();
    	try {
    		startEntityManagerFactory("ComponentesBakend");
    		em = entityManagerFactory.createEntityManager();
    		
    		lista = em.createQuery("SELECT e FROM Eventos e", Eventos.class).getResultList();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}

        return lista;
    }
}

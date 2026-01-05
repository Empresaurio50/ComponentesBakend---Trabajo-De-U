package acceso;

import java.util.Date;

import entidades.Asignadas;
import entidades.Entrevistas;

public class ServicioAsignadas extends Acceso {

	public void marcarOpcion(Entrevistas entrevista, String tipoOpcion) {


	    try {
	        startEntityManagerFactory("ComponentesBakend");
	        em = entityManagerFactory.createEntityManager();
	        em.getTransaction().begin();

	        // Evitar duplicados (si ya fue marcada antes)
	        String query = "SELECT COUNT(a) FROM Asignadas a " +
	        	    "WHERE a.entrevista.id = :idEntrevista AND a.tipoOpcion = :tipo";
	        
	        
	        Long existe = em.createQuery(query, Long.class).setParameter("idEntrevista", entrevista.getId()).setParameter("tipo", tipoOpcion).getSingleResult();


	        if (existe == 0) {
	            Asignadas opcion = new Asignadas();
	            opcion.setEntrevista(em.find(Entrevistas.class, entrevista.getId()));
	            opcion.setTipoOpcion(tipoOpcion);
	            opcion.setFechaHora(new Date());

	            em.persist(opcion);
	        }

	        em.getTransaction().commit();

	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	}
	
	public boolean existeOpcion(int idEntrevista, String tipo) {
		Long marcado = 0l;

		
		try {
			startEntityManagerFactory("ComponentesBakend");
		    em = entityManagerFactory.createEntityManager();

			 marcado = em.createQuery(
		        "SELECT COUNT(a) FROM Asignadas a " +
		        "WHERE a.entrevista.id = :id AND a.tipoOpcion = :tipo",
		        Long.class
		    )
		    .setParameter("id", idEntrevista)
		    .setParameter("tipo", tipo)
		    .getSingleResult();

		    
		    stopEntityManagerFactory();
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		return marcado > 0;
	    
	}
}

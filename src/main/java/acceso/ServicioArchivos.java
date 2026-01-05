package acceso;
import entidades.ArchivoAdjunto;
import entidades.Entrevistas;
public class ServicioArchivos extends Acceso {

    public void guardar(ArchivoAdjunto archivo) {
    	
    	try {
    		startEntityManagerFactory("ComponentesBakend");
        	em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            
            Entrevistas entrevistaManaged = em.find(
                Entrevistas.class,
                archivo.getEntrevista().getId()
            );
            
            archivo.setEntrevista(entrevistaManaged);
            em.persist(archivo);
            em.getTransaction().commit();
            stopEntityManagerFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    
    
    
    
}


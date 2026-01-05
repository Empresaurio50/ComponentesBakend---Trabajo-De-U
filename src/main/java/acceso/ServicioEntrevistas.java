package acceso;

import java.util.ArrayList;
import java.util.List;
import entidades.Entrevistas;
import entidades.Solicitantes;
import interfaces.DTO;

public class ServicioEntrevistas extends Acceso implements DTO<Entrevistas> {

    @Override
    public void crear(Entrevistas ent) {
        try {
            startEntityManagerFactory("ComponentesBakend");
            em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();

            em.persist(ent);

            em.getTransaction().commit();
            stopEntityManagerFactory();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Entrevistas> listarPorParroquia(int idParroquia){
    	List<Entrevistas> lista = new ArrayList<Entrevistas>();

    	try {
			
    		startEntityManagerFactory("ComponentesBakend");
    		em = entityManagerFactory.createEntityManager();
    		
    		String query = "SELECT e FROM Entrevistas e WHERE e.parroquias.id = :id ";
    		lista = em.createQuery(query, Entrevistas.class).setParameter("id", idParroquia)
    				.getResultList();
    		
    		
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    	
    	return lista;
    }
    
    
    @Override
    public List<Entrevistas> listar() {
        List<Entrevistas> lista = null;

        try {
            startEntityManagerFactory("ComponentesBakend");
            em = entityManagerFactory.createEntityManager();

            String query = "SELECT e FROM Entrevistas e";
            lista = em.createQuery(query, Entrevistas.class).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void editar(Entrevistas ent) {
        try {
            startEntityManagerFactory("ComponentesBakend");
            em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();

            em.merge(ent);

            em.getTransaction().commit();
            stopEntityManagerFactory();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Entrevistas ent) {
        try {
            startEntityManagerFactory("ComponentesBakend");
            em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();

            Entrevistas encontrado = em.find(Entrevistas.class, ent.getId());
            if (encontrado != null) {
                em.remove(encontrado);
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Integer expedientesSolicitantes(Solicitantes soli) {

        int cantidad = 0;

        try {
            startEntityManagerFactory("ComponentesBakend");
            em = entityManagerFactory.createEntityManager();

            String sql = "SELECT COUNT(*) FROM entrevista_solicitante WHERE idSolicitante = ?";

            cantidad = ((Number) em.createNativeQuery(sql)
                    .setParameter(1, soli.getId())
                    .getSingleResult())
                    .intValue();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cantidad;
    }
    

}
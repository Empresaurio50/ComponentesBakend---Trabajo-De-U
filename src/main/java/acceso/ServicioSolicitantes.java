package acceso;

import java.util.ArrayList;
import java.util.List;
import entidades.Solicitantes;
import interfaces.DTO;

public class ServicioSolicitantes extends Acceso implements DTO<Solicitantes> {

	public Solicitantes buscarCedula(Solicitantes soli) {
		
		Solicitantes retornoSolicitantes = new Solicitantes();
		
		try {
			
			startEntityManagerFactory("ComponentesBakend");
			em = entityManagerFactory.createEntityManager();
			
			
			String query = "SELECT s FROM " + Solicitantes.class.getSimpleName() +" s WHERE s.cedula = :cedula";

	        retornoSolicitantes = em.createQuery(query, Solicitantes.class)
	                                     .setParameter("cedula", soli.getCedula())
	                                     .getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retornoSolicitantes;
		
	}
	
	@Override
	public void crear(Solicitantes solicitantes) {
		try {
			startEntityManagerFactory("ComponentesBakend");
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			em.persist(solicitantes);

			em.getTransaction().commit();
			stopEntityManagerFactory();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void editar(Solicitantes t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Solicitantes t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Solicitantes> listar() {

		List<Solicitantes> listaRetorno = new ArrayList<Solicitantes>();
		try {

			startEntityManagerFactory("ComponentesBakend");
			em = entityManagerFactory.createEntityManager();

			String query = "SELECT t FROM " + Solicitantes.class.getSimpleName() + " t";

			listaRetorno = em.createQuery(query, Solicitantes.class).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (em != null && em.isOpen()) {
				em.close();
			}

		}

		return listaRetorno;

	}
}

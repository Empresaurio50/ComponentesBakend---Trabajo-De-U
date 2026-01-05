package acceso;

import entidades.Ayudas;
import entidades.Entrevistas;

import java.util.ArrayList;
import java.util.List;

public class TipoAyudaDAO extends Acceso {

	public void asignarAyuda(int idEntrevista, int idAyuda) {
		
		
		try {
			startEntityManagerFactory("ComponentesBakend");
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Entrevistas entrevistas = em.find(Entrevistas.class, idEntrevista);
			
			Ayudas ayudas = em.find(Ayudas.class, idAyuda);
			
			
			entrevistas.setAyuda(ayudas);
			em.merge(entrevistas);
			
			
			em.getTransaction().commit();
			stopEntityManagerFactory();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public List<Ayudas> listarActivos() {

		List<Ayudas> listaActivos = new ArrayList<Ayudas>();

		try {
			startEntityManagerFactory("ComponentesBakend");
			em = entityManagerFactory.createEntityManager();

			String query = "SELECT t FROM " + Ayudas.class.getSimpleName() + " t " + "WHERE t.activo = true "
					+ "ORDER BY t.nombre ";

			listaActivos = em.createQuery(query, Ayudas.class).getResultList();

			stopEntityManagerFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaActivos;

	}

	public List<Ayudas> listarAyudas() {

		List<Ayudas> listaAyudas = new ArrayList<Ayudas>();

		try {
			startEntityManagerFactory("ComponentesBakend");
			em = entityManagerFactory.createEntityManager();

			String query = "SELECT t FROM " + Ayudas.class.getSimpleName() + " t ";

			listaAyudas = em.createQuery(query, Ayudas.class).getResultList();

			stopEntityManagerFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaAyudas;

	}

	public Ayudas buscarPorId(Integer id) {

		Ayudas busque = new Ayudas();

		try {
			startEntityManagerFactory("ComponentesBakend");
			em = entityManagerFactory.createEntityManager();

			busque = em.find(Ayudas.class, id);

			stopEntityManagerFactory();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return busque;

	}

}
package acceso;

import java.util.ArrayList;
import java.util.List;

import entidades.Parroquias;

public class ServicioParroquias extends Acceso {
	
	private List<Parroquias> listaRetorno = new ArrayList<Parroquias>();
	
	
	public List<Parroquias> treerParroquias() {
	try {
		
		startEntityManagerFactory("ComponentesBakend");
		
		em = entityManagerFactory.createEntityManager();

		String query = "SELECT parro FROM " + Parroquias.class.getSimpleName() +" parro";
		
		listaRetorno = em.createQuery(query, Parroquias.class).getResultList();

	} catch (Exception e) {
		e.printStackTrace();
	}
	return listaRetorno;
	
}
	
	public Parroquias buscarParroquiaId(int id) {
		
		Parroquias parroquiaRetorno = new Parroquias();
		
		try {
			startEntityManagerFactory("ComponentesBakend");
			em = entityManagerFactory.createEntityManager();
			
			String query = "SELECT parro FROM " + Parroquias.class.getSimpleName() +" parro "
					+ "WHERE parro.id = :id";
			
			parroquiaRetorno = em.createQuery(query, Parroquias.class).setParameter("id", id)
					.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return parroquiaRetorno;
	}
	

}

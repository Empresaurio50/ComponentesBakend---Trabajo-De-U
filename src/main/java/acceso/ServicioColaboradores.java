package acceso;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import entidades.Colaboradores;
import interfaces.DTO;

public class ServicioColaboradores extends Acceso implements DTO<Colaboradores> {
	
	public Colaboradores loginColaborador(Colaboradores colaboradores) {
		
		Colaboradores usuarioRetorno = new Colaboradores();
		
		try {
			
			startEntityManagerFactory("ComponentesBakend");
			
			em = entityManagerFactory.createEntityManager();

			String query = "SELECT cola FROM " + Colaboradores.class.getSimpleName() +" cola "
					+ "WHERE cola.telefono = :telefono AND cola.clave = :clave";
			
			usuarioRetorno = em.createQuery(query, Colaboradores.class).setParameter("telefono", colaboradores.getTelefono())
					.setParameter("clave", colaboradores.getClave())
					.getSingleResult();
			
			
		
		}catch (NoResultException e) {
	        System.out.println("Credenciales incorrectas para teléfono: " + colaboradores.getTelefono());
	        return null; // ✅ Retornar null explícitamente
	    }
		catch (Exception e) {
			e.printStackTrace();
		}
		return usuarioRetorno;	
	}
	
	@Override
	public void crear(Colaboradores colaboradores) {
		try {
			
			startEntityManagerFactory("ComponentesBakend");
			em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            
            em.persist(colaboradores);

            
            em.getTransaction().commit();
            stopEntityManagerFactory();
            System.out.print("termino");
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public Colaboradores buscarPorTelefono(Colaboradores colaboradores) {

	    Colaboradores retornoColaborador = null;

	    try {
	        startEntityManagerFactory("ComponentesBakend");
	        em = entityManagerFactory.createEntityManager();

	        String query = "SELECT cola FROM Colaboradores cola "
	                     + "WHERE cola.telefono = :telefono";

	        retornoColaborador = em.createQuery(query, Colaboradores.class)
	                .setParameter("telefono", colaboradores.getTelefono())
	                .getSingleResult();
	        
	        

	    } catch (NoResultException e) {
	        return null; 
	    } catch (NonUniqueResultException e) {
	        throw new RuntimeException("Existen dos colaboradores con el mismo teléfono. Esto NO debería pasar.");
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	    return retornoColaborador;
	}

	
	
	@Override
	public void editar(Colaboradores colaboradores) {
		// TODO Auto-generated method stub
		
	}@Override
	public void eliminar(Colaboradores colaboradores) {
		try {
			startEntityManagerFactory("ComponentesBakend");
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			
			System.out.print(colaboradores.getTelefono());
			
			Colaboradores existe = em.find(Colaboradores.class, colaboradores.getId());
			
			if (existe != null) {
				em.remove(existe);
			}else {
				System.out.println("No se encuentra el colaborador con ese id");
			}
			
			
			em.getTransaction().commit();
			stopEntityManagerFactory();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}@Override
	public List<Colaboradores> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	
}

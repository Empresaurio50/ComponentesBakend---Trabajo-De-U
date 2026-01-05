package app;

import acceso.ServicioColaboradores;
import acceso.ServicioParroquias;
import entidades.Colaboradores;
import entidades.Parroquias;
public class App {

	public static void main(String[] args) {
		
		ServicioColaboradores dao = new ServicioColaboradores();
		ServicioParroquias paro = new ServicioParroquias();

		
		Parroquias pa =  paro.buscarParroquiaId(1);

	    // 2️⃣ Crear colaborador
	    Colaboradores colaborador = new Colaboradores();
	    colaborador.setClave("12345");
	    colaborador.setParroquias(pa); // 👈 SINGULAR

	    // 3️⃣ Guardar colaborador
	    dao.crear(colaborador);

	    System.out.println("Colaborador creado con ID: " + colaborador.getId());
	    System.out.println(pa);
		
	}

}
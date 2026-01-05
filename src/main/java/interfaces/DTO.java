package interfaces;

import java.util.List;

public interface DTO<T> {

	List<T> listar();
	void crear(T t);
	void editar(T t);
	void eliminar(T t);
	
}

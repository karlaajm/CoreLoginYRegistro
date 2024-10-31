package com.karla.repositorios;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.karla.modelos.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long> {
	List<Usuario> findAll();
	
	Usuario findByNombreUsuario(String nombreUsuario);
}

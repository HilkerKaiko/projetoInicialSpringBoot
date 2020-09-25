package br.com.hilker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.hilker.entity.Usuario;
import br.com.hilker.exception.IntegradorException;


@Repository
public interface UsuarioRepo extends CrudRepository<Usuario, Long> {

	
	@Query("SELECT u FROM Usuario u "
			+ "WHERE u.email 	= :email "
			+ "AND 	 u.senha 	= :senha ")
	Optional<Usuario> consultarPorParametros(@Param("email") String email, @Param("senha") String senha) throws IntegradorException;
	
	
	@Query("SELECT u FROM Usuario u "
			+ "WHERE u.email 	= :email ")
	Optional<Usuario> consultarPorEmail(@Param("email") String email) throws IntegradorException;
	
}

package com.mycode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.mycode.entities.AuthUsuarioRol;

@Repository("usuarioRolRepository")
public interface IAuthUsuarioRolRepository extends JpaRepository<AuthUsuarioRol,Integer> {

	//public abstract List<AuthUsuarioRol> findByIdUsuario(int id);
	
	@Query(value = "SELECT "
				 + "r.nombre "
			     + "FROM auth_usuario_rol ur "
			     + "INNER JOIN auth_rol r ON ur.id_rol = r.id "
			     + "WHERE ur.id_usuario =:#{#idUsuario}",nativeQuery = true)
	List<String> findByIdUsuario(@Param("idUsuario") int id);
	
}


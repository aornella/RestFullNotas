package com.mycode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycode.entities.AuthUsuario;

@Repository("usuarioRepository")
public interface IAuthUsuarioRepository extends JpaRepository<AuthUsuario,Integer> {

	public abstract AuthUsuario findBynombreUsuario(String usuario);
}

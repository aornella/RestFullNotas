package com.mycode.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="auth_usuario_rol")
@Entity
public class AuthUsuarioRol {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="id_usuario")
	private int idUsuario;
	
	@Column(name="id_rol")
	private int idRol;

	public AuthUsuarioRol() {
		
	}
	
	public AuthUsuarioRol(int id, int idUsuario, int idRol) {
		this.id = id;
		this.idUsuario = idUsuario;
		this.idRol = idRol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	
	
}

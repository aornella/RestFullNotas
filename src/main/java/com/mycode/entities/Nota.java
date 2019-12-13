package com.mycode.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="nota")
@Entity
// @XmlRootElement (Serializa la clase a formato XML)
public class Nota {
	
	@Id
	//@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="contenido")
	private String contenido;

	public int getId() {
		return id;
	}
	
	public Nota() {
		
	}
	
	public Nota(int id, String nombre, String contenido) {
		this.id = id;
		this.nombre = nombre;
		this.contenido = contenido;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	

}

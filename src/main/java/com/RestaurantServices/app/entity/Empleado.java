package com.RestaurantServices.app.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table (name="empleado")
public class Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "nombres")
	private String nombres;
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "DUI")
	private String DUI;
	@Column(name = "telefono")
	private String telefono;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="usuario", referencedColumnName = "id")
	private Usuario usuario;
	

	public Empleado() {
		this.nombres = "";
		this.apellidos = "";
		this.direccion = "";
		DUI = "";
		this.telefono = "";
		this.usuario = new Usuario();
	}
	
	
	
	
	
	public Empleado(String nombres, String apellidos, String direccion, String dUI, String telefono, Usuario usuario) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		DUI = dUI;
		this.telefono = telefono;
		this.usuario = usuario;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDUI() {
		return DUI;
	}
	public void setDUI(String dUI) {
		DUI = dUI;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	
}

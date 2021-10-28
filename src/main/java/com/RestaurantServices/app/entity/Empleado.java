package com.RestaurantServices.app.entity;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table (name="empleados")
public class Empleado implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "nombres", length = 50)
	@NotNull
	private String nombres;
	@Column(name = "apellidos", length = 50)
	@NotNull
	private String apellidos;
	@Column(name = "direccion", length = 80)
	@NotNull
	private String direccion;
	@Column(name = "DUI", length = 15)
	@NotNull
	private String DUI;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="usuario", referencedColumnName = "id")
	@NotNull
	private Usuario usuario;
	@Column(name = "telefono", length = 20)
	@NotNull
	private String telefono;

	public Empleado() {
		this.nombres = "";
		this.apellidos = "";
		this.direccion = "";
		DUI = "";
		this.telefono = "";
		this.usuario = new Usuario();
	}
	
	
	
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

package com.RestaurantServices.app.entity;



import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table (name="menus")
public class Menu implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "nombre",length = 50, nullable = false)
	private String nombre;
	///EAGER devuelve un objeto, mientras que LAZY puede devolver null
		/*
		 * @OneToOne
		 Las relaciones One to One (@OneToOne) se caracterizan porque solo puede
		 existir una y solo una relación con la Entidad de destino, de esta forma,
		 la entidad marcada como @OnoToOne deberá tener una referencia a la Entidad destino 
		 */
	/*
	 En una relacion one to one debe ser la dueña una entidad, en este caso menu es dueño de catogria
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="categorias", referencedColumnName = "id", nullable = false)
	private Categoria categoria;
	@Column(name = "descripcion",length = 60)
	private String descripcion;
	@Column(name = "precio", nullable = false)
	private float precio;
	/*@Lob con esto definimos que estamos trabajando con objetos pesados
	 */
	@Lob
	@Column(name = "imagen",columnDefinition = "bigint", nullable = false)
	private byte[] imagen;
	
	
	public Menu() {
		super();
	}
	public Menu(int id ,String nombre, Categoria categoria, String descripcion, float precio, byte[] imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen = imagen;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
}

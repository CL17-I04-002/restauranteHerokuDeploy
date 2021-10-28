package com.RestaurantServices.app.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/*@OneToMany(mappedBy = "detalles_pedidos")
	private List<Detalle_pedido> detalle_pedido;*/
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "empleado", referencedColumnName = "id", nullable = false)
	private Empleado empleado;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mesa", referencedColumnName = "id", nullable = false)
	private Mesa mesa;
	
	@Column(name = "fecha_pedido", nullable = false)
	private Date Fecha_pedido;
	
	@Column(name = "observacion", length = 50)
	private String observacion;
	
	@Column(name = "estado", length = 25, nullable = false)
	@Enumerated(value = EnumType.STRING)
	private Estado estado;

	public Pedido() {
		super();
	}

	public Pedido(long id, Empleado empleado, Mesa mesa, Date fecha_pedido, String observacion, Estado estado) {
		super();
		this.id = id;
		this.empleado = empleado;
		this.mesa = mesa;
		Fecha_pedido = fecha_pedido;
		this.observacion = observacion;
		this.estado = estado;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Date getFecha_pedido() {
		return Fecha_pedido;
	}

	public void setFecha_pedido(Date fecha_pedido) {
		Fecha_pedido = fecha_pedido;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}

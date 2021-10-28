package com.RestaurantServices.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalles_pedidos")
public class Detalle_pedido implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pedido", referencedColumnName = "id", nullable = false)
	private Pedido pedido;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "menu", referencedColumnName = "id", nullable = false)
	private Menu menu;
	
	@Column(name = "cantidad", nullable = false)
	private long cantidad;

	public Detalle_pedido() {
		super();
	}

	public Detalle_pedido(long id, Pedido pedido, Menu menu, long cantidad) {
		super();
		this.id = id;
		this.pedido = pedido;
		this.menu = menu;
		this.cantidad = cantidad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	
	
}

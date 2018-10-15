package com.automation.models;

public class Product {

	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	private int id;
	
	private String nombre;
	
	private int cantidad;

	public int getId() {
		return id;
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Product(int id, String nombre, int cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	
	
		
	
}

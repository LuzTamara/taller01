/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.isi.died.tp.modelo.productos;

import java.util.ArrayList;

import frsf.isi.died.tp.util.Ordenable;

/**
 * Representa de manera abstracta los materiales de capacitación
 * 
 * @author LuzTamara
 * 
 * Integrantes: Franco Brechbuhl, Tamara Luz
 * 
 * 
 */
public abstract class MaterialCapacitacion {
	protected Integer id;
	/**
	 * Titulo del material
	 */
	protected String titulo;

	/**
	 * Costo básico que debe sumarse al precio por el mero hecho de publicarlo en el
	 * portal
	 */
	protected Double costo;
	

	/**
	 * Constructor por defecto
	 */
	public MaterialCapacitacion() {
		this(0,"en desarrollo",0.0);
	}

	/**
	 * Constructor que recibe como argumento un ID y un Titulo
	 * 
	 * @param id
	 * @param titulo
	 */
	public MaterialCapacitacion(Integer id, String titulo) {
		this(id,titulo,0.0);
	}

	/**
	 * Constructor que recibe como argumento un ID y un costo
	 * 
	 * @param id
	 * @param titulo
	 */
	public MaterialCapacitacion(Integer id,String titulo, Double costo) {
		this.id =id;
		this.titulo = titulo;
		this.costo = costo;
	}
	

	/**
	 * El precio de un material se define según el tipo del material y toma como
	 * base el costo del mismo
	 * 
	 * @return
	 */
	public abstract Double precio();
	
	/**
	 * Getter que devuelve el id
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter que modifica el valor del id
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter que devuelve el titulo
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Setter que modifica el valor del titulo
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Getter que devuelve el costo
	 * @return costo
	 */
	public Double getCosto() {
		return costo;
	}

	/**
	 * Setter que modifica el valor del costo
	 * @param costo
	 */
	public void setCosto(Double costo) {
		this.costo = costo;
	}

	/**
	 * Retorna verdadero si es una instancia de libro, falso en caso contrario
	 * @return
	 */
	public abstract Boolean esLibro();

	/**
	 * Retorna verdadero si es una instancia de video, falso en caso contrario
	 * @return
	 */
	public abstract Boolean esVideo();
	
	
	/**
	 * Retorna un string que representa el material con el formato :
	 * [Titulo: <titulo> ; Precio: <precio> ]
	 */
	public String toString() {
		return ("Titulo: " + this.titulo + "; Precio: " + this.precio());
				
	}
	
	
	// TODO 10: implementar Ordenable

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.isi.died.tp.modelo.productos;

import java.util.ArrayList;

import frsf.isi.died.tp.util.Ordenable;

/**
 * Representa de manera abstracta los materiales de capacitaciÃ³n
 * 
 * @author LuzTamara
 * 
 * Integrantes: Franco Brechbuhl, Tamara Luz
 * 
 * 
 */
public abstract class MaterialCapacitacion implements Ordenable {
	protected Integer id;
	/**
	 * Titulo del material
	 */
	protected String titulo;

	/**
	 * Costo bÃ¡sico que debe sumarse al precio por el mero hecho de publicarlo en el
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
	 * El precio de un material se define segÃºn el tipo del material y toma como
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
	
	/**
	 * Retorna el resultado del método precio()
	 * @return
	 * 
	 * Consideramos que el método funciona aunque esté técnicamente
	 * invocando un método abstracto porque será enviado a alguna de
	 * las clases hijas donde sí se encuentra implementado, por lo que
	 * al usar la palabra clave this hacemos referencia a una de ellas
	 * y la implementación se buscará en la clase correcta.
	 */
	public final int valor() {
		return ((int) (double) this.precio());
	}

	/**
	 * Sobreescribe el metodo equals de la clase object.
	 * Dos objetos son iguales si ambos son instancia de MaterialCapacitacion
	 * y ademas tienen el mismo titulo, sin tener en cuenta diferencia entre mayusculas
	 * y minusculas
	 * @return boolean 
	 */
	public boolean equals(Object obj) {
		boolean retorno;
		if (obj instanceof MaterialCapacitacion){
			if(this.getTitulo().equalsIgnoreCase(((MaterialCapacitacion) obj).getTitulo())) 
				retorno = true;
			else
				retorno = false;
		}
		else retorno = false;
		return retorno;
	}
	
}

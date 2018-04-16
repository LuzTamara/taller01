package frsf.isi.died.tp.modelo;

import java.util.Arrays;
import java.util.Collection;

import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
//importamos tambien listaserviceradix para poder usar su metodo constructor
import frsf.isi.died.tp.util.*;


/**
 * Esta clase implementa la interface Biblioteca y todas sus operaciones, gestionando todos los
 * @see MaterialCapacitacion en un arreglo.
 * @author mdominguez
 *
 */
public class BibliotecaArray implements Biblioteca{

	/**
	 * Arreglo donde se almacenan todos los materiales de capacitacion
	 */
	private MaterialCapacitacion[] materialCapacitacion;
	/**
	 * Variable interna de control que se utiliza para llevar registro de cuantos materiales 
	 * se llevan insertados. Se utiliza para evitar insertar un nuevo material fuera de rango
	 * y tambien para responder la consulta acerca de cuantos materiales hay insertados
	 */
	private Integer cantidadMaterial;
	
	/**
	 * variable de tipo ListaService que apunta a una instancia del servicio de operaciones de lista
	 */
	private ListasService ServicioOperaciones;

	
	public BibliotecaArray() {
		cantidadMaterial=0;
		this.materialCapacitacion= new MaterialCapacitacion[10];
		this.ServicioOperaciones = new ListaServiceRadix(materialCapacitacion);
		
	}

	/**
	 * Agrega un material al arreglo de materiales de capacitacion si hay espacio en el arreglo
	   caso contrario el metodo no agrega ningun elemento y termina su ejecucion

	 */
	public void agregar(MaterialCapacitacion material) {
		if(cantidadMaterial < 10) {
			materialCapacitacion[cantidadMaterial] = material;
			cantidadMaterial++;
		}
		
	}

	/**
	 * Retorna la cantidad de materiales existentes en la biblioteca
	 * @return cantidad material
	 */
	public Integer cantidadMateriales() {
		return cantidadMaterial;
	}



	/**Retorna la cantidad de libros registrados en el sistema.
	 * @return cantidad libros
	 */
	public Integer cantidadLibros() {
		Integer cant = 0;
		for(MaterialCapacitacion mat: materialCapacitacion) {
			if(mat != null) {
				if(mat.esLibro())
					cant++;
			}
		}
		return cant;
	}



	/**Retorna la cantidad de videos registrados en el sistema.
	 * @return cantidad videos
	 */
	public Integer cantidadVideos() {
		Integer cant = 0;
		for(MaterialCapacitacion mat: materialCapacitacion) {
			if(mat != null) {
				if(mat.esVideo())
					cant++;
			}
		}
		return cant;
	}

	/**
	 * Invoca al metodo imprimir de la variable de tipo ListaService para que imprima el arreglo 
	 */
	public void imprimir() {
		ServicioOperaciones.imprimir();
	 
	}
		

	/**
	 * invoca al metodo ordenar de la variable de tipo ListaService para que ordene el arreglo 
	 */
	public void ordenarPorPrecio(Boolean b) {
		if(b)
		ServicioOperaciones.ordenar();
	}


	@Override
	public Collection<MaterialCapacitacion> materiales() {
		return Arrays.asList(this.materialCapacitacion);
	}



}

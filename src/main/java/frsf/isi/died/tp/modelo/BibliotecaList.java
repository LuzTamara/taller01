package frsf.isi.died.tp.modelo;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.util.Ordenable;
import frsf.isi.died.tp.util.MaterialNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Arrays;

public class BibliotecaList implements Biblioteca{
	
	private ArrayList<MaterialCapacitacion> materiales;
	
	/**
	 * Crea un nuevo array list de materiales de capacitacion
	 */
	public BibliotecaList() {
		this.materiales = new ArrayList<>();
		}

	/**
	 * agrega el material mat al array list
	 * @param mat
	 * @return 
	 */
	public void agregar(MaterialCapacitacion mat) {
		this.materiales().add(mat);
	}
	
	/**
	 * retorna el tamanio de la lista
	 * @return Integer
	 */
	public Integer cantidadMateriales() {
		return(this.materiales.size());
	}
	
	/**
	 * recorre la lista y devuelve la cantidad de libros en ella
	 */
	public Integer cantidadLibros() {
		int count = 0;
		for (int i = 0; i < (materiales.size());  i++) {
			if((materiales.get(i)).esLibro())
				count++;
		}
		return count;
		
	}
	
	/**
	 * recorre la lista y devuelve la cantidad de videos en ella
	 */
	public Integer cantidadVideos() {
		int count = 0;
		for (int i = 0; i < (materiales.size());  i++) {
			if((materiales.get(i)).esVideo())
				count++;
		}
		return count;
		
	}
	
	/**
	 * retorna this.materiales
	 */
	public Collection<MaterialCapacitacion> materiales(){
		return this.materiales;
	}
	
	/**
	 * recorre la lista e imprime por consola cada elemento
	 */
	public void imprimir() {
		int i = 0;
		for(MaterialCapacitacion obj : materiales) {
			if(obj!=null) System.out.println("Elemento en posicion "+(++i)+": "+obj);		
		}
	}
		
	/**
	 * Se ordena en funcion del parametro boolean b
	 * Si b es false se ordena alfabeticamente.
	 * Si b es true se ordena por precio.
	 */
	public void ordenarPorPrecio(Boolean b) {
		if(b == false) {
			Collections.sort(materiales);
		}
		else {
			materiales.sort((MaterialCapacitacion m1, MaterialCapacitacion m2) -> ((int)((double)(m1.getCosto())))- ((int)((double)(m2.getCosto()))));
		}
	}
	
	/** Rutina guia que ordena la lista por costo e invoca a un metodo recursivo, 
	 * el que busca el libro con el algoritmo de busqueda binaria ya implementado
	 * 
	 */
	
	@Override
	public MaterialCapacitacion buscar(Integer precio){
		this.ordenarPorPrecio(true);
		try {
			return buscadorBinario(0, (materiales.size()-1), precio);
		}
		catch(MaterialNotFoundException m){
			throw new RuntimeException(); 
			//System.out.println(m.getMessage());
			//return null;
		}
	}
	
	private MaterialCapacitacion buscadorBinario(Integer i,Integer f, Integer c) throws MaterialNotFoundException{
			
		Integer m = (i+f)/2;
		
		if(f<i) throw new MaterialNotFoundException((int)(c));
		
		if((int)c == (int)(double)(materiales.get(m).getCosto())) {
			return materiales.get(m);
		}
		if((int)c < (int)(double)(materiales.get(m).getCosto()))
			return buscadorBinario(i, m-1, c);
		else
			return buscadorBinario(m+1, f, c);
	}
	
}



package frsf.isi.died.tp.modelo;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.util.Ordenable;

import java.util.ArrayList;
import java.util.Collection;

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
	 */
		public void ordenarPorPrecio(Boolean b) {
			//TODO 01: metodo ordenar
			}
		}
}


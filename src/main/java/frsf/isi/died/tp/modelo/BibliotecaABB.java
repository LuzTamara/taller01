package frsf.isi.died.tp.modelo;

import java.util.Collection;
import java.util.Comparator;

import frsf.isi.died.tp.estructuras.Arbol;
import frsf.isi.died.tp.estructuras.ArbolBinarioBusqueda;
import frsf.isi.died.tp.estructuras.ArbolVacio;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;

public class BibliotecaABB implements Biblioteca {

	private Arbol materiales;
	private Boolean flagOrdenarPorPrecio;
	private Comparator<MaterialCapacitacion> comparaTitulo= (mc1,mc2)-> mc1.getTitulo().compareTo(mc2.getTitulo());
	private Comparator<MaterialCapacitacion> comparaPrecio= (mc1,mc2)-> mc1.precio().intValue()- mc2.precio().intValue();
	
	public BibliotecaABB() {
		this.materiales = new ArbolVacio();
		flagOrdenarPorPrecio= false;
	}
	
	@Override
	public void agregar(MaterialCapacitacion material) {
		if(this.materiales.esVacio()) this.materiales = new ArbolBinarioBusqueda(material, comparaTitulo);
		else{
			if(materiales.tamanio()<10)this.materiales.add(material);
		}
	}

	@Override
	public Integer cantidadMateriales() {
		return materiales.tamanio();
	}

	@Override
	public Integer cantidadLibros() {
		return materiales.tamanioLibros();
	}

	@Override
	public Integer cantidadVideos() {
		return materiales.tamanioVideos();
	}

	@Override
	public Collection<MaterialCapacitacion> materiales() {
		
		return this.materiales.inOrden();	
	}

	@Override
	public void imprimir() {
		materiales.imprimir();
	}

	@Override
	public void ordenarPorPrecio(Boolean b) {
		if((flagOrdenarPorPrecio && b) || (!flagOrdenarPorPrecio && !b ) ) {
			// no hago nada porque ya estaba ordenando por precio
			// y me pide que ordene por precio por lo tanto retorno
			return;
		}

		if(flagOrdenarPorPrecio && !b) {
			this.flagOrdenarPorPrecio = false;
			this.ordenarPorTitulo();
		}
		if(!flagOrdenarPorPrecio && b) {
			this.flagOrdenarPorPrecio= true;
			this.ordenarPorPrecio();
		}		
	}
	


	@Override
	public MaterialCapacitacion buscar(Integer precio) {
		// TODO Auto-generated method stub
		if(!flagOrdenarPorPrecio) this.ordenarPorPrecio(true);
		return this.materiales.buscar(precio);		
	}
	
	public Collection<MaterialCapacitacion> rango(Double costoMinimo,Double costoMax){
		if(!flagOrdenarPorPrecio) this.ordenarPorPrecio(true); 				
		return this.materiales.rango(costoMinimo, costoMax);
	}
	
	private void ordenarPorPrecio() {
		ArbolBinarioBusqueda arbolAux = new ArbolBinarioBusqueda(comparaPrecio);
		Collection<MaterialCapacitacion> listaAux = this.materiales.inOrden();
		for (MaterialCapacitacion m: listaAux)
			if(m != null) {
				arbolAux.add(m);
			}
		materiales = arbolAux;
		return;
		
	}
	
	private void ordenarPorTitulo() {
	return;
	}

}
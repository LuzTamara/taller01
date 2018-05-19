package frsf.isi.died.tp.util;

public class MaterialNotFoundException extends Exception {
	public MaterialNotFoundException(int costo) {
		super("Material de precio " + costo + " no encontrado");
	}
}

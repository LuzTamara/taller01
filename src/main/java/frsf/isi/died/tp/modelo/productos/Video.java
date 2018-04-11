package frsf.isi.died.tp.modelo.productos;

/**
 * Representa un video en el sistema de biblioteca digital
 * @author LuzTamara
 */
public class Video extends MaterialCapacitacion {
	/**
	 * Representa el costo que se cobra cada segundo de duracion del video
	 */
	static Double costoPorSegundo=0.15;
	
	/**
	 * Representa la duracion en segundos del video
	 */
	private Integer duracion;
	
	
	/**
	 * Constructor por defecto del Video
	 */
	public Video() {
		
	}
	
	/**
	 * permite crear un video con su titulo e identificador
	 * @param id es el identificador del video
	 * @param titulo es el titulo del video
	 */
	public Video(Integer id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}
	
	/**
	 * permite crear un video con todos sus parametros
	 * @param id es el identificador del video
	 * @param titulo es el titulo del video
	 * @param costo es el costo de ofrecerlo online
	 * @param duracion es la duracion del video
	 */
	public Video(Integer id, String titulo, Double costo, Integer duracion) {
		this.id = id;
		this.titulo = titulo;
		this.costo = costo;
		this.duracion = duracion;
	}
		
	/**
	 * Devuelve true al ser preguntado si es video
	 * @return true
	 */
	public Boolean esVideo() {
		return true;
	}
	/**
	 * Devuelve false al ser preguntado si es libro
	 * @return false
	 */
	public Boolean esLibro() {
		return false;
	}
	
	public Double precio() {
		return (costo+(duracion*costoPorSegundo));
	}

	
	
}
/**
 * Clase Celda.
 *
 * Clase destinada a verificar el estado de una celda la TablaHash con
 * direccionamiento abierto y sondeo lineal.
 */
public class Celda {

    /* Estado de la celda. */
    private Etiqueta etiqueta;
    /* Tupla dentro de la celda. */
    private Tupla tupla;

    /**
     * Método Constructor por parámetros (etiqueta, tupla).
     * @param etiqueta ; etiqueta de la celda.
     * @param tupla ; tupla en la celda.
     */
    public Celda(Etiqueta etiqueta, Tupla tupla) {
	this.etiqueta = etiqueta;
	this.tupla = tupla;
    }

    /**
     * Método getter para obtener la Etiqueta de la tupla.
     * @return etiqueta de la celda.
     */
    public Etiqueta getEtiqueta() {
	return this.etiqueta;
    }

    /**
     * Método setter para modificar la Etiqueta de la celda.
     * @param nueva etiqueta de la celda.
     */
    public void setEtiqueta(Etiqueta etiqueta) {
	this.etiqueta = etiqueta;
    }
    
    /**
     * Método getter para obtener la Tupla de la celda.
     * @return tupla de la celda.
     */
    public Tupla getTupla() {
	return this.tupla;
    }

    /**
     * Método setter para modificar la Tupla de la celda.
     * @param nueva tupla de la celda.
     */
    public void setTupla(Tupla tupla) {
	this.tupla = tupla;
    }
    //Pedro Ruiz, Miranda Sánchez, Alan Alvarez
}

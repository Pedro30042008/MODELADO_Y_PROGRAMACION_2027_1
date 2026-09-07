import java.util.LinkedList;

/**
 * TablaSondeoLineal
 * Clase destinada a la implementacion de una TablaHash utilizando 
 * Direccionamiento Abierto con Sondeo lineal
 */

public class TablaSondeoLineal {
    

    /**
     * Clase interna privada destinada a calcular la función de dispersión.
     */
    private class FuncionDispersion {

        /**
         * Método que aplica la función de dispersión h(k,i) = (k+i) mod m.
         *
         * @param llave llave de una Tupla.
         * @return índice de una cubeta en la TablaHash.
         */
        public int hash(int llave, int indice) {
            return Math.floorMod((llave+indice), tablaHash.length);
        }
    }

    /* Función de dispersión utilizada por la tabla. */
    private final FuncionDispersion dispersor = new FuncionDispersion();

    /* Número de elementos almacenados en la TablaHash. */
    private int numElementos;

    /* Arreglo de tuplas. */
    private Tupla[] tablaHash;

    /**
     * Constructor por default. Crea una tabla hash de tamaño 7.
     */
    @SuppressWarnings("unchecked")
    public TablaSondeoLineal(){
        tablaHash = new Tupla[7];
    }

    /**
     * Constructor para crear una tabla hash con una dimensión dada.
     *
     * @param dimension dimensión/tamaño de la TablaHash.
     */
    @SuppressWarnings("unchecked")
    public TablaSondeoLineal(int dimension) {

        if (dimension <= 0) {
            throw new IllegalArgumentException(
                "La dimensión debe ser mayor que 0."
            );
        }

        tablaHash = new Tupla[dimension];
    }

    public void insertar(int llave,int i, String valor){
        //pedimos el indice aplicando funcion
        int indiceTabla = dispersor.hash(llave, i);

        if(tablaHash[indiceTabla].equals(Tupla.DELETED) || tablaHash[indiceTabla].equals(null)){
                tablaHash[indiceTabla] = new Tupla(llave, valor);
            }else{
                insertar(llave, i++, valor);
            }

        
    }
}

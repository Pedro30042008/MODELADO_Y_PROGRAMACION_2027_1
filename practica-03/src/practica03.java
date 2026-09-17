/**
 * Clase Main.
 * Clase destinda a ejecutar pruebas de las operaciones realizadas en la
 * clase ArbolB. 
 */
public class practica03 {

    /* Método Main */
    public static void main(String[] args) {
	ArbolB arbolB = new ArbolB();
	// Probando insertar.
        arbolB.insertar(10);
	arbolB.insertar(20);
	arbolB.insertar(8);
	System.out.println(arbolB);
    }
}

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
        arbolB.insertar(100);
	arbolB.insertar(200);
	arbolB.insertar(300);
	arbolB.insertar(400);
	arbolB.insertar(500);
	arbolB.insertar(600);
	arbolB.insertar(700);
	arbolB.insertar(800);
	arbolB.insertar(1000);
	arbolB.insertar(2000);
	arbolB.insertar(3000);
	arbolB.insertar(4000);
	arbolB.insertar(250);
	arbolB.insertar(550);
	arbolB.insertar(850);
	arbolB.insertar(50);
	System.out.println(arbolB);
    }
}

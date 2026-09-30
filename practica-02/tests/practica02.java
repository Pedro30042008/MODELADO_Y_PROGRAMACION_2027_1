/**
 * Clase Main.
 * Clase destinda a ejecutar pruebas de las operaciones realizadas en la
 * clase ArbolB. 
 */
public class practica02 {

    /* Método privado para imprimir Texto. */
    private static void imprimirTexto(String texto){
	System.out.println(texto);
    }
    
    /* Método Main */
    public static void main(String[] args) {
	// Pruebas de la clase ArbolB.
	ArbolB arbolB = new ArbolB();

	// Pruebas Unitarias.
	imprimirTexto("--------------------------------------------------------------------------");
	imprimirTexto("                             Pruebas Unitarias.");
	imprimirTexto("--------------------------------------------------------------------------\n");
	
	// Prueba 1: Árbol Vacío.
	String tmp = null;
	Integer aux = arbolB.buscar(10);
	if (aux != null) {
	    tmp = Integer.toString(aux);
	} else {
	    tmp = "NOT_FOUND";
	}
        imprimirTexto(
		      String.join("\n",
				  "Prueba 1: Árbol Vacío." + "\n",
				  "Ejecutamos:",
				  "arbolB.buscar(10)" + "\n",
				  "Resultado Esperado:",
				  "NOT_FOUND" + "\n",
				  "Resultado Obtenido: ",
				  tmp + "\n"));
	
	// Prueba 2: Inserción sin split.
	arbolB.insertar(20);
	arbolB.insertar(40);
	arbolB.insertar(10);
	
	imprimirTexto(
		      String.join("\n",
				  "Prueba 2: Inserción sin split." + "\n",
				  "Ejecutamos:",
				  "arbolB.insertar(20);",
				  "arbolB.insertar(40);",
				  "arbolB.insertar(10);",
				  "System.out.println(arbolB)" + "\n" ,
				  "Resultado Esperado:",
				  "Nivel 00: [10 | 20 | 40]" + "\n",
				  "Resultado Obtenido: ",
				  arbolB.toString() + "\n"));

	// Prueba 3: Primer split de la raíz.
	arbolB.insertar(30);
	
	imprimirTexto(
		      String.join("\n",
				  "Prueba 3: Primer split de la raíz." + "\n",
				  "Continuamos:",
				  "arbolB.insertar(30);",
				  "System.out.println(arbolB)" + "\n",
				  "Resultado Esperado:",
				  "Nivel 00: [30]",
				  "Nivel 01: [10 | 20] [40]" + "\n",
				  "Resultado Obtenido: ",
				  arbolB.toString() + "\n"));

	// Prueba 4: Búsqueda existente e inexistente.
	String tmp1 = null;
	String tmp2 = null;
	String tmp3 = null;
	Integer aux1 = arbolB.buscar(20);
	Integer aux2 = arbolB.buscar(30);
	Integer aux3 = arbolB.buscar(99);
	if (aux1 != null) {
	    tmp1 = Integer.toString(aux1);
	} else {
	    tmp1 = "NOT_FOUND";
	}
	if (aux2 != null) {
	    tmp2 = Integer.toString(aux2);
	} else {
	    tmp2 = "NOT_FOUND";
	}
	if (aux3 != null) {
	    tmp3 = Integer.toString(aux3);
	} else {
	    tmp3 = "NOT_FOUND";
	}
        imprimirTexto(
		      String.join("\n",
				  "Prueba 4: Búsqueda existente e inexistente." + "\n",
				  "Ejecutamos:",
				  "arbolB.buscar(20)",
				  "arbolB.buscar(30)",
				  "arbolB.buscar(99)" + "\n",
				  "Resultado Esperado:",
				  "20",
				  "30",
				  "NOT_FOUND" + "\n",
				  "Resultado Obtenido: ",
				  tmp1,
				  tmp2,
				  tmp3 + "\n"));

	// Prueba 5: División y propagación hasta crear una nueva raíz..
	arbolB = new ArbolB();
	arbolB.insertar(20);
	arbolB.insertar(40);
	arbolB.insertar(10);
	arbolB.insertar(30);
	arbolB.insertar(50);
	arbolB.insertar(60);
	arbolB.insertar(70);
	arbolB.insertar(5);
	arbolB.insertar(15);
	arbolB.insertar(25);
	arbolB.insertar(35);
	arbolB.insertar(45);
	
	imprimirTexto(
		      String.join("\n",
				  "Prueba 5: División y propagación hasta crear una nueva raíz." + "\n",
				  "Ejecutamos:",
				  "arbolB = new ArbolB()",
				  "arbolB.insertar(20)",
				  "arbolB.insertar(40)",
				  "arbolB.insertar(10)",
				  "arbolB.insertar(30)",
				  "arbolB.insertar(50)",
				  "arbolB.insertar(60)",
				  "arbolB.insertar(70)",
				  "arbolB.insertar(5)",
				  "arbolB.insertar(15)",
				  "arbolB.insertar(25)",
				  "arbolB.insertar(35)",
				  "arbolB.insertar(45)",
				  "System.out.println(arbolB)" + "\n",
				  "Resultado Esperado:",
				  "Nivel 00: [45]",
				  "Nivel 01: [15 | 30] [60]",
				  "Nivel 02: [5 | 10] [20 | 25] [35 | 40] [50] [70]" + "\n",
				  "Resultado Obtenido: ",
				  arbolB.toString() + "\n"));

	// Prueba 6: Llave Repetida.
	arbolB.insertar(35);

	imprimirTexto(
		      String.join("\n",
				  "Prueba 6: Llave Repetida." + "\n",
				  "Continuamos:",
				  "arbolB.insertar(35)",
				  "System.out.println(arbolB)" + "\n",
				  "Resultado Esperado:",
				  "Nivel 00: [45]",
				  "Nivel 01: [15 | 30] [60]",
				  "Nivel 02: [5 | 10] [20 | 25] [35 | 40] [50] [70]" + "\n",
				  "Resultado Obtenido: ",
				  arbolB.toString() + "\n"));

	// Prueba 7: Eliminación sin Underflow.
	arbolB.eliminar(25);

	imprimirTexto(
		      String.join("\n",
				  "Prueba 7: Eliminación sin Underflow." + "\n",
				  "Continuamos:",
				  "arbolB.eliminar(25)",
				  "System.out.println(arbolB)" + "\n",
				  "Resultado Esperado:",
				  "Nivel 00: [45]",
				  "Nivel 01: [15 | 30] [60]",
				  "Nivel 02: [5 | 10] [20] [35 | 40] [50] [70]" + "\n",
				  "Resultado Obtenido: ",
				  arbolB.toString() + "\n"));

	// Prueba 8: Secuencia con reparación.
	arbolB.eliminar(10);
	arbolB.eliminar(70);
	
	imprimirTexto(
		      String.join("\n",
				  "Prueba 8: Secuencia con reparación." + "\n",
				  "Continuamos:",
				  "arbolB.eliminar(10)",
				  "arbolB.eliminar(70)",
				  "System.out.println(arbolB)" + "\n",
				  "Resultado Esperado:",
				  "Nivel 00: [30]",
				  "Nivel 01: [15] [45]",
				  "Nivel 02: [5] [20] [35 | 40] [50 | 60]" + "\n",
				  "Resultado Obtenido: ",
				  arbolB.toString() + "\n"));

	// Prueba 9: Disminución de altura.
	arbolB.eliminar(5);
	
	imprimirTexto(
		      String.join("\n",
				  "Prueba 9: Disminución de altura." + "\n",
				  "Continuamos:",
				  "arbolB.eliminar(5)",
				  "System.out.println(arbolB)" + "\n",
				  "Resultado Esperado:",
				  "Nivel 00: [30 | 45]",
				  "Nivel 01: [15 | 20] [35 | 40] [50 | 60]" + "\n",
				  "Resultado Obtenido: ",
				  arbolB.toString() + "\n"));

	// Ejecución Final.
	imprimirTexto("--------------------------------------------------------------------------");
	imprimirTexto("                             Ejecución Final.");
	imprimirTexto("--------------------------------------------------------------------------\n");
	
	arbolB = new ArbolB();
	arbolB.insertar(20);
	arbolB.insertar(40);
	arbolB.insertar(10);
	arbolB.insertar(30);
	arbolB.insertar(50);
	arbolB.insertar(60);
	arbolB.insertar(70);
	arbolB.insertar(5);
	arbolB.insertar(15);
	arbolB.insertar(25);
	arbolB.insertar(35);
	arbolB.insertar(45);
	
	System.out.println("Arbol Inicial: \n" + arbolB + "\n");

        tmp1 = null;
	tmp2 = null;
	aux1 = arbolB.buscar(35);
	aux2 = arbolB.buscar(99);
	if (aux1 != null) {
	    tmp1 = Integer.toString(aux1);
	} else {
	    tmp1 = "NOT_FOUND";
	}
	if (aux2 != null) {
	    tmp2 = Integer.toString(aux2);
	} else {
	    tmp2 = "NOT_FOUND";
	}

	System.out.println("arbolB.buscar(35): " + tmp1);
	System.out.println("arbolB.buscar(99): " + tmp2 + "\n");

	arbolB.eliminar(25);
	arbolB.eliminar(10);
	arbolB.eliminar(70);
	arbolB.eliminar(5);

	System.out.println("Arbol Final: \n" + arbolB + "\n");

        tmp1 = null;
	tmp2 = null;
	aux1 = arbolB.buscar(25);
	aux2 = arbolB.buscar(35);
	if (aux1 != null) {
	    tmp1 = Integer.toString(aux1);
	} else {
	    tmp1 = "NOT_FOUND";
	}
	if (aux2 != null) {
	    tmp2 = Integer.toString(aux2);
	} else {
	    tmp2 = "NOT_FOUND";
	}
	
	System.out.println("arbolB.buscar(25): " + tmp1);
	System.out.println("arbolB.buscar(35): " + tmp2);
	System.out.println();
	
	// Ejecución Final.
	imprimirTexto("--------------------------------------------------------------------------");
	imprimirTexto("                      Verificación de Validar Árbol.");
	imprimirTexto("--------------------------------------------------------------------------\n");
	
	arbolB = new ArbolB();
	System.out.println("Arbol Actual: \n" + arbolB);
	System.out.print("Validar Arbol: ");
	System.out.println(arbolB.validarArbol());
	System.out.println();
	arbolB.insertar(20);
	System.out.println("Arbol Actual: \n" + arbolB);
	System.out.print("Validar Arbol: ");
	System.out.println(arbolB.validarArbol());
	System.out.println();
	arbolB.insertar(40);
	System.out.println("Arbol Actual: \n" + arbolB);
	System.out.print("Validar Arbol: ");
	System.out.println(arbolB.validarArbol());
	System.out.println();
	arbolB.insertar(10);
	System.out.println("Arbol Actual: \n" + arbolB);
	System.out.print("Validar Arbol: ");
	System.out.println(arbolB.validarArbol());
	System.out.println();
	arbolB.insertar(30);
	System.out.println("Arbol Actual: \n" + arbolB);
	System.out.print("Validar Arbol: ");
	System.out.println(arbolB.validarArbol());
	System.out.println();
	arbolB.insertar(50);
	System.out.println("Arbol Actual: \n" + arbolB);
	System.out.print("Validar Arbol: ");
	System.out.println(arbolB.validarArbol());
	System.out.println();
	arbolB.insertar(60);
	System.out.println("Arbol Actual: \n" + arbolB);
	System.out.print("Validar Arbol: ");
	System.out.println(arbolB.validarArbol());
	System.out.println();
	arbolB.insertar(70);
	System.out.println("Arbol Actual: \n" + arbolB);
	System.out.print("Validar Arbol: ");
	System.out.println(arbolB.validarArbol());
	System.out.println();
	arbolB.insertar(5);
	System.out.println("Arbol Actual: \n" + arbolB);
	System.out.print("Validar Arbol: ");
	System.out.println(arbolB.validarArbol());
	System.out.println();
	arbolB.insertar(15);
	System.out.println("Arbol Actual: \n" + arbolB);
	System.out.print("Validar Arbol: ");
	System.out.println(arbolB.validarArbol());
	System.out.println();
	arbolB.insertar(25);
	System.out.println("Arbol Actual: \n" + arbolB);
	System.out.print("Validar Arbol: ");
	System.out.println(arbolB.validarArbol());
	System.out.println();
	arbolB.insertar(35);
	System.out.println("Arbol Actual: \n" + arbolB);
	System.out.print("Validar Arbol: ");
	System.out.println(arbolB.validarArbol());
	System.out.println();
	arbolB.insertar(45);
	System.out.println("Arbol Actual: \n" + arbolB);
	System.out.print("Validar Arbol: ");
	System.out.println(arbolB.validarArbol());

	arbolB.casosValidar();
    }
}
//Alan Gael, Pedro Pablo, Miranda Sanchez
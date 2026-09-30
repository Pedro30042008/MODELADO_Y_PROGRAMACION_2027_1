# Practica 02

## Descripción 

En esta practica implementamos una estructura de dato, **Arboles B** en java.

Los Árboles B son estructuras de datos de búsqueda auto-balanceadas optimizadas para sistemas de almacenamiento y bases de datos, ya que minimizan las operaciones de lectura/escritura en disco.

Los arboles estan acotados de orden 4 y soportan las operaciones minimas `insertar(x)` `buscar(x)` `eliminar(x)`
`imprimirPorNiveles()` y como reto opcional `validarArbol()`.

## Estructura

```text
practica-02/
|
├── docs/
|   └── Documentacion_practica_02.txt
├── src/ 
|   └── ArbolB.java
├── tests/
│   └── practica02.java
└── README.md
```

## Ejecución para los test
Desde la carpeta `practica-02`

```bash
javac -d bin src/*.java tests/*.java
java -cp bin practica02
rm -rf bin
```
Todo en una sola linea

```bash
javac -d bin src/*.java tests/*.java && java -cp bin practica02 && rm -rf bin
```

## Preguntas
1. Lenguaje utilizado   
    La práctica fue implementada en **Java**. La clase principal de la estructura es `ArbolB`, mientras que la clase `practica02` se utiliza para crear árboles y ejecutar los diferentes casos de prueba.  

2,3. Las instrucciones para ejecutar el programa y explicación de cómo ejecutar los casos de prueba ya se mencionario anteriormente.

4. Representación de una Nodo
    En esta implementación representamos a un nodo del Arbol B como `NodoArbolB`, en el cual como atributos tenemos:
    
    `LinkedList<Celda> celdas;`<br>
        Son las llaves que almacena el nodo a lo mas son 3.  
	`NodoArbolB padre;`  
        Referencia al padre para acceder a hermanos y el correcto funcionamiento de las operaciones.   
	`NodoArbolB intervaloMayor;`  
        Referencia directa al intervalo mayor.  
	`int numHijos;`  
        Contador de hijos.  
	`int numLlaves;`  
        Contador de llaves.  
    
    De igual forma nos apoyamos de una clase `Celda` la cual como atributos tenemos  

    `Integer llave;`  
        Almacena el valor numerico de la celda.  
	`NodoArbolB intervaloMenor;`  
        Referencia exactamente al intervalo menor a la llave de la celda actual.  
    
    `NodoArbolB` funciona dando referencia directa al intervalo mayor y por cada celda dentro del nodo tiene referencia directa a su intervalo mayor.
    Decidimos implementarlo de esta forma para poder tener un orden a los hijos y para recuperar a hermanos.
    Más detalles en _docs/Documentacion_practica_02.txt_

6. ¿Que significa _m = 4_ y por que cada nodo acepta max 3 llaves?

    _m = 4_ indica que el árbol B es de **orden 4**. Esto significa que un nodo puede tener como máximo cuatro hijos.
    
    Por esta razón un nodo estable admite como máximo tres llaves, ya que _r_ es el máximo número de llaves por nodo, que es igual a _r = m - 1 = 4 - 1 = 3_ .
    Durante una inserción un nodo puede alcanzar temporalmente cuatro llaves **desbordamiento**. Cuando esto sucede se produce una división o `split` para que el árbol B cumpla nuevamente las invariantes, incluido que un árbol con orden 4 tiene a lo más en cada nodo 3 llaves.

8. ¿Cómo se decide qué hijo seguir durante una búsqueda?  
    Primero se recorren, en orden, las celdas del nodo actual.
    Para cada llave se realizan dos comprobaciones.

    Si la llave almacenada es igual a la llave buscada, la búsqueda termina porque el elemento fue encontrado.

    Si la llave almacenada es mayor que la llave buscada, significa que el valor buscado solamente puede encontrarse en el intervalo menor de esa celda, por lo que se continúa mediante:
    `celda.intervaloMenor`.  
    
    Si se recorren todas las llaves del nodo y ninguna es mayor que la llave buscada, significa que el valor buscado es mayor que todas las llaves del nodo. En ese caso se continúa mediante:
    `nodo.intervaloMayor`.  

9. ¿Qué ocurre cuando un nodo alcanza cuatro llaves?

    Como el árbol tiene orden `m = 4`, tres es el máximo permitido de llaves en un nodo. Cuando una inserción provoca que un nodo tenga cuatro llaves, es decir, ocurre un **desbordamiento**, se ejecuta el método `split`.
    La división separa el nodo en dos nodos y una de sus llaves se promueve al padre.

    Si la división ocurre en la raíz, se crea una nueva raíz.
    Si al promover una llave el padre también alcanza cuatro llaves, el proceso se repite recursivamente sobre el padre.
    Por esta razón una división puede propagarse hacia niveles superiores e incluso aumentar la altura del árbol.
   
11. Convención de promoción utilizada
 	Si tenemos un **desbordamiento** en un nodo, ocupamos la tercera celda, que contiene la tercera llave, para promoverla al nodo padre. En la implementación, quisimos generalizar la idea para cualquier _m_, entonces elegimos la mediana de las celdas para promoverla al nodo padre mediante la fórmula:
	
    _mediana = (r / 2) + 1_

	con _r_ tomando el valor de 4, es decir, la cantidad de llaves que se considera como **desbordamiento** en un nodo para un árbol de orden _m = 4_, también la división _r / 2_ que toma la parte entera y el _+ 1_ para tomar la celda del lado derecho, en esta implementación, la tercera celda.

    Además, en la implementación se dividen las llaves de manera que la llave elegida o celda promovida se elimina del nodo original y se inserta en el padre. Las llaves menores permanecen en el nodo izquierdo y las llaves mayores pasan al nuevo nodo derecho.
    La celda promovida conserva la referencia necesaria al nodo izquierdo y el padre actualiza la referencia al nuevo nodo derecho.
    Si el nodo dividido era la raíz, primero se crea una nueva raíz y posteriormente la llave promovida se inserta en ella.  

13. Redistribución y fusión

    La **redistribución** se utiliza durante la eliminación cuando un nodo queda con menos llaves que el mínimo permitido, pero uno de sus hermanos tiene llaves suficientes para prestar.
    La llave no se mueve directamente de un hermano al otro. El movimiento se realiza a través del padre.  

    Si presta el hermano izquierdo:  
    ```text
    hermano izquierdo → padre → nodo subocupado
    ```

    La última llave del hermano izquierdo sube al padre y la antigua llave separadora del padre baja al principio del nodo subocupado.

    Si presta el hermano derecho:

    ```text
    nodo subocupado ← padre ← hermano derecho
    ```

    La primera llave del hermano derecho sube al padre y la antigua llave separadora baja al final del nodo subocupado.

    Cuando se trabaja con nodos internos también se mueve la referencia de hijo correspondiente.

    La **fusión** ocurre cuando el nodo está subocupado y ninguno de sus hermanos puede prestar.

    En este caso se combinan:

    ```text
    nodo izquierdo
    +
    llave separadora del padre
    +
    nodo derecho
    ```

    para formar un único nodo.

    Como consecuencia, el padre pierde una llave y un hijo. Si el padre queda subocupado, la reparación continúa hacia niveles superiores.
    Si el padre era la raíz y queda sin llaves, el nodo fusionado se convierte en la nueva raíz, disminuyendo la altura del árbol.

14. ¿Por qué al insertar una llave nueva no podemos decidir el hijo únicamente comparando con la primera llave del nodo?  

    Porque un nodo puede contener varias llaves y, por lo tanto, varios intervalos posibles. Comparar únicamente con la primera llave no permite determinar con precisión cuál de esos intervalos corresponde a la nueva llave.

    Por ejemplo, si un nodo contiene `[30 | 60]` y queremos insertar `70`, saber únicamente que 70 > 30 no basta; todavía necesitamos comparar con 60 para saber en qué intervalo debe continuar la inserción.
    

15. ¿Por qué una búsqueda no debe recorrer todos los hijos de un nodo?  

    Porque las llaves del nodo permiten determinar cuál es el único intervalo en el que podría encontrarse la llave buscada.
    Recorrer todos los hijos sería innecesario si antes encontramos el intervalo correcto, ya que las propiedades de orden del árbol B permiten descartar las demás ramas y continuar únicamente por el hijo correspondiente.     
    
    
    Por ejemplo, si un nodo contiene `[30 | 60]` y buscamos `40`, sabemos que únicamente debemos seguir el intervalo entre 30 y 60.

`Pedro Ruiz, Miranda Sánchez, Alan Alvarez <3`

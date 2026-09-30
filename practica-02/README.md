# Practica 02

## Descripción 

En esta practica implementamos una estructura de dato,**Arboles B** en java.

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
1. Representación de una Nodo
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

2. ¿Que significa _m = 4_ y por que cada nodo acepta max 3 llaves?

    _m = 4_ Significa el orden que tiene el arbol, es decir la cantidad de hijos a lo maximo puede tener un hijo.
    Esto implica que maximo puede tener 3 llaves, para mantener el orden en el arbol.

3. Que hijo seguir durante una busqueda.
    El hijo que vamos a seguir debe de corresponder al intervalo mayor o menor dependiendo de lo que estamos buscando.  

    Primero buscamos en las celdas de la raiz, por cada celda decidimos si lo que buscamos corresponde al intervalo menor, nos vamos
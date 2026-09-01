# Práctica 0: Paradigmas de programación y flujo básico con Git

## Reflexión

**1. ¿Qué significa programar de forma estructurada?**
Programar de forma estructurada significa organizar el programa de manera clara, dividiendo el problema en partes más pequeñas y controlando el flujo mediante secuencias y condiciones. La idea es evitar tener toda la lógica en un solo lugar y hacer que el código sea más fácil de leer, modificar y mantener.
     
Se enfoca principalmente en tres estructuras de control (Iteración, Selección y Secuencia), de esta manera logramos un 
flujo de ejecución lineal y entendible.

**2. ¿Cuáles son las tres estructuras fundamentales de control?** 
      **Secuencia =** Es la ejecución de instrucciones una después de la anterior en el orden escritas.
      **Selección/Condición =** Es la toma de decisiones que nos lleva a la ejecucion por distintos caminos segun la condicion booleana (Ej. if, else, switch).
      **Iteración/Repetición =** Es la repetición de un bloque de código meintras se cumpla una codición booleana (Ej. while, for, do-while).
      
**3. ¿Qué ventaja tuvo separar el programa en funciones?**  
Separar el programa permitió que cada parte tuviera una responsabilidad específica de acuerdo al paradigma POO, por lo que fue más fácil entender qué hacía cada sección. Por ejemplo, en nuestro código la validación de datos, el cálculo del promedio y el manejo del estudiante están separados, en lugar de tener toda la lógica directamente en el main. Esto también facilita reutilizar partes del código y modificarlo sin tanto problema.

**4. ¿Qué función tendría que modificarse si la calificación mínima aprobatoria cambiara?**  
      La función [`calcular_promedio(self, estudiante)`](practica-0/src/sistemaCalificaciones.py #L52)
      Pues es la encargada de hacer la división, aun que tambien podriamos fijarnos en (practica-0/src/verificadorDatos.py) pues aquí esta la lógica completa para recolectar las calificaciones; tanto validas como invalidas.
      
**5. ¿Qué diferencia conceptual observa entre una función y un método?**  

**6. ¿Qué representa un commit en Git?**  

**7. ¿Por qué es preferible realizar varios commits pequeños en lugar de un solo commit al final?**  

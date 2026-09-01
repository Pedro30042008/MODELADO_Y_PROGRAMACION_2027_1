# Práctica 0: Paradigmas de programación y flujo básico con Git

## Reflexión

**1. ¿Qué significa programar de forma estructurada?**
      Es un paradigma de programación tal que se enfoca en una mejor comprensión, calidad y en el tiempo de desarrollo.
      Se enfoca principalmente en tres estructuras de control (Iteración, Selección y Secuencia), de esta manera logramos un 
      flujo de ejecución lineal y entendible.

**2. ¿Cuáles son las tres estructuras fundamentales de control?** 
      **Secuencia =** Es la ejecución de instrucciones una después de la anterior en el orden escritas.
      **Selección/Condición =** Es la toma de decisiones que nos lleva a la ejecucion por distintos caminos segun la condicion booleana (Ej. if, else, switch).
      **Iteración/Repetición =** Es la repetición de un bloque de código meintras se cumpla una codición booleana (Ej. while, for, do-while).
**3. ¿Qué ventaja tuvo separar el programa en funciones?**  
      La ventaja más notoria es reutilizar código, pues permite invocar un mismo bloque de lógica previamente ya realizado con una responsabilidad definida, en múltiples partes del programa principal o como auxiliar. 
      De igual forma como este código está aislado es mucho más fácil depurar o corregir errores ya que cada función. Por ultimo ayuda demasiado en 
      un código legible pues podemos resumir procesos complejos llamando a la función.
**4. ¿Qué función tendría que modificarse si la calificación mínima aprobatoria cambiara?**  
      La función [`calcular_promedio(self, estudiante)`](practica-0/src/sistemaCalificaciones.py#L52)
      Pues es la encargada de hacer la división, aun que tambien podriamos fijarnos en (practica-0/src/verificadorDatos.py) pues aquí esta la lógica completa para recolectar las calificaciones; tanto validas como invalidas.
**5. ¿Qué diferencia conceptual observa entre una función y un método?**  

**6. ¿Qué representa un commit en Git?**  

**7. ¿Por qué es preferible realizar varios commits pequeños en lugar de un solo commit al final?**  

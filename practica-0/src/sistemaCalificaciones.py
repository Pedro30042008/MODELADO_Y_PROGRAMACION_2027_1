# Importacion de clases.
from estudiante import Estudiante

# Clase: SistemaCalificaciones
class SistemaCalificaciones:
    
    # Método para iniciar la calculadora.
    def iniciaCalculadora(self):
        
        # Variable que instancia un objeto de la clase Estudiante.
        alumno = Estudiante()
        
        # Ingresa el nombre del estudiante.
        while True:

            # Solicita el nombre del estudiante.
            print("\nIngresa el nombre del estudiante.")
            nombre = input("Respuesta: ")

            # Intentamos asignar el nombre al estudiante.
            alumno.nombre = nombre

            # Si el alumno tiene nombre asignado continuamos.
            if alumno.nombre is not None:
                break

        # Ingresa las calificaciones del estudiante.
        while True:

            # Solicita las calificaciones del estudiante.
            print("\nIngresa las calificaciones separadas por comas [8, 9, 10]")
            arreglo_calificaciones = input("Respuesta: ")
            
            # Intentamos asignar las calificaciones.
            alumno.lista_calificaciones = arreglo_calificaciones

            # Si el alumno tiene calificaciones asignadas continuamos.
            if alumno.lista_calificaciones is not None:
                break

        # Calculamos el promedio.
        alumno.promedio = self.calcular_promedio(alumno)
        
        # Verificamos si el alumno está aprobado.
        # alumno.estado_academico = self.definir_estado_academico(alumno)
        
        # Imprime el estudiante en pantalla.
        print()
        print(alumno)

    # Método para iniciar la calculadora.
    def calcular_promedio(self, estudiante):
        # Variable para guardar el calculo del promedio.
        promedio = sum(estudiante.lista_calificaciones) / len(estudiante.lista_calificaciones)
        # Devuelve el calculo del promedio.
        return promedio

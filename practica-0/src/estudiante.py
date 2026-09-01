# Importacion de clases.
from verificadorDatos import VerificadorDatos

# Clase: Estudiante
class Estudiante:

    # Método: Constructor vacío.
    def __init__(self):

        # Inicializa los atributos.
        self.__nombre: str | None = None
        self.__lista_calificaciones: list[float] | None = None
        self.__promedio: float | None = None
        self.__estado_academico: str | None = None

    # Método: get_nombre()
    @property
    def nombre(self) -> str:
        # Regresa el nombre del estudiante
        return self.__nombre

    # Método: set_nombre()
    @nombre.setter
    def nombre(self, nombre: str):
        # Llamamos al método para verificar nombre válido.
        self.__nombre = VerificadorDatos.verificar_nombre(nombre)

    # Método: get_lista_calificaciones()
    @property
    def lista_calificaciones(self) -> list[float]:
        # Regresa la lista de calificaciones del estudiante.
        return self.__lista_calificaciones

    # Método: set_lista_calificaciones()
    @lista_calificaciones.setter
    def lista_calificaciones(self, calificaciones: str):
        # Llamamos al método para verificar calificaciones válidas.
        self.__lista_calificaciones = VerificadorDatos.verificar_calificaciones(calificaciones)

    # Método: get_promedio()
    @property
    def promedio(self) -> float:
        # Regresa el nombre del estudiante
        return self.__promedio

    # Método: set_promedio()
    @promedio.setter
    def promedio(self, promedio: float):
        # Asignamos el promedio obtenido.
        self.__promedio = promedio

    # Método: get_estado_academico()
    @property
    def estado_academico(self) -> str:
        # Regresa el promedio del estudiante
        return self.__estado_academico

    # Método: set_estado_academico()
    @estado_academico.setter
    def estado_academico(self, estado_academico: str):
        # Asignamos el estado academico obtenido.
        self.__estado_academico = estado_academico

    # Método: to String()
    def __str__(self) -> str:
        # Damos formato a las calificaciones.
        notas = ", ".join(f"{num:.2f}" for num in self.__lista_calificaciones)
        # Imprime el estudiante con sus datos.
        return (
            f"Nombre: {self.__nombre}\n"
            f"Lista de calificaciones: [{notas}]\n"
            f"Promedio: {self.__promedio:.2f}\n"
            #f"Estado Académico: {self.__estado_academico}\n"
        )
    

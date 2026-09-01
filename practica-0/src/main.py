# Importacion de clases.
from sistemaCalificaciones import SistemaCalificaciones

# Función principal main.
def main():

    # Instancia los objetos necesarios.
    recepcionista = SistemaCalificaciones()

    # Imprime bienvenida al Programa.
    print("\nBienvenido a Calculadora de Promedio\n")

    # Menú del programa.
    while True:

        # Opciones.
        print("Ingresa una opcion del menú.")
        print("[1] Calcular promedio de un estudiante.")
        print("[2] Salir del programa.")

        # Respuesta del usuario.
        respuesta = input("Respuesta: ")

        # Evaluación de la respuesta.
        match respuesta:

            # Opción [1]: Calcular el promedio de un estudiante.
            case "1":
                recepcionista.iniciaCalculadora()
                
            # Opción [2]: Salir del prgrama.
            case "2":
                print("\nAbandonando el programa.")
                break
            
            # Respuesta inválida o fuera del menú.
            case _:
                print("Ingresa una opcion válida del menú escribiendo '1' o '2'\n")

# Al ejecutar el archivo main.py llama a main().
if __name__ == "__main__":
    main()

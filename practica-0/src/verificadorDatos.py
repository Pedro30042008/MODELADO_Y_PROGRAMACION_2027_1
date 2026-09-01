# Importamos recursos necesarios.
import re

# Clase: VerificadorDatos
class VerificadorDatos:

    # Caracteres válidos en un nombre. [Letras Mayusculas y Minúsculas de A-Z, acentos, diéresis y espacios]
    __caracteres_validos = r"^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\s]+$"
    
    # Método: verificarNombre(nombre)
    @staticmethod
    def verificar_nombre(nombre) -> str | None:
        
        # Si es la cadena vacía.
        if nombre == "":
            print("\nNo se permite dejar el campo vacío.")
            return None
        
        # Si tiene caracteres especiales.
        if not bool(re.match(VerificadorDatos.__caracteres_validos, nombre)):
            print("\nNo se permiten caracteres especiales o números en el nombre.")
            return None
        
        # Devolvemos el nombre validado.
        return nombre.strip()
        
    # Método: verificarCalificaciones(String[])
    @staticmethod
    def verificar_calificaciones(calificaciones: str) -> list[float] | None:

        # Si es la cadena vacía.
        if not calificaciones.strip():
            print("\nNo se permite dejar el campo vacío.")
            return None

        # Referenciar la lista de calificaciones dada.
        lista_usuario = calificaciones.split(',')
        
        # Referenciar la lista de calificaciones en números.
        lista_calificaciones = []

        # Atrapar posibles excepciones.
        try:
            # Verificamos cada elemento de la lista del usuario.
            for elemento in lista_usuario:
                # Limpiamos espacios.
                elemento_normalizado = elemento.strip()
                # Si tiene espacios en blancos.
                if not elemento_normalizado:
                    # Mensaje error.
                    print("\nNo se permiten calificaciones vacías entre comas.")
                    return None
                # Intentar convertir a float.
                calif = float(elemento_normalizado)
                # Si no es positiva o mayor a 10 la calif no es válida.
                if calif > 10 or calif < 0:
                    # Mensaje error.
                    print("\nNo se permiten calificaciones mayores a 10 o negativas.")
                    return None
                # Agregamos la calif a la lista de calificaciones.
                lista_calificaciones.append(calif)
                
        # No se pudo hacer la conversión a número.        
        except ValueError:
            print("\nSólo se permiten números en las calificaciones. ")
            return None
        
        # Verificamos si tiene la cantidad mínima de calificaciones.
        if len(lista_calificaciones) < 3:
            print("\nSe requieren al menos 3 calificaciones para promediar.")
            return None
        
        # Devolvemos la lista de califs ya con números float.
        return lista_calificaciones

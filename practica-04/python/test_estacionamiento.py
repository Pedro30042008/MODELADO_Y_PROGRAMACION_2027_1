import pytest

from estacionamiento import Estacionamiento
from MinutosInvalidos import MinutosInvalidos
from ClienteInvalido import ClienteInvalido

@pytest.fixture
def sistema():
    """Preparación reutilizable para las pruebas."""
    return Estacionamiento()

# Test de Casos Normales

# Arrange
@pytest.mark.parametrize(
    "minutos, esperado",
    [
                        # | Núm. |   Caso   | Regla(s) | Descripción                                |
        (10, 0.00),     # |  1   |  Normal  |    R5    | Cliente "normal" con boleto pasó 10 min.   |
        (40, 20.00),    # |  2   |  Normal  |    R6    | Cliente "normal" con boleto pasó 40 min.   |    
        (1250, 320.00), # |  3   |  Normal  |    R7    | Cliente "normal" con boleto pasó 1250 min. |
    ],
)
def test_cliente_Normal_con_Boleto_Casos_Normal(sistema, minutos, esperado):
    """
    Verifica el cobro calculado para un cliente "normal" con boleto dado un cierto tiempo.
    """
    
    # Act
    resultado = sistema.calcular_total(minutos, "normal", False)
    
    # Assert
    assert resultado == esperado

# Test de Casos Frontera

# Arrange
@pytest.mark.parametrize(
    "minutos, esperado",
    [
                      # | Núm. |   Caso     | Regla(s) | Descripción                                                                                  |
        (15, 0.00),   # |  4   |  Frontera  |    R5    | Cliente "normal" con boleto pasó 15 min, último valor entre el rango de 1-15.                |
        (16, 20.00),  # |  5   |  Frontera  |    R6    | Cliente "normal" con boleto pasó 16 min, primer valor entre el rango de 16-60.               |
        (60, 20.00),  # |  6   |  Frontera  |    R6    | Cliente "normal" con boleto pasó 60 min, último valor entre el rango de 16-60.               |
        (61, 35.00),  # |  7   |  Frontera  |    R7    | Cliente "normal" con boleto pasó 61 min, una hora completa y una hora adicional iniciada.    |
        (120, 35.00), # |  8   |  Frontera  |    R7    | Cliente "normal" con boleto pasó 120 min, dos horas completas sin hora adicional iniciada.   |
        (121, 50.00), # |  9   |  Frontera  |    R7    | Cliente "normal" con boleto pasó 121 min, dos horas completas y una hora adicional iniciada. |
    ],
)
def test_cliente_Normal_con_Boleto_Casos_Frontera(sistema, minutos, esperado):
    """
    Verifica el cobro calculado para un cliente "normal" con boleto dado un cierto tiempo,
    en escencia cuando hay un cambio entre los límites de rangos de tiempo.
    """
    
    # Act
    resultado = sistema.calcular_total(minutos, "normal", False)
    
    # Assert
    assert resultado == esperado

# Test de Entradas inválidas

# Arrange
@pytest.mark.parametrize(
    "minutos",
    [
                # | Caso | Descripción                                                      |
        -1,     # | 10   | Cliente "normal" con boleto pasó -1 min no está bien definido.   |
        15.5,   # | 15   | Cliente "normal" con boleto pasó 15.5 min no está bien definido. |
    ],
)
def test_Minutos_Invalidos(sistema, minutos):
    """
    Verifica que el programa rechaze los Minutos Inválidos establecidos
    en la R1.
    """
    # Siguiendo la R10, verifcamos que rechaze los minutos negativos.
    # Act and Assert
    with pytest.raises(MinutosInvalidos):
        sistema.calcular_total(minutos, "normal", False)

def test_Cliente_Invalido(sistema):
    """
    Verifica que el programa rechaze los clientes que no están
    definidos en la R2. Siguiendo el procedimiento de R11.
    """
    # | Caso | Descripción                                                      |
    # | 10   | Cliente "premium" con boleto pasó 5 min no está bien definido.   |
    
    # Arrage, Act and Assert
    with pytest.raises(ClienteInvalido):
        sistema.calcular_total(5, "premium", False)

# Test de Casos interacción entre reglas

# Arrange
@pytest.mark.parametrize(
    "boleto, esperado",
    [
                          # | Núm. |         Caso         | Regla(s) | Descripción                                                             |
        (False, 288.00),  # | 12   | Interacción entre R  | R7 y R8  | Cliente "frecuente" con boleto paso 1250 minutos en el estacionamiento. |
        (True, 300.00),   # | 13   | Interacción entre R  | R7 y R8  | Cliente "frecuente" sin boleto paso 1250 minutos en el estacionamiento. |
    ],
)
def test_cliente_Frecuente_Casos_Interaccion_entre_reglas(sistema, boleto, esperado):
    """
    Verifica que el programa calcule correctamente el costo del estacionamiento
    dado que el cliente es frecuente, pase 1250 minutos y tenga o no boleto.
    """
    # Act
    resultado = sistema.calcular_total(1250, "frecuente", boleto)
    
    # Assert
    assert resultado == esperado

# Test Numeros decimales entre resultados

# Arrange
@pytest.mark.parametrize(
    "minutos, esperado",
    [
                      # | Núm. |           Caso            | Regla(s) | Descripción                                                           |
        (61, 31.50),  # | 14   | Decimales en el resultado | R7 y R8  | Cliente "frecuente" con boleto paso 61 minutos en el estacionamiento. |
    ],
)
def test_cliente_Frecuente_Casos_Resultado_con_decimales(sistema, minutos, esperado):
    """
    Verifica que el programa calcule correctamente el costo del estacionamiento
    dado que el cliente es frecuente y tenga boleto.
    """
    # Act
    resultado = sistema.calcular_total(minutos, "frecuente", False)
    
    # Assert
    assert resultado == pytest.approx(esperado)
    
# TODO:
# 1. Agregue casos normales. *
# 2. Agregue casos frontera. *
# 3. Agregue entradas inválidas con pytest.raises. *
# 4. Agregue casos parametrizados con @pytest.mark.parametrize. *
# 5. Use pytest.approx cuando el resultado esperado tenga decimales. *
# 6. Pruebe interacciones entre reglas. *

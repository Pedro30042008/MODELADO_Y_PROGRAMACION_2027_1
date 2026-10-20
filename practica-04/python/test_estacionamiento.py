import pytest

from estacionamiento import Estacionamiento

@pytest.fixture
def sistema():
    """Preparación reutilizable para las pruebas."""
    return Estacionamiento()

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
    assert resultado == pytest.approx(esperado)

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
    assert resultado == pytest.approx(esperado)
    
# TODO:
# 1. Agregue casos normales. *
# 2. Agregue casos frontera.
# 3. Agregue entradas inválidas con pytest.raises.
# 4. Agregue casos parametrizados con @pytest.mark.parametrize.
# 5. Use pytest.approx cuando el resultado esperado tenga decimales.
# 6. Pruebe interacciones entre reglas.

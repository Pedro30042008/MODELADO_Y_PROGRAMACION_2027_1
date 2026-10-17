import pytest

from estacionamiento import Estacionamiento

@pytest.fixture
def sistema():
    """Preparación reutilizable para las pruebas."""
    return Estacionamiento()


def test_ejemplo_inicial(sistema):
    """
    Esta prueba sólo sirve como punto de partida.
    El alumno debe reemplazarla/complementarla con su diseño de casos.
    """
    # Arrange
    minutos = 10

    # Act
    resultado = sistema.calcular_total(minutos, "normal", False)

    # Assert
    assert resultado == 0.0

# Arrange
@pytest.mark.parametrize(
    "minutos, esperado",
    [
                        # | Núm. |   Caso   | Regla(s) |                Descripción                 |

        (10, 0.00),     # |  1   |  Normal  |    R5    | Cliente "normal" con boleto pasó 10 min.   |
        (40, 20.00),    # |  2   |  Normal  |    R6    | Cliente "normal" con boleto pasó 40 min.   |    
        (1250, 320.00), # |  3   |  Normal  |    R7    | Cliente "normal" con boleto pasó 1250 min. |
    ],
)
def test_cliente_Normal_con_Boleto(sistema, minutos, esperado):
    """
    Verifica el cobro calculado para un cliente "normal" con boleto dado un cierto tiempo.
    """
    
    # Act
    resultado = sistema.calcular_total(minutos, "normal", False)
    
    # Assert
    assert resultado == pytest.approx(esperado)
    
# TODO:
# 1. Agregue casos normales.
# 2. Agregue casos frontera.
# 3. Agregue entradas inválidas con pytest.raises.
# 4. Agregue casos parametrizados con @pytest.mark.parametrize.
# 5. Use pytest.approx cuando el resultado esperado tenga decimales.
# 6. Pruebe interacciones entre reglas.

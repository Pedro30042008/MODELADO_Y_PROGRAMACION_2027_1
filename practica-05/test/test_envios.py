import pytest
from envios import calcular_envio

def test_calcular_envio():
    assert calcular_envio(3, "estandar") == 50
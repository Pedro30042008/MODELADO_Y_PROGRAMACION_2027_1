# Práctica 04: Pruebas Unitarias

## Descripción

El Sistema de Ticket estacionamiento se encarga de calcular el costo de un estacionamiento dado los minutos de permanencia, el tipo de cliente y si se perdió el boleto.

El objetivo de la práctica es implementar un sistema de pruebas (con base en Pruebas Unitarias) que valide el modelo del sistema, es decir, el comportamiento esperado del mismo. En caso de que el sistema no pase las pruebas, corregir el código de ser necesario.

**Nota:** Aunque un programa tenga una suite en la que todas las pruebas sean aprobadas, esto no significa necesariamente que el programa sea correcto.

## Estructura

```text
practica-04/
|
├── docs/
|   └── Documentacion_practica_04.pdf
|   
├── python/ 
|   ├── estacionamiento.py
|   ├── test_estacionamiento.py
|   └── requirements.txt
│
├── casos-prueba.pdf
└── README.md
```

## Requerimientos

- Python 3;
- pip (el gestor de paquetes de Python);
- Soporte para entornos virtuales;
- pytest.

## Guía de los requerimientos (puede variar dependiendo el sistema operativo).

Ir al directorio correspondiente:

```bash
cd practica-04/python
```

Instalar los requerimientos de ser necesario:

```bash
sudo apt update
sudo apt install python3 python3-pip python3-venv -y
```

Preparar el entorno virtual:

```bash
python3 -m venv .venv
```

Entrar al entorno virtual:

```bash
source .venv/bin/activate
```

En el entorno virtual instalar los requerimientos.txt:

```bash
python -m pip install -r requirements.txt
```

Salir del entorno virtual:

```bash
deactivate
```

## Ejecución del programa

```bash
cd practica-04/python
source .venv/bin/activate
pytest -v
```

`Pedro Ruiz, Miranda Sánchez, Alan Alvarez <3`
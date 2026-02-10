# Actividad 1: Sistema de Gestión de Conciertos

Este proyecto consiste en el desarrollo de una aplicación para la gestión de conciertos, incluyendo la administración de entradas y usuarios.

## 📋 Estructura de Clases

### 1. Clase `Entrada`
Gestiona los tickets individuales para los eventos.
- **Atributos:** `concierto`, `tipoEntrada` (Enumerado: VIP, GRADA, PISTA).
- **Métodos Implementados:**
  - `getPrecioTotal()`: Devuelve el precio base, +10% (Pista) o +20% (VIP).
  - `toString()`: Devuelve "Entrada de [precio total] €".

### 2. Clase `Concierto`
Contiene la logística y el control de ventas del evento.
- **Atributos:** `artista`, `ciudad`, `precioBase`, `aforoMaximo`, `entradasVendidas` e `activo`.
- **Métodos Implementados:**
  - `calcularPrecioTotal()`: Devuelve el dinero total recaudado sumando cada entrada vendida.
  - `calcularPrecioMedio()`: Devuelve el promedio de los precios de las entradas vendidas.
  - `entradasDisponibles()`: Comprueba si el número de ventas es menor al aforo máximo.
  - `toString()`: Devuelve "Concierto de [artista] en [ciudad]".

### 3. Clase `Usuario`
Representa al cliente y sus interacciones.
- **Atributos:** `nombre`, `edad`, `entradasCompradas`, `conciertosAsistidos` y `valoraciones`.
- **Métodos Implementados:**
  - `comprarEntrada(concierto, tipoEntrada)`: Valida si el concierto está activo, si el usuario ya asistió y si hay disponibilidad antes de procesar la compra.
  - `valorar(concierto, valoracion)`: Registra una nota entre 0 y 10 para conciertos en la lista de asistidos.
  - `toString()`: Devuelve "[Nombre] (ha asistido a [X] conciertos)".

---

## 🚀 Ejecución en Main

El flujo de trabajo principal incluye:
1. Creación de **3 objetos Concierto**.
2. Creación de **3 objetos Usuario**.
3. Simulación de compra: cada usuario adquiere entradas para **2 conciertos**.
4. Simulación de feedback: cada usuario valora **1 concierto**.

## 📊 Estadísticas del Sistema (Opcional)

Se calculan y muestran por consola los siguientes datos globales:
* Total de entradas vendidas (suma de los 3 conciertos).
* Total de ventas desglosadas por tipo (Pista, Grada y VIP).
* Recaudación total acumulada.
* Precio medio de todas las entradas del sistema.
* Concierto con mayor y menor volumen de ventas.

---
**Desarrollado en Java** utilizando `ArrayList`, `HashSet` y `HashMap`.

**Hecho por JULIAN CHAVEZ**

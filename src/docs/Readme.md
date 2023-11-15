# Java Multithreading Example

Este proyecto de ejemplo en Java demuestra la implementación de hilos para la producción y consumo de verduras en un almacén.

## Contenido

1. [Estructura del Proyecto](#estructura-del-proyecto)
2. [Clases](#clases)
   - [Almacen](#almacen)
   - [Productor](#productor)
   - [Consumidor](#consumidor)
3. [Main](#main)
4. [Detalles Adicionales](#detalles-adicionales)
   - [Uso de ArrayList](#uso-de-arraylist)
   - [Randomización](#randomización)
   - [Excepciones e Interrupciones](#excepciones-e-interrupciones)

## Estructura del Proyecto

- `net.salesianos.features`: Contiene la clase `Almacen` que representa el almacén de verduras.
- `net.salesianos.threads`: Contiene las clases `Productor` y `Consumidor` que implementan hilos para producir y consumir verduras.

## Clases

### Almacen

La clase `Almacen` representa el almacén de verduras y proporciona métodos sincronizados para producir y consumir.

- **Métodos:**
  - `producir(String nombre, String verdura)`: Método sincronizado para que los productores agreguen verduras al almacén.
  - `consumir(String nombre)`: Método sincronizado para que los consumidores retiren verduras del almacén.

### Productor

La clase `Productor` es un hilo que simula la producción de verduras y las agrega al almacén.

- **Métodos:**
  - `run()`: Implementa la lógica del hilo para producir verduras.

### Consumidor

La clase `Consumidor` es un hilo que simula el consumo de verduras desde el almacén.

- **Métodos:**
  - `run()`: Implementa la lógica del hilo para consumir verduras.

## Main

La clase `Main` se encarga de la ejecución de productores y consumidores, demostrando el uso de multithreading.

- **Lógica:**
  - Se crean instancias de `Almacen`, `Productor`, y `Consumidor`.
  - Se inician y se espera a que todos los hilos terminen usando los métodos "start()" y "join()".

## Detalles Adicionales

### Uso de ArrayList

Dentro de la clase `Almacen` se implementa un ArrayList para controlar en todo momento que verdura se produce
y que verdura se consume , para controlar la espera de los clientes y la espera de la producción.

### Randomización

La randomización se utiliza en las clases `Productor` y `Consumidor` para simular procesos como el tiempo de crecimiento de verduras y el tiempo de consumición. Los métodos `numeroAleatorio` y `tiempoDeConsumicionAleatorio` utilizan `Math.random()`.

### Excepciones e Interrupciones

Se manejan las excepciones `InterruptedException` en las clases `Productor`

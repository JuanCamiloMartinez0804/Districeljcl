# Districeljcl

Proyecto Integrador - Grupo 327-  Programación I (Java, POO) Tecnología en Sistemas de Información - UNIAJC

**Sistema de Gestión para Venta y Reparación de Celulares**

## Descripción del proyecto

Districeljcl es un sistema de información desarrollado como proyecto integrador de la asignatura Programación I. Su propósito es facilitar la administración de los procesos relacionados con la venta y reparación de celulares, permitiendo organizar la información de clientes, dispositivos, ventas, reparaciones y otros elementos necesarios para el funcionamiento de una tienda.

El proyecto se desarrolla utilizando el lenguaje Java, aplicando los principios de la Programación Orientada a Objetos (POO) y una organización por capas que permite separar las entidades del negocio, la gestión de datos, la lógica de las operaciones y las interfaces gráficas.

## Objetivo general

Desarrollar un sistema de información en Java que permita gestionar los procesos de venta y reparación de celulares mediante una estructura organizada, aplicando conceptos de Programación Orientada a Objetos y utilizando interfaces gráficas para facilitar la interacción con los usuarios.

## Tecnologías utilizadas

- **Lenguaje de programación:** Java 25 (JDK 25).
- **Entorno de desarrollo:** Apache NetBeans 29.
- **Interfaz gráfica:** Java Swing.
- **Gestión de información:** colecciones ArrayList.
- **Herramienta de compilación:** Apache Ant.
- **Control de versiones:** Git.
- **Repositorio remoto:** GitHub.

## Arquitectura del proyecto

El sistema está organizado en paquetes que permiten separar las responsabilidades de cada componente:

| Paquete | Descripción |
|---|---|
| `districeljcl.modelo` | Contiene las clases que representan las entidades del sistema. |
| `districeljcl.repositorio` | Administra el almacenamiento y la consulta de los objetos. |
| `districeljcl.controlador` | Gestiona las operaciones y validaciones del sistema. |
| `districeljcl.vista` | Contiene las interfaces gráficas desarrolladas con Java Swing. |
| `districeljcl.pruebas` | Contiene las clases utilizadas para realizar pruebas de funcionamiento. |
| `districeljcl.util` | Agrupa clases auxiliares del proyecto. |

## Entidades del sistema

El modelo contempla diferentes entidades relacionadas con la administración de una tienda de celulares, entre ellas:

- Cliente.
- Celular.
- Marca.
- Venta.
- DetalleVenta.
- Reparacion.
- Repuesto.
- DetalleReparacion.
- HistorialReparacion.
- Pago.
- Entrega.
- Usuario.
- Rol.
- Tienda.
- AutorizacionDisposicion.

Estas clases permiten representar los principales elementos y relaciones del negocio.

## Funcionalidades implementadas

### Gestión de clientes

El módulo de clientes permite:

- Registrar nuevos clientes.
- Consultar y buscar clientes registrados.
- Actualizar la información de los clientes.
- Eliminar registros mediante confirmación.
- Validar que no existan documentos de identificación duplicados.

### Gestión de celulares

El módulo de celulares permite:

- Registrar dispositivos asociados a una marca.
- Consultar celulares registrados.
- Buscar dispositivos por marca, modelo o IMEI.
- Actualizar la información y el precio de venta.
- Eliminar celulares mediante confirmación.
- Validar que no existan números IMEI duplicados.

### Gestión de ventas

El proyecto cuenta con clases y lógica de control para registrar y consultar ventas, relacionando clientes y celulares y controlando la disponibilidad de los dispositivos.

La interfaz gráfica de ventas se encuentra pendiente de integración.

## Validaciones y pruebas

Se realizaron pruebas funcionales para comprobar las operaciones CRUD de los módulos de clientes y celulares.

Entre las verificaciones realizadas se encuentran:

- Registro correcto de información.
- Búsqueda de registros existentes.
- Actualización de datos.
- Eliminación con confirmación.
- Rechazo de documentos duplicados.
- Rechazo de números IMEI duplicados.

Las pruebas permitieron comprobar el funcionamiento de las operaciones principales de ambos módulos.

## Requisitos para ejecutar el proyecto

- JDK 25.
- Apache NetBeans compatible con Java 25.
- Apache Ant, incluido en el entorno de NetBeans.

## Instrucciones de ejecución

1. Clonar o descargar este repositorio.
2. Abrir Apache NetBeans.
3. Seleccionar **File → Open Project**.
4. Buscar y abrir la carpeta `Districeljcl`.
5. Configurar JDK 25 como plataforma Java del proyecto.
6. Ejecutar **Clean and Build**.
7. Abrir el paquete `districeljcl.vista`.
8. Ejecutar las clases `VentanaClientes.java` o `VentanaCelulares.java` para probar sus interfaces.

**Nota:** los repositorios implementados con ArrayList almacenan los registros en memoria. Por tanto, los datos no se conservan después de finalizar la ejecución de la aplicación.

## Estado del desarrollo

El proyecto se encuentra en desarrollo académico.

Actualmente se dispone de clases del modelo, repositorios, controladores y módulos gráficos funcionales para la gestión de clientes y celulares.

Quedan pendientes la integración completa de otras interfaces y funcionalidades contempladas en el diseño general del sistema.

## Información académica

**Proyecto:** Districeljcl  
**Asignatura:** Programación I  
**Institución:** Institución Universitaria Antonio José Camacho (UNIAJC)  
**Programa:** Tecnología en Sistemas de Información  
**Periodo académico:** 2026-2

## Integrantes

Juan Camilo Martinez Vasquez
Julian David Galeano Hernandez

## Repositorio

Este repositorio contiene el código fuente y los archivos de configuración necesarios para continuar con el desarrollo del proyecto en Apache NetBeans.

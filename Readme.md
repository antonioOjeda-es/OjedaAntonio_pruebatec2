# Sistema de Gestión de Turnos

## Descripción General
Sistema desarrollado para una entidad gubernamental que permite la gestión de turnos para diferentes trámites y ciudadanos. Los turnos son asignados numéricamente según orden de llegada.

## Tecnologías Utilizadas
- **Backend**: Java + Servlets
- **Persistencia**: JPA
- **Frontend**: JSP + Bootstrap
- **Características**: Diseño responsive, Programación funcional

## Funcionalidades Principales

### 1. Gestión de Nuevos Turnos 🎫
- Asignación numérica automática de turnos
- Registro de fecha y trámite
- Asignación exclusiva a ciudadano
- Ruta: `/app/crearTurnoCiudadano`

### 2. Sistema de Visualización y Filtrado 📋
- Lista detallada de turnos por fecha
- Filtros disponibles:
  - Por estado (En espera/Ya atendido)
  - Por rango de fechas
- Visualización integral de información
- Ruta: `/app/ciudadanos`

### 3. Gestión de Ciudadanos (Funcionalidad Extra) 👥
- Registro de nuevos ciudadanos
- Gestión de datos personales
- Extensión del sistema base para mejor control de usuarios
- Ruta: `/app/agregarCiudadano`

## Configuración de Base de Datos

### Detalles de Conexión
- **Nombre de la BD**: ciudadano_turno
- **Usuario**: root
- **Ubicación del SQL**: El archivo SQL se encuentra junto al pom.xml en la raíz del proyecto

### Estructura del Proyecto
```
proyecto/
├── pom.xml
├── ciudadanos.sql
├── src/
└── ...
```

## Características Técnicas Destacadas
- **Backend**
  - Implementación Java con Servlets
  - JPA para persistencia de datos
  - Uso de programación funcional

- **Frontend**
  - JSP para vistas dinámicas
  - Bootstrap para diseño responsive
  - Interfaz intuitiva y moderna

## Rutas Principales
- `/app/crearTurnoCiudadano` - Creación de nuevos turnos
- `/app/ciudadanos` - Gestión y filtrado de turnos
- `/app/agregarCiudadano` - Gestión de ciudadanos

## Notas de Implementación
- Sistema completamente responsive
- Interfaz intuitiva con Bootstrap
- Validaciones en frontend y backend
- Sistema de filtrado avanzado para búsqueda de turnos


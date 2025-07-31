Proyecto de Microservicios con Spring Boot y Spring Cloud
Este proyecto es una aplicación backend construida siguiendo una arquitectura de microservicios. Simula un sistema básico de gestión académica donde se administran cursos y estudiantes, demostrando la implementación de patrones clave de sistemas distribuidos.

Arquitectura
La aplicación está compuesta por varios microservicios que trabajan en conjunto, cada uno con una responsabilidad única.

Config Server (Puerto 8888)

Función: Actúa como el centro de configuración para todos los demás microservicios. Externaliza las propiedades de cada servicio en un solo lugar, permitiendo una gestión centralizada.

Eureka Server (Puerto 8761)

Función: Es el registro y descubridor de servicios (Service Discovery). Actúa como un "directorio telefónico" donde cada microservicio se registra al iniciar. Esto permite que los servicios se encuentren entre sí dinámicamente sin necesidad de conocer sus direcciones IP o puertos.

API Gateway (Puerto 8080)

Función: Es el único punto de entrada (Single Point of Entry) para todas las peticiones externas. Se encarga de recibir las solicitudes, enrutarlas al microservicio correspondiente, y manejar tareas transversales como la seguridad o el monitoreo.

Student Service (Puerto 8090)

Función: Gestiona toda la lógica de negocio relacionada con los estudiantes (crear, leer, actualizar, eliminar).

Course Service (Puerto 9090)

Función: Gestiona toda la lógica de negocio relacionada con los cursos y la inscripción de estudiantes en ellos.

🚀 Tecnologías Utilizadas
Backend:

Java 17

Spring Boot 3

Spring Cloud (Gateway, Eureka, Config)

Spring Data JPA (Hibernate)

Base de Datos:

MySQL

Build Tool:

Apache Maven

📋 Prerrequisitos
JDK 17 o superior.

Apache Maven 3.8 o superior.

Una instancia de MySQL en ejecución.

Postman o un cliente API similar para realizar pruebas.

⚙️ Configuración
Todas las configuraciones de los microservicios (puertos, conexión a la base de datos, etc.) se gestionan de forma centralizada en el proyecto microservice-config, dentro de la carpeta src/main/resources/configurations/.

Asegúrate de configurar correctamente los datos de conexión a tu base de datos MySQL en los archivos msvc-student.yml y msvc-course.yml.

▶️ Cómo Ejecutar el Proyecto
Es crucial iniciar los servicios en el siguiente orden para garantizar que el sistema funcione correctamente.

microservice-config: El servidor de configuración debe ser el primero.

microservice-eureka: El servidor de descubrimiento necesita su configuración para arrancar.

msvc-student y msvc-course: Los servicios de negocio. Pueden iniciarse en cualquier orden después de Eureka.

msvc-gateway: El Gateway debe ser el último, ya que necesita descubrir las rutas de los otros servicios en Eureka.

Verificación: Una vez que todo esté corriendo, abre el dashboard de Eureka en tu navegador: http://localhost:8761/. Deberías ver a MSVC-GATEWAY, MSVC-COURSE y MSVC-STUDENT en la lista con el estado UP.

Endpoints de la API
Todas las peticiones deben hacerse a través del API Gateway en el puerto 8080.

Estudiantes
Obtener todos los estudiantes:

GET http://localhost:8080/api/student/all

Crear un nuevo estudiante:

POST http://localhost:8080/api/student/create

Body (JSON):

JSON

{
    "name": "Carlos",
    "lastName": "Zuluaga",
    "email": "carlos@example.com",
    "courseId": 1
}
Cursos
Obtener todos los cursos:

GET http://localhost:8080/api/course/all

Buscar estudiantes de un curso:

GET http://localhost:8080/api/course/search-student/1 (donde 1 es el ID del curso).

🔮 Próximos Pasos y Mejoras
Desarrollar un Frontend: Crear una aplicación cliente con React, Angular o Vue.js para consumir los servicios.

Implementar Seguridad: Proteger los endpoints utilizando Spring Security y JWT.

Contenerización: Empaquetar cada microservicio en un contenedor Docker y orquestarlos con Docker Compose.

Pruebas: Añadir pruebas unitarias y de integración.

Resiliencia: Implementar patrones como Circuit Breaker con Resilience4j.

# Parcial-mutantes
# API de Detección de Mutantes

Esta API permite verificar si un conjunto de ADN pertenece a un humano mutante. La API está diseñada para manejar solicitudes de verificación de ADN y devolver estadísticas sobre las verificaciones realizadas.

## Requisitos Previos

Antes de ejecutar la API, asegúrate de tener instalado lo siguiente:

- **Java JDK 17** o superior
- **Gradle** (versión 7.0 o superior)
- **Base de datos H2**

## Configuración del Proyecto

1. **Clonar el repositorio:**

   ```bash
   git clone https://github.com/OTSUGUA14/Parcial-mutantes.git
#
API de Detección de Mutantes
Esta API permite verificar si un conjunto de ADN pertenece a un humano mutante. Está diseñada para manejar solicitudes de verificación de ADN y devolver estadísticas sobre las verificaciones realizadas.

Requisitos Previos
Antes de ejecutar la API, asegúrate de tener instalado lo siguiente:

Java JDK 17 o superior
Gradle (versión 7.0 o superior)
Base de datos H2
Configuración del Proyecto
Clonar el repositorio:

git clone https://github.com/OTSUGUA14/Parcial-mutantes.git

Navegar al directorio del proyecto:

cd Parcial-mutantes

Construir el proyecto con Gradle:

./gradlew build

Ejecución de la API
Iniciar el servidor:

./gradlew bootRun

La API estará disponible en http://localhost:8080.

Probar la API:

Puedes probar la API utilizando herramientas como Postman o curl. A continuación se muestra un ejemplo de cómo enviar una solicitud POST para verificar un ADN:

curl -X POST http://localhost:8080/mutant -H "Content-Type: application/json" -d '{ "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGATGG", "TCACTA", "TCACTG"] }'

Respuesta esperada:

{ "mutant": true }

Acceder a las estadísticas:

Para obtener estadísticas sobre las verificaciones de ADN, envía una solicitud GET a la siguiente URL:

curl -X GET http://localhost:8080/stats

Respuesta esperada:

{ "count_mutant_dna": 40, "count_human_dna": 100, "ratio": 0.4 }

Pruebas
Para ejecutar los tests automáticos y asegurarte de que la cobertura de código es superior al 80%, puedes usar el siguiente comando:

./gradlew test

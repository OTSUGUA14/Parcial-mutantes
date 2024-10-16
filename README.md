# Parcial-mutantes
# API de Detección de Mutantes

## Requisitos Previos

Antes de ejecutar la API, asegúrate de tener instalado lo siguiente:

- **Java JDK 17** o superior
- **Gradle** (versión 7.0 o superior)
- **Base de datos H2**

## Configuración del Proyecto

1. **Clonar el repositorio:**

   ```bash
   git clone https://github.com/OTSUGUA14/Parcial-mutantes.git

2.**Navegar al directorio del proyecto:**

``
      cd Parcial-mutantes``

3.**Construir el proyecto con Gradle:**

``./gradlew build``


4.**Ejecución de la API**
- Iniciar el servidor:

``./gradlew bootRun``
o
``correrlo desde aplication (run)``

**La API estará disponible en**

`` http://localhost:8080/mutant/mutants``.

**o (api hosteada)**

``https://mutantdetectionapi.appspot.com/mutant/mutants``


5.**Pruebas de la API**

*Puedes probar la API utilizando herramientas como Postman o curl. A continuación se muestra un ejemplo de cómo enviar una solicitud POST para verificar un ADN:*

POST http://localhost:8080/mutant '{ "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGATGG", "TCACTA", "TCACTG"] }'

Respuesta esperada:

{ "mutant": true }

- *Acceder a las estadísticas:*

*Para obtener estadísticas sobre las verificaciones de ADN, envía una solicitud GET a la siguiente URL:*

GET`` http://localhost:8080/mutant/stats``
o
GET ``*https://mutantdetectionapi.appspot.com/mutant/stats``


Respuesta esperada:

{ "count_mutant_dna": 40, "count_human_dna": 100, "ratio": 0.4 }

- *Pruebas*
*Para ejecutar los tests automáticos y asegurarte de que la cobertura de código es superior al 80%, puedes usar el siguiente comando:*

6.**Guardar mutantes en h2**
- ##PARA QUE SE GUARDE EL MUTANTE EN H2 SE TIENE QUE HACER DE MANERA LOCAL(una ves ya iniciada la app)
``http://localhost:8080/mutant/mutants``
- ##En el h2 van estos datos:
- 
JDBC URL: jdbc:h2:mem:testdb

User Name: augusto

Password: (dejar en blanco)

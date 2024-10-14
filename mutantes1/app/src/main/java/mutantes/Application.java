package mutantes;

import org.springframework.boot.autoconfigure.domain.EntityScan; // Importa la anotación EntityScan
import org.springframework.boot.SpringApplication; // Importa la clase SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication; // Importa la anotación SpringBootApplication

@SpringBootApplication // Indica que esta es la clase principal de la aplicación Spring Boot
@EntityScan(basePackages = "mutantes.model") // Especifica el paquete donde están las entidades JPA
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // Ejecuta la aplicación
    }
}

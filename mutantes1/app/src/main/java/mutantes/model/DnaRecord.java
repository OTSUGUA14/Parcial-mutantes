package mutantes.model;

import jakarta.persistence.*; // Importa las anotaciones de JPA
import lombok.Data; // Lombok para generar automáticamente getters, setters y otros métodos
import lombok.NoArgsConstructor; // Lombok para crear un constructor sin argumentos

@Entity // Indica que esta clase es una entidad JPA
@Table(name = "dna_records") // Especifica el nombre de la tabla en la base de datos
@Data // Genera automáticamente getters, setters, toString, equals, y hashCode
@NoArgsConstructor // Genera un constructor sin argumentos
public class DnaRecord {

    @Id // Indica que este atributo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID
    private Long id; // Identificador único de la entidad

    @Column(unique = true, nullable = false) // Especifica que esta columna es única y no puede ser nula
    private String dna; // Almacena el ADN en forma de cadena

    @Column(nullable = false) // Especifica que esta columna no puede ser nula
    private Boolean isMutant; // Indica si el ADN corresponde a un mutante (true) o no (false)
}

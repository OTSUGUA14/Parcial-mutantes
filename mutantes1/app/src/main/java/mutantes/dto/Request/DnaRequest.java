package mutantes.dto.Request;

// DTO (Data Transfer Object) para recibir el ADN en formato de solicitud
public class DnaRequest {
    private String[] dna; // Arreglo de cadenas que representa el ADN

    // Getter para acceder al ADN
    public String[] getDna() {
        return dna;
    }

    // Setter para establecer el ADN
    public void setDna(String[] dna) {
        this.dna = dna; // Asigna el ADN recibido al atributo
    }
}

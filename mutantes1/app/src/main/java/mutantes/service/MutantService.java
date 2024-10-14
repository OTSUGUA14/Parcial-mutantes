package mutantes.service;

import org.springframework.stereotype.Service; // Importa la anotación Service

@Service // Indica que esta clase es un servicio en Spring
public class MutantService {
   
    // Método que verifica si el ADN es mutante
    public boolean isMutant(String[] dna) {
        
        // Itera a través de cada fila del ADN
        for (int i = 0; i < dna.length; i++) {
            // Itera a través de cada carácter de la fila
            for (int j = 0; j < dna[i].length(); j++) {
                // Comprobar fila
                if (j + 3 < dna[i].length() && dna[i].charAt(j) == dna[i].charAt(j + 3)) {
                    if (dna[i].charAt(j) == dna[i].charAt(j + 1) && dna[i].charAt(j) == dna[i].charAt(j + 2)) {
                        return true; // Se encontró una secuencia mutante horizontal
                    }
                }
                // Comprobar columna
                if (i + 3 < dna.length && dna[i].charAt(j) == dna[i + 3].charAt(j)) {
                    if (dna[i].charAt(j) == dna[i + 1].charAt(j) && dna[i].charAt(j) == dna[i + 2].charAt(j)) {
                        return true; // Se encontró una secuencia mutante vertical
                    }
                }
                // Comprobar diagonal principal
                if (i + 3 < dna.length && j + 3 < dna[i].length() && dna[i].charAt(j) == dna[i + 3].charAt(j + 3)) {
                    if (dna[i].charAt(j) == dna[i + 1].charAt(j + 1) && dna[i].charAt(j) == dna[i + 2].charAt(j + 2)) {
                        return true; // Se encontró una secuencia mutante diagonal
                    }
                }
            }
        }
        return false; // No se encontró ninguna secuencia mutante
    }
}

package mutantes.repository;

import mutantes.model.DnaRecord; // Asegúrate de importar la entidad DnaRecord
import org.springframework.data.jpa.repository.JpaRepository; // Importa la interfaz JpaRepository

// Interfaz que extiende JpaRepository para gestionar DnaRecord
public interface DnaRecordRepository extends JpaRepository<DnaRecord, Long> {
    // Método que verifica si existe un registro de ADN por su cadena
    boolean existsByDna(String dna);

    // Método que cuenta cuántos registros son de mutantes
    long countByIsMutant(boolean isMutant);
}

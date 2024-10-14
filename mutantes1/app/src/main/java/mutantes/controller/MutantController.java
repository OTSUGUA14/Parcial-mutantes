package mutantes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mutantes.dto.DnaStats;
import mutantes.dto.Request.DnaRequest;
import mutantes.service.MutantService;
import mutantes.repository.DnaRecordRepository;
import mutantes.model.DnaRecord;

@CrossOrigin(origins = "*") // Permite solicitudes de cualquier origen (CORS)
@RestController // Indica que esta clase es un controlador de REST
@RequestMapping("/mutant") // Mapea las solicitudes a la ruta base "/mutant"
public class MutantController {

    private final MutantService mutantService; // Servicio para la lógica de mutantes
    private final DnaRecordRepository dnaRecordRepository; // Repositorio para el acceso a datos de ADN

    // Constructor para inyectar las dependencias
    public MutantController(MutantService mutantService, DnaRecordRepository dnaRecordRepository) {
        this.mutantService = mutantService;
        this.dnaRecordRepository = dnaRecordRepository;
    }

    // Endpoint para verificar si un ADN corresponde a un mutante
    @PostMapping("/mutants") // Mapea las solicitudes POST a "/mutant/mutants"
    public ResponseEntity<String> isMutant(@RequestBody DnaRequest dnaRequest) {
        // Llama al servicio para verificar si el ADN es mutante
        boolean isMutant = mutantService.isMutant(dnaRequest.getDna());
        
        // Guarda el ADN como una cadena
        String dnaString = String.join(",", dnaRequest.getDna());
        
        // Verifica si el ADN ya existe en la base de datos
        if (isMutant) {
            if (!dnaRecordRepository.existsByDna(dnaString)) {
                // Si el ADN no existe, lo guarda en la base de datos
                System.out.println("El ADN no existe, se procederá a guardar: " + dnaString);
                DnaRecord dnaRecord = new DnaRecord();
                dnaRecord.setDna(dnaString);
                dnaRecord.setIsMutant(isMutant);
                dnaRecordRepository.save(dnaRecord);
            } else {
                // Si el ADN ya existe, lo notifica en la consola
                System.out.println("El ADN ya existe: " + dnaString);
            }
        }

        // Retorna una respuesta indicando si es mutante o no
        return isMutant 
            ? ResponseEntity.ok("Mutant detected") // Si es mutante, retorna 200 OK
            : new ResponseEntity<>("Not a mutant", HttpStatus.FORBIDDEN); // Si no es mutante, retorna 403 Forbidden
    }

    // Endpoint para obtener estadísticas de los ADN procesados
    @GetMapping("/stats") // Mapea las solicitudes GET a "/mutant/stats"
    public ResponseEntity<DnaStats> getStats() {
        // Cuenta cuántos ADN son mutantes y cuántos humanos
        long countMutantDna = dnaRecordRepository.countByIsMutant(true);
        long countHumanDna = dnaRecordRepository.countByIsMutant(false);
        double ratio = (countHumanDna > 0) ? (double) countMutantDna / countHumanDna : 0; // Calcula la razón mutantes/humanos

        // Crea un objeto de estadísticas para devolver
        DnaStats stats = new DnaStats(countMutantDna, countHumanDna, ratio);

        return ResponseEntity.ok(stats); // Retorna las estadísticas con un código 200 OK
    }

    // Endpoint de prueba para verificar que la API esté funcionando
    @GetMapping("/test") // Mapea las solicitudes GET a "/mutant/test"
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("¡La API está funcionando!"); // Retorna un mensaje de prueba
    }
}

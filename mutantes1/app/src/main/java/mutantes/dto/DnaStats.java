package mutantes.dto;

// DTO para enviar estadísticas sobre los ADN procesados
public class DnaStats {
    private long countMutantDna; // Contador de ADN mutantes
    private long countHumanDna;   // Contador de ADN humanos
    private double ratio;          // Relación entre mutantes y humanos

    // Constructor para inicializar los atributos
    public DnaStats(long countMutantDna, long countHumanDna, double ratio) {
        this.countMutantDna = countMutantDna; // Inicializa el contador de ADN mutantes
        this.countHumanDna = countHumanDna;   // Inicializa el contador de ADN humanos
        this.ratio = ratio;                     // Inicializa la relación
    }

    // Getters y Setters
    public long getCountMutantDna() {
        return countMutantDna; // Devuelve el contador de ADN mutantes
    }

    public void setCountMutantDna(long countMutantDna) {
        this.countMutantDna = countMutantDna; // Establece el contador de ADN mutantes
    }

    public long getCountHumanDna() {
        return countHumanDna; // Devuelve el contador de ADN humanos
    }

    public void setCountHumanDna(long countHumanDna) {
        this.countHumanDna = countHumanDna; // Establece el contador de ADN humanos
    }

    public double getRatio() {
        return ratio; // Devuelve la relación entre mutantes y humanos
    }

    public void setRatio(double ratio) {
        this.ratio = ratio; // Establece la relación
    }
}

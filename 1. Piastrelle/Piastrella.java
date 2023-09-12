/**
 * OVERVIEW: Piastrella è una classe astratta atta a rappresentare lo stato ed i
 * comportamenti di una piastrella generica.
 * Le istanze di questa classe sono immutabili.
 */

public abstract class Piastrella implements Rivestimento {
    /**
     * IR: Il costo della piastrella deve obbligatoriamente essere positivo.
     * AF: Una piastrella generica è rappresentata dal suo costo.
     */

    // ATTRIBUTI
    /** Il costo dellla singola piastrella */
    private final int costo;

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto Piastrella generico a partire dal costo avuto per
     * argomento.
     * 
     * @throws IllegalArgumentException nel caso in cui il costo avuto per argomento
     *                                  non fosse positivo.
     */
    public Piastrella(final int costo) {
        if (costo <= 0)
            throw new IllegalArgumentException("Il costo avuto per argomento deve essere positivo.");

        this.costo = costo;
    }

    // METODI
    @Override
    public int get_costo() {
        return costo;
    }
}
/**
 * OVERVIEW: PiastrellaQuadrata è una classe concreta che estende stato e
 * metodi di una Piastrella generica ed implementa metodi e comportamenti
 * specifici di una piastrella di forma quadrata.
 * Le istanze di questa classe sono immutabili.
 */

public class PiastrellaQuadrata extends Piastrella {
    /**
     * IR: Il lato della piastrella di forma quadrata deve obbligatoriamente essere
     * positivo.
     * AF: Una piastrella quadrata è rappresentata dalla misura del suo lato.
     */

    // ATTRIBUTI
    /** Il lato della piastrella quadrata */
    private final int lato;

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto PiastrellaQuadrata a partire dalle misure delle
     * diagonali avute per argomento e dal costo unitario della piastrella.
     * 
     * @throws IllegalArgumentException nel caso in cui la misura del lato del
     *                                  quadrato non fosse positiva.
     */
    public PiastrellaQuadrata(final int lato, final int costo_unitario) {
        super(costo_unitario);

        if (lato <= 0)
            throw new IllegalArgumentException(
                    "La misura del lato avuta per argomento deve essere positiva.");

        this.lato = lato;
    }

    // METODI

    @Override
    public int get_superficie() {
        return lato * lato;
    }
}
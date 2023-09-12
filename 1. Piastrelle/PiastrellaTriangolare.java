/**
 * OVERVIEW: PiastrellaTriangolare è una classe concreta che estende stato e
 * metodi di una piastrella generica ed implementa metodi e comportamenti
 * specifici di una piastrella di forma triangolare.
 * Le istanze di questa classe sono immutabili.
 */

public class PiastrellaTriangolare extends Piastrella {
    /**
     * IR: La base del triangolo deve obbligatoriamente essere positiva.
     * L'altezza del triangolo deve obbligatoriamente essere positiva.
     * AF: Una piastrella triangolare è rappresentata dalle misure della sua
     * base e della sua altezza.
     */

    // ATTRIBUTI
    /** La base e l'altezza della piastrella triangolare */
    private final int base;
    private final int altezza;

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto PiastrellaTriangolare a partire dalle misure della base, dell'altezza e del costo unitario della piastrella.
     * 
     * @throws IllegalArgumentException nel caso in cui la misura della base non fosse positiva.
     * 
     * @throws IllegalArgumetnException nel caso in cui la misura dell'altezza non fosse positiva.
     */
    public PiastrellaTriangolare(final int base, final int altezza, final int costo_unitario) {
        super(costo_unitario);

        if (base <= 0)
            throw new IllegalArgumentException(
                    "La misura della base avuta per argomento deve essere positiva.");

        if (altezza <= 0)
            throw new IllegalArgumentException(
                    "La misura dell'altezza avuta per argomento deve essere positiva.");

        this.base = base;
        this.altezza = altezza;
    }

    // METODI

    @Override
    public int get_superficie() {
        return (base * altezza) / 2;
    }
}
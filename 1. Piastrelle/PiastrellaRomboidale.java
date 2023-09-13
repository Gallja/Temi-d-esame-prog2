/**
 * OVERVIEW: PiastrellaRomboidale è una classe concreta che estende stato e
 * metodi di una Piastrella generica ed implementa metodi e comportamenti
 * specifici di una piastrella di forma romboidale.
 * Le istanze di questa classe sono immutabili.
 */

public class PiastrellaRomboidale extends Piastrella {
    /**
     * IR: La diagonale minore deve obbligatoriamente essere positiva.
     * La diagonale maggiore deve obbligatoriamente essere positiva.
     * La diagonale maggiore deve obbligatoriamente essere maggiore rispetto alla
     * diagonale minore.
     * 
     * AF: diagonale minore: la misura della diagonale minore della piastrella di
     * forma romboidale.
     * diagonale maggiore: la misura della diagonale maggiore della piastralla di
     * forma romboidale.
     */

    // ATTRIBUTI
    /** La diagonale minore della piastrella romboidale e la diagonale maggiore */
    private final int diagonale_minore;
    private final int diagonale_maggiore;

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto PiastrellaRomboidale a partire dalle misure delle
     * diagonali avute per argomento e dal costo unitario della piastrella.
     * 
     * @throws IllegalArgumentException nel caso in cui la misura della diagonale
     *                                  minore avuta per argomento non fosse
     *                                  positiva
     * 
     * @throws IllegalArgumetnException nel caso in cui la misura della diagonale
     *                                  maggiore avuta per argomento non fosse
     *                                  positiva
     * 
     * @throws IllegalArgumentException nel caso in cui la misura della diagonale
     *                                  maggiore non fosse maggiore di quella della
     *                                  diagonale minore
     */
    public PiastrellaRomboidale(final int diagonale_minore, final int diagonale_maggiore, final int costo_unitario) {
        super(costo_unitario);

        if (diagonale_minore <= 0)
            throw new IllegalArgumentException(
                    "La misura della diagonale minore avuta per argomento deve essere positiva.");

        if (diagonale_maggiore <= 0)
            throw new IllegalArgumentException(
                    "La misura della diagonale minore avuta per argomento deve essere positiva.");

        if (diagonale_maggiore <= diagonale_minore)
            throw new IllegalArgumentException(
                    "La misura della diagonale maggiore deve essere maggiore di quella della diagonale minore.");

        this.diagonale_minore = diagonale_minore;
        this.diagonale_maggiore = diagonale_maggiore;
    }

    // METODI

    @Override
    public int get_superficie() {
        return (diagonale_maggiore * diagonale_minore) / 2;
    }
}
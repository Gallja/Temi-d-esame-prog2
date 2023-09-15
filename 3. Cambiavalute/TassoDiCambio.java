import java.util.*;
/**
 * OVERVIEW: TassoDiCambio è una classe concreta atta a rappresentare metodi e comportamenti di un tasso di cambio; 
 * Dato un importo, il TassoDiCambio è in grado di convertirlo in una Valuta desiderata in base ad una costante di cambio giornaliera.
 * Le istanze di questa classe sono immutabili.
 */

public class TassoDiCambio {
    /**
     * IR: Il primo Importo non deve essere nullo.
     * Il secondo Importo non deve essere nullo.
     * 
     * AF: importo1: l'Importo in una Valuta che si intende convertire.
     * importo2: l'Importo nella valuta 'obiettivo'.
     */

    // ATTRIBUTI
    /** Gli importi di cui necessita il Tasso di Cambio */
    private Importo importo1;
    private Importo importo2;

    // COSTRUTTORE


    /**
     * Costruisce un nuovo oggetto {@code this} a partire dall'importo che si vuole convertire {@code importo1}, la Valuta che si intende 'raggiungere' {@code v} e il cambio {@code cambioOdierno} avuti per argomento.
     * 
     * @param importo1 il primo Importo.
     * @param importo2 il secondo Importo.
     * 
     * @throws NullPointerException nel caso in cui {@code importo1} fosse nullo.
     * @throws NullPointerException nel caso in cui {@code importo2} fosse nullo.
     * @throws IllegalArgumentException nel caso in cui {@code importo1} e {@importo2} avessero la stessa valuta.
     */
    public TassoDiCambio(Importo importo1, Importo importo2) {
        Objects.requireNonNull(importo1, "Il primo importo non deve essere nullo.");

        Objects.requireNonNull(importo2, "Il secondo importo non deve essere nullo.");

        if (importo1.getValuta() == importo2.getValuta()) 
            throw new IllegalArgumentException("Le valute dei 2 importi avuti per argomento non possono essere uguali per effettuare il cambio.");

        this.importo1 = importo1;
        this.importo2 = importo2;
    }

    // METODI

    /**
     * Restituisce il primo Importo.
     * 
     * @return Il primo Importo.
     */
    public Importo getImporto1() {
        return importo1;
    }

    /**
     * Restituisce il secondo Importo.
     * 
     * @return Il secondo Importo.
     */
    public Importo getImporto2() {
        return importo2;
    }

    /**
     * Restituisce un nuovo Importo frutto della conversione dell'Importo {@code imp_da_convertire} avuto per argomento.
     * 
     * @param imp_da_convertire l'Importo che si desidera convertire.
     * 
     * @throws NullPointerException nel caso in cui {@code imp_da_convertire} fosse nullo.
     * @throws IllegalArgumentException nel caso in cui {@code imp_da_convertire} avesse una Valuta non adatta alla conversione.
     * 
     * @return Un nuovo Importo frutto della conversione di {@code imp_da_convertire}.
     */
    public Importo conversione(Importo imp_da_convertire) {
        Objects.requireNonNull(imp_da_convertire, "L'importo da convertire fornito per argomento non deve essere nullo.");

        if (imp_da_convertire.getValuta() != importo1.getValuta() && imp_da_convertire.getValuta() != importo2.getValuta())
            throw new IllegalArgumentException("L'importo avuto per argomento ha valute differenti rispetto a importo1 ed importo2.");

        if (imp_da_convertire.getValuta() == importo2.getValuta()) {
            int val = (importo1.getValore() * imp_da_convertire.getValore()) / importo2.getValore();
            return new Importo(val, importo1.getValuta());
        } else {
            int val = (importo2.getValore() * imp_da_convertire.getValore()) / importo1.getValore();
            return new Importo(val, importo2.getValuta());
        }
    }

    @Override
    public String toString() {
        return "TassoDiCambio [importo1=" + importo1 + ", importo2=" + importo2 + "]";
    }
}
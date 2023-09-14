import java.util.*;

/**
 * OVERVIEW: Importo è una classe concreta che rappresenta un valore in denaro con relativi metodi e comportamenti.
 * Le istanze di questa classe sono mutabili.
 */

public class Importo {
    /**
     * IR: La valuta non deve essere nulla.
     * AF: valore: il valore numerico dell'importo.
     * valuta: la valuta corrispondente dell'importo.
     */

    // ATTRIBUTI
    /** Il valore e la valuta corrispondente */
    private int valore;
    private Valuta valuta;

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto Importo a partire da {@code valore} e {@code valuta} avuti per argomenti.
     * 
     * @param valore il valore numerico dell'importo.
     * 
     * @param valuta la valuta corrispondente dell'importo.
     * 
     * @throws NullPointerException nel caso in cui {@code valuta} fosse nulla.
     * 
     */
    public Importo(final int valore, final Valuta valuta) {
        Objects.requireNonNull(valuta, "La valuta avuta per argomento non deve essere nulla.");

        this.valuta = valuta;
        this.valore = valore;
    }

    // METODI   

    /**
     * Restituisce un intero corrispondente al valore dell'importo.
     * 
     * @return l'intero corrispondente al valore dell'importo.
     */
    public int getValore() {
        return valore;
    }

    /**
     * Restituisce la valuta dell'importo.
     * 
     * @return la Valuta corrispondente all'importo.
     */
    public Valuta getValuta() {
        return valuta;
    }

    /**
     * Somma {@code this} con l'Importo {@code i} avuto per argomento.
     * 
     * @param i l'Importo che si intende sommare a {@code this}
     * 
     * @throws NullPointerException nel caso in cui {@code i} fosse nullo.
     * 
     * @throws IllegalArgumentException nel caso in cui {@code i} non avesse la stessa Valuta di {@code this}.
     */
    public void somma(Importo i) {
        Objects.requireNonNull(i, "L'Importo avuto per argomento non deve essere nullo.");

        if (!(i.getValuta() == valuta)) 
            throw new IllegalArgumentException("La Valuta dell'Importo avuto per argomento deve coincidere con quella di this.");

        valore += i.getValore();
    }

    /**
     * Sottrae {@code this} con l'Importo {@code i} avuto per argomento.
     * 
     * @param i l'importo che si intende sottrarre a {@code this}
     * 
     * @throws NullPointerException nel caso in cui {@code i} fosse nullo.
     * 
     * @throws IllegalArgumentException nel caso in cui {@code i} non avesse la stessa Valuta di {@code this}.
     */
    public void sottrai(Importo i) {
        Objects.requireNonNull(i, "L'Importo avuto per argomento non deve essere nullo.");

        if (!(i.getValuta() == valuta)) 
            throw new IllegalArgumentException("La Valuta dell'Importo avuto per argomento deve coincidere con quella di this.");

        valore -= i.getValore();
    }

    /**
     * Confronta {@code this} con l'Importo {@code i} avuto per argomento.
     * Restituisce inoltre un valore intero, in base al risultato del confronto, con la seguente codifica:
     * 1 --> {@code this} è maggiore di {@code i}
     * 0 --> {@code this} e {@code i} sono uguali
     * -1 --> {@code this} è minore di {@code i}
     * 
     * @param i l'importo che si intende sottrarre a {@code this}
     * 
     * @throws NullPointerException nel caso in cui {@code i} fosse nullo.
     * 
     * @throws IllegalArgumentException nel caso in cui {@code i} non avesse la stessa Valuta di {@code this}.
     * 
     */
    public int confronta(Importo i) {
        Objects.requireNonNull(i, "L'Importo avuto per argomento non deve essere nullo.");

        if (i.getValuta() != valuta) 
            throw new IllegalArgumentException("La Valuta dell'Importo avuto per argomento deve coincidere con quella di this.");

        if (valore > i.getValore()) {
            return 1;
        }

        if (valore == i.getValore()) {
            return 0;
        } 

        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(valuta.toString()).append(valore);

        return sb.toString();
    }
}
import java.util.*;
/**
 * OVERVIEW: TassoDiCambio è una classe concreta atta a rappresentare metodi e comportamenti di un tasso di cambio; 
 * Le istanze di questa classe sono immutabili.
 */

public class TassoDiCambio {
    /**
     * IR: Il primo Importo non deve essere nullo.
     * Il secondo Importo non deve essere nullo.
     * Il cambio odierno deve essere positivo.
     * 
     * AF: importo1: l'Importo in una Valuta che si intende convertire.
     * importo2: l'Importo nella valuta 'obiettivo'.
     * cambioOdierno: la costante di cambio giornaliera mediante la quale è possibile effettuare il cambio da una valuta all'altra.
     */

    // ATTRIBUTI
    /** Gli importi che si intende convertire ed il cambio del giorno */
    private Importo importo1;
    private Importo importo2;
    private float cambioOdierno;

    // COSTRUTTORE


    /**
     * Costruisce un nuovo oggetto {@code this} a partire dall'importo che si vuole convertire {@code importo1}, la Valuta che si intende 'raggiungere' {@code v} e il cambio {@code cambioOdierno} avuti per argomento.
     * 
     * @param importo1 il primo Importo che si intende convertire.
     * @param v la Valuta che rappresenta il goal della conversione.
     * @param cambioOdierno la costante di cambio giornaliero atta a convertire un Importo in una Valuta nell'equivalente di un'altra.
     * 
     * @throws NullPointerException nel caso in cui {@code importo1} fosse nullo.
     * @throws NullPointerException nel caso in cui {@code v} fosse nullo.
     * @throws IllegalArgumentException nel caso in cui il valore di {@code cambioOdierno} non fosse positivo.
     * @throws IllegalArgumentException nel caso in cui la Valuta di {@code importo1} fosse uguale a quella di {@code v}.
     */
    public TassoDiCambio(Importo importo1, Valuta v, float cambioOdierno) {
        Objects.requireNonNull(importo1, "L'importo della Valuta che si intende convertire non deve essere nullo.");

        Objects.requireNonNull(v, "La valuta avuta per argomento non deve essere nulla.");

        if (cambioOdierno <= 0) 
            throw new IllegalArgumentException("Il valore del cambio odierno deve obbligatoriamente essere positivo.");

        if (importo1.getValuta() == v) 
            throw new IllegalArgumentException("La valuta dell'importo avuto per argomento deve essere diversa dalla valuta obiettivo.");   

        this.importo1 = importo1;
        this.cambioOdierno = cambioOdierno;

        float valTmp = importo1.getValore() * cambioOdierno;
        importo2 = new Importo((int)valTmp, v);
    }

    // METODI

    /**
     * Restituisce un nuovo Importo, frutto della conversione dalla valuta del secondo Importo a quella del primo.
     * 
     * @return L'Importo frutto della conversione 'al contrario'.
     */
    public Importo reverse() {
        float valTmp = importo2.getValore() * cambioOdierno;
        Importo ris = new Importo((int)valTmp, importo1.getValuta());
        return ris;
    }
}
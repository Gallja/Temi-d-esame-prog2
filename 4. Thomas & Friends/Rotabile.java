import java.util.*;

/**
 * OVERVIEW: Rotabile è una classe astratta che rappresenta un generico Rotabile con relativo stato e metodi.
 * Un Rotabile generico è rappresentato dal suo modello ed il peso corrispondente.
 * Le istanze di questa classe sono immutabili.
 */

public abstract class Rotabile {
    /**
     * IR: Il modello del Rotabile non deve essere nullo.
     * Il modello del Rotabile non deve essere vuoto.
     * Il peso del Rotabile deve essere positivo.
     * 
     * AF: modello: il modello che identifica il Rotabile.
     * peso: il peso del Rotabile.
     */

    // ATTRIBUTI
    /** Il modello del Rotabile ed il relativo peso */
    private final String modello;
    private final int peso;

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire da {@code modello} e {@code peso} avuti per argomenti.
     * 
     * @param modello Il nome del modello di {@code this}.
     * @param peso Il peso relativo a {@code this}.
     * 
     * @throws NullPointerException nel caso in cui il {@code modello} fosse nullo.
     * @throws IllegalArgumentException nel caso in cui {@code modello} fosse vuoto.
     * @throws IllegalArgumentException nel caso in cui {@code peso} non fosse positivo.
     */
    public Rotabile(final String modello, final int peso) {
        Objects.requireNonNull(modello, "Il modello avuto per argomento non deve essere nullo.");

        if (modello.isEmpty()) throw new IllegalArgumentException("Il modello avuto per argomento non deve essere vuoto.");

        if (peso <= 0) throw new IllegalArgumentException("Il peso avuto per argomento deve essere positivo.");

        this.modello = modello;
        this.peso = peso;
    }

    // METODI

    /**
     * Restituisce il modello di {@code this}.
     * 
     * @return Il modello di {@code this}.
     */
    public String getModello() {
        return modello;
    }

    /**
     * Restituisce il peso di {@code this}.
     * 
     * @return Il peso di {@code this}.
     */
    public int getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Rotabile [modello=" + modello + ", peso=" + peso + "]";
    }   

}
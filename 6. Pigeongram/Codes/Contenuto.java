import java.util.*;

/**
 * OVERVIW: Contenuto è una classe astratta che imlpementa stato e comportamenti di un generico contenuto di un messaggio.
 * Ogni contenuto è caratterizzato da un simbolo che ne indichi il tipo e gli argomenti.
 * Le istanze di questa classe sono immutabili.
 */

public abstract class Contenuto {
    /**
     * IR: L'argomento non deve essere nullo.
     * L'argomento non deve essere vuoto.
     * 
     * AF: id : carattere identificativo del contenuto.
     * arg : stringa identificativa dell'argomento del contenuto.
     */

    // ATTRIBUTI
    /** Il carattere che identifica il tipo di contenuto */
    private final char id;
    /** La stringa con l'argomento del contenuto */
    private final String arg;

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire dall'identificativo {@code id} e dall'argomento {@code arg} avuti per argomento.
     * 
     * @param id L'identificativo di {@code this}.
     * @param arg L'argomento di {@code this}.
     * 
     * @throws NullPointerException Se {@code arg} è nullo.
     * @throws IllegalArgumentException Se {@code arg} è vuoto.
     */
    public Contenuto(final char id, final String arg) {
        Objects.requireNonNull(arg, "La stringa avuta per argomento non deve essere nulla.");
    
        if (arg.isEmpty()) throw new IllegalArgumentException("La stringa avuta per argomento non deve essere vuota.");

        this.id = id;
        this.arg = arg;
    }

    // METODI

    /**
     * Restituisce l'id di {@code this}.
     * 
     * @return Il carattere corrispondente all'id di {@code this}.
     */
    public char getId() {
        return id;
    }

    /**
     * Restituisce l'argomento di {@code this}.
     * 
     * @return Il carattere corrispondente all'argomento di {@code this}.
     */
    public String getArg() {
        return arg;
    }

    @Override
    public String toString() {
        return "[" + id + "]" + arg;
    }
}
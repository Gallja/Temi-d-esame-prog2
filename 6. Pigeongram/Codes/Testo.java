/**
 * OVERVIEW: Testo è una classe concreta che implementa metodi e comportamenti di un contenuto di un messaggio.
 * Un Testo è caratterizzato dall'identificativo del contenuto e dall'argomento.
 * Le istanze di questa classe sono immutabili.
 */

public class Testo extends Contenuto {
    
    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire dall'identificativo {@code id}
     * 
     * @param id Il carattere identificativo di {@code this}.
     * @param arg L'argomento di {@code this}.
     */
    public Testo(final char id, final String arg) {
        super(id, arg);
    }

}
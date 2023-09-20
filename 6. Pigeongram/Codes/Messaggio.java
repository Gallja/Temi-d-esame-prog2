import java.util.*;

/**
 * OVERVIEW: Messaggio è una classe concreta atta a rappresentare stato, metodi e comportamenti di un messaggio fra 2 utenti.
 * Un messaggio è caratterizzato dal suo mittente, il destinataria ed il contenuto.
 * Le istanze di questa classe sono immutabili.
 */

public class Messaggio {
    /**
     * IR: Il mittente non deve essere nullo.
     * Il destinatario non deve essere nullo.
     * Il mittente non deve coincidere con il destinatario.
     * Il contenuto non deve essere nullo.
     * 
     * AF: mittente : l'utente che invia il messaggio
     * destinatario : l'utente che riceve il messaggio
     * contenuto : il contenuto all'interno del messaggio
     */

    // ATTRIBUTI
    /** L'utente che invia il messaggio */
    private final Utente mittente;
    /** L'utente che riceve il messaggio */
    private final Utente destinatario;
    /** Il contenuto del messaggio */
    private final Contenuto contenuto;

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire dall'utente {@code mittente}, dall'utente {@code destinatario} e dal {@code contenuto} avuti per argomento.
     * 
     * @param mittente L'utente che invia {@code this}.
     * @param destinatario L'utente che riceve {@code this}.
     * @param contenuto Il contenuto di {@code this}
     * 
     * @throws NullPointerException se {@code mittente} è null.
     * @throws NullPointerException se {@code destinatario} è null.
     * @throws NullPointerException se {@code contenuto} è null.
     * @throws IllegalArgumentException se {@code mittente} e {@code destinatario} coincidono.
     */
    public Messaggio(final Utente mittente, final Utente destinatario, final Contenuto contenuto) {
        Objects.requireNonNull(mittente, "Il mittente non deve essere null.");

        Objects.requireNonNull(destinatario, "Il destinatario non deve essere null.");

        Objects.requireNonNull(contenuto, "Il contenuto del messaggio non deve essere null.");

        if (mittente.equals(destinatario)) throw new IllegalArgumentException("Il mittente ed il destinatario non devono coincidere.");

        this.mittente = mittente;
        this.destinatario = destinatario;
        this.contenuto = contenuto;
    }

    // METODI

    /**
     * Restituisce username del mittente di {@code this}.
     * 
     * @return username del mittente di {@code this}.
     */
    public String getMittente() {
        return mittente.getUsername();
    }

    /**
     * Restituisce username del destinatario di {@code this}.
     * 
     * @return username del destinatario di {@code this}.
     */
    public String getDestinatario() {
        return destinatario.getUsername();
    }

    /**
     * Restituisce il contenuto di {@code this}.
     * 
     * @return L'utente contenuto di {@code this}.
     */
    public Contenuto getContenuto() {
        return contenuto;
    }

    @Override
    public String toString() {
        return "Mittente: " + mittente + "\nDestinatario: " + destinatario + "\nContenuto: " + contenuto.toString();
    }
}
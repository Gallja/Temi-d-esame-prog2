import java.util.*;

/**
 * OVERVIEW: Conversazione è una classe concreta che rappresenta l'insieme di messaggi scambiati fra 2 utenti.
 * Una conversazione è caratterizzata da una lista di messaggi che la compongono.
 * Le istanze di questa classe sono mutabili.
 */

public class Conversazione implements Iterable<Messaggio> {
    /**
     * IR: messaggi non deve essere null.
     * messaggi non deve contenere valori null.
     * 
     * AF: messaggi : la lista di messaggi della conversazione.
     */    

    // ATTRIBUTI
    /** La lista di messaggi nella conversazione */
    private final List<Messaggio> messaggi = new ArrayList<Messaggio>();

    // COSTRUTTORE

    /**@throws NullPointerException Se {@code messaggi_in} è null.
     * Costruisce un nuovo oggetto {@code this} a partire dalla lista di messaggi {@code messaggi_in} fornita per argomento.
     * 
     * @param messaggi_in La lista di messaggi con la quale si intende costruire {@code this}.
     * 
     * @throws NullPointerException Se {@code messaggi_in} è null.
     * @throws NullPointerException Se {@code messaggi_in} contiene 1 o più valori null.
     */
    public Conversazione(final List<Messaggio> messaggi_in) {
        Objects.requireNonNull(messaggi_in, "La lista di messaggi non deve essere nulla.");

        for (Messaggio m : messaggi_in) {
            Objects.requireNonNull(m, "La lista di messaggi non deve contenere valori null.");
            
            messaggi.add(m);
        }
    }

    // METODI

    /**
     * Restituisce i messaggi di {@code this}.
     * 
     * @return La lista immutabile di messaggi di {@code this}.
     */
    public List<Messaggio> getMessaggi() {
        return Collections.unmodifiableList(messaggi);
    }

    @Override
    public Iterator<Messaggio> iterator() {
        return messaggi.iterator();
    }
}
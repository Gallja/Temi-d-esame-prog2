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
     * Per ogni elemento di Conversazione mittente e destinatario devono essere uguali.
     * 
     * AF: messaggi : la lista di messaggi della conversazione.
     */    

    // ATTRIBUTI
    /** La lista di messaggi nella conversazione */
    private final List<Messaggio> messaggi = new ArrayList<Messaggio>();

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire dalla lista di messaggi {@code messaggi_in} fornita per argomento.
     * 
     * @param messaggi_in La lista di messaggi con la quale si intende costruire {@code this}.
     * 
     * @throws NullPointerException Se {@code messaggi_in} è null.
     * @throws NullPointerException Se {@code messaggi_in} contiene 1 o più valori null.
     * @throws IllegalArgumentException Se {@code messaggi_in} non contiene mittente e destinatario omogenei.
     */
    public Conversazione(final List<Messaggio> messaggi_in) {
        Objects.requireNonNull(messaggi_in, "La lista di messaggi non deve essere nulla.");

        if (!controllaConv(messaggi_in)) throw new IllegalArgumentException("La lista di messaggi avuta per argomento deve contenere mittente e destinatario omogenei.");

        for (Messaggio m : messaggi_in) {
            Objects.requireNonNull(m, "La lista di messaggi non deve contenere valori null.");
            
            messaggi.add(m);
        }
    }

    // METODI

    /**
     * Restituisce un valore {@code True/False} in base al controllo effettuato sull'omogeneità della lista di messaggi {@code messaggi_in} fornita per argomento.<br/><br/>
     * Per omogeneità si intende una lista di messaggi all'interno della quale mittente e destinatario sono sempre uguali.
     * 
     * @param messaggi_in La lista di messaggi da controllare.
     * 
     * @return Valore {@code True/False} risultato del controllo su {@code messaggi_in}.
     * 
     * @throws NullPointerException Se {@code messaggi_in} è null.
     * @throws NullPointerException Se {@code messaggi_in} contiene valori null.
     */
    private boolean controllaConv(final List<Messaggio> messaggi_in) {
        Objects.requireNonNull(messaggi_in, "La lista di messaggi avuta per argomento non deve essere nulla.");

        boolean flag = true;

        for (int i = 0; i < messaggi_in.size() - 1; i ++) {
            Objects.requireNonNull(messaggi_in.get(i), "La lista di messaggi non deve contenere valori null.");

            if (!messaggi_in.get(i).equals(messaggi_in.get(i + 1))) {
                return false;
            }
        }

        return flag;
    }

    /**
     * Restituisce i messaggi di {@code this}.
     * 
     * @return La lista immutabile di messaggi di {@code this}.
     */
    public List<Messaggio> getMessaggi() {
        return Collections.unmodifiableList(messaggi);
    }

    /**
     * Restituisce username del destinatario di {@code this}.
     * 
     * @return username del destinatario di {@code this}.
     */
    public String getDestinatario() {
        Messaggio mess = messaggi.get(0);

        return mess.getDestinatario();
    }

    /**
     * Restituisce username del mittente di {@code this}.
     * 
     * @return username del mittente di {@code this}.
     */
    public String getMittente() {
        Messaggio mess = messaggi.get(0);

        return mess.getMittente();
    }

    @Override
    public Iterator<Messaggio> iterator() {
        return messaggi.iterator();
    }
}
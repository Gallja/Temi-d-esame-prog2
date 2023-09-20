import java.util.*;

/**
 * OVERVIEW: Rete è una classe concreta atta a rappresentare e gestire le funzionalità di una rete di utenti e conversazioni.
 * Una rete è rappresentata dagli utenti che ne fanno parte e le conversazioni all'interno di essa.
 * Le istanze di questa classe sono mutabili.
 */

public class Rete {
    /**
     * IR: L'elenco di utenti non deve esssere null.
     * Ogni elemento dell'elenco di utenti non deve essere null.
     * L'elenco di conversazioni non deve essere null.
     * Ogni elemento dell'elenco di conversazioni non deve essere null.
     * 
     * AF: utenti : gli utenti nella rete
     * conversazioni : le conversazioni nella rete
     */

    // ATTRIBUTI
    /** La lista di utenti nella rete */
    private final List<Utente> utenti = new ArrayList<Utente>();
    /** La lista di conversazioni nella rete */
    private final List<Conversazione> conversazioni = new ArrayList<Conversazione>();

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire da una lista di utenti {@code utenti_in} ed una lista di conversazioni {@code conversazioni_in} avuti come argomento.
     * 
     * @param utenti_in La lista di utenti di {@code this}.
     * @param conversazioni_in La lista di conversazioni di {@code this}.
     * 
     * @throws NullPointerException Se {@code utenti_in} è null.
     * @throws NullPointerException Se {@code utenti_in} contiene valori null.
     * @throws NullPointerException Se {@code conversazioni_in} è null.
     * @throws NullPointerException Se {@code conversazioni_in} contiene valori null.
     */
    public Rete(final List<Utente> utenti_in, final List<Conversazione> conversazioni_in) {
        Objects.requireNonNull(utenti_in, "La lista di utenti non deve essere null.");

        Objects.requireNonNull(conversazioni_in, "La lista di utenti non deve essere null.");

        for (Utente u : utenti_in) {
            Objects.requireNonNull(u, "La lista di utenti non deve contenere valori null.");

            utenti.add(u);
        }

        for (Conversazione c : conversazioni_in) {
            Objects.requireNonNull(c, "La lista di utenti non deve contenere valori null.");

            conversazioni.add(c);
        }
    }

    // METODI

    /**
     * Restituisce un valore {@code True/False} in base al controllo sulla presenza di un utente all'interno di {@code this}.
     * 
     * @param u L'utente di cui si vuole controllare la presenza in {@code this}.
     * 
     * @return Il valore {@code True/False} risulato del controllo
     * 
     * @throws NullPointerException Se {@code u} è null.
     */
    public boolean nellaRete(final Utente u) {
        Objects.requireNonNull(u, "L'utente avuto per argomento non dev'essere null.");

        boolean flag = false;

        for (Utente ut : utenti) {
            if (ut.equals(u)) {
                flag = true;
                return flag;
            } 
        }

        return flag;
    }

    /**
     * Modifica {@code this} aggiungendo un utente.
     * 
     * @param u L'utente che si intende aggiungere a {@code this}
     * 
     * @throws NullPointerException Se {@code u} è null.
     * @throws IllegalArgumentException Se {@code u} fosse già presente in {@code this}.
     */
    public void registraUtente(final Utente u) {
        Objects.requireNonNull(u, "L'utente avuto per argomento non deve essere null.");

        if (nellaRete(u)) throw new IllegalArgumentException("L'utente avuto per argomento è già presente nella rete.");

        utenti.add(u);
    }

    /**
     * Restituisce un valore {@code True/False} in base al controllo dell'autenticazione dell'utente {@code u} avuto per argomento.<br/><br/>
     * True --> Utente abilitato in {@code this} <br/><br/>
     * False --> Utente non abilitato in {@code this}
     * 
     * @param u L'utente di cui si intende controllare l'abilitazione in {@code this}.
     * 
     * @throws NullPointerException Se {@code u} è null.
     * @throws IllegalArgumentException Se {@code u} non è presente in {@code this}.
     */
    public boolean abilitato(final Utente u) {
        Objects.requireNonNull(u, "L'utente avuto per argomento non deve essere null.");

        if (!nellaRete(u)) throw new IllegalArgumentException("L'utente avuto per argomento non è presente nella rete.");

        if (u.autenticazione(u) == 1) return true;

        return false;
    }

    @Override
    public String toString() {
        return "Rete [utenti=" + utenti + ", conversazioni=" + conversazioni + "]";
    }
}
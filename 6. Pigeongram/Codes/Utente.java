import java.util.*;

/**
 * OVERVIEW: Utente è una classe concreta atta a rappresentare stato e metodi di un Utente che intende scambiare messaggi.
 * Un Utente è caratterizzato dal suo nome e dalla sua password.
 * Le istanze di questa classe sono mutabili.
 */

public class Utente implements Iterable<Conversazione> {
    /**
     * IR: username non deve essere null.
     * username non deve essere vuoto.
     * username non deve contenere spazi.
     * La password non deve essere null.
     * La password non deve essere vuota.
     * La lista di conversazioni non deve essere null.
     * La lista di conversazioni non deve contenere valori null.
     * 
     * AF: username : il nome utente
     * password : la password dell'utente
     * conversazioni : le conversazioni dell'utente
     */

    // ATTRIBUTI
    /** username dell'utente */
    private final String username;
    /** La password dell'utente, che all'occorrenza può essere modificata, ma mai visualizzata in chiaro */
    private String password;
    /** La lista di conversazioni dell'utente */
    private List<Conversazione> conversazioni = new ArrayList<Conversazione>();

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire da {@code username}, la {@code password} e la lista di conversazioni {@code conversazioni} avuti per argomento.
     * 
     * @param username Lo username di {@code this}.
     * @param password La password di {@code this}.
     * @param conversazioni La lista di conversazioni di {@code this}.
     * 
     * @throws NullPointerException se {@code username} è null.
     * @throws NullPointerException se {@code password} è null.
     * @throws NullPointerException se {@code conversazioni} è null.
     * @throws NullPointerException se {@code conversazioni} contiene valori null.
     * @throws IllegalArgumentException se {@code username} è vuoto.
     * @throws IllegalArgumentException se {@code username} contiene spazi.
     * @throws IllegalArgumentException se {@code password} è vuota.
     */
    public Utente(final String username, final String password, final List<Conversazione> conversazioni_in) {
        Objects.requireNonNull(username, "username non deve essere null.");
        Objects.requireNonNull(password, "username non deve essere null.");
        Objects.requireNonNull(conversazioni_in, "la lista di conversazioni non deve essere null.");

        if (username.isEmpty()) throw new IllegalArgumentException("username non deve essere vuoto.");

        if (password.isEmpty()) throw new IllegalArgumentException("La password non deve essere vuota.");

        if (username.contains(" ")) throw new IllegalArgumentException("username non deve contenere spazi.");

        for (Conversazione c : conversazioni_in) {
            Objects.requireNonNull(c, "La lista di conversazioni non deve contenere valori null.");

            conversazioni.add(c);
        }

        this.username = username;
        this.password = password;
    }

    // METODI

    /**
     * Restituisce lo username di {@code this}.
     * 
     * @return Lo username di {@code this}.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Imposta una nuova password {@code password} avuta per argomento per l'Utente {@code this}.
     * 
     * @param password La nuova passowrd che si intende impostare per {@code this}.
     * 
     * @throws NullPointerException nel caso in cui {@code password} fosse nulla.
     * @throws IllegalArgumentException nel caso in cui {@code password} fosse vuota.
    */
    public void setPassword(String password) {
        Objects.requireNonNull(password, "La password avuta per argomento non deve essere nulla.");

        if (password.isEmpty()) throw new IllegalArgumentException("La password avuta per argomento non deve essere vuota.");

        this.password = password;
    }


    /**
     * Restituisce un valore corrispondente al risultato dell'autenticazione di {@code this} grazie a {@code username} e {@code password} avuti per argomento.
     * La codifica del risultato è la seguente: <br/><br/>
     * 1 --> autenticato con successo <br/><br/>
     * 0 --> non autenticato 
     * 
     * @param username Lo username con cui si intende effettuare l'autenticazione con {@code this}.
     * @param password La password con cui si intende effettuare l'autenticazione con {@code this}.
     * 
     * @return Il risultato dell'autenticazione di {@code this}.
     * 
     * @throws NullPointerException se {@code username} è null.
     * @throws NullPointerException se {@code password} è null.
     * @throws IllegalArgumentException se {@code username} è vuoto.
     * @throws IllegalArgumentException se {@code username} contiene spazi.
     * @throws IllegalArgumentException se {@code password} è vuota.
     */
    public int autenticazione(final String username, final String password) {
        Objects.requireNonNull(username, "Lo username non deve essere vuoto.");
        Objects.requireNonNull(password, "Lo username non deve essere vuoto.");

        if (username.isEmpty()) throw new IllegalArgumentException("Lo username non deve essere vuoto.");

        if (password.isEmpty()) throw new IllegalArgumentException("La password non deve essere vuota.");

        if (username.contains(" ")) throw new IllegalArgumentException("Lo username non deve contenere spazi.");

        if (this.username.equals(username) && this.password.equals(password)) {
            return 1;
        }

        return 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.username, this.password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Utente other = (Utente) obj;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    }

    /**
     * Restituisce una lista contenente i nomi degli interlocutori di {@code this}.
     * 
     * @return La lista dei nomi degli interlocutori di {@code this}.
     */
    public List<String> getInterlocutori() {
        List<String> listRis = new ArrayList<String>();

        for (Conversazione c : conversazioni) {
            List<Messaggio> mess = c.getMessaggi();
            for (Messaggio m : mess) {
                listRis.add(m.getDestinatario());
            }
        }

        return Collections.unmodifiableList(listRis);
    }

    @Override
    public String toString() {
        return username;
    }

    @Override
    public Iterator<Conversazione> iterator() {
        return conversazioni.iterator();
    }
}
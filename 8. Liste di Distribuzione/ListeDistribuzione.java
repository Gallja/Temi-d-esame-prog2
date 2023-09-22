import java.util.*;

/**
 * OVERVIEW: ListeDistribuzione è una classe concreta che rappresenta stato e
 * metodi di liste di distribuzione per indirizzi email di posta elettronica.
 * Una lista di distribuzione è caratterizzata da un nome ed i suoi indirizzi.
 * Le istanze di questa classe sono immutabili.
 */

public class ListeDistribuzione {
    /**
     * IR:
     * 
     * AF:
     */

    // ATTRIBUTI
    /** Il nome di {@code this} */
    private final String nome;
    /** Gli indirizzi di {@code this} */
    private final Set<Indirizzo> indirizzi = new HashSet<Indirizzo>();

    // COSTRUTTORI

    /**
     * Costruisce un nuovo oggetto {@code this} a partire dal {@code nome} e
     * dall'alias {@code a} avuti per argomento.
     * 
     * @param nome Il nome di {@code this}.
     * @param a    L'alias dal quale si intende costruire {@code this}.
     * 
     * @throws NullPointerException     Se {@code nome} è null.
     * @throws NullPointerException     Se {@code a} è null.
     * @throws IllegalArgumentExcetpion Se {@code nome} è vuoto.
     */
    public ListeDistribuzione(final String nome, final Alias a) {
        Objects.requireNonNull(nome, "Il nome della lista avuto per argomento non deve essere null.");

        Objects.requireNonNull(a, "L'alias avuto per argomento non deve essere null.");

        if (nome.isEmpty())
            throw new IllegalArgumentException("Il nome della lista avuto per argomento non deve essere vuoto.");

        this.nome = nome;

        Set<Indirizzo.Locale> locali = a.getIndirizzi();
        Indirizzo.Dominio dominio = a.getDominio();

        for (Indirizzo.Locale indLoc : locali) {
            Indirizzo newInd = new Indirizzo(dominio, indLoc);

            indirizzi.add(newInd);
        }
    }

    // METODI

    /**
     * Restituisce il nome di {@code this}.
     * 
     * @return Il nome di {@code this}.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Restituisce gli indirizzi di {@code this}.
     * 
     * @return Gli indirizzi di {@code this}.
     */
    public Set<Indirizzo> getIndirizzi() {
        return Collections.unmodifiableSet(indirizzi);
    }
}
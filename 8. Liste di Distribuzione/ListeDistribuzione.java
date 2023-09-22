import java.util.*;

/**
 * OVERVIEW: ListeDistribuzione è una classe concreta che rappresenta stato e
 * metodi di liste di distribuzione per indirizzi email di posta elettronica.
 * Una lista di distribuzione è caratterizzata da un nome ed i suoi indirizzi.
 * Le istanze di questa classe sono immutabili.
 */

public class ListeDistribuzione implements Iterable<Indirizzo> {
    /**
     * IR: Il nome della lista non deve essere null.
     * Il nome della lista non deve essere vuoto.
     * Il Set di indirizzi email non deve essere null.
     * Il Set di indirizzi email non deve contenere valori null.
     * 
     * AF: nome : il nome di {@code this}
     * indirizzi : la lista di indirizzi email di {@code this}
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

    /**
     * Costruisce un nuovo oggetto {@code this} a partire da 2 liste di
     * distribuzione {@code lista1} e {@code lista2}, cui viene effettauta la somma.
     * 
     * @param lista1 La prima lista che compone {@code this}.
     * @param lista2 La seconda lista che compone {@code this}.
     * 
     * @throws NullPointerException     Se il nome di {@code lista1} è null.
     * @throws NullPointerException     Se il nome di {@code lista2} è null.
     * @throws NullPointerException     Se {@code lista1} è null.
     * @throws NullPointerException     Se {@code lista2} è null.
     * @throws NullPointerException     Se {@code lista1} contiene valori null.
     * @throws NullPointerException     Se {@code lista2} contiene valori null.
     * @throws IllegalArgumentException Se il nome di {@code lista1} è vuoto.
     * @throws IllegalArgumentException Se il nome di {@code lista2} è vuoto.
     */
    public ListeDistribuzione(final ListeDistribuzione lista1, final ListeDistribuzione lista2) {
        Objects.requireNonNull(lista1, "La prima lista avuta per argomento non deve essere null.");

        Objects.requireNonNull(lista2, "La seconda lista avuta per argomento non deve essere null.");

        Objects.requireNonNull(lista1.getNome(), "La prima lista avuta per argomento non deve avere nome null.");

        Objects.requireNonNull(lista2.getNome(), "La seconda lista avuta per argomento non deve avere nome null.");

        if (lista1.getNome().isEmpty())
            throw new IllegalArgumentException("La prima lista avuta per argomento non deve avere nome vuoto.");

        if (lista2.getNome().isEmpty())
            throw new IllegalArgumentException("La seconda lista avuta per argomento non deve avere nome vuoto.");

        String nomeFinale = lista1.getNome() + lista2.getNome();

        Set<Indirizzo> setFinale = new HashSet<>();

        for (Indirizzo ind : lista1.getIndirizzi()) {
            Objects.requireNonNull(ind, "La prima lista avuta per argomento non deve contenere valori null.");

            setFinale.add(ind);
        }

        for (Indirizzo ind : lista2.getIndirizzi()) {
            Objects.requireNonNull(ind, "La seconda lista avuta per argomento non deve contenere valori null.");

            setFinale.add(ind);
        }

        this.nome = nomeFinale;

        for (Indirizzo indir : setFinale) {
            this.indirizzi.add(indir);
        }
    }

    /**
     * Costruisce un nuovo oggetto {@code this} a partire da un nuovo nome
     * {@code nuovoNome}, 2 liste di distribuzione {@code lista1} e {@code lista2},
     * cui viene effettauta la differenza.
     * 
     * @param nuovoNome Il nuovo nome di {@code this}.
     * @param lista1    La prima lista che compone {@code this}.
     * @param lista2    La seconda lista che compone {@code this}.
     * 
     * @throws NullPointerException     Se {@code nuovoNome} è null.
     * @throws NullPointerException     Se il nome di {@code lista1} è null.
     * @throws NullPointerException     Se il nome di {@code lista2} è null.
     * @throws NullPointerException     Se {@code lista1} è null.
     * @throws NullPointerException     Se {@code lista2} è null.
     * @throws NullPointerException     Se {@code lista1} contiene valori null.
     * @throws NullPointerException     Se {@code lista2} contiene valori null.
     * @throws IllegalArgumentException Se {@code nuovoNome} è vuoto.
     * @throws IllegalArgumentException Se il nome di {@code lista1} è vuoto.
     * @throws IllegalArgumentException Se il nome di {@code lista2} è vuoto.
     */
    public ListeDistribuzione(final String nuovoNome, final ListeDistribuzione lista1,
            final ListeDistribuzione lista2) {
        Objects.requireNonNull(nuovoNome, "Il nome della lista da costruire non deve essere null.");

        Objects.requireNonNull(lista1, "La prima lista avuta per argomento non deve essere null.");

        Objects.requireNonNull(lista2, "La seconda lista avuta per argomento non deve essere null.");

        Objects.requireNonNull(lista1.getNome(), "La prima lista avuta per argomento non deve avere nome null.");

        Objects.requireNonNull(lista2.getNome(), "La seconda lista avuta per argomento non deve avere nome null.");

        if (lista1.getNome().isEmpty())
            throw new IllegalArgumentException("La prima lista avuta per argomento non deve avere nome vuoto.");

        if (lista2.getNome().isEmpty())
            throw new IllegalArgumentException("La seconda lista avuta per argomento non deve avere nome vuoto.");

        if (nuovoNome.isEmpty())
            throw new IllegalArgumentException("Il nome della lista avuto per argomento non deve essere vuoto.");

        this.nome = nuovoNome;

        Set<Indirizzo> set1 = new HashSet<>();
        Set<Indirizzo> setFinale = new HashSet<>();

        for (Indirizzo ind : lista1.getIndirizzi()) {
            Objects.requireNonNull(ind, "La prima lista avuta per argomento non deve contenere valori null.");

            set1.add(ind);
        }

        for (Indirizzo ind : lista2.getIndirizzi()) {
            Objects.requireNonNull(ind, "La seconda lista avuta per argomento non deve contenere valori null.");

            if (set1.contains(ind))
                setFinale.add(ind);
        }

        for (Indirizzo indir : setFinale) {
            this.indirizzi.add(indir);
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

    @Override
    public int hashCode() {
        return Objects.hash(this.nome);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ListeDistribuzione other = (ListeDistribuzione) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public Iterator<Indirizzo> iterator() {
        return indirizzi.iterator();
    }
}
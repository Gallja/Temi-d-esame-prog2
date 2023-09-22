import java.util.*;

/**
 * OVERVIEW: Alias è una classe concreta che implementa stato e metodi di un
 * alias di posta elettronica, con lo scopo di inviare una email ad una serie di
 * indirizzi che condividono, per l'appunto, lo stesso alias.
 * Un alias è caratterizzato da un nome, un dominio e da una serie di indirizzi
 * email.
 * Le istanze di questa classe sono mutabili.
 */

public class Alias implements Iterable<Indirizzo.Locale> {
    /**
     * IR: Il nome di {@code this} non deve essere null.
     * Il nome di {@code this} non deve essere vuoto.
     * Il dominio di {@code this} non deve essere null.
     * La lista di indirizzi di {@code this} non deve essere null.
     * La lista di indirizzi di {@code this} non deve contenere valori null.
     * 
     * AF: nome : il nome di {@code this}
     * dom : il dominio di {@code this}
     * indirizzi : gli indirizzi associati a {@code this}
     */

    // ATTRIBUTI
    /** Il nome di {@code this} */
    private final String nome;
    /** Il dominio di {@code this} */
    private final Indirizzo.Dominio dom;
    /** La serie di indirizzi email di {@code this} */
    private final Set<Indirizzo.Locale> indirizzi = new HashSet<Indirizzo.Locale>();

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire da {@code nome}, il
     * dominio {@code dom} e la lista di indirizzi {@code indirizzi_in} avuti per
     * argomento.
     * 
     * @param nome         Il nome di {@code this}.
     * @param dom          Il dominio di {@code this}.
     * @param indirizzi_in La lista di indirizzi locali associati a {@code this}.
     * 
     * @throws NullPointerException     Se {@code nome} è null.
     * @throws NullPointerException     Se {@code dom} è null.
     * @throws NullPointerException     Se {@code indirizzi_in} è null.
     * @throws NullPointerException     Se {@code indirizzi_in} contiene valori
     *                                  null.
     * @throws IllegalArgumentException Se {@code nome} è vuoto.
     * @throws IllegalArgumentException se {@code dom} è vuoto.
     */
    public Alias(final String nome, final String dom, final Set<Indirizzo.Locale> indirizzi_in) {
        Objects.requireNonNull(nome, "Il nome avuto per argomento non deve essere null.");

        Objects.requireNonNull(dom, "Il dominio avuto per argomento non deve essere null.");

        Objects.requireNonNull(indirizzi_in, "La lista di indirizzi avuta per argomento non deve essere null.");

        if (nome.isEmpty())
            throw new IllegalArgumentException("Il nome avuto per argomento non deve essere vuoto.");

        if (dom.isEmpty())
            throw new IllegalArgumentException("Il dominio avuto per argomento non deve essere vuoto.");

        this.nome = nome;
        this.dom = new Indirizzo.Dominio(dom);

        for (Indirizzo.Locale ind : indirizzi_in) {
            Objects.requireNonNull(ind, "La lista di indirizzi avuta per argomento non deve contenere valori null.");

            this.indirizzi.add(ind);
        }
    }

    // METODI

    /**
     * Restituisce il nome di {@code this}.
     * 
     * @return Il nome di {@code this}.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce il dominio di {@code this}.
     * 
     * @return Il dominio di {@code this}.
     */
    public Indirizzo.Dominio getDominio() {
        return this.dom;
    }

    /**
     * Restituisce gli indirizzi di {@code this}.
     * 
     * @return Gli indirizzi di {@code this}.
     */
    public Set<Indirizzo.Locale> getIndirizzi() {
        return Collections.unmodifiableSet(indirizzi);
    }

    /**
     * Modifica {@code this} aggiungendo alla lista di indirizzi locali l'indirizzo
     * {@code ind} avuto per argomento.
     * 
     * @param ind La porzione locale dell'indirizzo da aggiungere a {@code this}.
     * 
     * @throws NullPointerException Se {@code ind} è null.
     */
    public void addIndirizzo(final Indirizzo.Locale ind) {
        Objects.requireNonNull(ind, "La porzione locale dell'indirizzo avuta per argomento non deve essere null.");

        indirizzi.add(ind);
    }

    /**
     * Rimuove da {@code this} un elemento locale {@code ind} avuto per argomento.
     * 
     * @param ind La porzione locale di un indirizzo che si intende rimuovere da
     *            {@code this}.
     * 
     * @throws NullPointerException     Se {@code ind} è null.
     * @throws IllegalArgumentException Se {@code ind} non esiste in {@code this}.
     */
    public void removeIndirizzo(final Indirizzo.Locale ind) {
        Objects.requireNonNull(ind, "La porzione locale dell'indirizzo da rimuovere dall'alias non deve essere null.");

        if (!indirizzi.contains(ind))
            throw new IllegalArgumentException(
                    "La porzione locale avuta per argomento deve far parte dell'elenco di indirizzi.");

        indirizzi.remove(ind);
    }

    /**
     * Restituisce {@code True/False} se l'alias {@code a} avuto per argomento è
     * contenuto in {@code this}.
     * 
     * @param a L'alias di cui controllare la presenza in {@code this}.
     * 
     * @return {@code True/False} se {@code a} è presente o meno in {@code this}.
     * 
     * @throws NullPointerException se {@code a} è null.
     */
    public boolean containsAlias(final Alias a) {
        Objects.requireNonNull(a, "L'alias avuto per argomento non deve essere null.");

        if (dom.containsDom(a.getDominio()))
            return true;

        return false;
    }

    /**
     * Restituisce un valore {@code True/False} se {@code ind} appartiene o o meno a
     * {@code this}.
     * 
     * @param ind L'indirizzo di cui si vuole controllare la presenza in
     *            {@code this}.
     * 
     * @return {@code True/False} se {@code int} è presente o meno in {@code this}.
     * 
     * @throws NullPointerException     Se {@code ind} è null.
     * @throws IllegalArgumentException Se {@code ind} ha un dominio che non
     *                                  coincide con quello di {@code this}.
     */
    public boolean containsIndirizzo(final Indirizzo ind) {
        Objects.requireNonNull(ind, "L'indirizzo avuto per argomento non deve essere null.");

        String domTmp = ind.getDominio();

        String confronto = dom.getDom();

        if (!confronto.contains(domTmp))
            throw new IllegalArgumentException(
                    "L'indirizzo avuto per argomento non ha un dominio che coincide con quello di this.");

        for (Indirizzo.Locale il : indirizzi) {
            if (il.getLoc().equals(ind.getLocale()))
                return true;
        }

        return false;
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
        Alias other = (Alias) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public Iterator<Indirizzo.Locale> iterator() {
        return indirizzi.iterator();
    }
}
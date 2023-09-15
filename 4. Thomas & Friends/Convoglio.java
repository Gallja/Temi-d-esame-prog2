import java.util.*;

/**
 * OVERVIEW: Convoglio è una classe concreta che rappresenta un convoglio ferroviario.
 * Un Convoglio è rappresentato da 1 o 2 Locomotori (obbligatoriamente in testa al convoglio oppure in testa e in coda al convoglio) e 1 o più Vagoni.
 * Una tipica istanza di questa classe è: "Locomotore Vagone Vagone Locomotore". 
 * Le istanze di questa classe sono mutabili.
 */

public class Convoglio implements Iterable<Vagone> {
    /**
     * IR: La lista dei Locomotori non deve essere nulla.
     * Tutti gli elementi della lista di Locomotori non devono essere nulli.
     * 
     * La lista dei Vagoni non deve essere nulla.
     * Tutti gli elementi della lista di Vagoni non devono essere nulli.
     * 
     * AF: locomotori: la lista contenente i locomotori del Convoglio.
     * vagoni: la lista contenente i vagoni del Convoglio.
     */
    
    // ATTRIBUTI
    /** La lista contenente i Locomotori del Convoglio e la lista contenente i Vagoni del Convoglio */
    private String nomeConvoglio;
    private ArrayList<Locomotore> locomotori = new ArrayList<Locomotore>();
    private ArrayList<Vagone> vagoni = new ArrayList<Vagone>();

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire dalle liste {@code locomotori_in} e {@code vagoni_in} avute per argomenti.
     * 
     * @param locomotori_in La lista di Locomotori di {@code this}.
     * @param vagoni_in La lista di Vagoni di {@code this}.
     * 
     * @throws NullPointerException nel caso in cui {@code nomeConvoglio} fosse nullo.
     * @throws IllegalArgumentException nel cason in cui {@code nomeConvoglio} fosse vuoto.
     * @throws NullPointerException nel caso in cui {@code locomotori_in} fosse nullo.
     * @throws NullPointerException nel caso in cui {@code vagoni_in} fosse nullo.
     * @throws NullPointerException nel caso in cui {@code locomotori_in} contenesse un valore nullo.
     * @throws NullPointerException nel caso in cui {@code vagoni_in} contenesse un valore nullo.
     * @throws IllegalArgumentException nel caso in cui {@code locomotori_in} fosse maggiore di 2.
     */
    public Convoglio(final String nomeConvoglio, final ArrayList<Locomotore> locomotori_in, final ArrayList<Vagone> vagoni_in) {
        Objects.requireNonNull(locomotori_in, "La lista di locomotori avuta per argomento non deve essere nulla.");

        Objects.requireNonNull(vagoni_in, "La lista di vagoni avuta per argomento non deve essere nulla.");

        Objects.requireNonNull(nomeConvoglio, "Il nome del Convoglio non deve essere nullo.");

        if (nomeConvoglio.isEmpty()) throw new IllegalArgumentException("Il nome del Convoglio non deve essere vuoto.");

        if (locomotori_in.size() > 2) throw new IllegalArgumentException("Il Convoglio non può avere più di 2 locomotori.");

        this.nomeConvoglio = nomeConvoglio;

        for (Locomotore l : locomotori_in) {
            Objects.requireNonNull(l, "La lista di locomotori avuta per argomento non deve contenere valori nulli.");

            locomotori.add(l);
        }

        for (Vagone v : vagoni_in) {
            Objects.requireNonNull(v, "La lista di vagoni avuta per argomento non deve contenere valori nulli.");

            vagoni.add(v);
        }
    }

    // METODI

    /**
     * Modifica {@code this} sostituendo il Locomotore in posizione {@code i} con il Locomotore {@code loc} avuto per argomento.
     * 
     * @param loc Il Locomotore con cui si vuole modificare {@code this}.
     * @param i L'indice dei Locomotori di {@code this} che si intende sostituire.
     * 
     * @throws NullPointerException nel caso in cui {@code loc} fosse nullo.
     * @throws IllegalArgumentException nel caso in cui {@code i} fosse < 0.
     * @throws IllegalArgumentException nel caso in cui {@code i} fosse maggiore della capacità della lista di Locomotori di {@code this}.
     */
    public void replaceLocomotore(final Locomotore loc, final int i) {
        Objects.requireNonNull(loc, "Il Locomotore avuto per argomento non deve essere nullo.");

        if (i < 0) throw new IllegalArgumentException("L'indice avuto per argomento non deve essere < 0.");

        if (i > locomotori.size()) throw new IllegalArgumentException("L'indice avuto per argomento non deve essere > della capacità della lista di Locomotori.");

        locomotori.set(i, loc);
    }

    /**
     * Modifica {@code this} sostituendo il Vagone in posizione {@code i} con il Vagone {@code vag} avuto per argomento.
     * 
     * @param vag Il Vagone con cui si vuole modificare {@code this}.
     * @param i L'indice dei Vagoni di {@code this} che si intende sostituire.
     * 
     * @throws NullPointerException nel caso in cui {@code vag} fosse nullo.
     * @throws IllegalArgumentException nel caso in cui {@code i} fosse < 0.
     * @throws IllegalArgumentException nel caso in cui {@code i} fosse maggiore della capacità della lista di Locomotori di {@code this}.
     */
    public void replaceVagone(final Vagone vag, final int i) {
        Objects.requireNonNull(vag, "Il Vagone avuto per argomento non deve essere nullo.");

        if (i < 0) throw new IllegalArgumentException("L'indice avuto per argomento non deve essere < 0.");

        if (i > vagoni.size()) throw new IllegalArgumentException("L'indice avuto per argomento non deve essere > della capacità della lista di Vagoni.");

        vagoni.set(i, vag);
    }

    /**
     * Restituisce i Locomotori di {@code this}.
     * 
     * @return I Locomotori di {@code this}.
     */
    public ArrayList<Locomotore> getLocomotori() {
        return locomotori;
    }

    /**
     * Restituisce i Vagoni di {@code this}.
     * 
     * @return I Vagoni di {@code this}.
     */
    public ArrayList<Vagone> getVagoni() {
        return vagoni;
    }

    /**
     * Aggiugne un Locomotore {@code loc} avuto per argomento a {@code this}.
     * 
     * @param loc Il Locomotore che si desidera aggiungere a {@code this}.
     * 
     * @throws NullPointerException nel caso in cui {@code loc} fosse nullo.
     * @throws IllegalArgumentException nel caso in cui la dimensione di {@code this} fosse già = 2.
     */
    public void addLocomotore(final Locomotore loc) {
        Objects.requireNonNull(loc, "Il Locomotore avuto per argomento non deve essere nullo.");

        if (locomotori.size() == 2) throw new IllegalArgumentException("I Locomotori del Convoglio sono già 2, non è possibile aggiungerne altri.");

        locomotori.add(loc);
    }

    /**
     * Aggiugne un Locomotore {@code vag} avuto per argomento a {@code this}.
     * 
     * @param vag Il Vagone che si desidera aggiungere a {@code this}.
     * 
     * @throws NullPointerException nel caso in cui {@code vag} fosse nullo.
     */
    public void addVagone(final Vagone vag) {
        Objects.requireNonNull(vag, "Il Locomotore avuto per argomento non deve essere nullo.");

        vagoni.add(vag);
    }

    /**
     * Modifica {@code this} assegnandogli un nome {@code s} avuto per argomento.
     * 
     * @param s Il nome con cui si desidera modificare {@code s}
     * 
     * @throws NullPointerException nel caso in cui {@code s} fosse nullo.
     * @throws IllegalArgumentException nel caso in cui {@code s} fosse vuoto.
     */
    public void setNomeConvoglio(final String s) {
        Objects.requireNonNull(s, "Il nome avuto per argomento non deve essere nullo.");

        if (s.isEmpty()) throw new IllegalArgumentException("Il nome avuto per argomento non deve essere vuoto.");

        nomeConvoglio = s;
    }

    /**
     * Restituisce il nome di {@code this}.
     * 
     * @return Il nome di {@code this}.
     */
    public String getNomeConvoglio() {
        return nomeConvoglio;
    }

    /**
     * Restituisce un valore {@code True/False} se {@code this} è o meno valido.
     * 
     * @return Valore booleano in base alla validità di {@code this}.
     */
    public boolean isValido() {
        int pesoTot = 0;

        for (Vagone v : vagoni) {
            pesoTot += v.getPeso();
        }

        int potenzaTot = 0;

        if (locomotori.size() == 2) {
            potenzaTot += locomotori.get(0).getPotenza();
            potenzaTot += locomotori.get(1).getPotenza();
        } else {
            potenzaTot += locomotori.get(0).getPotenza();
        }

        return pesoTot < potenzaTot;
    }

    @Override
    public Iterator<Vagone> iterator() {
        return vagoni.iterator();
    }

    @Override
    public String toString() {
        boolean ris = isValido();
        String risp = "";

        if (ris) {
            risp = "valido";
        } else {
            risp = "non valido";
        }

        return "Convoglio [nomeConvoglio=" + nomeConvoglio + ", locomotori=" + locomotori + ", vagoni=" + vagoni + "]" + risp;
    }

}
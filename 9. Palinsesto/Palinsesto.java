import java.util.*;

/**
 * OVERVIEW: Palinsesto è una classe concreta che implementa stato e metodi di
 * un palinsesto di trasmissioni.
 * Un palinsesto è rappresentato da una serie di trasmissioni che lo compongono
 * giornalmente.
 * Le istanze di questa classe sono mutabili.
 */

public class Palinsesto implements Iterable<Trasmissione> {
    /**
     * IR: La lista di trasmissioni non deve essere null.
     * La lista di trasmissioni non deve contenere valori null.
     * La lista di trasmissioni non deve contenere sovrapposizioni di trasmissioni.
     * 
     * AF: trasmissioni : la lista di trasmissioni che compongono il palinsesto.
     */

    // ATTRIBUTI
    /** La serie di trasmissioni di {@code this} */
    List<Trasmissione> trasmissioni = new ArrayList<Trasmissione>();

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire dalla lista
     * {@code trasmissioni_in} avuta per argomento.
     * 
     * @param trasmissioni_in La lista di trasmissioni con la quale si intende
     *                        inizializzare {@code this}.
     * 
     * @throws NullPointerException     Se {@code trasmissioni_in} è null.
     * @throws NullPointerException     Se {@code trasmissioni_in} contiene valori
     *                                  null.
     * @throws IllegalArgumentException Se {@code trasmissioni_in} contiene
     *                                  trasmissioni che si intersecano fra loro.
     */
    public Palinsesto(List<Trasmissione> trasmissioni_in) {
        Objects.requireNonNull(trasmissioni_in, "La lista di trasmissioni avuta per argomento non deve essere null.");

        for (Trasmissione t : trasmissioni_in) {
            Objects.requireNonNull(t, "La lista di trasmissioni avuta per argomento non deve contenere valori null.");

            trasmissioni.add(t);
        }

        if (interseca())
            throw new IllegalArgumentException(
                    "La lista di trasmissioni avuta per argomento non deve avere sovrapposizione di trasmissioni");
    }

    // METODI

    /**
     * Restituisce {@code True/False} se {@code this} ha o meno trasmissioni che si
     * sovrappongono.
     * 
     * @return {@code True/False} se le trasmissioni di {@code this} si intersecano
     *         o no.
     */
    private boolean interseca() {

        return false;
    }

    /**
     * Restituisce {@code True/False} se {@code this} ha o meno sovrapposizioni con
     * la trasmissione {@code t} avuta per argomento.
     * 
     * @return {@code True/False} se le trasmissioni di {@code this} si intersecano
     *         o no con {@code t}.
     * 
     * @throws NullPointerException Se {@code t} è null.
     */
    private boolean interseca(final Trasmissione t) {
        Objects.requireNonNull(t, "La trasmissione avuta per argomento non deve essere null.");

        return false;
    }

    /**
     * Modifica {@code this} aggiungendo una trasmissione {@code t} avuta per
     * argomento.
     * 
     * @param t La trasmissione che si intende aggiungere a {@code this}.
     * 
     * @throws NullPointerException     Se {@code t} è null.
     * @throws IllegalArgumentException Se {@code t} interseca con qualche
     *                                  trasmissione di {@code this}.
     */
    public void addTrasmissione(final Trasmissione t) {
        Objects.requireNonNull(t, "La trasmissione avuta per argomento non deve essere null.");

        if (interseca(t))
            throw new IllegalArgumentException(
                    "La trasmissione avuta per argomento non si deve sovrapporre con nessuna trasmissione già presente.");

        trasmissioni.add(t);
    }

    /**
     * Modifica {@code this} rimuovendo una trasmissione {@code t} avuta per
     * argomento.
     * 
     * @param t La trasmissione che si intende rimuovere da {@code this}.
     * 
     * @throws NullPointerException Se {@code t} è null.
     */
    public void removeTrasmissione(final Trasmissione t) {
        Objects.requireNonNull(t, "La trasmissione avuta per argomento non deve essere null.");

        trasmissioni.remove(t);
    }

    @Override
    public Iterator<Trasmissione> iterator() {
        return trasmissioni.iterator();
    }

    @Override
    public String toString() {
        return "Palinsesto [trasmissioni=" + trasmissioni + "]";
    }

}
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * OVERVIEW: ListMultiset è una classe concreta che implementa metodi e
 * comportamenti di una StringMultiset.
 * Un ListMultiset è rappresentato da una lista di elementi con o senza
 * ripetizioni.
 * Le istanze di questa classe sono mutabili.
 */

public class ListMultiset implements StringMultiset {

    /**
     * IR: La lista contenente gli elementi del Multiset non deve essere nulla.
     * Tutti gli elementi della lista contenente gli elementi del Multiset non
     * devono essere nulli.
     * Tutti gli elementi della lista contenente gli elementi del Multiset non
     * devono essere vuoti.
     * 
     * AF: elem: gli elementi contenuti all'interno del Multiset.
     */

    // ATTRIBUTI
    /** La lista contenente gli elementi del Multiset */
    private ArrayList<String> elem = new ArrayList<String>();

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto this a partire dalla lista {@code elementi} avuta
     * per argomento.
     * 
     * @throws NullPointerException     nel caso in cui {@code elementi} fosse
     *                                  nullo.
     * 
     * @throws NullPointerException     nel caso in cui un elemento di
     *                                  {@code elementi}
     *                                  fosse nullo.
     * 
     * @throws IllegalArgumentException nel caso in cui un elemento di
     *                                  {@code elementi} fosse vuoto.
     * 
     * @param elementi gli elementi del Multiset a partire dai quali si intende
     *                 costruire l'insieme.
     */
    public ListMultiset(final ArrayList<String> elementi) {
        Objects.requireNonNull(elementi, "La lista di elementi avuta per argomento non deve essere nulla.");

        for (String s : elementi) {
            if (s.isEmpty()) {
                throw new IllegalArgumentException(
                        "Tutti gli elementi della lista avuta per argomento non devono essere nulli.");
            }

            elem.add(s);
        }
    }

    // METODI

    @Override
    public int add(String s) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean contains(String s) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public StringMultiset intersection(StringMultiset o) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int multiplicity(String s) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int remove(String s) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public StringMultiset union(StringMultiset o) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<String> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

}
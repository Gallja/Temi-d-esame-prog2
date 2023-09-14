import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * OVERVIEW: ListMultiset è una classe concreta che implementa metodi e
 * comportamenti di un StringMultiset.
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

    /**
     * Restituisce l'elemento del Multiset a partire dall'indice avuto per
     * argomento.
     * 
     * @throws IllegalArgumentException nel caso in cui {@code i} fosse maggiore
     *                                  rispetto alla dimensione della lista di
     *                                  Multiset.
     * 
     * @param i l'indice dell'elemento che si intende ricercare.
     * @return la Stringa corrispondente all'indice avuto per argomento, non deve
     *         mai essere vuota o nulla.
     */
    public String get_elem(int i) {
        if (i > elem.size()) {
            throw new IllegalArgumentException(
                    "L'indice dell'elemento da ricercare è maggiore rispetto alla dimensione del Multiset.");
        }

        return elem.get(i);
    }

    @Override
    public int add(String s) {
        Objects.requireNonNull(s, "L'elemento avuto per argomento non deve essere nullo.");

        elem.add(s);

        return multiplicity(s);
    }

    @Override
    public boolean contains(String s) {
        Objects.requireNonNull(s, "L'elemento avuto per argomento non deve essere nullo.");

        return elem.contains(s);
    }

    @Override
    public StringMultiset intersection(StringMultiset o) {
        Objects.requireNonNull(o, "L'elemento avuto per argomento non deve essere nullo.");

        return null;
    }

    @Override
    public int multiplicity(String s) {
        Objects.requireNonNull(s, "L'elemento avuto per argomento non deve essere nullo.");

        int conta = 0;
        for (String elemento : elem) {
            if (elemento.equals(s)) {
                conta += 1;
            }
        }

        return conta;
    }

    @Override
    public int remove(String s) {
        Objects.requireNonNull(s, "L'elemento avuto per argomento non deve essere nullo.");

        elem.remove(s);
        return multiplicity(s);
    }

    @Override
    public int size() {
        int cardinalita = 0;

        for (String elemento : elem) {
            cardinalita += multiplicity(elemento);
        }

        return cardinalita;
    }

    @Override
    public StringMultiset union(StringMultiset o) {
        Objects.requireNonNull(o, "L'elemento avuto per argomento non deve essere nullo.");

        ListMultiset backup = new ListMultiset(elem);

        Set<String> supporto1 = o.get_supporto();
        Set<String> supporto2 = backup.get_supporto();

        supporto1.addAll(supporto2);

        ArrayList<String> ris1 = new ArrayList<String>();

        Iterator<String> iterator = o.iterator();

        while (iterator.hasNext()) {
            String elemento = iterator.next();

            ris1.add(elemento);
        }

        StringMultiset ris_finale = new ListMultiset(ris1);

        return ris_finale;
    }

    @Override
    public Set<String> get_supporto() {
        final Set<String> ris = new HashSet<String>();

        for (String elemento : elem) {
            ris.add(elemento);
        }

        return ris;
    }

    /**
     * @Override
     *           public Iterator<String> iterator() {
     *           return get_supporto().iterator();
     *           }
     */

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int pos = 0;

            private boolean duplicato(int index) {
                for (int i = 0; i < index; i++) {
                    if (elem.get(i) == elem.get(index)) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public boolean hasNext() {
                while (pos < elem.size() && duplicato(pos)) {
                    pos++;
                }
                if (pos == elem.size())
                    return false;
                return true;
            }

            @Override
            public String next() {
                pos++;
                return elem.get(pos - 1);
            }

        };
    }

}
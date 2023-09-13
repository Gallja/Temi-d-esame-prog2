import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * OVERVIEW: MapMultiset è una classe concreta che implementa metodi e
 * comportamenti di un StringMultiset.
 * MapMultiset è rappresentato da una mappa da stringhe a interi, con le
 * stringhe che sono gli elementi del Multiset e gli interi che rappresentano la
 * molteplicità dell'elemento.
 * 
 * Le istanze di questa classe sono mutabili.
 */

public class MapMultiset implements StringMultiset {

    /**
     * IR: La mappa rappresentante il Multiset non deve essere nulla.
     * Tutti gli elementi chiave del Multiset non devono essere nulli.
     * Tutti gli elementi chiave del Multiset non devono essere vuoti.
     * Tutti gli elementi chiave del Multiset devono essere univoci.
     * Tutti gli elementi valore del Multiset non devono essere nulli.
     * 
     * AF: mappa: mappa che rappresenta l'elemento contenuto nel Multiset e l'intero
     * che ne indica la molteplicità all'interno del Multiset stesso.
     */

    // ATTRIBUTI
    /** La mappa che rappresenta il Multiset */
    HashMap<String, Integer> mappa = new HashMap<>();

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto this a partire dalla HashMap {@code mappa_in}
     * fornita per argomento.
     * 
     * @throws NullPointerException     nel caso in cui {@code mappa_in} fosse
     *                                  nulla.
     * 
     * @throws NullPointerException     nel caso in cui la chiave di
     *                                  {@code mappa_in} fosse nulla.
     * 
     * @throws NullPointerException     nel caso in cui il valore di
     *                                  {@code mappa_in} fosse nullo.
     * 
     * @throws IllegalArgumentException nel caso in cui la chiave di
     *                                  {@code mappa_in} fosse vuota.
     * 
     * @param mappa_in la HashMap fornita come argomento per costruire un nuovo
     *                 oggetto MapMultiset.
     */
    public MapMultiset(final HashMap<String, Integer> mappa_in) {
        Objects.requireNonNull(mappa_in, "La mappa fornita per argomento non deve essere nulla.");

        for (Map.Entry<String, Integer> entry : mappa_in.entrySet()) {
            Objects.requireNonNull(entry.getKey(), "L'elemento del Multiset non può essere nullo.");

            Objects.requireNonNull(entry.getValue(),
                    "La molteplicità dell'elemento del Multiset non può essere nullo.");

            if (entry.getKey().isEmpty()) {
                throw new IllegalArgumentException("L'elemento del Multiset non può essere vuoto.");
            }

            mappa.put(entry.getKey(), entry.getValue());
        }
    }

    // METODI

    @Override
    public int add(String s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public int remove(String s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public boolean contains(String s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public int multiplicity(String s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'multiplicity'");
    }

    @Override
    public Set<String> get_supporto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get_supporto'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public StringMultiset union(StringMultiset o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'union'");
    }

    @Override
    public StringMultiset intersection(StringMultiset o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'intersection'");
    }

    @Override
    public Iterator<String> iterator() {
        return mappa.keySet().iterator();
    }
}
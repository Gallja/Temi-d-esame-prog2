import java.util.Iterator;
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
     * IR: 
     * 
     * AF: 
     */

    // ATTRIBUTI

    // COSTRUTTORE

    //METODI

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
}
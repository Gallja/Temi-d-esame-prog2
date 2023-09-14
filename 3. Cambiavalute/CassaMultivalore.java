import java.util.*;

/**
 * OVERVIEW: CassaMultivalore è una classe concreta che rappresenta una cassa multivalore con relativi metodi e comportamenti.
 * Le istanze di questa classe sono mutabili.
 */

public class CassaMultivalore implements Iterable <Importo> {
    /**
     * IR: La lista contenente gli importi non deve essere nulla.
     * Tutti gli elementi della lista di importi non devono essere nulli.
     * 
     * AF: importi: la lista contenente gli importi della cassa.
     */

    // ATTRIBUTI
    /** La lista contenente tutti gli importi */
    private ArrayList<Importo> importi = new ArrayList<Importo>();

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire dalla lista {@code importi_in} avuta per argomento.
     * 
     * @param importi la lista di importi
     * 
     * @throws NullPointerException nel caso in cui {@code importi_in} fosse nulla.
     * 
     * @throws NullPointerException nel caso in cui un elemento di {@code importi_in} fosse nullo.
     * 
     * @throws IllegalArgumentException nel caso in cui {@code importi_in} contenesse una valuta duplicata.
     */
    public CassaMultivalore(final ArrayList<Importo> importi_in) {
        Objects.requireNonNull(importi_in, "La lista di importi avuta per argomento non deve essere nulla.");

        int cnt = 0;
        for (Importo i : importi_in) {
            Objects.requireNonNull(i, "Tutti gli elementi della lista di importi avuta per argomento non devono essere nulli.");

            if (cnt != 0) {
                for (Importo i2 : importi) {
                    if (i.getValuta() == i2.getValuta()) {
                        throw new IllegalArgumentException("La lista di importi avuta per argomento non deve contenere valute duplicate.");
                    }
                }
            }

            importi.add(i);
            cnt ++;
        }
    }

    /**
     * Ritorna un Importo all'interno di {@code this} in base all'indice {@code i} avuto per argomento.
     * 
     * @param i l'indice dell'Importo che si intende ottenere.
     * 
     * @throws IllegalArgumentException nel caso in cui {@code i} fosse maggiore rispetto alla dimensione della lista di Importi.
     */
    public Importo getImporto(int i) {
        if (i > importi.size()) 
            throw new IllegalArgumentException();

        return importi.get(i);
    }

    /**
     * Modifica {@code this} prelevando una quantità di importo {@code q} avuta per argometo.
     */
    public void preleva() {

    }

    /**
     * 
     */
    public void versa() {

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((importi == null) ? 0 : importi.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CassaMultivalore other = (CassaMultivalore) obj;
        if (importi == null) {
            if (other.importi != null)
                return false;
        } else if (!importi.equals(other.importi))
            return false;
        return true;
    }

    @Override
    public Iterator<Importo> iterator() {
        return new Iterator<Importo>() {
            private int pos = 0;

            @Override
            public boolean hasNext() {
                for (int i = pos; i < importi.size(); i ++) {
                    if (importi.get(i).getValore() != 0) {
                        return true;
                    }
                }

                return false;
            }

            @Override
            public Importo next() {
                pos ++;
                return importi.get(pos - 1);
            }

        };
    }
    
}
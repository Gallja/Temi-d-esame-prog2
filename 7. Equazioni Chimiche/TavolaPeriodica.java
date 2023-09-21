import java.util.*;

/**
 * OVERVIEW: TavolaPeriodica è una classe concreta che rappresenta la tavola
 * periodica con i propri elementi chimici (o atomi) con relativo simbolo e
 * peso.
 * La tavola periodica è caratterizzata dall'elenco di elementi chimici che la
 * compongono.
 * Le istanze di questa classe sono mutabili.
 */

public class TavolaPeriodica implements Iterable<ElementoChimico> {
    /**
     * IR: La mappa contenente gli elementi chimici non deve essere null.
     * Ogni elemento chiave-valore degli elementi chimici della tavola periodica non
     * deve essere null.
     * 
     * AF: elementi : l'elenco di elementi chimici della tavola periodica con
     * relativo numero atomico.
     */

    // ATTRIBUTI
    /** La lista di elementi chimici all'interno di {@code this} */
    private final Map<ElementoChimico, Integer> elementi = new HashMap<ElementoChimico, Integer>();

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire dalla lista di elementi
     * chimici {@code elementi_in} avuta per argomento.
     * 
     * @param elementi_in La lista di elementi chimici con la quale costruire
     *                    {@code this}.
     * 
     * @throws NullPointerException Se {@code elementi_in} è null.
     * @throws NullPointerException Se {@code elementi_in} contiene valori null.
     */
    public TavolaPeriodica(final Map<ElementoChimico, Integer> elementi_in) {
        Objects.requireNonNull(elementi_in, "La collezione di elementi avuta per argomento non deve essere null.");

        for (Map.Entry<ElementoChimico, Integer> entry : elementi_in.entrySet()) {
            Objects.requireNonNull(entry.getKey(), "L'elemento della tavola non può essere nullo.");

            Objects.requireNonNull(entry.getValue(), "Il numero atomico della tavola non può essere nullo.");

            elementi.put(entry.getKey(), entry.getValue());
        }
    }

    // METODI

    /**
     * Restituisce una mappa corrispondente a tutti gli elementi della tavola
     * periodica.
     * 
     * @return La mappa di tutti gli elementi chimici nella tavola.
     */
    public Map<ElementoChimico, Integer> getElementi() {
        return Collections.unmodifiableMap(elementi);
    }

    /**
     * Aggiunge un nuovo elemento chimico {@code el} a {@code this}, avendo per
     * argomento anche il numero atomico {@code numAtomico}.
     * 
     * @param el         L'elemento chimico da aggiungere a {@code this}.
     * @param numAtomico Il numero atomico dell'elemento chimico da aggiungere a
     *                   {@code this}.
     * 
     * @throws NullPointerException     Se {@code el} è null.
     * @throws IllegalArgumentException Se {@code numAtomico} fosse già presente in
     *                                  {@code this}.
     */
    public void addElemento(final ElementoChimico el, final int numAtomico) {
        Objects.requireNonNull(el, "L'elemento chimico avuto per argomento non deve essere null.");

        for (Map.Entry<ElementoChimico, Integer> entry : elementi.entrySet()) {
            if (entry.getValue() == numAtomico)
                throw new IllegalArgumentException(
                        "Il numero atomico avuto per argomento è già presente per un altro elemento della tavola periodica.");
        }

        elementi.put(el, numAtomico);
    }

    /**
     * Restituisce un valore {@code True/False} in base al controllo della presenza
     * dell'elemento {@code e}, avuto per argomento, in {@code this}.
     * 
     * @param e L'elemento chimico di cui si vuole controllare la presenza in
     *          {@code this}.
     * 
     * @return {@code True/False} in base alla presenza (o non) do {@code e} in
     *         {@code this}.
     * 
     * @throws NullPointerException Se {@code e} è null.
     */
    public boolean nellTavola(final ElementoChimico e) {
        Objects.requireNonNull(e, "L'elemento chimico avuto per argomento non deve essere null.");

        boolean flag = false;

        for (Map.Entry<ElementoChimico, Integer> entry : elementi.entrySet()) {
            if (entry.getKey().equals(e))
                return flag = true;
        }

        return flag;
    }

    @Override
    public Iterator<ElementoChimico> iterator() {
        return elementi.keySet().iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<ElementoChimico, Integer> entry : elementi.entrySet()) {
            sb.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }

        return sb.toString();
    }
}
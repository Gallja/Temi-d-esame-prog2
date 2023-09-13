/**
 * OVERVIEW: StringMultiset è un'interfaccia che descrive metodi e comportamenti
 * di un Multiset. Un Multiset è un insieme in cui ciascun elemento può essere
 * contenuto più di una volta (il numero di volte che un elemento compare è
 * chiamato 'molteplicità').
 */

public interface StringMultiset extends Iterable<String> {

    /**
     * Aggiunge un elemento al Multiset restituendo un valore corrispondente alla
     * molteplicità dell'elemento inserito.
     * 
     * @throws NullPointerException nel caso in cui s è nullo.
     * 
     * @param s L'elemento che si intende aggiungere al Multiset
     * @return la molteplicità di {@code s}, deve sempre avere valore
     *         positivo
     */
    public int add(String s);

    /**
     * Rimuove un elemento dal Multiset restituendo un valore corrispondente alla
     * molteplicità dell'elemento appena rimosso.
     * 
     * @throws NullPointerException     nel caso in cui {@code s} è nullo.
     * 
     * @throws IllegalArgumentException nel caso in cui {@code s} non fosse
     *                                  contenuto all'interno del Multiset.
     * 
     * @param s l'elemento da rimuovere
     * @return la molteplicità di {@code s}, deve sempre avere valore positivo o
     *         pari a zero.
     */
    public int remove(String s);

    /**
     * Controlla che {@code s} sia contenuto all'interno del Multiset e in base al
     * controllo restituisce un valore true/false.
     * 
     * @throws NullPointerException nel caso in cui {@code s} è nullo.
     * 
     * @param s l'elemento da cercare all'interno del Multiset
     * @return valore booleano corrispondente alla presenza di {@code s} all'interno
     *         del Multiset.
     */
    public boolean contains(String s);

    /**
     * Restituisce un valore intero corrispondente alla molteplicità di {@code s}
     * nel Multiset.
     * 
     * @throws NullPointerException nel caso in cui {@code s} è nullo.
     * 
     * @param s l'elemento di cui si necessita la molteplicità
     * @return valore intero della molteplicità di {@code s} nel Multiset
     */
    public int multiplicity(String s);

    /**
     * Restituisce un intero corrispondente alla cardinalità del Multiset.
     * 
     * @return il valore corrispondente alla cardinalità del Multiset, deve sempre
     *         avere valore positivo.
     */
    public int size();

    /**
     * Restituisce un nuovo Multiset effettuando l'unione fra this e {@code o}.
     * 
     * @param o il Multiset con cui si intende effettuare l'unione
     * 
     * @throws NullPointerException nel caso in cui {@code o} fosse nullo.
     * 
     * @return un Multiset frutto dell'unione fra this e {@code o}.
     */
    public StringMultiset union(StringMultiset o);

    /**
     * Restituisce un nuovo Multiset effettuando l'intersezione fra this e
     * {@code o}.
     * 
     * @param o il Multiset con cui si intende effettuare l'intersezione.
     * 
     * @throws NullPointerException nel caso in cui {@code o} fosse nullo.
     * 
     * @return un Multiset frutto dell'intersezione fra this e {@code o}.
     */
    public StringMultiset intersection(StringMultiset o);
}

import java.util.*;

/**
 * OVERVIEW: Vagone è una classe concreta che attua metodi e comportamenti di un Rotabile generico e ne estende le funzionalità.
 * Un Vagone è rappresentato dal modello, dal peso e da una serie di Dotazioni contenuto in esso.
 * Le istanze di questa classe sono immutabili.
 */

public class Vagone extends Rotabile {
    /**
     * IR: La lista di dotazioni non deve essere nulla.
     * Ogni elemento all'interno della lista di dotazioni non deve essere nullo.
     * 
     * AF: dotazioni: la lista contenente le dotazioni del Vagone.
     */

    // ATTRIBUTI
    /** La lista contenente le dotazioni del Vagone */
    private ArrayList<Dotazione> dotazioni = new ArrayList<Dotazione>();

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire da {@code modello}, {@code peso} e una lista di dotazioni {@code dotazioni_in} avuti per argomenti.
     * 
     * @param modello Il modello di {@code this}
     * @param peso Il peso di {@code this}
     * @param dotazioni_in La lista di dotazioni di {@code this}
     * 
     * @throws NullPointerException nel caso in cui {@code dotazioni_in} fosse nullo.
     * @throws NullPointerException nel caso in cui un elemento di {@code dotazioni_in} fosse nullo.
     */
    public Vagone(String modello, int peso, ArrayList<Dotazione> dotazioni_in) {
        super(modello, peso);
        
        Objects.requireNonNull(dotazioni_in, "La lista di dotazioni avuta per argomento non deve essere nulla.");

        for (Dotazione d : dotazioni_in) {
            Objects.requireNonNull(d, "La lista di dotazioni avuta per argomento non deve contenere valori nulli.");

            dotazioni.add(d);
        }
    }

    // METODI

    /**
     * Restituisce una dotazione di {@code this} in base all'indice {@code i} avuto per argomento.
     * 
     * @param i L'indice della dotazione di {@code this} che si intende ottenere.
     * 
     * @throws IllegalArgumentException nel caso in cui {@code i} non fosse >= 0.
     * @throws IllegalArgumentException nel caso in cui {@code i} fosse maggiore della lista di dotazioni di {@code this}.
     * 
     * @return la dotazione di {@code this} all'indice {@code i}
     * 
     */
    public Dotazione getDotazione(final int i) {
        if (i < 0) throw new IllegalArgumentException("L'indice avuto per argomento deve essere >= 0");

        if (i > dotazioni.size()) throw new IllegalArgumentException("L'indice avuto per argomento non deve essere maggiore della dimensione della lista di dotazioni.");
    
        return dotazioni.get(i);
    }

    /**
     * Restituisce le dotazioni di {@code this}.
     * 
     * @return le dotazioni di {@code this}.
     */
    public ArrayList<Dotazione> getDotazioni() {
        return dotazioni;
    }

    @Override
    public String toString() {
        return "Vagone [dotazioni=" + dotazioni + "]";
    }
}
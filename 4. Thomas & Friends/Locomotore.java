/**
 * OVERVIEW: Locomotore è una classe concreta che implementa metodi e comportamenti di un generico Rotabile e ne estende le funzionalità.
 * Un Locomotore è caratterizzato da un modello, un peso e una potenza.
 * Le istanze di questa classe sono immutabili.
 */

public class Locomotore extends Rotabile {
    /**
     * IR: la potenza del Locomotore deve obbligatoriamente essere positiva.
     * 
     * AF: potenza: il valore della potenza del Locomotore.
     */

    // ATTRIBUTI
    /** La potenza del Locomotore */
    private int potenza;

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire da {@code modello}, {@code peso} e {@code potenza} avuti per argomento.
     * 
     * @param modello Il modello di {@code this}.
     * @param peso Il peso di {@code this}.
     * @param potenza La potenza di {@code this}.
     * 
     * @throws IllegalArgumentException nel caso in cui {@code potenza} non fosse positivo.
     */
    public Locomotore(String modello, int peso, int potenza) {
        super(modello, peso);

        if (potenza <= 0) throw new IllegalArgumentException("La potenza del Locomotore deve essere positiva.");


        this.potenza = potenza;
    }

    // METODI

    @Override
    public String getModello() {
        return super.getModello();
    }

    @Override
    public int getPeso() {
        return super.getPeso();
    }

    /**
     * Restituisce il valore della potenza di {@code this}.
     * 
     * @return Il valore della potenza di {@code this}.
     */
    public int getPotenza() {
        return potenza;
    }

    @Override
    public String toString() {
        return "Locomotore [potenza=" + potenza + "]";
    }
    
}
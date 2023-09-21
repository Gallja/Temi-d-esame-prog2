import java.util.*;

/**
 * OVERVIEW: MolecolaSemplice è una classe concreta che implementa metodi e
 * comportamenti di una generica molecola chimica.
 * Una molecola semplice è rappresentata dall'elemento chimico di cui è composto
 * (che esiste nella tavola periodica) e l'occorrenza dell'elemento stesso
 * all'interno della molecola.
 * Le istanze di questa classe sonoo immutabili.
 */

public class MolecolaSemplice implements Molecola {
    /**
     * IR: L'elemento chimico di cui è composta la molecola non deve essere null.
     * L'elemento chimico di cui è composta la molecola deve essere presente nella
     * tavola periodica.
     * L'occorrenza dell'elemento chimico deve essere positiva.
     * La tavola periodica a cui fa riferimento la molecola non deve essere null.
     * 
     * AF: elemento : l'elemento chimico di cui è composta la molecola.
     * occorrenza : l'occorrenza dell'elemento chimico nella molecola.
     * tavola : la tavola periodica a cui fa riferimento la molecola.
     */

    // ATTRIBUTI
    private final ElementoChimico elemento;
    private final int occorrenza;
    private final TavolaPeriodica tavola;

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire dall'elemento chimico
     * {@code elemento_in}, dall'occorrenza di quest'ultimo {@code occorrenza_in} e
     * dalla tavola periodica {@code tavola_in} avuti per argomento.
     * 
     * @param elemento_in
     * @param occorrenza_in
     * @param tavola_in
     */
    public MolecolaSemplice(final ElementoChimico elemento_in, final int occorrenza_in,
            final TavolaPeriodica tavola_in) {
        Objects.requireNonNull(elemento_in, "L'elemento chimico avuto per argomento non deve essere null.");

        Objects.requireNonNull(tavola_in, "La tavola periodica avuta per argomento non deve essere null.");

        if (occorrenza_in <= 0)
            throw new IllegalArgumentException(
                    "L'occorrenza dell'elemento chimico nella molecola semplice deve essere positiva.");

        this.tavola = tavola_in;

        if (!tavola.nellTavola(elemento_in))
            throw new IllegalArgumentException(
                    "La molecola avuta per argomento deve essere presente all'interno della tavola periodica.");

        this.elemento = elemento_in;
        this.occorrenza = occorrenza_in;
    }

    // METODI

    /**
     * Restituisce l'elemento chimico di {@code this}.
     * 
     * @return L'elemento chimico di {@code this}.
     */
    public ElementoChimico getElemento() {
        return elemento;
    }

    /**
     * Restituisce l'occorrenza dell'elemento chimico di {@code this}.
     * 
     * @return L'occorrenza dell'elemento chimico di {@code this}.
     */
    public int getOccorrenza() {
        return occorrenza;
    }

    @Override
    public String getFormula() {
        return elemento.toString() + occorrenza;
    }

    @Override
    public float getPeso() {
        return elemento.getPeso() * occorrenza;
    }

    @Override
    public String getTipo() {
        return "Semplice";
    }

    @Override
    public String toString() {
        return "MolecolaSemplice [elemento=" + elemento + ", occorrenza=" + occorrenza;
    }

}
import java.util.*;

/**
 * OVERVIEW: ElementoChimico è una classe concreta che implementa stato e
 * comportamenti di un elemento chimico della tavola periodica.
 * Ogni elemento chimico è rappresentato dal suo numero atomico, il nome, il
 * relativo simbolo ed il peso.
 * Le istanze di questa classe sono immutabili.
 */

public class ElementoChimico {
    /**
     * Il nome dell'elemento non deve essere nullo.
     * Il nome dell'elemento non deve essere vuoto.
     * Il simbolo dell'elemento non deve essere nullo.
     * Il simbolo dell'elemento non deve essere vuoto.
     * Il simbolo dell'elemento deve essere presente all'interno della tavola
     * periodica.
     * Il simbolo dell'elemento non deve avere lunghezza superiore di 2 caratteri.
     * Il peso dell'elemento deve essere positivo.
     * 
     * AF: nome : il nome dell'elemento.
     * simbolo : il simbolo dell'elemento.
     * peso : il peso dell'elemento.
     */

    // ATTRIBUTI
    /** Il nome di {@code this} */
    private final String nome;
    /** Il simbolo di {@code this} */
    private final String simbolo;
    /** Il peso in Dalton di {@code this} */
    private final float peso;

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire da {@code nome},
     * {@code simbolo} e {@code peso} avuti per argomento.
     * 
     * @param nome    Il nome dell'elemento chimico.
     * @param simbolo Il simbolo dell'elemento chimico.
     * @param peso    Il peso in Dalton dell'elemento chimico.
     * 
     * @throws NullPointerException     Se {@code nome} è null.
     * @throws NullPointerException     Se {@code simbolo} è null.
     * @throws IllegalArgumentException Se {@code nome} è vuoto.
     * @throws IllegalArgumentException Se {@code simbolo} è vuoto.
     * @throws IllegalArgumentException Se {@code simbolo} ha una lunghezza maggiore
     *                                  di 2 caratteri.
     * @throws IllegalArgumentException Se {@code peso} non è positivo.
     */
    public ElementoChimico(final String nome, final String simbolo, final float peso) {
        Objects.requireNonNull(nome, "Il nome dell'elemento non deve essere nullo.");

        Objects.requireNonNull(simbolo, "Il simbolo dell'elemento non deve essere nullo.");

        if (nome.isEmpty())
            throw new IllegalArgumentException("Il nome dell'elemento non deve essere vuoto.");

        if (simbolo.isEmpty())
            throw new IllegalArgumentException("Il simbolo dell'elemento non deve essere vuoto.");

        if (peso <= 0)
            throw new IllegalArgumentException("Il peso dell'elemento deve essere positivo.");

        if (simbolo.length() > 1)
            throw new IllegalArgumentException("Il simbolo dell'elemento non può avere più di 2 caratteri.");

        this.nome = nome;
        this.simbolo = simbolo;
        this.peso = peso;
    }

    // METODI

    /**
     * Restituisce il nome di {@code this}.
     * 
     * @return Il nome di {@code this}.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Restituisce il simbolo di {@code this}.
     * 
     * @return Il simbolo di {@code this}.
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     * Restituisce il peso in Dalton di {@code this}.
     * 
     * @return Il peso in Dalton di {@code this}.
     */
    public float getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "ElementoChimico [nome=" + nome + ", simbolo=" + simbolo + ", peso=" + peso + "]";
    }
}
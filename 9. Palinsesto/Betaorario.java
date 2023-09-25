/**
 * OVERVIEW: {@code Betaorario }è una classe concreta che implementa stato e
 * metodi di un orario formato da {@code betaore} e {@code betaminuti}.
 * Un'istanza tipica di questa classe è "Betaorario : { x : y }" con
 * {@code x} che corrisponde alle betaore e {@code y} ai betaminuti.<br/>
 * <br/>
 * Le istanze di questa classe sono immutabili.
 */

public class Betaorario implements Comparable<Betaorario> {
    /**
     * IR: Il valore delle betaore di {@code this} deve essere positivo.
     * Il valore delle betaore di {@code this} deve essere <= di 30.
     * Il valore dei betaminuti di {@code this} deve essere positivo.
     * Il valore dei betaminuti di {@code this} deve essere <= 79.
     * 
     * AF: betaore : il numero di betaore di {@code this}
     * betaminuti : il numero di betaminuti di {@code this}
     */

    // ATTRIBUTI
    /** Le betaore di {@code this} */
    private final int betaore;
    /** I minuti di {@code this} */
    private final int betaminuti;

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire dalle {@code betaore} e
     * dai {@code betaminuti} avuti per argomento.
     * 
     * @param betaore    Le betaore con cui si intende istanziare {@code this}.
     * @param betaminuti I betaminuti con cui si intende istanziare {@code this}.
     * 
     * @throws IllegalArgumentException Se {@code betaore} non è compreso fra 0 e 30
     *                                  (estremi inclusi).
     * @throws IllegalArgumentException Se {@code betaminuti} non è compreso fra 0 e
     *                                  79 (estremi inclusi).
     */
    public Betaorario(final int betaore, final int betaminuti) {
        if (betaore < 0 || betaore > 30)
            throw new IllegalArgumentException(
                    "Le betaore avute per argomento devono essere comprese fra 0 e 30, estremi inclusi.");

        if (betaminuti < 0 || betaminuti > 79)
            throw new IllegalArgumentException(
                    "I betaminuti avuti per argomento devono essere compresi fra 0 e 79, estremi inclusi.");

        this.betaore = betaore;
        this.betaminuti = betaminuti;
    }

    // METODI

    /**
     * Restituisce il valore corrispondente al numero di betaore di {@code this}.
     * 
     * @return Il numero di betaore di {@code this}.
     */
    public int getBetaore() {
        return betaore;
    }

    /**
     * Restituisce il valore corrispondente al numero di betaminuti di {@code this}.
     * 
     * @return Il numero di betaminuti di {@code this}.
     */
    public int getBetaminuti() {
        return betaminuti;
    }

    @Override
    public int compareTo(Betaorario o) {
        if (this.getBetaore() > o.getBetaore())
            return 1;

        if (this.getBetaore() < o.getBetaore())
            return -1;

        if (this.getBetaore() == o.getBetaore() && this.getBetaminuti() > o.getBetaminuti())
            return 1;

        if (this.getBetaore() == o.getBetaore() && this.getBetaminuti() < o.getBetaminuti())
            return -1;

        return 0;
    }

    @Override
    public String toString() {
        return "Betaorario : {" + betaore + " : " + betaminuti + "}";
    }
}
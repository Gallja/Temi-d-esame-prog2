/**
 * OVERVIEW: StellaFissa è una classe concreta che estende stato e comportamenti di un generico corpo celeste.
 * Ogni stella fissa è caratterizzata dal nome e dalla posizione.
 * Le istanze di questa classe sono immutabili.
 */

public class StellaFissa extends CorpoCeleste {
    /**
     * IR: 
     * 
     * AF: 
     */

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire dal {@code nome} e dalla posizione {@code pos} avuti per argomento.
     * 
     * @param nome Il nome di {@code this}
     * @param pos La posizione di {@code this}
     */
    public StellaFissa(final String nome, final PuntoTreDimensioni pos) {
        super(nome, pos);
    }

    // METODI
    
    @Override
    public void attrazione(CorpoCeleste c) {
        return;
    }

    @Override
    public String toString() {
        return "StellaFissa ["+ super.toString() +"]";
    }
}
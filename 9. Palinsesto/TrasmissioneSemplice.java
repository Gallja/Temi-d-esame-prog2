import java.util.*;

/**
 * OVERVIEW: TrasmissioneSemplice è una classe concreta che implementa metodi e
 * comportamenti di una Trasmissione.
 * Una trasmissione semplice è caratterizzata dal proprio titolo e l'unica
 * fascia betaoraria alla quale è associata.
 * Le istanze di questa classe sono immutabili.
 */

public class TrasmissioneSemplice implements Trasmissione {
    /**
     * IR: Il titolo di {@code this} non deve essere null.
     * Il titolo di {@code this} non deve essere vuoto.
     * La fascia oraria di {@code this} non deve essere null.
     * 
     * AF: titolo : il titolo di {@code this}
     * fascia : la fascia betaoraria alla quale è associata {@code this}
     */

    // ATTRIBUTI
    /** Il titolo di {@code this} */
    private final String titolo;
    /** La fascia oraria di {@code this} */
    private final FasciaBetaoraria fascia;

    // COSTRUTTORE

    public TrasmissioneSemplice(String titolo, FasciaBetaoraria fascia) {
        this.titolo = titolo;
        this.fascia = fascia;
    }

    // METODI

    @Override
    public Collection<FasciaBetaoraria> getFasce() {
        Collection<FasciaBetaoraria> fasceUnica = new ArrayList<FasciaBetaoraria>();
        fasceUnica.add(fascia);

        return Collections.unmodifiableCollection(fasceUnica);
    }

    @Override
    public String getTitolo() {
        return titolo;
    }

    @Override
    public String toString() {
        return "TrasmissioneSemplice [titolo=" + titolo + ", fascia=" + fascia + "]";
    }

}
import java.util.*;

/**
 * OVERVIEW: FasciaBetaoraria è una classe concreta che implementa stato, metodi
 * e comportamenti di una fascia betaoraria di un evento generico con un inizio,
 * una durata ed una fine.
 * Le istanze di questa classe sono immutabili.
 */

public class FasciaBetaoraria {
    /**
     * IR: Il betaorario di inizio di {@code this} non deve essere null.
     * Il betaorario di durata di {@code this} non deve essere null.
     * Il betaorario di fine di {@code this} non deve essere null.
     * Il betaorario di inizio e di fine di {@code this} non devono coincidere.
     * Il betaorario di inizio di {@code this} deve essere minore di quello di fine.
     * 
     * AF: inizio : l'inizio di {@code this}
     * durata : la durata, in betaminuti, di {@code this}
     * fine : la fine di {@code this}
     */

    // ATTRIBUTI
    /** L'inizio di {@code this} */
    private final Betaorario inizio;
    /** La duranta di {@code this} */
    private final Betaorario durata;
    /** La fine di {@code this} */
    private final Betaorario fine;

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire dall' {@code inizio} e
     * dalla {@code durata} avuti per argomento.
     * 
     * @param inizio L'inizio con cui si intende istanziare {@code this}.
     * @param durata La durata di {@code this}.
     * 
     * @throws NullPointerException    Se {@code inizio} è null.
     * @throws NullPointerException    Se {@code durata} è null.
     * @throws IllegalArgumentExcepton Se {@code durata} è tale per cui {@code fine}
     *                                 non è nello stesso giorno di {@code inizio}.
     */
    public FasciaBetaoraria(final Betaorario inizio, final Betaorario durata) {
        Objects.requireNonNull(inizio, "L'inizio della fascia betaoraria non deve essere null.");

        Objects.requireNonNull(durata, "La durata della fascia betaoraria non deve essere null.");

        this.inizio = inizio;
        this.durata = durata;

        this.fine = inizio.sommaBetaorario(durata);

        if (inizio.getBetaore() < fine.getBetaore())
            throw new IllegalArgumentException(
                    "La durata avuta per argomento non deve far sforare il giorno di 79 betaore.");
    }

    // METODI

    /**
     * Restituisce un Betaorario corrispondente all'inizio di {@code this}.
     * 
     * @return L'inizio di {@code this}.
     */
    public Betaorario getInizio() {
        return inizio;
    }

    /**
     * Restituisce un Betaorario corrispondente alla durata di {@code this}.
     * 
     * @return La durata di {@code this}.
     */
    public Betaorario getDurata() {
        return durata;
    }

    /**
     * Restituisce un Betaorario corrispondente alla fine di {@code this}.
     * 
     * @return La fine di {@code this}.
     */
    public Betaorario getFine() {
        return fine;
    }

    @Override
    public String toString() {
        return "FasciaBetaoraria [inizio=" + inizio.toString() + ", durata=" + durata.toString() + ", fine="
                + fine.toString() + "]";
    }

}
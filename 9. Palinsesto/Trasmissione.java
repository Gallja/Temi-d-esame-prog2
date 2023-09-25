import java.util.*;

/**
 * OVERVIEW: Trasmissione è un'interfaccia che elenca metodi e specifiche di
 * comportamento di una generica trasmissione.
 * Poiché le trasmissioni possono essere molte e di diverse tipologie, è utile
 * che queste ultime implementino a dovere le specifiche di comportamento
 * comune.
 */

public interface Trasmissione {

    /**
     * Restituisce il titolo di {@code this}.
     * 
     * @return Il titolo di {@code this}.
     */
    String getTitolo();

    /**
     * Restituisce le fasce betaorarie di {@code this}.
     * 
     * @return Le fassce betaorarie di {@code this}.
     */
    Collection<FasciaBetaoraria> getFasce();
}
/**
 * OVERVIEW: Rivestimento è un'interfaccia atta a rappresentare metodi e
 * comportamenti di un rivestimento di un ambiente (casa, locale, ecc...).
 */

public interface Rivestimento {

    /**
     * Restituisce un intero corrispondente al costo della pavimentazione
     * desiderata.
     * 
     * @return il costo della pavimentazione
     */
    int get_costo();

    /**
     * Restituisce un intero corrispondente alla superficie totale della
     * pavimentazione desiderata.
     * 
     * @return la superficie della pavimentazione
     */
    int get_superficie();
}
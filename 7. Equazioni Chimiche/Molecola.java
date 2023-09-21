/**
 * OVERVIEW: Molecola è un'interfaccia che implementa metodi e comportamenti di
 * una generica molecola formata da elementi chimici.
 */

public interface Molecola {
    // METODI

    /**
     * Resituisce una stringa corrispondente alla formula di {@code this}
     * nell'ordine stabilito dalla convenzione di Hill.
     * La convenzione di Hill la molecola deve essere scritta con gli elementi
     * nell'ordine C, H, N e O seguiti dagli altri elementi in ordine alfabetico del
     * simbolo e, se la numerosità dell'elemento è pari a 1, tale numero viene
     * omesso.
     * 
     * @return La stringa corrispondente alla formula di {@code this} nell'ordine di
     *         Hill.
     */
    String getFormula();

    /**
     * Restituisce un valore corrispondente al peso complessivo di {@code this}.
     * 
     * @return Il peso complessivo di {@code this}.
     */
    float getPeso();

    /**
     * Restituisce una stringa che indichi la tipologia di {@code this} in quanto
     * molecola. <br/>
     * <br/>
     * Può essere {@code Semplice} o {@code Composta}.
     * 
     * @return {@code Semplice/Composta} in base alla tipologia di Molecola
     *         {@code this}.
     */
    String getTipo();
}
import java.util.*;

/**
 * OVERVIEW: MolceolaComposta è una classe concreta che implementa metodi e
 * comportamenti di una molecola generica.
 * Una molecola composta è rappresentata dagli elementi chimici di cui è
 * composta con relativa numerosità di quest'ultimo nella formula.
 * Le istanze di questa classe sono immutabili.
 */

public class MolecolaComposta implements Molecola, Iterable<ElementoChimico> {

    /**
     * IR: La mappa che tiene traccia degli elementi chimici della molecola non deve
     * essere null.
     * La mappa che tiene traccia degli elementi chimici della molecola non deve
     * contenere valori null.
     * 
     * AF:
     */

    // ATTRIBUTI
    /** La mappa che contiene gli elementi chimici di {@code this} */
    private final Map<ElementoChimico, Integer> elMolecola = new HashMap<ElementoChimico, Integer>();
    /**
     * La tavola periodica a cui fanno riferimento gli elementi chimici di
     * {@code this}
     */
    private final TavolaPeriodica tavola;

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire dalla tavola periodica
     * {@code tavola_in} e dalla molecola {@code elMolecola_in} avuti per argomento.
     * 
     * @param tavola_in     La tavola periodica di cui devono far parte gli elementi
     *                      chimici di {@code this}.
     * @param elMolecola_in La mappa con la molecola composta dalla quale costruire
     *                      {@code this}.
     * 
     * @throws NullPointerException     Se {@code tavola_in} è null.
     * @throws NullPointerException     Se {@code elMolecola_in} è null.
     * @throws NullPointerException     Se {@code elMolecola_in} contiene valori
     *                                  null.
     * @throws IllegalArgumentException Se {@code elMolecola_in} contiene un
     *                                  elemento
     *                                  chimico non prensente in {@code tavola_in}.
     */
    public MolecolaComposta(final TavolaPeriodica tavola_in, final Map<ElementoChimico, Integer> elMolecola_in) {
        Objects.requireNonNull(tavola_in, "La tavola periodica avuta per argomento non deve essere nulla.");

        Objects.requireNonNull(elMolecola_in,
                "La mappa con gli elementi chimici che compongono la molecola avuta per argomento non deve essere null.");

        this.tavola = tavola_in;

        for (Map.Entry<ElementoChimico, Integer> entry : elMolecola_in.entrySet()) {
            Objects.requireNonNull(entry.getKey(), "Gli elementi della molecola non devono essere null.");

            Objects.requireNonNull(entry.getValue(),
                    "L'occorrenza dell'elemento chimico nella molecola non deve essere null.");

            if (!tavola.nellTavola(entry.getKey()))
                throw new IllegalArgumentException(
                        "Tutti gli elementi della molecola avuta per argomento devono essere presenti nella tavola periodica.");

            elMolecola.put(entry.getKey(), entry.getValue());
        }
    }

    // METODI

    /**
     * Modifica {@code this} ordinandone gli elementi secondo convenzione di Hill.
     * 
     * La convenzione di Hill la molecola deve essere scritta con gli elementi
     * nell'ordine C, H, N e O seguiti dagli altri elementi in ordine alfabetico del
     * simbolo e, se la numerosità dell'elemento è pari a 1, tale numero viene
     * omesso.
     */
    private void ordina() {

    }

    @Override
    public String getFormula() {
        return null;
    }

    @Override
    public float getPeso() {
        float pesoTot = 0;

        for (Map.Entry<ElementoChimico, Integer> entry : elMolecola.entrySet()) {
            pesoTot += entry.getKey().getPeso() * entry.getValue();
        }

        return pesoTot;
    }

    @Override
    public String getTipo() {
        return "Composta";
    }

    @Override
    public Iterator<ElementoChimico> iterator() {
        return elMolecola.keySet().iterator();
    }

    @Override
    public String toString() {
        return "MolecolaComposta [elMolecola=" + elMolecola + ", tavola=" + tavola + "]";
    }

}
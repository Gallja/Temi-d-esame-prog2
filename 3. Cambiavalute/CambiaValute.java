import java.util.*;

/**
 * OVERVIEW: CambiaValute è una classe concreta con lo scopo di rappresentare metodi e comportamenti di un reale cambiavalute;
 * Il CambiaValute permette, avendo un Cassa, di cambiare a richiesta un Importo.
 * Le istanze di questa classe sono mutabili.
 */

public class CambiaValute {
    /**
     * IR: La CassaMultivalore non deve essere nulla.
     * La lista di tassi di cambio non deve essere nulla.
     * Tutti gli elementi della lista dei tassi di cambio non devono essere nulli.
     * 
     * AF: cassa: la CassaMultivalore che contiene gli Importi del Cambiavalute.
     * tassi: la lista contenente i vari Tassi di Cambio per convertire gli Importi se necessario.
     */

    // ATTRIBUTI
    private CassaMultivalore cassa;
    private ArrayList<TassoDiCambio> tassi = new ArrayList<TassoDiCambio>();

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire da una lista di importi {@code importi} e una lista di tassi di cambio {@code tassi_in}.
     * 
     * @param importi la lista di Importi che contiene la Cassa del Cambiavalute.
     * @param tassi_in la lista di Tassi di Cambio.
     * 
     * @throws NullPointerException nel caso in cui {@code importi} fosse nullo.
     * @throws NullPointerException nel caso in cui {@code tassi_in} fosse nullo.
     * @throws NullPointerException nel caso in cui un elemento di {@code tassi_in} fosse nullo.
     */
    public CambiaValute(ArrayList<Importo> importi, ArrayList<TassoDiCambio> tassi_in) {
        Objects.requireNonNull(importi, "La lista di importi avuta per argomento non deve essere nulla.");

        Objects.requireNonNull(tassi_in, "La lista di tassi di cambio avuta per argomento non deve essere nulla.");

        cassa = new CassaMultivalore(importi);

        for (TassoDiCambio t : tassi_in) {
            Objects.requireNonNull(t, "Tutti gli elementi della lista di tassi di cambio avuta per argomento non devono essere nulli.");

            tassi.add(t);
        }
    }

    // METODI

    /**
     * Effettua un cambio a partire 
     */
    public void cambio() {

    }
}
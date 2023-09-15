import java.util.*;

/**
 * OVERVIEW: CambiaValute è una classe concreta con lo scopo di rappresentare metodi e comportamenti di un reale cambiavalute;
 * Il CambiaValute permette, avendo un Cassa, di cambiare a richiesta un Importo.
 * Le istanze di questa classe sono mutabili.
 */

public class CambiaValute implements Iterable<TassoDiCambio> {
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
     * Aggiorna un Tasso di Cambio in base all'indice {@code index} e agli Importi {@code importo1} ed {@code importo2} forniti per argomento.
     * 
     * @param index la posizione del Tasso da aggiornare
     * @param importo1 Il primo Importo 
     * @param importo2 Il secondo Importo
     * 
     * @throws NullPointerException nel caso in cui {@code importo1} fosse nullo.
     * @throws NullPoinerException nel caso in cui {@code importo2} fosse nullo.
     * @throws IllegalArgumentException nel caso in cui {@code index} non fosse positivo.
     * @throws IllegalArgumentException nel caso in cui {@code index} fosse maggiore della dimensione della lista di Tassi di Cambio.
     * @throws IllegalArgumentException nel caso in cui {@code importo1} e {@code importo2} avessero la stessa valuta.
     * @throws IllegalArgumentException nel caso in cui {@code importo1} o {@code importo2} avessero una valuta differente rispetto a quella della lista all'indice {@code index} avuto per argomento.
     */
    public void aggiornaTasso(int index, Importo importo1, Importo importo2) {
        Objects.requireNonNull(importo1, "Il primo Importo non deve essere nullo.");
        Objects.requireNonNull(importo2, "Il secondo Importo non deve essere nullo.");

        if (index < 0)
            throw new IllegalArgumentException("L'indice della lista avuto per argomento deve obbligatoriamente essere positivo.");
        
        if (index > tassi.size())
            throw new IllegalArgumentException("L'indice della lista avuto per argomento è maggiore rispetto alla dimensione della lista di Tassi.");

        if (importo1.getValuta() == importo2.getValuta())
            throw new IllegalArgumentException("Le valute dei 2 importi devono obbligatoriamente essere diverse.");
        
        if (tassi.get(index).getImporto1().getValuta() != importo1.getValuta() || tassi.get(index).getImporto2().getValuta() != importo2.getValuta())
            throw new IllegalArgumentException("");

        TassoDiCambio ris = new TassoDiCambio(importo1, importo2);
        tassi.remove(index);
        tassi.add(ris);
    }

    /**
     * Aggiugne un nuovo Tasso di Cambio a {@code this} a partire dagli importi {@code importo1} ed {@code importo2} avuti per argomento.
     * 
     * @param importo1 Il primo Importo del Tasso da aggiungere.
     * @param importo2 Il secondo Importo del Tasso da aggiungere.
     * 
     * @throws NullPointerException nel caso in cui {@code importo1} fosse nullo.
     * @throws NullPointerException nel caso in cui {@code importo2} fosse nullo.
     * @throws IllegalArgumentException nel caso in cui il Tasso di Cambio che si intende inserire tramite {@code importo1} e {@code importo2} fosse già presente in {@code this}.
     */
    public void aggiugniTasso(Importo importo1, Importo importo2) {
        Objects.requireNonNull(importo1, "Il primo Importo non deve essere nullo.");
        Objects.requireNonNull(importo2, "Il secondo Importo non deve essere nullo.");

        for (TassoDiCambio t : tassi) {
            if (t.getImporto1().getValuta() == importo1.getValuta() || t.getImporto2().getValuta() == importo2.getValuta())
                throw new IllegalArgumentException("Il Tasso di Cambio che si desidera inserire è già presente.");
        }

        TassoDiCambio ris = new TassoDiCambio(importo1, importo2);
        tassi.add(ris);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(cassa.toString()).append("\n");
        for (TassoDiCambio t : tassi) {
            sb.append(t.toString()).append("\n");
        }

        return sb.toString();
    }

    @Override
    public Iterator<TassoDiCambio> iterator() {
        return tassi.iterator();
    }
}
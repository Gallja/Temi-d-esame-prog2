import java.util.*;

/**
 * OVERVIEW: SistemaAstronomico è una classe concreta che implementa stato e comportamenti di un sistema astronomico di corpi celesti.
 * Un sistema astronomico è caratterizzato da una serie di corpi celesti.
 * Le istanze di questa classe sono mutabili.
 */

public class SistemaAstronomico implements Iterable<CorpoCeleste> {
    /**
     * IR: La lista di corpi celesti facenti parte del sistema astronomico non deve essere null.
     * Ogni elemento della lista di corpi celesti non deve essere null.
     * X
     * AF: corpi : la lista contenente i corpi celesti del sistema astronomico.
     */

    // ATTRIBUTI
    /** La lista di corpi celesti del sistema astronomico */
    List<CorpoCeleste> corpi = new ArrayList<CorpoCeleste>();

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire dalla lista {@code corpi_in} fornita per argomento.
     * 
     * @param corpi_in la lista di corpi di {@code this}
     * 
     * @throws NullPointerException se {@code corpi_in} è null.
     * @throws NullPointerException se {@code corpi_in} contiene uno o più valori null.
     */
    public SistemaAstronomico(final List<CorpoCeleste> corpi_in) {
        Objects.requireNonNull(corpi_in, "La lista di corpi celesti non deve essere null.");

        for (CorpoCeleste c : corpi_in) {
            Objects.requireNonNull(c, "La lista di corpi celesti non deve avere valori null.");

            corpi.add(c);
        }
    }

    // METODI

    /**
     * Restituisce i corpi celesti facenti parte di {@code this}.
     * 
     * @return I corpi celesti di {@code this}
     */
    public List<CorpoCeleste> getCorpi() {
        return Collections.unmodifiableList(corpi);
    }


    /**
     * Restituisce il corpo celeste di {@code this} alla posizione {@code i} avuta per argomento.
     * 
     * @param i La posizione del corpo celeste di {@code this} che si intende ottenere.
     * 
     * @return Il corpo celeste desiderato di {@code this}.
     * 
     * @throws IllegalArgumentException se i è < 0.
     * @throws IllegalArgumentException se i è maggiore della dimensione di {@code this}.
     */
    public CorpoCeleste getCorpo(final int i) {
        if (i < 0) throw new IllegalArgumentException("La posizione avuta per argomento deve essere >= 0.");

        if (i > corpi.size()) throw new IllegalArgumentException("La posizione avuta per argomento non deve essere > della dimensione del sistema astronomico.");

        return corpi.get(i);
    }

    /**
     * Aggiunge un corpo celeste {@code corpo} a {@code this}.
     * 
     * @param corpo Il corpo celeste da aggiungere a {@code this}.
     * 
     * @throws NullPointerException Se {@code corpo} è null.
     */
    public void setCorpo(CorpoCeleste corpo) {
        Objects.requireNonNull(corpo, "Il corpo avuto per argomento non deve essere null.");

        corpi.add(corpo);
    }

    /**
     * Modifica {@code this} facendo interagire fra di loro i corpi celesti che ne fanno parte.
     * L'interazione tra corpi celesti consiste nella modifica della velocità, e solo dopo anche della posizione, di un corpo c con tutti gli altri.
     *
     */
    public void interazionePianeti() {
        for (int i = 0; i < corpi.size(); i++) {
            for (int j = 0; j < corpi.size(); j++) {
                if (i == j) continue;
                corpi.get(i).attrazione(corpi.get(j));
            }
        }

        for (int i = 0; i < corpi.size(); i++) {
            corpi.get(i).modPos();
        }
    }

    /**
     * Restituisce un valore corrispondente all'energia totale di {@code this}. <br/><br/>
     * L'energia totale è pari alla somma di tutte le energie dei corpi celesti di {@code this}.
     * 
     * @return Il valore corrispondente all'energia totale di {@code this}
     */
    public int energiaTot() {
        int tot = 0;

        for (CorpoCeleste c : corpi) {
            tot += c.energiaCorpo();
        }

        return tot;
    }

    @Override
    public Iterator<CorpoCeleste> iterator() {
        return corpi.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (CorpoCeleste c : corpi) {
            sb.append(c.toString()).append("\n");
        }

        sb.append(energiaTot());

        return sb.toString();
    }

}
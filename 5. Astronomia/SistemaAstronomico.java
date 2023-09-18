import java.util.*;

/**
 * OVERVIEW: SistemaAstronomico è una classe concreta che implementa stato e comportamenti di un sistema astronomico di corpi celesti.
 * Un sistema astronomico è caratterizzato da una serie di corpi celesti.
 * Le istanze di questa classe sono mutabili.
 */

public class SistemaAstronomico {
    /**
     * IR: La lista di corpi celesti facenti parte del sistema astronomico non deve essere null.
     * Ogni elemento della lista di corpi celesti non deve essere null.
     * 
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
    public String toString() {
        return "SistemaAstronomico [corpi=" + corpi + "]" + energiaTot();
    }
}
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/**
 * OVERVIEW: Pavimentazione è una classe concreta che implementa metodi e
 * comportamenti di una pavimentazione di un ambiente.
 * Le istanze di questa classe sono immutabili.
 */

public class Pavimentazione implements Rivestimento, Iterable<Pavimentazione.Componente> {
    /**
     * OVERVIEW: Componente è una classe concreta che implementa stato e metodi di
     * un componente formato da una certa pavimentazione con relativa quantità.
     * Le istanze di questa classe sono immutabili.
     */

    public static class Componente implements Rivestimento {
        /**
         * IR: Il rivestimento di un Componente non deve essere nullo.
         * La quantità di rivestimento di un Componente deve obbligatoriamente essere
         * positiva.
         * 
         * AF: rivestimento: il rivestimento che forma il compoenente.
         * quantita: la quantità di rivestimento del componente.
         */

        // ATTRIBUTI
        /**
         * Il Rivestimento della Pavimentazione e la relativa quantità di quest'ultimo
         */
        public final Rivestimento rivestimento;
        public int quantita;

        // COSTRUTTORE

        /**
         * Costruisce un nuovo oggetto Componente a partire dal Rivestimento e dalla
         * quantità avuti per argomento.
         * 
         * @throws NullPointerException     nel caso in cui il Rivestimento avuto per
         *                                  argomento fosse nullo
         * 
         * @throws IllegalArgumentException nel caso in cui la quantita avuta per
         *                                  argomento
         *                                  non fosse positiva
         */
        public Componente(final int quantita, final Rivestimento rivestimento) {
            Objects.requireNonNull(rivestimento, "Il rivestimento avuto per argomento non deve essere nullo.");

            if (quantita <= 0)
                throw new IllegalArgumentException(
                        "La quantita del componenete avuta per argomento deve essere positiva.");

            this.rivestimento = rivestimento;
            this.quantita = quantita;
        }

        // METODI

        @Override
        public int get_costo() {
            return quantita * rivestimento.get_costo();
        }

        @Override
        public int get_superficie() {
            return quantita * rivestimento.get_superficie();
        }

    }

    /**
     * IR: La collezione di componenti non deve essere nulla.
     * La collezione di componenti non deve essere vuota.
     * 
     * AF: componenti: una lista di componenti atta a rappresentare la
     * pavimentazione di un qualsiasi ambiente.
     */

    // ATTRIBUTI
    /** La collezione di componenti che compongono la Pavimentazione */
    private final Collection<Componente> componenti = new ArrayList<>();

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto Pavimentazione a partire da una collezione di
     * componenti avuta per argomento.
     * 
     * @throws NullPointerException     nel caso in cui la collezione di componenti
     *                                  avuta
     *                                  per argomento fosse nulla.
     * 
     * @throws IllegalArgumentException nel caso in cui la collezione di componenti
     *                                  avuta
     *                                  per argomento fosse vuota.
     */
    public Pavimentazione(final Collection<Componente> componenti_in) {
        Objects.requireNonNull(componenti_in,
                "La collezione di componenti fornita per argomento non deve essere nulla.");

        if (componenti_in.isEmpty())
            throw new IllegalArgumentException("La collezione di componenti non deve essere vuota.");

        for (Componente c : componenti_in) {
            componenti.add(c);
        }
    }

    // METODI

    @Override
    public int get_costo() {
        int tot = 0;
        for (final Rivestimento r : componenti) {
            tot += r.get_costo();
        }

        return tot;
    }

    @Override
    public int get_superficie() {
        int tot = 0;
        for (final Rivestimento r : componenti) {
            tot += r.get_superficie();
        }

        return tot;
    }

    @Override
    public Iterator<Pavimentazione.Componente> iterator() {
        return componenti.iterator();
    }
}
/**
 * OVERVIEW: Dotazione è una classe concreta atta a rappresentare le dotazioni di cui è composto il vagone di un treno.
 * Una Dotazione è rappresentata dal suo nome e la relativa quantità.
 * Le istanze di questa classe sono immutabili.
 */

public class Dotazione {
    /**
     * IR: Il nome della Dotazione non deve essere nullo.
     * Il nome della Dotazione non deve essere vuoto.
     * La quantità di Dotazione deve obbligatoriamente essere positiva.
     * 
     * AF: nome: il nome della Dotazione nel vagone.
     * quantita: la quantita di Dotazione nel vagone.
     */

    // ATTRIBUTI
    /** Il nome della Dotazione e la relativa quantità all'interno del vagone */
    public String nome;
    public int quantita;

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire dal {@code nome} e la relativa {@code quantita} avuti per argomento.
     * 
     * @param nome Il nome della {@code this}
     * @param quantita La quantità di {@code this}
     * 
     * @throws NullPointerException nel caso in cui {@code nome} fosse nullo.
     * @throws IllegalArgumentException nel caso in cui {@code nome} fosse vuoto.
     * @throws IllegalArgumentException nel caso in cui {@code quantita} non fosse positivo.
     */
    public Dotazione(final String nome, final int quantita) {
        Objects.requireNonNull(nome, "Il nome della Dotazione avuto per argmento non deve essere nullo.");

        if (nome.isEmpty()) throw new IllegalArgumentException("Il nome avuto per argomento non deve essere vuoto.");

        if (quantita <= 0) throw new IllegalArgumentException("La quantita avuta per argomento deve essere positiva.");

        this.nome = nome;
        this.quantita = quantita;
    }

    // MET0DI

    /**
     * Restituisce il nome di {@code this}.
     * 
     * @return la stringa corrispondente al nome di {@code this}.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Restituisce la quantità di {@code this}.
     * 
     * @return il valore corrispondente alla quantità di {@code this}.
     */
    public int getQuantita() {
        return quantita;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dotazione other = (Dotazione) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Dotazione [nome=" + nome + ", quantita=" + quantita + "]";
    }

}
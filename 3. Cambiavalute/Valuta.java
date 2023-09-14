import java.util.Objects;

/**
 * OVERVIEW: Valuta è una classe concreta che rappresenta una valuta
 * caratterizzata da un nome e da un simbolo.
 * Le istanze di questa classe sono immutabili.
 */

public enum Valuta {

    $("Dollaro", '$'),
    €("Euro", '€'),
    ₣("Franco", '₣'),
    ₺("Lira", '₺'),
    ₹("Rupia", '₹'),
    £("Sterlina", '£'),
    ¥("Yen", '¥');

    /**
     * IR: Il nome della valuta non deve essere vuoto.
     * Il nome della valuta non deve essere nullo.
     * 
     * AF: nome: il nome della Valuta
     * simbolo: il simbolo corrispondente della Valuta
     */

    // ATTRIBUTI
    /** Il nome della Valuta e il relativo simbolo */
    private final String nome;
    private final char simbolo;

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto Valuta a partire da {@code nome} e
     * {@code simbolo} avuti per argomento.
     * 
     * @throws IllegalArgumentException nel caso in cui {@code nome} fosse vuoto.
     * 
     * @throws NullPointerException     nel caso in cui {@code nome} fosse nullo.
     * 
     * @param nome    il nome della Valuta
     * @param simbolo il corrispondente simbolo della Valuta
     */
    Valuta(final String nome, final char simbolo) {
        if (nome.isEmpty())
            throw new IllegalArgumentException("Il nome della Valuta avuta per argomento non deve eessere nulla.");

        this.nome = Objects.requireNonNull(nome, "Il nome della Valuta avuto per argomento non deve essere nullo.");
        this.simbolo = simbolo;
    }

    // METODI

    /**
     * Restituisce una stringa corrispondente al nome della Valuta.
     * 
     * @return Stringa corrispondente al nome della valuta, non è mai vuota o nulla.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Restituisce un carattere corrispondente al simbolo della Valuta.
     * 
     * @return il simbolo della Valuta.
     */
    public char getSimbolo() {
        return simbolo;
    }

    @Override
    public String toString() {
        return "Valuta [nome = " + nome + ", simbolo = " + simbolo + "]";
    }
}
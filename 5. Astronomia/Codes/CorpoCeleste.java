package Codes;
import java.util.*;

/**
 * OVERVIEW: CorpoCeleste è una classe astratta che rappresenta stato e comportamenti di un corpo celeste nel cosmo.
 * Un corpo celeste è caratterizzato dal suo nome e dalla posizione.
 * Le istanze di questa classe sono mutabili.
 */

public abstract class CorpoCeleste {
    /**
     * IR: Il nome del corpo celeste non deve essere null.
     * Il nome del corpo celeste non deve essere vuoto.
     * La posizione del corpo celeste non deve essere nulla.
     * 
     * AF: nome : il nome del corpo celeste.
     * pos : la posizione del corpo celeste.
     */

    // ATTRIBUTI
    /** Il nome del corpo celeste */
    private final String nome;
    /** La posizione del corpo celeste */
    private final PuntoTreDimensioni pos;

    // COSTRUTTORE

    /**
     * Costruisce un nouvo oggetto {@code this} a partire dal {@code nome} e la posizione {@code pos} avuti per argomento.
     * 
     * @param nome Il nome di {@code this}
     * @param pos La posizione tridimensionale di {@code this}
     * 
     * @throws NullPointerException se {@code nome} è null.
     * @throws IllegalArgumentException se {@code nome} è vuoto.
     * @throws NullPointerException se {@code pos} è null.
     */
    public CorpoCeleste(final String nome, final PuntoTreDimensioni pos) {
        Objects.requireNonNull(nome, "Il nome del corpo celeste non deve essere null.");

        Objects.requireNonNull(pos, "La posizione avuta per argomento non deve essere null");

        if (nome.isEmpty()) throw new IllegalArgumentException("Il nome del corpo celeste non deve essere vuoto.");

        this.nome = nome;
        this.pos = pos;
    }

    // METODI

    /**
     * Restituisce il nome di {@code this}.
     * 
     * @return Il nome di {@code this}
     */
    public String getNome() {
        return nome;
    }

    /**
     * Restituisce la posizione di {@code this}.
     * 
     * @return La posizione di {@code this}
     */
    public PuntoTreDimensioni getPos() {
        return new PuntoTreDimensioni(pos);
    }

    /**
     * Restituisce un valore corrispondente all'energia potenziale di {@code this}.
     * 
     * @return L'energia potenziale di {@code this}
     */
    public int energiaPotenziale() {
        return (int) Math.sqrt(pos.getX() * pos.getX() + pos.getY() * pos.getY() + pos.getZ() * pos.getZ());
    }

    /**
     * Restituisce un valore corrispondente all'energia cinetica di {@code this}.
     * 
     * @return L'energia cinetica di {@code this}
     */
    public int energiaCinetica() {
        return 0;
    }

    /**
     * Restituisce un valore corrispondente all'energia di {@code this}.<br/><br/>
     * L'energia si calcola moltiplicando l'energia potenziale per l'energia cinetica.
     * 
     * @return L'energia di {@code this}
     */
    public int energiaCorpo() {
        return energiaCinetica() * energiaPotenziale();
    }

    /**
     * Modifica la velocità di {@code this} in funzione dell'attrazione verso tutti gli altri corpi celesti.
     * 
     * @param c Il corpo celeste con cui viene modificata la velocità di {@code this}
     */
    public abstract void attrazione(CorpoCeleste c);

    /**
     * Modifica la velocità di {@code this} solo dopo gli effetti causati dall' {@code attrazione}.
     *
     */
    public abstract void modPos();

    @Override
    public String toString() {
        return nome + ", pos: " + pos + "]";
    }
    
}
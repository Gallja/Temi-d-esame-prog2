import java.util.*;

/**
 * OVERVIEW: Pianeta è una classe concreta che implementa ed estende metodi e comportamenti di un generico corpo celeste.
 * Un pianeta è rappresentato dal suo nome, dalla sua posizione e dalla sua velocità.
 * Le istanze di questa classe sono mutabili.
 */

public class Pianeta extends CorpoCeleste {
    /**
     * IR: La velocità del pianeta non deve essere nulla.
     * 
     * AF: vel : la velocità, espressa con 3 dimensioni, del Pianeta
     */

    // ATTRIBUTI
    /** La velocità, espressa in 3 dimensioni, del Pianeta */
    final PuntoTreDimensioni vel;

    // COSTRUTTORE
    
    /**
     * Costruisce un nuovo oggetto {@code this} a partire dal {@code nome}, dalla posizione {@code pos} e della velocità {@code vel} avuti per argomento.
     * 
     * @param nome Il nome di {@code this}
     * @param pos La posizione di {@code this}
     * @param vel La velocità di {@code this}
     * 
     * @throws NullPointerException se {@code vel} è null.
     */
    public Pianeta(final String nome, final PuntoTreDimensioni pos, final PuntoTreDimensioni vel) {
        super(nome, pos);

        Objects.requireNonNull(vel, "La velocità avuta per argomento non deve essere nulla.");

        this.vel = vel;
    }

    // METODI

    @Override
    public int energiaCinetica() {
        return (int) Math.sqrt(vel.getX() * vel.getX() + vel.getY() * vel.getY() + vel.getZ() * vel.getZ());
    }

    @Override
    public int energiaCorpo() {
        return energiaCinetica() * super.energiaPotenziale();
    }

    @Override
    public void attrazione(CorpoCeleste c) {
        if (this.getPos().getX() > c.getPos().getX()) {
            this.getPos().setX(this.getPos().getX() + 1);
        } else {
            if (this.getPos().getX() < c.getPos().getX()) {
                this.getPos().setX(this.getPos().getX() - 1);
            } else {
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Pianeta" + super.toString() + "[vel=" + vel + "]";
    }
}
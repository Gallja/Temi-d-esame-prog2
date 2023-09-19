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

    /**
     * Restituisce un valore tridimensionale corrispondente alla velocità di {@code this}.
     * 
     * @return La velocità di {@code this}
     */
    public PuntoTreDimensioni getVel() {
        return vel;
    }

    @Override
    public void attrazione(CorpoCeleste c) {
        int x = this.getPos().getX();
        int y = this.getPos().getY();
        int z = this.getPos().getZ();

        if (x > c.getPos().getX()) {
            this.vel.setX(vel.getX() - 1);
        } else if (x < c.getPos().getX()) {
            this.vel.setX(vel.getX() + 1);
        }

        if (y > c.getPos().getY()) {
            this.vel.setY(vel.getY() - 1);
        } else if (y < c.getPos().getY()) {
            this.vel.setY(vel.getY() + 1);
        }

        if (z > c.getPos().getZ()) {
            this.vel.setZ(vel.getZ() - 1);
        } else if (z < c.getPos().getZ()) {
            this.vel.setZ(vel.getZ() + 1);
        }
    }
    
    /**
     * Modifica la velocità di {@code this} solo dopo gli effetti causati dall' {@code attrazione}.
     *
     */
    public void modPos() {
        int x = this.getPos().getX();
        int y = this.getPos().getY();
        int z = this.getPos().getZ();

        this.getPos().setX(x + this.vel.getX());
        this.getPos().setY(y + this.vel.getY());
        this.getPos().setZ(z + this.vel.getZ());
    }
    

    @Override
    public String toString() {
        return "Pianeta, " + super.toString() + ", vel: " + vel;
    }
}
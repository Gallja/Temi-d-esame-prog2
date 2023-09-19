package Codes;
/**
 * OVERVIEW: PuntoTreDimensioni è una classe concreta che rappresenta il concetto matematico-geometrico di un punto di 3 dimensioni.
 * Ogni punto tridimensionale è caratterizzato da 3 coordinate x, y e z.
 * Le istanze di questa classe sono mutabili.
 */

public class PuntoTreDimensioni {
    /**
     * IR: Le coordinate x, y e z possono assumere tutti i valori.
     * 
     * AF: x : la coordinata sull'asse x del punto.
     * y : la coordinata sull'asse y del punto.
     * z : la coordinata sull'asse z del punto.
     */

    // ATTRIBUTI
    /** Le 3 coordinate del punto */
    private int x;
    private int y;
    private int z;

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire dalle coordinate {@code x}, {@code y} e {@code z} avuti per argomento.
     * 
     * @param x la coordinata x di {@code this}
     * @param y la coordinata y di {@code this}
     * @param z la coordinata z di {@code this}
     */
    public PuntoTreDimensioni(final int x, final int y, final int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Costruisce una copia di {@code PuntoTreDimensioni}.
     * 
     * @param altro_punto Il {@code PuntoTreDimensioni} dal quale si vuole costruire la copia
     */
    public PuntoTreDimensioni(PuntoTreDimensioni altro_punto) {
        this(altro_punto.x, altro_punto.y, altro_punto.z);
    }

    // METODI

    /**
     * Ritorna un valore corrispondente alla coordinata x di {@code this}.
     * 
     * @return il valore di x
     */
    public int getX() {
        return x;
    }

    /**
     * Ritorna un valore corrispondente alla coordinata y di {@code this}.
     * 
     * @return il valore di y
     */
    public int getY() {
        return y;
    }

    /**
     * Ritorna un valore corrispondente alla coordinata z di {@code this}.
     * 
     * @return il valore di z
     */
    public int getZ() {
        return z;
    }

    /**
     * Modifica {@code this} aggiornand la coordinata x con la {@code x} avuta per argomento.
     * 
     * @param x La nuova coordinata x di {@code this}
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Modifica {@code this} aggiornand la coordinata x con la {@code y} avuta per argomento.
     * 
     * @param x La nuova coordinata y di {@code this}
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Modifica {@code this} aggiornand la coordinata z con la {@code x} avuta per argomento.
     * 
     * @param x La nuova coordinata z di {@code this}
     */
    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
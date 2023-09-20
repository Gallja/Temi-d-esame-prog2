/**
 * OVEVIEW: Immagine è una classe concreta atta ad estendere ed implementare stato e comportamenti di un Contenuto di tipo immagine.
 * Un contenuto di un'immagine è rappresentato dal suo carattere identificativo e dall'argomento (nel caso specifico il titolo dell'immagine).
 * Potrebbe avere senso, in un contesto più esteso rispetto a quello della traccia, avere più attributi (per esempio avere un attributo all'interno del quale vi sono i byte di codifica dell'immagine).
 * Oppure potrebbe essere utile avere un altro attributo di tipo stringa che contiene il path del file immagine che verrà poi opportunamente costruito.
 * Le istanze di questa classe sono immutabili.
 */

 public class Immagine extends Contenuto {

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire dal carattere {@code id} e dall'argomento {@code arg} avuti per argomento.
     * 
     * @param id Il carattere identificativo di {@code this}.
     * @param arg L'argomento di {@code this}.
     */
    public Immagine(final char id, final String arg) {
        super(id, arg);
    }
}
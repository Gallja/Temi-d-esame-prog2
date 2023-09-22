import java.util.regex.*;
import java.util.*;

/**
 * OVERVIEW: Indirizzo è una classe concreta che implementa stato e metodi di un
 * indirizzo email.
 * Ogni indirizzo è rappresentato dalla sua parte locale e dalla sua parte
 * dominio.
 * Una tipica istanza di questa classe è "nome.cognome@dominio.it"
 * Le istanze di questa classe sono immutabili.
 */

public class Indirizzo {

    /**
     * OVERVIEW: Locale è una classe concreta che rappresenta la porzione locale di
     * un inidirizzo email.
     * Ogni porzione locale è rappresentata dalla stringa "username" dell'utente
     * separata dal '.'.
     * Le istanze di questa classe sono immutabili.
     */
    public static class Locale {
        /**
         * IR: Il nome della porzione locale non deve essere null.
         * Il nome della porzione locale non deve essere vuoto.
         * Il nome della porzione locale deve rispettare l'espressione regolare
         * {@code regex}.
         * 
         * AF: nome : la porzione "locale" dell'inidirizzo email.
         * regex : l'espressione regolare che deve rispettare {@code this}.
         */

        // ATTRIBUTI
        /** La stringa corrispondente alla porzione locale di {@code this} */
        private final String nome;
        /** L'espressione regolare che deve rispettare {@code this} */
        final static String regex = "^[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*$";

        // COSTRUTTORE

        /**
         * Costruisce un nuovo oggetto {@code this} a partire dalla stringa fornita
         * {@code nome} avuta per argomento.
         * 
         * @param nome La stringa che forma la porzione locale di {@code this}
         * 
         * @throws NullPointerException     Se {@code nome} è null.
         * @throws IllegalArgumentException Se {@code nome} è vuoto.
         * @throws IllegalArgumentException Se {@code nome} non rispetta l'espressione
         *                                  regolare per le porzioni locali degli
         *                                  indirizzi email
         *                                  "^[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*$".
         */
        public Locale(final String nome) {
            Objects.requireNonNull(nome, "Il nome avuto per argomento non deve essere null.");

            if (nome.isEmpty())
                throw new IllegalArgumentException("Il nome avuto per argomento non deve essere vuoto.");

            String strRis = "";

            if (nome.contains(" ")) {
                String[] result = nome.split(" ");

                for (int i = 0; i < result.length; i++) {
                    strRis += result[i];
                    if (i != result.length - 1) {
                        strRis += ".";
                    }
                }

                this.nome = strRis;

                if (!checkEspressione(this.nome))
                    throw new IllegalArgumentException("La porzione locale deve rispettare l'espressione regolare.");

            } else {
                this.nome = nome;

                if (!checkEspressione(this.nome))
                    throw new IllegalArgumentException("La porzione locale deve rispettare l'espressione regolare.");
            }
        }

        // METODI

        /**
         * Restituisce un valore {@code True/False} se la stringa {@code s} avuta per
         * argomento rispetta l'espressione regolare.
         *
         * @param s La stringa che si intende controllare.
         * 
         * @throws NullPointerException     Se {@code s} è null.
         * @throws IllegalArgumentException Se {@code s} è vuoto.
         */
        private boolean checkEspressione(final String s) {
            Objects.requireNonNull(s, "La stringa avuta per argomento non deve essere null.");

            if (s.isEmpty())
                throw new IllegalArgumentException("La stringa avuta per argomento non deve essere vuota.");

            Pattern pattern = Pattern.compile(this.regex);

            Matcher matcher = pattern.matcher(s);

            return matcher.matches();
        }

        /**
         * Restituisce la stringa corrispondente alla porzione locale dell'indirizzo
         * email.
         * 
         * @return La porzione locale dell'inirizzo email.
         */
        private String getLoc() {
            return nome;
        }
    }

    /**
     * OVERVIEW: Dominio è una classe statica concreta che rappresenta la porzione
     * del dominio di un indirizzo email.
     * Ogni porzione dominio è rappresentata da una o più parole chiavi separate dal
     * '.' e domini di livello come ".it" o ".com".
     * Le istanze di questa classe sono immutabili.
     */
    public static class Dominio {
        /**
         * IR: Il nome del dominio non deve essere null.
         * Il nome del dominio non deve essere vuoto.
         * Il nome del dominio deve rispettare l'espressione regolare.
         * 
         * AF: nomeDom : nome del dominio
         * regex : espressione regolare che deve rispettare {@code this}.
         */

        // ATTRIBUTI
        /** Il nome di {@code this} */
        private final String nomeDom;
        /** L'espressione regolare che deve rispettare {@code this} */
        static final String regex = "^[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        // COSTRUTTORE

        /**
         * Costruisce un nuovo oggetto {@code this} a partire dal nome del dominio
         * {@code nomeDom} e l'estensione {@code estensioneDom} avuti per argomento.
         * 
         * @param nomeDom Il nome di {@code this}
         * 
         * @throws NullPointerException     Se {@code nomeDom} è null.
         * @throws IllegalArgumentException Se {@code nomeDom} è vuoto.
         * @throws IllegalArgumentException Se {@code nomeDom} non rispetta
         *                                  l'espressione regolare
         */
        public Dominio(final String nomeDom) {
            Objects.requireNonNull(nomeDom, "Il nome del dominio avuto per argomento non deve essere null.");

            if (nomeDom.isEmpty())
                throw new IllegalArgumentException("Il nome del dominio non deve essere vuoto.");

            if (!checkEspressione(nomeDom))
                throw new IllegalArgumentException("Il dominio non rispetta l'espressione regolare.");

            this.nomeDom = nomeDom;
        }

        // METODI

        /**
         * Restituisce un valore {@code True/False} se la stringa {@code s} avuta per
         * argomento rispetta l'espressione regolare.
         *
         * @param s La stringa che si intende controllare.
         * 
         * @throws NullPointerException     Se {@code s} è null.
         * @throws IllegalArgumentException Se {@code s} è vuoto.
         */
        private boolean checkEspressione(final String s) {
            Objects.requireNonNull(s, "La stringa avuta per argomento non deve essere null.");

            if (s.isEmpty())
                throw new IllegalArgumentException("La stringa avuta per argomento non deve essere vuota.");

            Pattern pattern = Pattern.compile(this.regex);

            Matcher matcher = pattern.matcher(s);

            return matcher.matches();
        }

        /**
         * Restituisce la stringa corrispondente alla porzione dominio dell'indirizzo
         * email.
         * 
         * @return La porzione dominio dell'inirizzo email.
         */
        private String getDom() {
            return nomeDom;
        }
    }

    /**
     * IR: La porzione locale non deve essere null.
     * La porzione dominio non deve essere null.
     * 
     * AF: loc : porzione locale dell'indirizzo.
     * dom : porzione dominio dell'indirizzo.
     */

    // ATTRIBUTI
    /** La porzione locale di {@code this} */
    private final Locale loc;
    /** La porzione dominio di {@code this} */
    private final Dominio dom;

    // COSTRUTTORE

    /**
     * Costruisce un nuovo oggetto {@code this} a partire da una stringa
     * {@code email} avuta per argomento.
     * 
     * @param email La mail con cui si intende costruire {@code this}.
     * 
     * @throws NullPointerException     Se {@code email} è null.
     * @throws IllegalArgumentException Se {@code email} è vuota.
     * @throws IllegalArgumentException Se {@code email} non contiene, con
     *                                  occorrenza pari a 1, il carattere '@'.
     */
    public Indirizzo(final String email) {
        Objects.requireNonNull(email, "La mail avuta per argomento non deve essere null.");

        if (email.isEmpty())
            throw new IllegalArgumentException("La mail avuta per argomento non deve essere vuota.");

        int cntChiocciola = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@')
                cntChiocciola++;
        }

        if (cntChiocciola == 0 || cntChiocciola > 1)
            throw new IllegalArgumentException(
                    "L'indirizzo email avuto per argomento deve contenere una e una sola chiocciola.");

        String[] res = email.split("@");

        this.loc = new Locale(res[0]);
        this.dom = new Dominio(res[1]);
    }

    // METODI

    /**
     * Restituisce la porzione locale di {@code this}.
     * 
     * @return La porzione locale di {@code this}.
     */
    public String getLocale() {
        return loc.getLoc();
    }

    /**
     * Restituisce la porzione dominio di {@code this}.
     * 
     * @return La porzione dominio di {@code this}.
     */
    public String getDominio() {
        return dom.getDom();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.loc, this.dom);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Indirizzo other = (Indirizzo) obj;
        if (loc == null) {
            if (other.loc != null)
                return false;
        } else if (!loc.equals(other.loc))
            return false;
        if (dom == null) {
            if (other.dom != null)
                return false;
        } else if (!dom.equals(other.dom))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return loc.getLoc() + "@" + dom.getDom();
    }
}
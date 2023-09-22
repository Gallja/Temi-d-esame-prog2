import java.util.*;

/**
 * OVERVIEW: Indirizzo è una classe concreta che implementa stato e metodi di un indirizzo email.
 * Ogni indirizzo è rappresentato dalla sua parte locale e dalla sua parte dominio.
 * Una tipica istanza di questa classe è "nome.cognome@dominio.it" 
 * Le istanze di questa classe sono immutabili.
 */

public class Indirizzo {

    /**
     * OVERVIEW: Locale è una classe concreta che rappresenta la porzione locale di un inidirizzo email.
     * Ogni porzione locale è rappresentata dalla stringa "username" dell'utente separata dal '.'.
     * Le istanze di questa classe sono immutabili.
     */
    public class Locale {
        /**
         * IR: Il nome della porzione locale non deve essere null.
         * Il nome della porzione locale non deve essere vuoto.
         * Il nome della porzione locale deve rispettare l'espressione regolare "^[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*$".
         * 
         * AF: nome : la porzione "locale" dell'inidirizzo email.
         */

        // ATTRIBUTI
        /** La stringa corrispondente alla porzione locale di {@code this} */
        private final String nome;
        
        // COSTRUTTORE

        /**
         * Costruisce un nuovo oggetto {@code this} a partire dalla stringa fornita {@code nome} avuta per argomento.
         * 
         * @param nome La stringa che forma la porzione locale di {@code this}
         * 
         * @throws NullPointerException Se {@code nome} è null.
         * @throws IllegalArgumentException Se {@code nome} è vuoto.
         * @throws IllegalArgumentException Se {@code nome} non rispetta l'espressione regolare per le porzioni locali degli indirizzi email "^[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*$".
         */
        public Locale(final String nome) {
            Objects.requireNonNull(nome, "Il nome avuto per argomento non deve essere null.");

            if (nome.isEmpty()) throw new IllegalArgumentException("Il nome avuto per argomento non deve essere vuoto.");

            if (nome.contains(" ")) {
                String[] result = nome.split(" ");                

                for (int i = 0; i < result.length; i++) {
                    this.nome += result[i];
                    if (i != result.length - 1) {
                        this.nome += ".";
                    }
                }

                if (!checkEspressione(this.nome)) throw new IllegalArgumentException("La porzione locale deve rispettare l'espressione regolare.");
                
            } else {
                this.nome = nome;

                if (!checkEspressione(this.nome)) throw new IllegalArgumentException("La porzione locale deve rispettare l'espressione regolare.");
            }
        } 

        // METODI

        /**
         * Restituisce un valore {@code True/False} se la stringa {@code s} avuta per argomento rispetta l'espressione regolare "^[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*$".
         *
         * @param s La stringa che si intende controllare.
         * 
         * @throws NullPointerException Se {@code s} è null.
         * @throws IllegalArgumentException Se {@code s} è vuoto.
         */
        private boolean checkEspressione(final String s) {
            Objects.requireNonNull(s, "La stringa avuta per argomento non deve essere null.");

            if (s.isEmpty()) throw new IllegalArgumentException("La stringa avuta per argomento non deve essere vuota.");

            String regex = "^[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*$";

            Pattern pattern = Pattern.compile(regex);

            return Matcher matcher = pattern.matcher(s);
        }

        /**
         * Restituisce la stringa corrispondente alla porzione locale dell'indirizzo email.
         * 
         * @return La porzione locale dell'inirizzo email.
         */
        public String getNome() {
            return nome;
        }
    }

    /**
     * OVERVIEW: Dominio è una classe statica concreta che rappresenta la porzione del dominio di un indirizzo email.
     * Ogni porzione dominio è rappresentata da una o più parole chiavi separate dal '.' e domini di livello come ".it" o ".com".
     * Le istanze di questa classe sono immutabili.
     */
    public class Dominio {
        /**
         * IR: Il nome del dominio non deve essere null.
         * Il nome del dominio non deve essere vuoto.
         * Il nome del dominio deve rispettare l'espressione regolare "^[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$".
         * 
         * AF: nomeDom : nome del dominio
         * estensioneDom : estensione del dominio
         */

        // ATTRIBUTI
        /** Il nome di {@code this} */
        public final String nomeDom;

        // COSTRUTTORE

        /**
         * Costruisce un nuovo oggetto {@code this} a partire dal nome del dominio {@code nomeDom} e l'estensione {@code estensioneDom} avuti per argomento.
         * 
         * @param nomeDom Il nome di {@code this}
         * @param estensioneDom L'estensione di {@code this}
         * 
         * @throws NullPointerException Se {@code nomeDom} è null.
         * @throws NullPointerException Se {@code estensioneDom} è null.
         * @throws IllegalArgumentException Se {@code nomeDom} è vuoto.
         * @throws IllegalArgumentException Se {@code estensioneDom} è vuoto.
         * @throws IllegalArgumentException Se {@code this} non rispetta l'espressione regolare
         */
        public Dominio(final String nomeDom, final String estensioneDom) {
            Objects.requireNonNull(nomeDom, "Il nome del dominio avuto per argomento non deve essere null.");

            Objects.requireNonNull(estensioneDom, "L'estensione del dominio avuto per argomento non deve essere null.");

            if (nomeDom.isEmpty()) throw new IllegalArgumentException("Il nome del dominio non deve essere vuoto.");

            if (estensioneDom.isEmpty()) throw new IllegalArgumentException("L'estensione del dominio non deve essere vuoto.");

            nomeDom += estensioneDom;

            if (!checkEspressione(nomeDom)) throw IllegalArgumentException("Il dominio non rispetta l'espressione regolare.");

            this.nomeDom = nomeDom;
        }

        // METODI

        /**
         * Restituisce un valore {@code True/False} se la stringa {@code s} avuta per argomento rispetta l'espressione regolare "^[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$".
         *
         * @param s La stringa che si intende controllare.
         * 
         * @throws NullPointerException Se {@code s} è null.
         * @throws IllegalArgumentException Se {@code s} è vuoto.
         */
        private boolean checkEspressione(final String s) {
            Objects.requireNonNull(s, "La stringa avuta per argomento non deve essere null.");

            if (s.isEmpty()) throw new IllegalArgumentException("La stringa avuta per argomento non deve essere vuota.");

            String regex = "^[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

            Pattern pattern = Pattern.compile(regex);

            return Matcher matcher = pattern.matcher(s);
        }

        /**
         * Restituisce la stringa corrispondente alla porzione dominio dell'indirizzo email.
         * 
         * @return La porzione dominio dell'inirizzo email.
         */
        public String getDominio() {
            return nomeDom;
        }
    }

    /**
     * IR: 
     * 
     * AF: 
     */

    // ATTRIBUTI

    // COSTRUTTORE

    // ATTRIBUTI
}
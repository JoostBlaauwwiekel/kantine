public class KantineSimulatie {

    private Kantine kantine;
    private Kassa kassa;
    private KassaRij kassarij;
    private Dienblad klant;

    public static final int DAGEN = 7;

    /**
     * Constructor
     */
    public KantineSimulatie() {
        kantine = new Kantine();
    }

    /**
     * Deze methode simuleert een aantal dagen in het
     * verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {

        // herhaal voor elke dag
        for(int i = 0; i < dagen; i++) {

            // per dag nu even vast 10 + i personen naar binnen
            // laten gaan, wordt volgende week veranderd...

            // for lus voor personen
            for(int j = 0; j < 10 + i; j++){
                 kantine.loopPakSluitAan();
            }

            // verwerk rij voor de kassa
            kassa.rekenAf(klant);
            kassarij.eerstePersoonInRij();


            // toon dagtotalen (artikelen en geld in kassa)
            double dagTotaal = kassa.hoeveelheidGeldInKassa();

            // reset de kassa voor de volgende dag
            kassa.resetKassa();
        }
    }

    /**
     * Start een simulatie
     */
    public static void main(String[] args) {
        int dagen;

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }

        simulate(dagen);
    }
}
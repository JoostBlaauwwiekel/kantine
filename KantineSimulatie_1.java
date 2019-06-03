public class KantineSimulatie {

    // artikelen
    private static final String[] artikelnamen = new String[]
            {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};


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

        //maak een nieuwe kantine
        Kantine kantine = new Kantine;

        // herhaal voor elke dag
        for(int i = 0; i < dagen; i++) {

            // per dag nu even vast 10 + i personen naar binnen
            // laten gaan, wordt volgende week veranderd...

            // for lus voor personen
            for(int j = 0; j < 10 + i; j++){
                Persoon persoon = new Persoon();
                kantine.loopPakSluitAan(persoon, artikelnamen);
            }

            // verwerk rij voor de kassa
            //get nieuwe kassa
            Kassa kassa = kantine.getKassa();
            kassa.rekenAf();
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

        simuleer(dagen);
    }
}
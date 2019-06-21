import java.util.*;
/**
 * class KantineSimulatie
 * @version 2.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class KantineSimulatie {

    //de kansen om studenten, docenten en medewerkers te krijgen
    static int kansStudenten = 89;
    static int kansDocenten = 10;
    static int kansKantineMedewerkers = 1;

    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // random generator
    private Random random;

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;

    // artikelen
    private static final String[] artikelnamen = new String[]
            {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};

    // prijzen
    private static double[] artikelprijzen = new double[]{1.50, 2.10, 1.65, 1.65};

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10000;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20000;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;

    /**
     * Constructor van KantineSimulatie
     */
    public KantineSimulatie() {
        kantine = new Kantine();
        random = new Random();
        int[] hoeveelheden = getRandomArray(
                AANTAL_ARTIKELEN,
                MIN_ARTIKELEN_PER_SOORT,
                MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod = new KantineAanbod(
                artikelnamen, artikelprijzen, hoeveelheden);

        kantine.setKantineAanbod(kantineaanbod);
    }

    /**
     * Methode om een array van random getallen liggend tussen
     * min en max van de gegeven lengte te genereren
     *
     * @param lengte lengte van array
     * @param min mininum getal
     * @param max maximum getal
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for(int i = 0; i < lengte ;i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl)
     * en max(incl) te genereren.
     *
     * @param min minimum getal
     * @param max maximum getal
     * @return Een random getal tussen min en max
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array
     * artikelnamen de bijhorende array van artikelnamen te maken
     *
     * @param indexen de indexen van de artikelen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        for(int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];

        }

        return artikelen;
    }

    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen hoeveelheid dagen dat de kantine simuleert
     */
    public void simuleer(int dagen) {


        // for lus voor dagen
        for(int i = 0; i < dagen; i++) {

            //totaal aantal mensen
            int totaalPersonen = 100;


            // laat de personen maar komen...
            for(int j = 0; j < totaalPersonen; j++) {

                // maak persoon en dienblad aan, koppel ze
                // en bedenk hoeveel artikelen worden gepakt
                int aantalartikelen = 3 ;
                Persoon persoon;
                int randomPersoon = random.nextInt(100);
                if(randomPersoon <= kansStudenten) {
                    persoon = new Student("", 0);
                } else if(randomPersoon <= kansStudenten+kansDocenten) {
                    persoon = new Docent("", "");
                } else if(j <= kansStudenten+kansDocenten+kansKantineMedewerkers) {
                    persoon = new KantineMedewerker(0, false);
                } else {
                    persoon = new Persoon();
                }

                //creeer een betaalwijze
                double c = Math.random();
                if(c < 0.5) {
                    //50% kans
                    Betaalwijze betaalwijze = new Pinpas(30, 10);
                    //System.out.println("Pin:" + betaalwijze);
                    persoon.setBetaalwijze(betaalwijze);
                } else {
                    Betaalwijze betaalwijze = new Contant(50);
                    //System.out.println("Contant:" + betaalwijze);
                    persoon.setBetaalwijze(betaalwijze);
                }

                //maak een kassarij
                KassaRij kassarij = kantine.getKassaRij();

                kantine.loopPakSluitAan(persoon, artikelnamen);

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken = getRandomArray(
                        aantalartikelen, 0, AANTAL_ARTIKELEN-1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan
                kassarij.sluitAchteraan(persoon);

            }

            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();

            //maak een kassa
            Kassa kassa = kantine.getKassa();

            // druk de dagtotalen af en hoeveel personen binnen
            // zijn gekomen
            kassa.aantalArtikelen();
            kassa.hoeveelheidGeldInKassa();

            System.out.println(kassa.hoeveelheidGeldInKassa());

            // reset de kassa voor de volgende dag
            kassa.resetKassa();
        }
    }
    /**
     * Start een simulatie
     */
    public static void main(String[] args) {
        //als kansen van de typen personen moeten altijd 100% totaal zijn
        //als dat niet het geval is stopt het programma
        if(!(kansStudenten+kansDocenten+kansKantineMedewerkers == 100)) {
            System.out.println("Kansen moeten totaal 100% zijn. Het is nu: " + (kansStudenten+kansDocenten+kansKantineMedewerkers) + "%");
            return;
        }
        int dagen;
        KantineSimulatie simulatie = new KantineSimulatie();
        if (args.length == 0) {
            dagen = 7;
        } else {
            dagen = Integer.parseInt(args[0]);
        }

        simulatie.simuleer(dagen);
    }
}
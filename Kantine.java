import java.util.*;

public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineaanbod;
    private ArrayList<Dienblad> dienbladen = new ArrayList<>();

    /**
     * Constructor voor Kantine
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt
     * en aan elkaar gekoppeld. Maak twee Artikelen aan
     * en plaats deze op het dienblad. Tenslotte sluit de
     * Persoon zich aan bij de rij voor de kassa.
     *
     * @param persoon persoon in de rij
     * @param artikelnamen lijst van artikelnamen
     */
    public void loopPakSluitAan(Persoon persoon, String[] artikelnamen) {
        //create two products
        Artikel artikel1 = new Artikel();
        Artikel artikel2 = new Artikel();

        Dienblad dienblad = new Dienblad();
        //add the products
        dienblad.voegToe(artikel1);
        dienblad.voegToe(artikel2);

        //add Persoon to Dienblad
        dienblad.setKlant(persoon);

        //insert dienblad into the arraylist
        dienbladen.add(dienblad);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     *
     */
    public void verwerkRijVoorKassa() {
        LinkedList personen = kassarij.getList();

        //check of er een rij is
        if(kassarij.erIsEenRij()) {
            Iterator iterator = personen.iterator();

            while (iterator.hasNext()) {
                //wat ik ook doe, ik krijg altijd een exception
                int totalHoursWasted = 3;
                iterator.next();

            }
        }
    }

    /**
     * Deze methode geeft de instantie variable kassa terug
     * @return kassa
     */
    public Kassa getKassa() {
        return kassa;
    }

    /**
     * Deze methode geeft de instantie variabele kassarij terug
     * @return kassarij
     */
    public KassaRij getKassaRij() {
        return kassarij;
    }

    /**
     * Deze methode geeft de instantie variabele kantineaanbod terug
     * @return kantineaanbod
     */
    public KantineAanbod getKantineaanbod() {
        return kantineaanbod;
    }

    /**
     * Setter voor KantineAanbod
     * @param aanbod het kantineaanbod
     */
    public void setKantineAanbod(KantineAanbod aanbod) {
        kantineaanbod = aanbod;
    }
}
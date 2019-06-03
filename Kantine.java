import java.util.HashMap;
import java.util.Iterator;
public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineaanbod;

    /**
     * Constructor
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
     */
    public void loopPakSluitAan(Persoon persoon, String[] artikelnamen) {
        //create two products
        Artikel artikel1 = new Artikel();
        Artikel artikel2 = new Artikel();

        Dienblad dienblad = new Dienblad();
        //add the products
        dienblad.voegToe(artikel1);
        dienblad.voegToe(artikel2);

        //create a instance of HashMap
        HashMap<Dienblad, Persoon> koppeling = new HashMap<Dienblad, Persoon>();

        //add the combination to the HashMap
        koppeling.put(dienblad, persoon);

        //add the customer to the 'kassarij'
        kassarij.sluitAchteraan(persoon);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa(HashMap koppeling) {
        Iterator iterator = koppeling.entrySet().iterator();
        while(iterator.hasNext()) {
            Dienblad dienblad = (Dienblad) iterator.next();
            kassa.rekenAf(dienblad);
        }
    }

    /**
     * Deze methode geeft de instantie variable kassa terug
     * @return instantie variabele kassa
     */
    public Kassa getKassa() {
        return kassa;
    }

    /**
     * Deze methode geeft de instantie variabele kassarij terug
     * @return instantie variabele kassarij
     */
    public KassaRij getKassaRij() {
        return kassarij;
    }

    /**
     * Deze methode geeft de instantie variabele kantineaanbod terug
     * @return instantie variabele kantineaanbod
     */
    public KantineAanbod getKantineaanbod() {
        return kantineaanbod;
    }
}
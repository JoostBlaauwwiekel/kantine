import java.util.HashMap;
import java.util.Iterator;
/**
 * class Kantine
 * @version 1.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineaanbod;
    //create a instance of HashMap
    HashMap<Persoon, Dienblad> koppeling = new HashMap<Persoon, Dienblad>();

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

        //add the combination to the HashMap
        koppeling.put(persoon, dienblad);

        //add the customer to the 'kassarij'
        kassarij.sluitAchteraan(persoon);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa(HashMap koppeling) {
        Iterator iterator = koppeling.entrySet().iterator();
        while(iterator.hasNext()) {
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

    public HashMap getKoppeling() {
        return koppeling;
    }

    public void setKantineAanbod(KantineAanbod aanbod) {
        kantineaanbod = aanbod;
    }
}
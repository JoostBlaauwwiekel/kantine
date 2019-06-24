import java.util.*;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;

public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineaanbod;
    private ArrayList<Dienblad> dienbladen = new ArrayList<>();
    private EntityManager manager;

    /**
     * Constructor voor Kantine
     */
    public Kantine(EntityManager manager) {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij, manager);
        this.manager = manager;
    }



    /**
     * Methode die het dienblad en persoon linkt
     * en de producten in de dienblad zet
     *
     * @param dienblad persoon in de rij
     * @param artikelnamen lijst van artikelnamen
     */
    public void loopPakSluitAan(Dienblad dienblad, String[] artikelnamen) {
        //Voeg producten toe aan dienblad
        for (String artikel:artikelnamen) {
            dienblad.voegToe(kantineaanbod.getArtikel(artikel));
        }

        //Voeg dienblad toe aan ArrayList
        dienbladen.add(dienblad);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     *
     */
    public void verwerkRijVoorKassa() {
        //als er een rij is
        while(kassarij.erIsEenRij()) {
            Persoon klantAanBeurt = kassarij.eerstePersoonInRij();
            for (Dienblad dienblad : dienbladen) {
                if (klantAanBeurt.equals(dienblad.getKlant())) {
                     kassa.rekenAf(dienblad);
                     break;
                }
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
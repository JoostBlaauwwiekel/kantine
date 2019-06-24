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
     * In deze methode wordt een Persoon en Dienblad gemaakt
     * en aan elkaar gekoppeld. Maak twee Artikelen aan
     * en plaats deze op het dienblad. Tenslotte sluit de
     * Persoon zich aan bij de rij voor de kassa.
     *
     * @param persoon persoon in de rij
     * @param artikelnamen lijst van artikelnamen
     */
    public void loopPakSluitAan(Persoon persoon, String[] artikelnamen) {
        Dienblad dienblad = new Dienblad();
        //add the products

        for(int i = 0; i < 3; i++) {
            //create random nuber
            Random rand = new Random();

            // Obtain a number between [0 - 3].
            int n = rand.nextInt(3);

            //pak een 'product' of 'artikel'
            Artikel product = kantineaanbod.getArtikel(artikelnamen[n]);

            //en zet hem op je dienblad
            dienblad.voegToe(product);
        }

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
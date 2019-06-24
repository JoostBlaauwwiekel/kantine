import java.util.Iterator;
import java.util.Stack;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;
import java.time.LocalDate;

/**
 * class Kassa
 * @version 1.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class Kassa {
    private KassaRij kassarij;
    private double kassa = 0.00;
    private int aantal = 0;
    private EntityManager manager;

    /**
     * Constructor van Kassa
     *
     * @param kassarij de kassarij van de kassa
     */
    public Kassa(KassaRij kassarij, EntityManager manager) {
        this.kassarij = kassarij;
        this.manager = manager;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op.
     * Tel deze gegevens op bij de controletotalen die voor
     * de kassa worden bijgehouden. De implementatie wordt
     * later vervangen door een echte betaling door de persoon.
     *
     * @param klant de klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) {
        //Entity toevoegen
        EntityTransaction transaction = manager.getTransaction();

        //Maak een factuur voor de klant
        Factuur factuur = new Factuur(klant, LocalDate.now());

        //Pak het totaal en korting van het factuur
        double totaal = factuur.getTotaal();
        double korting = factuur.getKorting();

        //Bereken te betalen bedrag
        double teBetalen = totaal - korting;


        aantal = klant.getAantalArtikelen();

        //Pak persoon en zijn betaalwijze
        Persoon persoon = klant.getKlant();
        Betaalwijze betaalwijze = persoon.getBetaalwijze();

        try {
            //Bij succesvolle betaling stopt het de factuur in de database
            transaction.begin();
            betaalwijze.betaal(teBetalen);
            manager.persist(factuur);
            transaction.commit();
            //Voeg geld toe aan kassa
            kassa += teBetalen;
        } catch(TeWeinigGeldException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            JOptionPane.showMessageDialog(null, e, "Foutmelding", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd,
     * vanaf het moment dat de methode resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
        return aantal;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kass
     * zijn gepasseerd, vanaf het moment dat de methode
     * resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
        return kassa;
    }

    /**
     * getter voor kassarij
     *
     * @return kassarij
     */
    public KassaRij getKassarij() {
        return kassarij;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */
    public void resetKassa() {
        kassa = 0;
        aantal = 0;
    }

}
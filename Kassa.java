import java.util.Iterator;
import java.util.Stack;
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


    /**
     * Constructor van Kassa
     *
     * @param kassarij de kassarij van de kassa
     */
    public Kassa(KassaRij kassarij) {
        this.kassarij = kassarij;
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
        //Maak factuur aan
        Factuur factuur = new Factuur(klant, LocalDate.now());
        //Pak de totaal en korting uit het factuur
        double totaal = factuur.getTotaal();
        double korting = factuur.getKorting();
        //Bereken het te betalen bedrag
        double teBetalen = totaal - korting;

        //Pak het aantal artikelen van de klant
        aantal = klant.getAantalArtikelen();

        //Pak de persoon en betaalwijze
        Persoon persoon = klant.getKlant();
        Betaalwijze betaalwijze = persoon.getBetaalwijze();

        //Betaling met error check
        try {
            betaalwijze.betaal(teBetalen);
            //Voeg het geld toe aan de kassa
            kassa += teBetalen;
        } catch(TeWeinigGeldException e) {
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

    /**
     * Methode om de totaalprijs van de artikelen
     * op dienblad uit te rekenen
     *
     * @param dienblad dienblad met artikelen
     * @return De totaalprijs
     */
    public static double getTotaalPrijs(Dienblad dienblad) {
        Stack artikelen = dienblad.getArtikel();
        Iterator iterator = artikelen.iterator();
        int prijs = 0;

        while(iterator.hasNext()) {
            Artikel artikel = (Artikel) iterator.next();
            prijs += artikel.getPrijs();
        }
        return prijs;
    }

    public static double getKorting(Persoon persoon, double teBetalen) {
        if(persoon.geefKortingsPercentage() > 0) {
            //bereken nieuwe prijs
            double korting = persoon.geefKortingsPercentage();
            double nieuwePrijs = (100 - korting) * teBetalen / 100;

            //check of er een maximum geldt
            if(persoon.heeftMaximum()) {
                //de korting mag niet meer zijn dan 1 euro
                //haal gewoon het maximum van de originele bedrag af

                //vraag het maximale bedrag op
                double maximaal = persoon.geefMaximum();

                //bereken de korting die is gegeven
                double gegevenKorting = teBetalen - nieuwePrijs;

                //als deze groter is dan het maximale bedrag
                //moeten er maatregelen genomen worden
                if(gegevenKorting > maximaal) {
                    return maximaal;
                } else {
                    return gegevenKorting;
                }
            }
        }
        return 0;
    }

}
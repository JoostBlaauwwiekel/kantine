import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Stack;

@Entity
public class Factuur implements Serializable {

    //Decimalen van bedragen altijd met 2 decimalen
    private DecimalFormat geldNotatie = new DecimalFormat("#.00");

    //id van factuur
    @Id
    @GeneratedValue
    private Long id;

    //datum van factuur
    @Column
    private LocalDate datum;

    //korting van factuur
    private double korting;

    //totaal van factuur
    private double totaal;

    //Klan van factuur
    @Column
    private Dienblad klant;

    /**
     * Constructor zonder parameters
     */
    public Factuur() {
        totaal = 0;
        korting = 0;
    }

    /**
     * Constructor met parameters
     *
     * @param klant klant van factuur
     * @param datum datum van factuur
     */
    public Factuur(Dienblad klant, LocalDate datum) {
        this();
        this.datum = datum;
        this.klant = klant;

        verwerkBestelling(klant);
    }

    /**
     * Verwerk artikelen en pas kortingen toe
     *
     * Zet het totaal te betalen bedrag en het
     * totaal aan ontvangen kortingen
     *
     * @param dienblad klant van factuur
     */
    private void verwerkBestelling(Dienblad dienblad) {
        totaal = getTotaalPrijs(dienblad);
        korting = getKorting(dienblad.getKlant(), totaal);
        toString();
    }

    /**
     * getter voor totaal
     *
     * @return totaalbedgrag
     */
    public double getTotaal() {
        return totaal;
    }

    /**
     * getter voor korting
     * @return korting
     */
    public double getKorting() {
        return korting;
    }

    /**
     * toString methode
     * @return printbaar bonnetje
     */
    public String toString() {
        //Lijst van artikelen van de klant
        Stack<Artikel> artikelen = klant.getArtikel();
        //De persoonsgegevens van de klant
        Persoon persoon = klant.getKlant();
        //Het begin van de kassabon
        String beginBon = String.format("Kassabon voor %s. %s \t id: %d \n datum: %s\n artikelnaam \t \t artikelprijs \n",
                persoon.adressering(), persoon.getAchternaam(), id, datum.toString());
        String artikelenBon = "";
        for(Artikel artikel : artikelen) {
            String naam = artikel.getNaam();
            double prijs = artikel.getPrijs();
            artikelenBon += naam + "\t \t" + geldNotatie.format(prijs) + "\n";
        }
        String eindeBon = String.format("Totaalbedrag:\t€%f\nKorting:\t€%f\nTe betalen:\t€%f",
                geldNotatie.format(totaal), geldNotatie.format(korting), geldNotatie.format(totaal - korting));
        return beginBon + artikelenBon + eindeBon;
    }

    /**
     * Methode om de totaalprijs van de artikelen
     * op dienblad uit te rekenen
     *
     * @param dienblad dienblad met artikelen
     * @return De totaalprijs
     */
    public double getTotaalPrijs(Dienblad dienblad) {
        Stack artikelen = dienblad.getArtikel();
        Iterator iterator = artikelen.iterator();
        int prijs = 0;

        while(iterator.hasNext()) {
            Artikel artikel = (Artikel) iterator.next();
            prijs += artikel.getPrijs();
        }
        return prijs;
    }

    /**
     * Berekent de hoeveelheid korting een persoon krijgt
     *
     * @param persoon persoongegevens klant
     * @param teBetalen totaalbedrag
     * @return
     */
    public double getKorting(Persoon persoon, double teBetalen) {
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


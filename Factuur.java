import javax.persistence.*;
import javax.xml.stream.FactoryConfigurationError;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

@Entity
@Table
public class Factuur implements Serializable {

    //Decimalen van bedragen altijd met 2 decimalen
    private final DecimalFormat geldNotatie = new DecimalFormat("#.00");

    //id van factuur
    @Id
    @GeneratedValue
    private Long id;

    //datum van factuur
    @Column
    private LocalDate datum;

    //korting van factuur
    @Column
    private double korting;

    //totaal van factuur
    @Column
    private double totaal;

    @OneToMany(cascade = CascadeType.ALL)
    private ArrayList<FactuurRegel> regels = new ArrayList();

    /**
     * Constructor zonder parameters
     */
    public Factuur() {
        totaal = 0;
        korting = 0;
        datum = LocalDate.now();
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
        //zet de totaalprijs en korting vast
        totaal = getTotaalPrijs(dienblad);
        korting = getKorting(dienblad.getKlant(), totaal);
        //maak van elk artikel in het dienblad een FactuurRegel
        Stack<Artikel> artikelen = dienblad.getArtikel();
        for (Artikel artikel: artikelen) {
            FactuurRegel regel = new FactuurRegel(this, artikel);
            //voeg FactuurRegel toe aan ArrayList
            regels.add(regel);
        }
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
     * getter voor datum
     * @return datum
     */
    public LocalDate getDatum(){ return datum; }

    /**
     * setter voor totaal
     * @param totaal totaalprijs
     */
    public void setTotaal(double totaal) {
        this.totaal = totaal;
    }

    /**
     * setter voor korting
     * @param korting korting
     */
    public void setKorting(double korting) {
        this.korting = korting;
    }

    /**
     * setter voor datum
     * @param datum datum
     */
    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    /**
     * voegt regels toe aan array
     * @param regel factuurregel
     */
    public void addRegel(FactuurRegel regel) {
        regels.add(regel);
    }

    /**
     * toString methode
     * @return printbaar bonnetje
     */
    public String toString() {
        String breakLine = "----------------------------\n";
        String beginRegel = String.format("%sKassabon id: %d\tdatum: %s\n", breakLine, id, datum.toString());
        String artikelRegels = String.format("artikelnaam\t\t\tartikelprijs\n%s", breakLine);
        for(FactuurRegel regel : regels) {
            artikelRegels += regel.toString();
        }
        String eindeRegels = String.format("%sTotaalbedrag:\t\t€%.2f\nKorting:\t\t\t€%.2f\n%sTe betalen:\t\t\t€%.2f\n%s", breakLine,
                totaal, korting, breakLine, totaal - korting, breakLine);
        return beginRegel + artikelRegels + eindeRegels;
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
            double nieuwePrijs = (100 - korting) * teBetalen;

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


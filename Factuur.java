import java.time.LocalDate;
import java.io.Serializable;

public class Factuur implements Serializable {

    private Long id;

    private LocalDate datum;

    private double korting;

    private double totaal;

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
        totaal = Kassa.getTotaalPrijs(dienblad);
        korting = Kassa.getKorting(dienblad.getKlant(), totaal);
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
        
        return "";
    }
}


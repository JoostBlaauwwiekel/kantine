/**
 * class Artikel
 * @version 1.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class Artikel {
    private String naam;
    private double prijs;

    /**
     * Constructor van de klasse Artikel
     *
     * @param naam naam van artikel
     * @param prijs prijs per stuk
     */
    public Artikel(String naam, double prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    /**
     * Parameterloze constructor van Artikel
     */
    public Artikel() {
        //nothing

    }

    /**
     * Getter van de variabele prijs per stuk
     * @return prijs per stuk
     */
    public double getPrijs() {
        return prijs;
    }

    /**
     * Getter van de naam van een artikel
     * @return naam van artikel
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Setter van de variabele naam
     * @param naam naam van artikel
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * Setter van de variabele prijs
     * @param prijs prijs per stuk
     */
    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }
}

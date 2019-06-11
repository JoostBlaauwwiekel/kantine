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
     * @param naam
     * @param prijs
     */
    public Artikel(String naam, double prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    /**
     * Parameterloze constructor
     */
    public Artikel() {
        //nothing

    }

    /**
     * Getter van de variabele prijs
     * @return prijs
     */
    public double getPrijs() {
        return prijs;
    }

    /**
     * Getter van de variabele naam
     * @return naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Setter van de variabele naam
     * @param naam
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * Setter van de variabele prijs
     * @param prijs
     */
    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }
}

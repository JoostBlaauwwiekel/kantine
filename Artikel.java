/**
 * class Artikel
 * @version 1.0
 * @author Joost Blaauwwiekel
 */

public class Artikel {
    private string naam;
    private double prijs;

    public Artikel(string naam, double prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    public Artikel() {
        //nothing

    }

    public double getPrijs() {
        return prijs;
    }

    public string getNaam() {
        return naam;
    }

    public void setNaam(string naam) {
        this.naam = naam;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }
}

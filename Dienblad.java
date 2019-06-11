import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * class Dienblad
 * @version 1.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class Dienblad {
    private Stack<Artikel> artikelen = new Stack();
    private Persoon klant;

    /**
     * Parameterloze constructor
     */
    public Dienblad() { }

    /**
     * Constructor van de klasse Dienblad
     * @param klant de klant van wie het dienblad is
     */
    public Dienblad(Persoon klant) {
        klant = new Persoon();
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel het artikel dat toegevoegd moet worden
     */
    public void voegToe(Artikel artikel) {
        artikelen.add(artikel);
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() {
        return artikelen.size();
    }

    /**
     * Setter van de variabele klant
     * @param klant de klant van wie het dienblad is
     */
    public void setKlant(Persoon klant) {
        this.klant = klant;
    }

    /**
     * Getter van de variabele klant
     * @return klant
     */
    public Persoon getKlant() {
        return klant;
    }

    /**
     * Getter van de variabele artikel
     * @return artikelen
     */
    public Stack getArtikel() {
        return artikelen;
    }


}


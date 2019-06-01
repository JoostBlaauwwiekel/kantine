import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {
    private Stack<Artikel> artikelen = new Stack();
    private Persoon klant;

    /**
     * Constructor
     */
    public Dienblad() {

    }

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

   public void setKlant(Persoon klant) {
        this.klant = klant;
   }

   public Persoon getKlant() {
        return klant;
   }

   public Stack getArtikel() { return artikelen; }
}


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {
    private ArrayList<Artikel> artikelen = new ArrayList();
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

    /**
     * Methode om de totaalprijs van de artikelen
     * op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
    public double getTotaalPrijs() {
        Iterator iterator = artikelen.iterator();
        int prijs = 0;

        while(iterator.hasNext()) {
            Artikel artikel = (Artikel) iterator.next();
            prijs += artikel.getPrijs();
        }
        return prijs;
    }

    /**
     * Methode om een burgerservicenummer te
     * veranderen
     *
     * @param bsn burgerservicenummer
     */
    public void setKlantBSN(int bsn) {
        klant.setBSN(bsn);
    }

    /**
     * Methode om een voornaam te
     * veranderen
     *
     * @param voornaam voornaam
     */
    public void setKlantVoornaam(String voornaam) {
        klant.setVoornaam(voornaam);
    }

    /**
     * Methode om een achternaam te
     * veranderen
     *
     * @param achternaam achternaam
     */
    public void setKlantAchternaam(String achternaam) {
        klant.setAchternaam(achternaam);
    }

    /**
     * Methode om een geslacht te
     * veranderen
     *
     * @param geslacht geslacht
     */
    public void setKlantGeslacht(char geslacht) {
        klant.setGeslacht(geslacht);
    }

    /**
     * Deze methode verandert de geboortedatum
     *
     * @param dag   dag
     * @param maand maand
     * @param jaar  jaar
     */
    public void setKlantGeboortedatum(int dag, int maand, int jaar) {
        klant.setGeboortedatum(dag, maand, jaar);
    }
}


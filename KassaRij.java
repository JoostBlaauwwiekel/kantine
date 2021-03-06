import java.util.ArrayList;
import java.util.LinkedList;
/**
 * class KassaRij
 * @version 1.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class KassaRij {
    LinkedList<Persoon> persoon = new LinkedList<Persoon>();
    /**
     * Constructor van de klasse Kassarij
     */
    public KassaRij() {
        // method body omitted
    }

    /**
     * Persoon sluit achter in de rij aan
     *
     * @param klant klant die in de rij aansluit
     */
    public void sluitAchteraan(Persoon klant) {
        // method body omitted
        persoon.add(klant);
    }

    /**
     * Indien er een rij bestaat, de eerste klant uit
     * de rij verwijderen en retourneren.
     * Als er niemand in de rij staat geeft deze null terug.
     *
     * @return Eerste klant in de rij of null
     */
    public Persoon eerstePersoonInRij() {
        Persoon klant = null;
        if(persoon.size() > 0) {
            //first assign the value to a variable
            //before we delete the value from the arraylist
            klant = persoon.get(0);

            //remove the person and return the variable
            persoon.remove(0);
            return klant;
        } else {
            //return null
            return null;
        }
    }

    /**
     * Methode kijkt of er personen in de rij staan.
     *
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() {
        boolean waar = false;

        //if there are records inside the dienblad arraylist, return true
        //otherewise return false
        if(persoon.size() > 0) {
            waar = true;
        } else {
            waar = false;
        }

        return waar;

    }

    /**
     * Getter voor de LinkedList
     * @return LinkedList
     */
    public LinkedList getList() {
        return persoon;
    }
}
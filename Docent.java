/**
 * subclass Docent
 * @version 1.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class Docent extends Persoon implements KortingskaartHouder {

    String afdeling;
    String afkorting;

    /**
     * Constructor van Docent waar ook alle variabelen voor de Persoonklasse worden ingevoegd
     *
     * @param BSN burgerservicenummer, uniek per docent
     * @param voornaam voornaam van docent
     * @param achternaam achternaam van docent
     * @param geslacht geslacht van docent
     * @param dag dag van de maand van geboortedatum
     * @param maand geboortemaand
     * @param jaar geboortejaar
     * @param afdeling de afdeling van de docent
     * @param afkorting de afkorting van de docent
     */
    public Docent(int BSN, String voornaam, String achternaam, char geslacht, int dag, int maand, int jaar, String afdeling, String afkorting) {
        super(BSN,voornaam,achternaam,geslacht,dag,maand,jaar);
        this.afdeling = afdeling;
        this.afkorting = afkorting;
    }

    /**
     * Constructor van Docent met alleen de super() waarden leeg gelaten
     *
     * @param afdeling de afdeling van de docent
     * @param afkorting de afkorting van de docent
     */
    public Docent(String afdeling, String afkorting) {
        super();
        this.afdeling = afdeling;
        this.afkorting = afkorting;
    }

    /**
     * Constructor van Docent waar alle waarden leeg
     */
    public Docent(){
        super();
        afdeling = "";
        afkorting = "";
    }

    /**
     * Setter voor de variabele afdeling
     * @param afdeling
     */
    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    /**
     * Setter voor de variabele afkorting
     * @param afkorting
     */
    public void setAfkorting(String afkorting) {
        this.afkorting = afkorting;
    }

    /**
     * Getter voor de variabele afdeling
     * @return afdeling
     */
    public String getAfdeling() {
        return afdeling;
    }

    /**
     * Getter voor de variabele afkorting
     * @return afkorting
     */
    public String getAfkorting() {
        return afkorting;
    }

    /**
     * methode die het krotingspercentage geeft
     * @return kortingspercentage
     */
    @Override
    public double geefKortingsPercentage() {
        return 0.25;
    }

    /**
     * Methode die terug geeft of er een maximum geld
     * @return boolean maximum
     */
    @Override
    public boolean heeftMaximum() {
        return true;
    }

    /**
     * Methode die het maximale bedrag aan
     * korting terug geeft
     * @return maximum bedrag
     */
    @Override
    public double geefMaximum() {
        return 1;
    }
}

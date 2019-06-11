/**
 * Subclass Docent
 *
 * @author Joost Blaauwwiekel;, Hessel Jager
 * @version 1.0
 *
 */
public class Docent extends Persoon {

    String afdeling;
    String afkorting;

    public Docent(String afdeling, String afkorting) {
        super();
        this.afdeling = afdeling;
        this.afkorting = afkorting;
    }

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
}

/**
 * @version 1.0
 * @author Joost Blaauwwiekel
 *
 * Class Persoon
 *
 */
public class Persoon {

    public int BSN;
    public String voornaam;
    public String achternaam;
    public Datum geboortedatum;
    public char geslacht;

    public Persoon(int BSN, String voornaam, String achternaam, char geslacht, int dag, int maand, int jaar) {
        this.BSN = BSN;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geslacht = geslacht;
        this.geboortedatum = new Datum(dag, maand, jaar);
    }

    public Persoon() {
        BSN = 0;
        voornaam = "";
        achternaam = "";
        geslacht = Character.MIN_VALUE; //empty char value

    }

    public void setGeboortedatum(Datum geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public void setBSN(int BSN) {
        this.BSN = BSN;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setGeslacht(char geslacht) {

        if(this.geslacht == 'm' || this.geslacht == 'v') {
            this.geslacht = geslacht;
        } else {
            //do something else, not sure yet what should happen
        }
    }

    public int getBSN() {
        return BSN;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getGeboortedatum() {
        return geboortedatum.getDatumAsString();
    }

    public String getGeslacht() {

        if(geslacht == 'm' || geslacht == 'M') {
            return "Man";
        }
        if(geslacht == 'v' || geslacht == 'V') {
            return "Vrouw";
        }

        //else
        return "Onbekend";

    }

    public String toString() {
        return "BSN: " + BSN + "; Naam: " + voornaam + " " + achternaam + "; Geboortedatum: " + geboortedatum + ";  Geslacht: " + geslacht;
    }

}

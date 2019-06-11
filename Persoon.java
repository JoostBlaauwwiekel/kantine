import java.util.ArrayList;
/**
 * class Persoon
 * @version 1.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class Persoon {

    static ArrayList<Integer> BSN_Onthouder = new ArrayList<Integer>();

    public int BSN;
    public String voornaam;
    public String achternaam;
    public Datum geboortedatum;
    public char geslacht;

    /**
     * Constructor voor een Persoon klasse
     *
     * @param BSN burgerservicenummer, uniek per persoon
     * @param voornaam voornaam van persoon
     * @param achternaam achternaam van persoon
     * @param geslacht geslacht van persoon
     * @param dag dag van de maand van geboortedatum
     * @param maand geboortemaand
     * @param jaar geboortejaar
     */
    public Persoon(int BSN, String voornaam, String achternaam, char geslacht, int dag, int maand, int jaar) {
        if(bestaatBSN(BSN)) {
            System.out.println("BSN bestaat al, probeer opnieuw");
            return;
        } else {
            this.BSN = BSN;
            BSN_Onthouder.add(BSN);
            this.voornaam = voornaam;
            this.achternaam = achternaam;
            this.geslacht = geslacht;
            this.geboortedatum = new Datum(dag, maand, jaar);
        }
    }

    /**
     * Constructor voor klasse Persoon met alle waarden leeg
     */
    public Persoon() {
        BSN = 0;
        voornaam = "";
        achternaam = "";
        geslacht = Character.MIN_VALUE; //empty char value

    }

    public static boolean bestaatBSN(int nieuwBSN) {
        boolean exists = false;
        for(Integer e : BSN_Onthouder) {
            if(nieuwBSN == e) {
                exists = true;
                break;
            }
        }
        return exists;
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
            //log an error
            System.out.println("invalid sex inserted");
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

import java.time.LocalDate;
import java.util.ArrayList;
/**
 * class Persoon
 * @version 1.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class Persoon implements KortingskaartHouder {

    //lijst van bestaande BSNs, want elke persoon heeft een uniek nummer
    static ArrayList<Integer> BSN_Onthouder = new ArrayList<Integer>();

    public int BSN;
    public String voornaam;
    public String achternaam;
    public LocalDate geboortedatum;
    public char geslacht;
    public Betaalwijze betaalwijze;

    /**
     * Constructor voor een Persoon klasse
     *
     * @param BSN burgerservicenummer, uniek per persoon
     * @param voornaam voornaam van persoon
     * @param achternaam achternaam van persoon
     * @param geslacht geslacht van persoon
     * @param geboortedatum geboortedatum
     */
    public Persoon(int BSN, String voornaam, String achternaam, char geslacht, LocalDate geboortedatum) {
        this();
        if(bestaatBSN(BSN)) {
            System.out.println("BSN bestaat al, probeer opnieuw");
            return;
        } else {
            this.BSN = BSN;
            BSN_Onthouder.add(BSN);
            this.voornaam = voornaam;
            this.achternaam = achternaam;
            this.geslacht = geslacht;
            this.geboortedatum = geboortedatum;
        }
    }

    /**
     * Constructor voor klasse Persoon met alle waarden leeg gelaten
     */
    public Persoon() {
        BSN = 0;
        voornaam = "";
        achternaam = "";
        geslacht = Character.MIN_VALUE; //empty char value
        if(Math.random() < 0.5) {
            //50% kans
            this.betaalwijze = new Pinpas(30, 10);
        } else {
            this.betaalwijze = new Contant(50);
        }
    }

    /**
     * Methode die checkt of het BSN dat is ingevuld al bestaat in de lijst van BSNs
     *
     * @param nieuwBSN BSN van nieuwe instantie Persoon
     * @return Bestaat BSN wel/niet
     */
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

    /**
     * setter voor geboortedatum
     *
     * @param geboortedatum geboortedatum van persoon
     */
    public void setGeboortedatum(LocalDate geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    /**
     * setter voor BSN
     *
     * @param BSN BSN van persoon
     */
    public void setBSN(int BSN) {
        if(!bestaatBSN(BSN)) {
            this.BSN = BSN;
        } else {
            System.out.println("BSN staat al in database, vul a.u.b. een unieke BSN in.");
        }
    }

    /**
     * setter voor voornaam
     *
     * @param voornaam voornaam van persoon
     */
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    /**
     * setter voor achternaam
     *
     * @param achternaam achternaam van persoon
     */
    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    /**
     * setter voor geslacht
     *
     * @param geslacht geslacht van persoon
     */
    public void setGeslacht(char geslacht) {

        if(this.geslacht == 'm' || this.geslacht == 'v') {
            this.geslacht = geslacht;
        } else {
            //log an error
            System.out.println("invalid sex inserted");
        }
    }

    /**
     * getter voor BSN
     * @return BSN
     */
    public int getBSN() {
        return BSN;
    }

    /**
     * getter voor voornaam
     * @return voornaam
     */
    public String getVoornaam() {
        return voornaam;
    }

    /**
     * getter voor achternaam
     * @return achternaam
     */
    public String getAchternaam() {
        return achternaam;
    }

    /**
     * getter voor geboortedatum
     * @return geboortedatum als String
     */
    public String getGeboortedatum() {
        return geboortedatum.toString();
    }

    /**
     * getter voor geslacht
     * @return geslacht als String
     */
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

    /**
     * @return de adressering van een persoon
     */
    public String adressering() {

        if(geslacht == 'm' || geslacht == 'M') {
            return "dhr.";
        }
        if(geslacht == 'v' || geslacht == 'V') {
            return "mvr.";
        }

        //else
        return "";

    }

    /**
     * Maakt een betaalwijze aan voor de persoon
     * @param betaalwijze
     */
    public void setBetaalwijze(Betaalwijze betaalwijze) {
        this.betaalwijze = betaalwijze;
    }

    /**
     * Geeft terug welke betaalwijze de persoon gebruikt
     * @return instantie variabele betaalwijze
     */
    public Betaalwijze getBetaalwijze() {
        return betaalwijze;
    }

    /**
     * ToString methode
     *
     * @return String van alle persoonsinformatie
     */
    public String toString() {
        return String.format("BSN: %d; Naam: %s $s; Geboortedatum: %s; Geslacht: %C; ",
                BSN, voornaam, achternaam, geboortedatum.toString(), geslacht);
    }

    @Override
    public double geefMaximum() {
        return 0;
    }

    @Override
    public double geefKortingsPercentage() {
        return 0;
    }

    @Override
    public boolean heeftMaximum() {
        return false;
    }
}

/**
 * Subclass KantineMedewerker
 *
 * @author Joost Blaauwwiekel;, Hessel Jager
 * @version 1.0
 *
 */
public class KantineMedewerker extends Persoon {

    int medewerkersNummer;
    boolean magKassaStaan;


    public KantineMedewerker(int medewerkersNummer, boolean magKassaStaan) {
        super();
        this.magKassaStaan = magKassaStaan;
        this.medewerkersNummer = medewerkersNummer;
    }

    /**
     * Setter voor de variabele magKassaStaan
     * @param magKassaStaan
     */
    public void setMagKassaStaan(boolean magKassaStaan) {
        this.magKassaStaan = magKassaStaan;
    }

    /**
     * Setter voor de variabele medewerkersnummer
     * @param medewerkersNummer
     */
    public void setMedewerkersNummer(int medewerkersNummer) {
        this.medewerkersNummer = medewerkersNummer;
    }

    /**
     * Getter voor de variabele medewerkersnummer
     * @return medewerkersnummer
     */
    public int getMedewerkersNummer() {
        return medewerkersNummer;
    }

    /**
     * Getter voor de variabele magKassaStaan
     * @return magKassaStaan
     */
    public boolean getMagKassaStaan() {
        return magKassaStaan;
    }

}

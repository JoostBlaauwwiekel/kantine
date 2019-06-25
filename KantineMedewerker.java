import java.time.LocalDate;

/**
 * subclass KantineMedewerker
 * @version 1.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class KantineMedewerker extends Persoon implements KortingskaartHouder {

    int medewerkersNummer;
    boolean magKassaStaan;

    /**
     * Constructor van KantineMedewerker waar ook alle variabelen voor de Persoonklasse worden ingevoegd
     *
     * @param BSN burgerservicenummer, uniek per medewerker
     * @param voornaam voornaam van medewerker
     * @param achternaam achternaam van medewerker
     * @param geslacht geslacht van medewerker
     * @param datum geboortedatum
     * @param medewerkersNummer id-nummer van de medewerker
     * @param magKassaStaan boolean of de klant wel/niet achter de kassa mag staan
     */
    public KantineMedewerker(int BSN, String voornaam, String achternaam, char geslacht, LocalDate datum, int medewerkersNummer, boolean magKassaStaan) {
        super(BSN,voornaam,achternaam,geslacht,datum);
        this.magKassaStaan = magKassaStaan;
        this.medewerkersNummer = medewerkersNummer;
    }


    /**
     * Constructor van KantineMedewerker met alleen de super() waarden leeg gelaten
     *
     * @param medewerkersNummer id-nummer van de medewerker
     * @param magKassaStaan boolean of de klant wel/niet achter de kassa mag staan
     */
    public KantineMedewerker(int medewerkersNummer, boolean magKassaStaan) {
        super();
        this.magKassaStaan = magKassaStaan;
        this.medewerkersNummer = medewerkersNummer;
    }

    /**
     * Constructor van KantineMedewerker met alle waarden leeg gelaten
     */
    public KantineMedewerker() {
        super();
        magKassaStaan = false;
        medewerkersNummer = 0;
    }

    /**
     * Setter voor de variabele magKassaStaan
     * @param magKassaStaan boolean of de klant wel/niet achter de kassa mag staan
     */
    public void setMagKassaStaan(boolean magKassaStaan) {
        this.magKassaStaan = magKassaStaan;
    }

    /**
     * Setter voor de variabele medewerkersnummer
     * @param medewerkersNummer id-nummer van de medewerker
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

    /**
     * methode die het krotingspercentage geeft
     * @return kortingspercentage
     */
    @Override
    public double geefKortingsPercentage() {
        return 0.35;
    }

    /**
     * Methode die terug geeft of er een maximum geld
     * @return boolean maximum
     */
    @Override
    public boolean heeftMaximum() {
        return false;
    }

    /**
     * Methode die het maximale bedrag aan
     * korting terug geeft
     * @return maximum bedrag
     */
    @Override
    public double geefMaximum() {
        return 0;
    }

    /**
     * toString methode
     * @return String van persoonsgegevens
     */
    @Override
    public String toString() {
        return super.toString() + String.format("Medewerkersnummer: %d;\tStaat achter kassa: %b.", medewerkersNummer, magKassaStaan);
    }
}

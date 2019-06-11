/**
 * subclass Student
 * @version 1.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class Student extends Persoon {

    String studierichting;
    int studentnummer;

    /**
     * Constructor van Student waar ook alle variabelen voor de Persoonklasse worden ingevoegd
     *
     * @param BSN burgerservicenummer, uniek per Student
     * @param voornaam voornaam van Student
     * @param achternaam achternaam van Student
     * @param geslacht geslacht van Student
     * @param dag dag van de maand van geboortedatum
     * @param maand geboortemaand
     * @param jaar geboortejaar
     * @param studierichting welke opleiding de student volgt
     * @param studentnummer unieke studentnummer van de student
     */
    public Student(int BSN, String voornaam, String achternaam, char geslacht, int dag, int maand, int jaar, String studierichting, int studentnummer) {
        super(BSN,voornaam,achternaam,geslacht,dag,maand,jaar);
        this.studentnummer = studentnummer;
        this.studierichting = studierichting;
    }

    /**
     * Constructor van Student met alleen de super() waarden leeg gelaten
     *
     * @param studierichting welke opleiding de student volgt
     * @param studentnummer unieke studentnummer van de student
     */
    public Student(String studierichting, int studentnummer) {
        super();
        this.studentnummer = studentnummer;
        this.studierichting = studierichting;
    }

    /**
     * Constructor van Student met alle waarden leeg gelaten
     */
    public Student() {
        super();
        studentnummer = 0;
        studierichting = "";
    }

    /**
     * Setter voor de variabele studentNummer
     * @param studentnummer unieke studentnummer van de student
     */
    public void setStudentnummer(int studentnummer) {
        this.studentnummer = studentnummer;
    }

    /**
     * Setter voor de variabele studierichting
     * @param studierichting welke opleiding de student volgt
     */
    public void setStudierichting(String studierichting) {
        this.studierichting = studierichting;
    }

    /**
     * Getter voor de variabele studentnummer
     * @return het studentnummer
     */
    public int getStudentnummer() {
        return studentnummer;
    }

    /**
     * Getter voor de variabele studierichting
     * @return de studierichting
     */
    public String getStudierichting() {
        return studierichting;
    }
}

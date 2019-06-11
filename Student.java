/**
 * subclass Student
 * @version 1.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class Student extends Persoon {

    String studierichting;
    int studentnummer;

    /**
     * Constructor van Student
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
     * Constructor van Student waar de waarden leeg gelaten zijn
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
     * @return studentnummer
     */
    public int getStudentnummer() {
        return studentnummer;
    }

    /**
     * Getter voor de variabele studierichting
     * @return studierichting
     */
    public String getStudierichting() {
        return studierichting;
    }
}

/**
 * Subclass Student
 *
 * @author Joost Blaauwwiekel;, Hessel Jager
 * @version 1.0
 *
 */
public class Student extends Persoon {

    String studierichting;
    int studentnummer;

    public Student(String studierichting, int studentnummer) {
        super();
        this.studentnummer = studentnummer;
        this.studierichting = studierichting;
    }

    /**
     * Setter voor de variabele studentNummer
     * @param studentnummer
     */
    public void setStudentnummer(int studentnummer) {
        this.studentnummer = studentnummer;
    }

    /**
     * Setter voor de variabele studierichting
     * @param studierichting
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

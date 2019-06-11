/**
 * class test
 * @version 1.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class test {
    public Datum datum;

    public static void main(String[] args) {
        //Administratie administratie = new Administratie();
        int[] i = {45, 56, 34, 39, 40, 31};
        double[] j = {567.70, 498.25, 458.90};
        double[] k = {321.35, 450.50, 210.45, 190.85, 193.25, 159.90, 214.25, 220.90, 201.90, 242.70, 260.35};
        int day = 1;
        System.out.println("Gemiddelde aantal berekenen:");
        System.out.println(Administratie.berekenGemiddeldAantal(i)+"\n");
        System.out.println("Gemiddelde omzet berekenen:");
        System.out.println(Administratie.berekenGemiddeldeOmzet(j)+"\n");
        System.out.println("Dag omzet berekenen:");
        for (double omzet: Administratie.berekenDagOmzet(k)) {
            System.out.println(getDay(day) + ": " + omzet);
            day++;
        }
    }

    /**
     * Zet het nummer van de dag om naar de naam
     *
     * @param x getal dat dag representeert
     * @return de naam van de dag
     */
    private static String getDay(int x) {
        switch(x) {
            case 1:
                return "Maandag";
            case 2:
                return "Dinsdag";
            case 3:
                return "Woensdag";
            case 4:
                return "Donderdag";
            case 5:
                return "Vrijdag";
            case 6:
                return "Zaterdag";
            case 7:
                return "Zondag";
            default:
                return ("Er ging iets mis met de dag vinden x=" + x);
        }
    }
}
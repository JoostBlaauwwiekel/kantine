public class Administratie {

    final static int DAYS_IN_WEEK = 7;

    /**
     * Constructor voor Administratie, deze is private zodat
     * je niet per ongeluk een instantie van deze klasse kunt maken
     */
    private Administratie() { }

    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal aantak
     * @return het gemiddelde
     */
    public static double berekenGemiddeldAantal(int[] aantal) {
        double totaal = 0;
        for (double i : aantal) {
            totaal += i;
        }
        if(aantal.length == 0) {
            return 0;
        } else {
            return totaal / aantal.length;
        }
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet omzet
     * @return het gemiddelde
     */
    public static double berekenGemiddeldeOmzet(double[] omzet) {
        double totaal = 0;
        for (double i : omzet) {
            totaal += i;
        }
        if(omzet.length == 0) {
            return 0;
        } else {
            return totaal / omzet.length;
        }
    }

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet omzet
     * @return array (7 elementen) met dagomzetten
     */

    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp = new double[DAYS_IN_WEEK];
        for(int i = 0; i < DAYS_IN_WEEK; i++) {

            int j = 0;
            while(i + DAYS_IN_WEEK * j < omzet.length) {
                temp[i] += omzet[i + DAYS_IN_WEEK * j];
                j++;
                // omitted
            }
        }
        return temp;
    }
}

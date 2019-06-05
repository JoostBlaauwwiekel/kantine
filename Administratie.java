public class Administratie {

    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal aantak
     * @return het gemiddelde
     */
    public double berekenGemiddeldAantal(int[] aantal) {
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
    public double berekenGemiddeldeOmzet(double[] omzet) {
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
        double[] temp = new double[7];
        for(int i = 0; i < 7; i++) {

            int j = 0;
            while( ... ) {
                temp[i] += omzet[i + 7 * j];

                // omitted

            }
        }
        return temp;
    }
}

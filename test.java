public class test {
    public Datum datum;

    public static void main(String[] args) {
        //Administratie administratie = new Administratie();
        int[] i = {45, 56, 34, 39, 40, 31};
        double[] j = {567.70, 498.25, 458.90};
        double[] k = {321.35, 450.50, 210.45, 190.85, 193.25, 159.90, 214.25, 220.90, 201.90, 242.70, 260.35};
        //System.out.println(Administratie.berekenGemiddeldAantal(i));
        //System.out.println(Administratie.berekenGemiddeldeOmzet(j));
        for (double omzet: Administratie.berekenDagOmzet(k)) {
            System.out.println(omzet);
        }
    }
}
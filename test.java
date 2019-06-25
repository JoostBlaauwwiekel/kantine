import javax.swing.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Stack;

/**
 * class test
 * @version 1.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class test {

    /**
     * Main voor testen
     * @param args args
     */
    public static void main(String[] args) {
        testFactuur();
        //testAdministratie();
        //testBetalen();
        //testKassaRij();
    }

    /**
     * Tester voor Factuur klasse
     */
    public static void testFactuur() {
        System.out.printf("\n\n-----------%s-----------\n\n", "testFactuur");
        Artikel eenn = new Artikel("broodje ham     ", 1.25);
        Artikel twee = new Artikel("broodje ham/kaas", 2.10);
        Artikel drie = new Artikel("koffie          ", 0.95);
        Artikel vier = new Artikel("frikandel       ", 1.50);

        Persoon persoon = new Docent();
        double kortingPersoon = persoon.geefKortingsPercentage();
        Dienblad dienblad = new Dienblad(persoon);
        dienblad.voegToe(eenn);
        dienblad.voegToe(twee);
        dienblad.voegToe(drie);
        dienblad.voegToe(vier);

        Factuur factuur = new Factuur();

        factuur.setTotaal(factuur.getTotaalPrijs(dienblad));

        factuur.setKorting(factuur.getTotaal() - (1-kortingPersoon)*factuur.getTotaal());
        if(factuur.getKorting() > 1) {factuur.setKorting(1);}

        Stack<Artikel> artikelen = dienblad.getArtikel();
        for (Artikel artikel: artikelen) {
            FactuurRegel regel = new FactuurRegel(factuur, artikel);
            factuur.addRegel(regel);
        }
        System.out.printf(factuur.toString());
        System.out.printf("\n\n------------%s------------\n\n", "eindeTest");
    }

    /**
     * Tester voor Administratie methoden
     */
    public static void testAdministratie() {
        System.out.printf("\n\n--------%s--------\n\n", "testAdministratie");
        int[] i = {45, 56, 34, 39, 40, 31};
        double[] j = {567.70, 498.25, 458.90};
        double[] k = {321.35, 450.50, 210.45, 190.85, 193.25, 159.90, 214.25, 220.90, 201.90, 242.70, 260.35};
        int day = 0;
        System.out.println("Gemiddelde aantal berekenen:");
        System.out.println(Administratie.berekenGemiddeldAantal(i)+"\n");
        System.out.println("Gemiddelde omzet berekenen:");
        System.out.println(Administratie.berekenGemiddeldeOmzet(j)+"\n");
        System.out.println("Dag omzet berekenen:");
        for (double omzet: Administratie.berekenDagOmzet(k)) {
            System.out.println(Administratie.getDay(day) + ": " + omzet);
            day++;
        }
        System.out.printf("\n\n------------%s------------\n\n", "eindeTest");
    }

    /**
     * tester voor betalen met exception
     */
    public static void testBetalen() {
        System.out.printf("\n\n-----------%s-----------\n\n", "testBetalen");
        Betaalwijze pin = new Pinpas(30, 10);
        Betaalwijze contant = new Contant(20);
        double teBetalen = 20;

        try {
            pin.betaal(teBetalen);
            System.out.printf("Betaling met pin van €.2f succesvol, uw huidige saldo is: €%.2f\n",teBetalen, pin.getSaldo());
            contant.betaal(teBetalen);
            System.out.printf("Betaling contant van €.2f succesvol, uw huidige saldo is: €%.2f", teBetalen, contant.getSaldo());
        } catch(TeWeinigGeldException e) {
            JOptionPane.showMessageDialog(null, e, "Foutmelding", JOptionPane.INFORMATION_MESSAGE);
        }
        System.out.printf("\n\n------------%s------------\n\n", "eindeTest");
    }

    /**
     * tester voor kassarij
     */
    public static void testKassaRij() {
        System.out.printf("\n\n-----------%s----------\n\n", "testKassaRij");
        Persoon persoon1 = new Persoon();
        Persoon persoon2 = new Persoon();
        Persoon persoon3 = new Persoon();
        Persoon persoon4 = new Persoon();

        KassaRij kassaRij = new KassaRij();

        kassaRij.sluitAchteraan(persoon1);
        kassaRij.sluitAchteraan(persoon2);
        kassaRij.sluitAchteraan(persoon3);
        kassaRij.sluitAchteraan(persoon4);
        Persoon vooraan = kassaRij.eerstePersoonInRij();

        System.out.printf(vooraan.toString());
        System.out.printf("\n\n------------%s------------\n\n", "eindeTest");
    }
}
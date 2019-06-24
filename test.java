import javax.swing.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Stack;

/**
 * class test
 * @version 1.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class test {

    public static void main(String[] args) {
        String a = "bier";
        int b = 10;
        String testEen = String.format("Ik drink %d", b);
        String testTwee = String.format(" koude %s", a);
        System.out.println(testEen + testTwee);
    }

    /**
     * Berekent de hoeveelheid korting een persoon krijgt
     *
     * @param persoon persoongegevens klant
     * @param teBetalen totaalbedrag
     * @return
     */
    public static double getKorting(Persoon persoon, double teBetalen) {
        if(persoon.geefKortingsPercentage() > 0) {
            //bereken nieuwe prijs
            double korting = persoon.geefKortingsPercentage();
            double nieuwePrijs = (100 - korting) * teBetalen / 100;

            //check of er een maximum geldt
            if(persoon.heeftMaximum()) {
                //de korting mag niet meer zijn dan 1 euro
                //haal gewoon het maximum van de originele bedrag af

                //vraag het maximale bedrag op
                double maximaal = persoon.geefMaximum();

                //bereken de korting die is gegeven
                double gegevenKorting = teBetalen - nieuwePrijs;

                //als deze groter is dan het maximale bedrag
                //moeten er maatregelen genomen worden
                if(gegevenKorting > maximaal) {
                    return maximaal;
                } else {
                    return gegevenKorting;
                }
            }
        }
        return 0;
    }
}
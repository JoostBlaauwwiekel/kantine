import javax.swing.*;

/**
 * class test
 * @version 1.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class test {
    public Datum datum;

    public static void main(String[] args) {
        Betaalwijze pin = new Pinpas(30, 10);
        Betaalwijze contant = new Contant(19);

        try {
            pin.betaal(20);
            contant.betaal(20);
        } catch(TeWeinigGeldException e) {
            JOptionPane.showMessageDialog(null, e, "Foutmelding", JOptionPane.INFORMATION_MESSAGE);
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
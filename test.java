import javax.swing.*;

/**
 * class test
 * @version 1.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class test {
    public Datum datum;

    public static void main(String[] args) {
        Persoon persoon1 = new Persoon();
        Persoon persoon2 = new Persoon();
        Persoon persoon3 = new Persoon();
        Persoon persoon4 = new Persoon();

        KassaRij kassaRij = new KassaRij();

        kassaRij.sluitAchteraan(persoon1);
        kassaRij.sluitAchteraan(persoon2);
        kassaRij.sluitAchteraan(persoon3);
        kassaRij.sluitAchteraan(persoon4);

        System.out.println(kassaRij.eerstePersoonInRij());

    }
}
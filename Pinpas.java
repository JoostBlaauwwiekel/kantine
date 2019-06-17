/**
 * subclass Pinpas
 * @version 1.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class Pinpas extends Betaalwijze {

    private double kredietlimiet;

    public Pinpas(double kredietlimiet, double saldo) {
        super(saldo);

    }
    /**
     * Methode om kredietlimiet te zetten
     * @param kredietlimiet limiet om krediet te staan
     */
    public void setKredietLimiet(double kredietlimiet) {
        this.kredietlimiet = kredietlimiet;
    }

    /**
     * Methode om betaling af te handelen
     * return true
     */
    public boolean betaal(double tebetalen) {
        //haal het te betalen bedrag af van het saldo
        double nieuwSaldo = saldo - tebetalen;

        //check of het nieuwe saldo minder is dan 0
        if(nieuwSaldo < 0) {
            //dus wanneer de klant niet genoeg geld
            //op zijn/haar rekening heeft
            return false;
        } else {
            //wanneer de klant wel genoeg geld
            //op zijn/haar rekening heeft
            return true;
        }
    }
}

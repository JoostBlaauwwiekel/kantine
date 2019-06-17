/**
 * subclass Pinpas
 * @version 1.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class Pinpas extends Betaalwijze {

    private double kredietlimiet;

    public Pinpas(double kredietlimiet, double saldo) {
        super(saldo);
        this.kredietlimiet = kredietlimiet;
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
    public void betaal(double tebetalen) throws TeWeinigGeldException {
        //haal het te betalen bedrag af van het saldo
        double nieuwSaldo = saldo - tebetalen;
        double krediet = nieuwSaldo;

        //Geeft de absolute waarde van krediet
        if(nieuwSaldo < 0) {
            krediet = nieuwSaldo*-1;
        }

        //check of het nieuwe saldo minder is dan 0
        if(krediet > kredietlimiet) {
            throw new TeWeinigGeldException("U heeft uw kreditlimiet overschreden.");
        }
        saldo = nieuwSaldo;
    }
}

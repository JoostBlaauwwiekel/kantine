/**
 * subclass Contant
 * @version 1.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class Contant extends Betaalwijze {
    /**
     * Methode om betaling af te handelen
     */
    public Contant(double saldo) {
        super(saldo);
    }

    /**
     * Methode om een betaling te verichten met contant geld
     *
     * @param tebetalen hoeveelheid dat de klant moet betalen
     * @return of de betaling is gelukt
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException {
        //haal het te betalen bedrag af van het saldo
        double nieuwSaldo = saldo - tebetalen;

        //check of het nieuwe saldo minder is dan 0
        if(nieuwSaldo < 0) {
            throw new TeWeinigGeldException("U heeft onvoldoende contant saldo.");
        }
        saldo = nieuwSaldo;
    }


}
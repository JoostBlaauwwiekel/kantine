/**
 * class Betaalwijze
 * @version 1.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public abstract class Betaalwijze {

    protected double saldo;

    public Betaalwijze(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Methode om krediet te initialiseren
     * @param saldo saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @return saldo
     */
    public double getSaldo() { return saldo; }

    /**
     * Methode om betaling af te handelen
     *
     * @param tebetalen hoeveelheid dat de klant moet betalen
     * @return Boolean om te kijken of er voldoende saldo is
     */
    public abstract void betaal(double tebetalen) throws TeWeinigGeldException;

}
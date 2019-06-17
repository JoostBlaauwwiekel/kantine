public class TeWeinigGeldException extends Exception {

    private Exception e;
    private String message = "U heeft niet voldoende saldo";

    /**
     * constructor zonder parameters
     */
    public TeWeinigGeldException() {}

    /**
     * Constructor met parameter voor Exception
     * @param e Exception
     */
    public TeWeinigGeldException(Exception e) {this.e = e;}

    /**
     * Constructor met bericht parameter
     * @param message bericht voor exception
     */
    public TeWeinigGeldException(String message) {
        this.message = message;
    }

    /**
     * retourneert een String
     *
     * @return string bericht
     */
    public String toString(){
        return "Error: " + message;
    }
}

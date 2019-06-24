import javax.persistence.*;
import java.io.Serializable;
import java.text.DecimalFormat;

@Entity
@Table(name="factuur_regel")
public class FactuurRegel implements Serializable {

    //Decimalen van bedragen altijd met 2 decimalen
    private final DecimalFormat geldNotatie = new DecimalFormat("#.00");

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Factuur factuur;

    @Embedded
    private Artikel artikel;

    /**
     * constructor zonder parameters
     */
    public FactuurRegel() {}

    /**
     * constructor met parameters
     * @param factuur de factuur voor deze regel
     * @param artikel het artikel van de regel
     */
    public FactuurRegel(Factuur factuur, Artikel artikel) {
        this.artikel = artikel;
        this.factuur = factuur;
    }

    /**
     * @return printbare factuurregel
     */
    public String toString() {
        return String.format("%s\t€%.2f\n", artikel.getNaam(), artikel.getPrijs());
    }
}

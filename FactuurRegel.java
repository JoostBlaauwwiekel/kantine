import javax.persistence.*;
import java.io.Serializable;
import java.text.DecimalFormat;

@Entity
@Table(name="factuur_regel")
public class FactuurRegel implements Serializable {

    //id van factuurregel
    @Id
    @GeneratedValue
    private long id;

    //factuurregel hoort bij dit factuur
    @ManyToOne
    private Factuur factuur;

    //artikel van de regel
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

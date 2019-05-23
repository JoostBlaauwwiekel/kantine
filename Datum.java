import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Datum {

	private int dag;
	private int maand;
	private int jaar;

	public Datum(int dag, int maand, int jaar) {
		if(bestaatDatum(this.dag, this.maand, this.jaar)) {
			this.dag = dag;
			this.maand = maand;
			this.jaar = jaar;
		} else {
			dag = 0;
			maand = 0;
			jaar = 0;
		}
	}

	public Datum() {
		dag = 0;
		maand = 0;
		jaar = 0;
	}

	public void setDag(int dag) {
		if(bestaatDatum(dag,maand,jaar)) {
			this.dag = dag;
		}
	}

	public void setMaand(int maand) {
		if(bestaatDatum(dag,maand,jaar)) {
			this.maand = maand;
		}
	}

	public void setJaar(int jaar) {
		if(bestaatDatum(dag,maand,jaar)) {
			this.jaar = jaar;
		}
	}

	public boolean bestaatDatum(int dag, int maand, int jaar){
		// TODO? DONE!
		boolean exists = false;

		//first conditions
		if(dag >= 1 && maand >= 1 && maand <= 12 && jaar >= 1900 && jaar <= 2100) {
			//second layer of conditions
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

			// Input to be parsed should strictly follow the defined date format
			// above.
			format.setLenient(false);

			String date = dag + "/" + maand + "/" + jaar;
			try {
				format.parse(date);
			} catch (ParseException e) {
				System.out.println("Datum: " + date + " is geen correcte datum. ");
			}

			//if everything is correct, the exits variable becomes true
			exists = true;
		}

		return exists;
	}
	
	/**
	 * Getter voor Sting weergave van datum
	 * @return Geboortedatum
	 */
	public String getDatumAsString() {
		return dag + "-" + maand + "-" + jaar;
	}
}

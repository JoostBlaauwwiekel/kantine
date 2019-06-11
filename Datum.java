/**
 * class Datum
 * @version 1.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class Datum {

	private int dag;
	private int maand;
	private int jaar;

	/**
	 * Constructor van de klasse Datum
	 * Controleert of de datum bestaat,
	 * anders worden de waarden naar 0 gezet
	 *
	 * @param dag dag van de datum
	 * @param maand maand van de datum
	 * @param jaar jaar van de datum
	 */
	public Datum(int dag, int maand, int jaar) {
		//meteen checken of datum bestaat
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

	/**
	 * parameterloze constructor
	 */
	public Datum() {
		dag = 0;
		maand = 0;
		jaar = 0;
	}

	/**
	 * Setter van de variabele dag
	 * @param dag dag van datum
	 */
	public void setDag(int dag) {
		if(bestaatDatum(dag,maand,jaar)) {
			this.dag = dag;
		}
	}

	/**
	 * Setter van de variabele dag
	 * @param maand maand van datum
	 */
	public void setMaand(int maand) {
		if(bestaatDatum(dag,maand,jaar)) {
			this.maand = maand;
		}
	}

	/**
	 * Setter van de variabele jaar
	 * @param jaar jaar van datum
	 */
	public void setJaar(int jaar) {
		if(bestaatDatum(dag,maand,jaar)) {
			this.jaar = jaar;
		}
	}

	/**
	 *
	 * Deze methode controleert of de opgegeven
	 * datum bestaat of niet
	 *
	 * @param dag dag van datum
	 * @param maand maand van datum
	 * @param jaar jaar van datum
	 * @return boolean valid date
	 */
	public boolean bestaatDatum(int dag, int maand, int jaar) {
		boolean exists = false;

		//first conditions
		if(dag >= 1 && maand >= 1 && maand <= 12 && jaar >= 1900 && jaar <= 2100) {
			//second layer of conditions
			if(maand == 1 && dag > 31) {

			} else if(maand == 2 && dag > 28) {
				//some special conditions for february
				if(jaar % 4 == 0) {
					//if it is a 'schikkeljaar'
					if(maand == 2 && dag > 29) {
						exists = false;
					}
				}

				exists = false;
			} else if(maand == 3 && dag > 31) {
				exists = false;
			} else if(maand == 4 && dag > 30) {
				exists = false;
			} else if(maand == 5 && dag > 31) {
				exists = false;
			} else if(maand == 6 && dag > 30) {
				exists = false;
			} else if(maand == 7 && dag > 31) {
				exists = false;
			} else if(maand == 8 && dag > 31) {
				exists = false;
			} else if(maand == 9 && dag > 30) {
				exists = false;
			} else if(maand == 10 && dag > 31) {
				exists = false;
			} else if(maand == 11 && dag > 30) {
				exists = false;
			} else if(maand == 12 && dag > 31) {
				exists = false;
			} else {
				//if everything is correct, the exits variable becomes true
				exists = true;
			}
		}

		return exists;
	}
	
	/**
	 * Getter voor Sting weergave van datum
	 * @return datum als String
	 */
	public String getDatumAsString() {
		return dag + "-" + maand + "-" + jaar;
	}
}

package N3E1;

/**
 * De les notícies de tenis s’ha de saber de quina competició(String) parlen i
 * de quins tenistes(String). Notícies de tenis: Preu inicial: 150 € Federer,
 * Nadal o Djokovic: 100 € Notícies de Tenis: 4 punts Federer, Nadal o Djokovic:
 * 3 punts
 *
 */

public class NoticiaTenis extends Noticia {

	// attributes
	private String competition;
	private String tenista;

	// constructor
	public NoticiaTenis(String headline, String competition, String tenista) {
		super(headline);
		this.competition = competition;
		this.tenista = tenista;
	}

	// setters/getters
	public String getCompetition() {
		return competition;
	}

	public void setCompetition(String competition) {
		this.competition = competition;
	}

	public String getTenista() {
		return tenista;
	}

	public void setTenista(String tenista) {
		this.tenista = tenista;
	}

	// Generals
	public String toString() {
		return "Noticia de Tenis, el titular es " + super.getHeadline() + " de la competicion " + this.competition + " del tenista " + this.tenista;
	}
	
	public int calcPriceNews() {

		int totalPrice = 0, initialPrice = 0, priceTenista = 0;

		initialPrice = 150;
		priceTenista = ((this.tenista.equalsIgnoreCase("Federer")) || (this.tenista.equalsIgnoreCase("Nadal"))
				|| (this.tenista.equalsIgnoreCase("Djokovic")) ? 100 : 0);
		totalPrice = initialPrice + priceTenista;
		super.setPrice(totalPrice);

		return totalPrice;
	}

	public int calcScoreNews() {

		int totalScore = 0, initialScore = 0, scoreTenista = 0;

		initialScore = 4;
		scoreTenista = ((this.tenista.equalsIgnoreCase("Federer")) || (this.tenista.equalsIgnoreCase("Nadal"))
				|| (this.tenista.equalsIgnoreCase("Djokovic")) ? 3 : 0);
		totalScore = initialScore + scoreTenista;
		super.setPrice(totalScore);

		return totalScore;
	}
}

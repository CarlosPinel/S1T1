package N3E1;

/**
 * De les notícies d'F1 hem de saber a quina escuderia(String) fan referència.
 * Notícies d'F1: Preu inicial: 100 € Ferrari o Mercedes: 50 € 
 * Notícies F1: 4 punts Ferrari o Mercedes: 2 punts
 */

public class NoticiaF1 extends Noticia {

	// Attributes
	private String team;

	// Constructor
	public NoticiaF1(String headline, String team) {
		super(headline);
		this.team = team;
	}

	// setters/getters
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	// Generals
	public String toString() {
		return "Noticia de tenis, el titular es " + super.getHeadline() + " del equipo " + this.team;
	}
	
	public int calcPriceNews() {

		int totalPrice = 0, initialPrice = 0, priceTeam = 0;

		initialPrice = 100;
		priceTeam = ((this.team.equalsIgnoreCase("Ferrari")) || (this.team.equalsIgnoreCase("Mercedes")) ? 50 : 0);
		totalPrice = initialPrice + priceTeam;
		super.setPrice(totalPrice);

		return totalPrice;
	}

	public int calcScoreNews() {

		int totalScore = 0, initialScore = 0, scoreTeam = 0;

		initialScore = 4;
		scoreTeam = ((this.team.equalsIgnoreCase("Ferrari")) || (this.team.equalsIgnoreCase("Mercedes")) ? 2 : 0);
		totalScore = initialScore + scoreTeam;
		super.setScore(totalScore);
		
		return totalScore;
	}
}

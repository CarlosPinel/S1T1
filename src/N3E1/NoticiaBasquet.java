package N3E1;

/**
 * De les notícies de bàsquet s’ha d’indicar a quina competició fa
 * referència(String) i a quin club(String). Notícies de bàsquet: Preu inicial:
 * 250 € Eurolliga: 75 € Barça o Madrid: 75 €
 * 
 * Notícies de bàsquet: 4 punts Eurolliga: 3 punts ACB: 2 punts Barça o Madrid:
 * 1 punt
 */

public class NoticiaBasquet extends Noticia {

	// Atributos
	private String competition;
	private String club;

	// Constructor
	public NoticiaBasquet(String headline, String competition, String club) {
		super(headline);
		this.competition = competition;
		this.club = club;
	}

	// setters/getters
	public String getCompetition() {
		return competition;
	}

	public void setCompetition(String competition) {
		this.competition = competition;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	// Generals
	public String toString() {
		return "Noticia es de basquet, el titular es " + super.getHeadline() + " de la competicion " + this.competition + " del club " + this.club;
	}

	public int calcPriceNews() {

		int totalPrice = 0, initialPrice = 0, priceComp = 0, priceClub = 0;

		initialPrice = 250;
		priceComp = ((this.competition.equalsIgnoreCase("Euroleague")) ? 75 : 0);
		priceClub = ((this.club.equalsIgnoreCase("Barça")) || (this.club.equalsIgnoreCase("Madrid")) ? 75 : 0);
		totalPrice = initialPrice + priceComp + priceClub;
		super.setPrice(totalPrice);

		return totalPrice;
	}

	public int calcScoreNews() {

		int totalScore = 0, initialScore = 0, scoreComp = 0, scoreClub = 0;

		initialScore = 4;
		if (this.competition.equalsIgnoreCase("Euroleague")) {
			scoreComp = 3;
		} else if (this.competition.equalsIgnoreCase("ACB")) {
			scoreComp = 2;
		} else {
			scoreComp = 0;
		}
		scoreClub = ((this.club.equalsIgnoreCase("Barça")) || (this.club.equalsIgnoreCase("Madrid")) ? 1 : 0);
		totalScore = initialScore + scoreComp + scoreClub;
		super.setScore(totalScore);

		return totalScore;
	}
}

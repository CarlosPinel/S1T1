package N3E1;

/**
 * A més, de les notícies de futbol s’ha de saber a quina competició fa
 * referència(String), a quin club(String) i a quin jugador(String). Notícies de
 * futbol: Preu inicial: 300 € Lliga de Campions: 100 € Barça o Madrid: 100 €
 * Ferran Torres o Benzema: 50 € Exemple: Una notícia que parla d’un gol de
 * Ferran Torres del Barça a la Lliga de Campions, té un preu de 550 €.
 * 
 * Notícies de futbol: 5 Punts. Lliga de Campions: 3 punts Lliga: 2 punts Barça
 * o Madrid: 1 punt Ferran Torres o Benzema: 1 punt Exemple: Una notícia que
 * parla d’un gol de Ferran Torres del Barça a la Lliga de Campions, té una
 * puntuació de 10 punts.
 * 
 */

public class NoticiaFutbol extends Noticia {

	// Atributos
	private String competition;
	private String club;
	private String player;

	// Constructor
	public NoticiaFutbol(String headline, String competition, String club, String player) {
		super(headline);
		this.competition = competition;
		this.club = club;
		this.player = player;
	}

	// getters/setters
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

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	// Generals
	public String toString() {
		return "Noticia de futbol, el titular es " + super.getHeadline() + " de la competicion " + this.competition + " del club " + this.club + " del jugador " + this.player;
	}
	
	public int calcPriceNews() {

		int totalPrice = 0, initialPrice = 0, priceComp = 0, priceClub = 0, pricePlayer = 0;

		initialPrice = 300;
		priceComp = ((this.competition.equalsIgnoreCase("champions league")) ? 100 : 0);
		priceClub = ((this.club.equalsIgnoreCase("Barça")) || (this.club.equalsIgnoreCase("Madrid")) ? 100 : 0);
		pricePlayer = ((this.player.equalsIgnoreCase("Ferran Torres")) || (this.player.equalsIgnoreCase("Benzema")) ? 50 : 0);
		totalPrice = initialPrice + priceComp + priceClub + pricePlayer;
		super.setPrice(totalPrice);

		return totalPrice;
	}
	
	public int calcScoreNews() {

		int totalScore = 0, initialScore = 0, scoreComp = 0, scoreClub = 0, scorePlayer = 0;

		initialScore = 5;
		if (this.competition.equalsIgnoreCase("champions league")) {
			scoreComp = 3;
		} else if (this.competition.equalsIgnoreCase("la liga")) {
			scoreComp = 2;
		} else {
			scoreComp = 0;
		}
		scoreClub = ((this.club.equalsIgnoreCase("Barça")) || (this.club.equalsIgnoreCase("Madrid")) ? 1 : 0);
		scorePlayer = ((this.player.equalsIgnoreCase("Ferran Torres")) || (this.player.equalsIgnoreCase("Benzema")) ? 1 : 0);
		totalScore = initialScore + scoreComp + scoreClub + scorePlayer;
		super.setScore(totalScore);

		return totalScore;
	}
}

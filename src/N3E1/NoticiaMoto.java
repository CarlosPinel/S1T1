package N3E1;

/**
 * 
 * De les notícies de motociclisme s’ha d’indicar de quin equip(String) són.
 * Notícies de motociclisme: Preu inicial: 100 € Honda o Yamaha: 50 €
 * 
 * Notícies de Motociclisme: 3 punts Honda o Yamaha: 3 punts
 *
 */

public class NoticiaMoto extends Noticia {

	// Attributes
	private String team;

		// Constructor
		public NoticiaMoto(String headline, String team) {
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
			return "Noticia de motociclismo, el titular es " + super.getHeadline() + " del equipo " + this.team;
		}
		
		public int calcPriceNews() {

			int totalPrice = 0, initialPrice = 0, priceTeam = 0;

			initialPrice = 100;
			priceTeam = ((this.team.equalsIgnoreCase("Honda")) || (this.team.equalsIgnoreCase("Yamaha")) ? 50 : 0);
			totalPrice = initialPrice + priceTeam;
			super.setPrice(totalPrice);

			return totalPrice;
		}

		public int calcScoreNews() {

			int totalScore = 0, initialScore = 0, scoreTeam = 0;

			initialScore = 3;
			scoreTeam = ((this.team.equalsIgnoreCase("Honda")) || (this.team.equalsIgnoreCase("Yamaha")) ? 3 : 0);
			totalScore = initialScore + scoreTeam;
			super.setScore(totalScore);
			
			return totalScore;
		}

	}

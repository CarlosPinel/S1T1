/**
 * 
 */
package N3E1;

/*
En una redacció de notícies esportives tenen les notícies classificades per
esports: futbol, bàsquet, tenis, F1 i motociclisme. 
Les notícies han de tenir un titular, un text, una puntuació i un preu. 
En el moment de crear-se, el text ha d’estar buit. 
Les notícies es venen a diferents mitjans. 
Per saber el preu de cada notícia hem d'implementar un mètode que es diu calcularPreuNoticia(). 
*/

public abstract class Noticia {

	// Atributos
	private String headline;
	private String text;
	private int score;
	private int price;

	// Constructor
	public Noticia(String headline) {
		this.headline = headline;
		this.text = "";
		this.score = 0;
		this.price = 0;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	// Generals

	public abstract int calcPriceNews();
	
	public abstract int calcScoreNews();
	
	public String toString() {
		return " La noticia tiene el titular " + this.headline;
	}
}

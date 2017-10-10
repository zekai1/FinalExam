package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class Deck {

	private ArrayList<Card> cardsInDeck = new ArrayList<Card>();

	public Deck() {
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	public Card Draw() throws DeckException {
		
		if (this.cardsInDeck.size() == 0) {
			throw new DeckException(this);
		}
		
		return cardsInDeck.remove(0);
	}
	 
	public Card Draw(eSuit eSuit) {
		for (Card card: this.cardsInDeck) {
			if(card.geteSuit() == eSuit)
				return card;
		}
		return null;
	}
	
	public Card Draw(eRank eRank) {
		for (Card card : this.cardsInDeck) {
			if (card.geteRank() == eRank) {
				return card;
			}
		}
		return null;
	}
	
	public int CardCountSuit(eSuit eSuit) {
		int count = 0;
		for (Card card : this.cardsInDeck) {
			if(card.geteSuit() == eSuit) {
				count ++;
			}
		}
		return count;
	}
	
	public int CardCountRank(eRank eRank){ 
		int count = 0;
		for(Card card: this.cardsInDeck) {
			if (card.geteRank()==eRank)
				count ++;
			}
		return count;
	}
	
	public int CardCount(Card c) {
		for (Card card: cardsInDeck) {
			if(card == c) {
				return 1;
			}
		}
		return 0;
	}	
}

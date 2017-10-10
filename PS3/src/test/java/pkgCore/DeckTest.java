package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;


public class DeckTest {
	Deck deck = new Deck();
	
	@Test (expected = DeckException.class)
	public void TestEmptyDeck() throws DeckException  {
		for (int i = 0; i < 54; i++) {
					deck.Draw();			
				}
	}
	
	@Test
	public void TestDrawSuit() {
		Card card = deck.Draw(eSuit.DIAMONDS);
		assertTrue(card.geteSuit() == eSuit.DIAMONDS);
	}
	
	@Test
	public void TestDrawRank() {
		Card card = deck.Draw(eRank.JACK);
		assertTrue(card.geteRank() == eRank.JACK);
	} 
	
	@Test
	public void TestDeckRankCount() {
		assertTrue(deck.CardCountRank(pkgEnum.eRank.KING) == 4);
	}
	
	@Test
	public void TestDeckSuitCount() {
		assertTrue(deck.CardCountSuit(pkgEnum.eSuit.DIAMONDS) == 13);
	}

}

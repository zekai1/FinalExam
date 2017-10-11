package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.eCardNo;
import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPoker extends Hand {

	private ArrayList<CardRankCount> CRC = null;

	public HandPoker() {
		this.setHS(new HandScorePoker());
	}

	protected ArrayList<CardRankCount> getCRC() {
		return CRC;
	}

	@Override
	public HandScore ScoreHand() {
		// TODO : Implement this method... call each of the 'is' methods (isRoyalFlush,
		// etc) until
		// one of the hands is true, then score the hand

		Collections.sort(super.getCards());
		Frequency();

		if (isRoyalFlush()) {
                    
		} else if (isStraightFlush()) {

		}else if(isFullHouse()){
                    
                }else if(isFlush()){
                    
                }else if(isStraight()){
                    
                }else if(isThreeOfAKind()){
                    
                }else if(isTwoPair()){
                    
                }else if(isPair()){
                    
                }else if(isHighCard()){
                    
                }

		return null;
	}

	private void Frequency() {

		CRC = new ArrayList<CardRankCount>();

		int iCnt = 0;
		int iPos = 0;

		for (eRank eRank : eRank.values()) {
			iCnt = (CountRank(eRank));
			if (iCnt > 0) {
				iPos = FindCardRank(eRank);
				CRC.add(new CardRankCount(eRank, iCnt, iPos));
			}
		}

		Collections.sort(CRC);

		for (CardRankCount crcount : CRC) {
			System.out.print(crcount.getiCnt());
			System.out.print(" ");
			System.out.print(crcount.geteRank());
			System.out.print(" ");
			System.out.println(crcount.getiCardPosition());
		}

	}

	private int CountRank(eRank eRank) {
		int iCnt = 0;
		for (Card c : super.getCards()) {
			if (c.geteRank() == eRank) {
				iCnt++;
			}
		}
		return iCnt;
	}

	private int FindCardRank(eRank eRank) {
		int iPos = 0;

		for (iPos = 0; iPos < super.getCards().size(); iPos++) {
			if (super.getCards().get(iPos).geteRank() == eRank) {
				break;
			}
		}
		return iPos;
	}

	public boolean isRoyalFlush() {
		boolean bIsRoyalFlush = false;
		// TODO : Implement this method
                HandScorePoker HS = (HandScorePoker) super.getHS();
                int i=0,cardVal = super.getCards().get(0).geteRank().getiRankNbr();
                for (i = 1;i<super.getCards().size();i++) {
                    if(super.getCards().get(i).geteSuit()!=super.getCards().get(i-1).geteSuit() || cardVal + 1 != super.getCards().get(i).geteRank().getiRankNbr()){
                        break;
                    }
                    cardVal+=1;
		}
                if(i==super.getCards().size() && super.getCards().get(0).geteRank().getiRankNbr() == eRank.TEN.getiRankNbr()){
                    HS.seteHandStrength(eHandStrength.RoyalFlush);
                    HS.setHiCard(super.getCards().get(i));
                    HS.setLoCard(null);
                    bIsRoyalFlush = true;
                }
		return bIsRoyalFlush;
	}

	public boolean isStraightFlush() {
		boolean bisStraightFlush = false;
		// TODO : Implement this method
                HandScorePoker HS = (HandScorePoker) super.getHS();
                int i=0,cardVal = super.getCards().get(0).geteRank().getiRankNbr();
                for (i = 1;i<super.getCards().size();i++) {
                    if(super.getCards().get(i).geteSuit()!=super.getCards().get(i-1).geteSuit() || cardVal + 1 != super.getCards().get(i).geteRank().getiRankNbr()){
                        break;
                    }
                    cardVal+=1;
		}
                if(i==super.getCards().size() ){
                    HS.seteHandStrength(eHandStrength.StraightFlush);
                    HS.setHiCard(super.getCards().get(i));
                    HS.setLoCard(null);
                    bisStraightFlush = true;
                }
		
		return bisStraightFlush;
	}

	public boolean isFourOfAKind() {
		boolean bisFourOfAKind = false;
		HandScorePoker HS = (HandScorePoker) super.getHS();

		if (super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank() == super.getCards()
				.get(eCardNo.FOURTH.getiCardNo()).geteRank()) {

			HS.seteHandStrength(eHandStrength.FourOfAKind);
			HS.setHiCard(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HS.setLoCard(null);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.FIFTH.getiCardNo()));
			HS.setKickers(kickers);
			bisFourOfAKind = true;

		} else if (super.getCards().get(eCardNo.SECOND.getiCardNo()).geteRank() == super.getCards()
				.get(eCardNo.FIFTH.getiCardNo()).geteRank()) {
			HS.seteHandStrength(eHandStrength.FourOfAKind);
			HS.setHiCard(super.getCards().get(eCardNo.SECOND.getiCardNo()));
			HS.setLoCard(null);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HS.setKickers(kickers);
			bisFourOfAKind = true;
		}

		return bisFourOfAKind;
	}

	public boolean isFullHouse() {
		boolean bisFullHouse = false;

		if (this.CRC.size() == 2) {
			if ((CRC.get(0).getiCnt() == 3) && (CRC.get(1).getiCnt() == 2)) {
				bisFullHouse = true;
				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.FullHouse);
				HSP.setHiCard(this.getCards().get(CRC.get(0).getiCardPosition()));
				HSP.setLoCard(this.getCards().get(CRC.get(1).getiCardPosition()));
				ArrayList<Card> kickers = new ArrayList<Card>();
				HSP.setKickers(kickers);
				this.setHS(HSP);
			}
		}
		return bisFullHouse;

	}

	public boolean isFlush() {
		boolean bisFlush = false;

		int iCardCnt = super.getCards().size();
		int iSuitCnt = 0;

		for (eSuit eSuit : eSuit.values()) {
			for (Card c : super.getCards()) {
				if (eSuit == c.geteSuit()) {
					iSuitCnt++;
				}
			}
			if (iSuitCnt > 0)
				break;
		}

		if (iSuitCnt == iCardCnt)
			bisFlush = true;
		else
			bisFlush = false;

		return bisFlush;
	}

	public boolean isStraight() {
		boolean bisStraight = false;
		HandScorePoker HS = (HandScorePoker) super.getHS();
		// TODO : Implement this method
                int i=0,cardVal = super.getCards().get(0).geteRank().getiRankNbr();
                for (i = 1;i<super.getCards().size();i++) {
                    if(cardVal + 1 != super.getCards().get(i).geteRank().getiRankNbr()){
                        break;
                    }
                    cardVal+=1;
		}
                if(i==super.getCards().size()){
                    HS.seteHandStrength(eHandStrength.Straight);
                    HS.setHiCard(super.getCards().get(i));
                    bisStraight = true;
                }
		return bisStraight;
	}

	public boolean isThreeOfAKind() {
		boolean bisThreeOfAKind = false;

		if (this.getCRC().size() == 3) {
			if (this.getCRC().get(0).getiCnt() == 3) {

				HandScorePoker HSP = (HandScorePoker)this.getHS();
				HSP.seteHandStrength(eHandStrength.ThreeOfAKind);
				
				
				int iGetCard = this.getCRC().get(0).getiCardPosition();
				
				HSP.setHiCard(this.getCards().get(iGetCard));
				HSP.setLoCard(null);
				
		
				
				HSP.setKickers(FindTheKickers(this.getCRC()));
				
				

				
				
				this.setHS(HSP);
				
				
				
			}
		}

		// TODO : Implement this method
		return bisThreeOfAKind;
	}
	
	private ArrayList<Card> FindTheKickers(ArrayList<CardRankCount> CRC)
	{
		ArrayList<Card> kickers = new ArrayList<Card>();
		
		for (CardRankCount crcCheck: CRC)
		{
			if (crcCheck.getiCnt() == 1)
			{
				kickers.add(this.getCards().get(crcCheck.getiCardPosition()));
			}
		}
		
		return kickers;
	}

	public boolean isTwoPair() {
		boolean bisTwoPair = false;
		// TODO : Implement this method
                HandScorePoker HS = (HandScorePoker) super.getHS();
                int i=0,j,pair = 0, highest = 0, lowest = eRank.ACE.getiRankNbr();
                Card hiCard = null,loCard = null;
                for (i = 0;i<super.getCards().size();i++) {
                    for(j = i+1;j<super.getCards().size();j++){
                        if(super.getCards().get(i).geteRank() == super.getCards().get(j).geteRank()){
                            if(highest < super.getCards().get(i).geteRank().getiRankNbr()){
                                highest = super.getCards().get(i).geteRank().getiRankNbr();
                                hiCard = super.getCards().get(i);
                            }
                            if(lowest > super.getCards().get(i).geteRank().getiRankNbr()){
                                lowest = super.getCards().get(i).geteRank().getiRankNbr();
                                loCard = super.getCards().get(i);
                            }
                            pair++;
                            break;
                        }
                    }
		}
                if(pair == 2){
                    bisTwoPair= true;
                    HS.setHiCard(hiCard);
                    HS.setLoCard(loCard);
                    HS.setKickers(FindTheKickers(CRC));
                    HS.seteHandStrength(eHandStrength.TwoPair);
                }
		return bisTwoPair;
	}

	public boolean isPair() {
		boolean bisPair = false;
		HandScorePoker HS = (HandScorePoker) super.getHS();
                int i=0,j,pair = 0, highest = 0, lowest = eRank.ACE.getiRankNbr();
                Card hiCard = null,loCard = null;
                for (i = 0;i<super.getCards().size();i++) {
                    for(j = i+1;j<super.getCards().size();j++){
                        if(super.getCards().get(i).geteRank() == super.getCards().get(j).geteRank()){
                            if(highest < super.getCards().get(i).geteRank().getiRankNbr()){
                                highest = super.getCards().get(i).geteRank().getiRankNbr();
                                hiCard = super.getCards().get(i);
                            }
                            if(lowest > super.getCards().get(i).geteRank().getiRankNbr()){
                                lowest = super.getCards().get(i).geteRank().getiRankNbr();
                                loCard = super.getCards().get(i);
                            }
                            pair++;
                            break;
                        }
                    }
                    if(pair == 1)break;
		}
                if(pair == 1){
                    bisPair= true;
                    HS.setHiCard(hiCard);
                    HS.setLoCard(loCard);
                    HS.setKickers(FindTheKickers(CRC));
                    HS.seteHandStrength(eHandStrength.Pair);
                }
                return bisPair;
	}

	public boolean isHighCard() {
		boolean bisHighCard = false;
		// TODO : Implement this method
                HandScorePoker HS = (HandScorePoker) super.getHS();
                int i=0,j,pair = 0, highest = 0, lowest = eRank.ACE.getiRankNbr();
                Card hiCard = null,loCard = null;
                for (i = 0;i<super.getCards().size();i++) {
                    if(highest < super.getCards().get(i).geteRank().getiRankNbr()){
                        highest = super.getCards().get(i).geteRank().getiRankNbr();
                        hiCard = super.getCards().get(i);
                    }
                    if(lowest > super.getCards().get(i).geteRank().getiRankNbr()){
                        lowest = super.getCards().get(i).geteRank().getiRankNbr();
                        loCard = super.getCards().get(i);
                    }
                }
		
                if(pair == 2){
                    bisHighCard= true;
                    HS.setHiCard(hiCard);
                    HS.setLoCard(loCard);
                    HS.setKickers(FindTheKickers(CRC));
                    HS.seteHandStrength(eHandStrength.HighCard);
                }
		return bisHighCard;
	}

}

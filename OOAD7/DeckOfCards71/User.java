package OOAD7.DeckOfCards71;

import java.util.List;

public class User {
	private List<Card> _lCard;

	public List<Card> get_lCard() {
		return _lCard;
	}

	public void set_lCard(List<Card> _lCard) {
		this._lCard = _lCard;
	}
	
	public void addCard(Card c) {
		List<Card> cur = this.get_lCard();
		cur.add(c);
		this.set_lCard(cur);
	}
	
	public void removeCard(Card c) {
		List<Card> cur = this.get_lCard();
		cur.remove(c);
		this.set_lCard(cur);
	}
	
	public int getPoint() {
		List<Card> cur = this.get_lCard();
		int result = 0;
		for (int i = 0; i < cur.size(); i++) {
			result += cur.get(i).numb;
		}
		return result;
	}
}

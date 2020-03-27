// Factory Method
// The factory method offers an interface for creating an instance of a class, with its subclasses deciding 
// which class to instantiate

package OOAD7;

public class CardGame {
	class GameType {
		//static PokerGame Poker;
	}
	
	class PokerGame extends CardGame {
		
	}
	public static CardGame createCardGame(GameType type) {
		if (type == GameType.Poker) {
			return new PokerGame();
		}
		else if ( type == GameType.BlackJack) {
			return new BlackJackGame();
		}
		return null;
	}
}

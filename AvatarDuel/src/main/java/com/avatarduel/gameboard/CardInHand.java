package com.avatarduel.gameboard;

import com.avatarduel.model.Card;
import com.avatarduel.model.Land;
import com.avatarduel.model.Skill;
import com.avatarduel.model.Character;
import javafx.scene.text.Text;

/** Class containing cards in hand
 *
 * @author Muhammad Hasan - 13518012
 */
public class CardInHand {
    private final int maxCardInHand = 10;
    CardHand[] cardInHand;
        
    public CardInHand() {
        cardInHand = new CardHand[maxCardInHand];
        for (int i = 0; i < maxCardInHand; i++) {
            cardInHand[i] = new CardHand();
        }
    }
    
    public int addCardInHand(Card CC) {
       for (int i = 0; i < maxCardInHand; i++) {
           if (!cardInHand[i].getIsOccupied()) {
               cardInHand[i].flipIsOccupied();
               if (CC instanceof Character) {
                   cardInHand[i].setTextTo("CHARACTER");
               } else if (CC instanceof Skill) {
                   cardInHand[i].setTextTo("SKILL");
               } else if (CC instanceof Land) {
                   cardInHand[i].setTextTo("LAND");
               }
               cardInHand[i].setCard(CC);
               return 1;
           }
       }
       return 0;
    }
    
    public CardHand getCardInHandAt(int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos >= maxCardInHand)
           throw new IndexOutOfBoundsException("Index card in battle field out of bound");
        
        return cardInHand[pos];
    }
    
    /**
     * Close card so that it cannot be hovered
     */
    public void closeCards() {
        for (int i = 0; i < maxCardInHand; i++) {
            this.cardInHand[i].flipIsClosed();
        }
    }
    
    public void updateCardInHand() {
        for (int i = 0; i < maxCardInHand; i++) {
            CardHand CC = this.cardInHand[i];
            Card card = CC.getCard();
            CC.resetUnderLine();
            if (CC.getIsOccupied() && !CC.getIsClosed()) {
                if (card instanceof Land) {
                    this.cardInHand[i].setTextTo("LAND");
                } else if (card instanceof Skill) {
                    this.cardInHand[i].setTextTo("SKILL");
                } else if (card instanceof Character) {
                    this.cardInHand[i].setTextTo("CHARACTER");
                }
            } else {
                CC.setTextTo("");
            }
        }
    }
    
    public void resetCardInHand() {
        for (int i = 0; i < maxCardInHand; i++) {
            CardHand CC = this.cardInHand[i];
            CC.resetUnderLine();
            CC.resetCardHand();
        }
    }
    
    /**
     * Link text card to a array of text preferably FXML Texts
     * @param text Array of text references
     */
    public void setTextCardInHand(Text[] text) {
        for (int i = 0; i < text.length; i++) {
            this.cardInHand[i].setRefText(text[i]);
        }
    }
}

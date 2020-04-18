package com.avatarduel.gameboard;

import com.avatarduel.model.Card;
import javafx.scene.text.Text;

/** Class containing cards in battle field
 *
 * @author Muhammad Hasan - 13518012
 */
public class CardInBattleField {
    private final int maxCardInBattleField = 6;
    private int numOfCardInBattleField;
    CardBattleField[] cardInBattleField;
        
    public CardInBattleField() {
        cardInBattleField = new CardBattleField[maxCardInBattleField];
        for (int i = 0; i < maxCardInBattleField; i++) {
            cardInBattleField[i] = new CardBattleField();
        }
        numOfCardInBattleField = 0;
    }
    
    public void decreaseNumOfCardInBattleField() {
        this.numOfCardInBattleField--;
    }
    
    public boolean isCardInBattleFieldEmpty() {
        return (numOfCardInBattleField == 0);
    }
    
    public boolean isCardInBattleFieldFull() {
        return (numOfCardInBattleField == maxCardInBattleField);
    }
    
    /**
     * Add card in battle field also set the card to the turn when it is added (if successful)
     * @param CC Card that is added
     * @param turn The turn when it is added
     * @return true if successful, false if not
     */
    public boolean addCardInBattleField(Card CC, int turn) {
       if (isCardInBattleFieldFull()) return false;
       
       for (int i = 0; i < maxCardInBattleField; i++) {
           if (!cardInBattleField[i].getIsOccupied()) {
               cardInBattleField[i].flipIsOccupied();
               cardInBattleField[i].setTurnWhenSummon(turn);
               cardInBattleField[i].setTextTo("CHARACTER (ATTACK)");
               cardInBattleField[i].setCard(CC);
               numOfCardInBattleField++;
               break;
           }
       }
       
       return true;
    }
    
    public CardBattleField getCardInBattleFieldAt(int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos >= maxCardInBattleField)
           throw new IndexOutOfBoundsException("Index card in battle field out of bound");
        
        return cardInBattleField[pos];
    }
    
    public void updateCardInBattleField() {
        numOfCardInBattleField = 0;
        for (int i = 0; i < maxCardInBattleField; i++) {
            CardBattleField CC = this.cardInBattleField[i];
            CC.resetIsAttacked();
            CC.resetUnderLine();
            if (CC.getIsOccupied()) {
                String position = (CC.getIsAttacking() ? "(ATTACK)" : "(DEFENSE)");
                CC.setTextTo("CHARACTER " + position);
                numOfCardInBattleField++;
            } else {
                CC.setTextTo("");
            }
        }
    }
    
    public void resetCardInBattleField() {
        for (int i = 0; i < maxCardInBattleField; i++) {
            CardBattleField CC = this.cardInBattleField[i];
            CC.resetUnderLine();
            CC.resetCardBattleField();
        }
    }
    
    /**
     * Link text card to a array of text preferably FXML Texts
     * @param text Array of text references
     */
    public void setTextCardInBattleField(Text[] text) {
        for (int i = 0; i < text.length; i++) {
            this.cardInBattleField[i].setRefText(text[i]);
        }
    }
}

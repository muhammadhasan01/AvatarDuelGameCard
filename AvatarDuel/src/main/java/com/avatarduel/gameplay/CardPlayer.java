package com.avatarduel.gameplay;

import com.avatarduel.gameboard.CardBattleField;
import com.avatarduel.gameboard.CardHand;
import com.avatarduel.gameboard.CardInBattleField;
import com.avatarduel.gameboard.CardInHand;
import com.avatarduel.gameboard.CardInSkillField;
import com.avatarduel.gameboard.CardSkillField;

/** Class to handle cards that the player will have (Card in Hand, Card in Battle Field, and Card in Skill Field)
 *
 * @author Muhammad Hasan - 13518012
 */
public class CardPlayer {
    private CardInHand cardInHand;
    private CardInBattleField cardInBattleField;
    private CardInSkillField cardInSkillField;
    
    public CardPlayer() {
        this.cardInHand = new CardInHand();
        this.cardInBattleField = new CardInBattleField();
        this.cardInSkillField = new CardInSkillField();
    }
    
    public CardInHand getCardInHand() {
        return this.cardInHand;
    }
    
    public CardInBattleField getCardInBattleField() {
        return this.cardInBattleField;
    }
    
    public CardInSkillField getCardInSkillField() {
        return this.cardInSkillField;
    }
    
    public CardHand getCardHandAt(int pos) {
        return this.cardInHand.getCardInHandAt(pos - 1);
    }
    
    public CardBattleField getCardBattleFieldAt(int pos) {
        return this.cardInBattleField.getCardInBattleFieldAt(pos - 1);
    }
    
    public CardSkillField getCardSkillFieldAt(int pos) {
        return this.cardInSkillField.getCardInSkillFieldAt(pos - 1);
    }
    
    public void flipCloseCardInHand() {
        this.cardInHand.closeCards();
    }
    
    /**
     * Method to update all fields of cards
     */
    public void updateCards() {
        this.cardInHand.updateCardInHand();
        this.cardInBattleField.updateCardInBattleField();
        this.cardInSkillField.updateCardInSkillField();
    }
    
    /**
     * Method to reset all fields of cards
     */
    public void resetCards() {
        this.cardInHand.resetCardInHand();
        this.cardInBattleField.resetCardInBattleField();
        this.cardInSkillField.resetCardInSkillField();
    }
}

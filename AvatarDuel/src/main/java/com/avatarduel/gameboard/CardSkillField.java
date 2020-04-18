package com.avatarduel.gameboard;

/** Class to handle card in skill field
 *
 * @author Muhammad Hasan - 13518012
 */
public class CardSkillField extends CardBoard {
    private CardBattleField cardAttached;
    
    public CardSkillField() {
        super();
        this.cardAttached = new CardBattleField();
    }
    
    public CardBattleField getCardAttached() {
        return this.cardAttached;
    }
    
    public boolean isCardAttached() {
        return !(this.cardAttached.getCard().getName().equals(""));
    }
    
    public void setCardAttached(CardBattleField CC) {
        this.cardAttached = CC;
    }
    
    /**
     * Method to remove this card to the card attached
     */
    public void removeCardAttached() {
        this.cardAttached.removeCardAttached(this);
    }
    
    public void resetCardSkillField() {
        super.resetCardBoard();
        this.cardAttached.resetCardBattleField();
    }
}

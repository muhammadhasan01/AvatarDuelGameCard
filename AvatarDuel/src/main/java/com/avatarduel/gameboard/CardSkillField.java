/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.gameboard;

/**
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
    
    public void removeCardAttached() {
        this.cardAttached.removeCardAttached(this);
    }
    
    public void resetCardSkillField() {
        super.resetCardBoard();
        this.cardAttached.resetCardBattleField();
    }
}

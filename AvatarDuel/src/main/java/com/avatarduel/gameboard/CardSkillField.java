/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.gameboard;

import com.avatarduel.model.Card;

/**
 *
 * @author Muhammad Hasan - 13518012
 */
public class CardSkillField extends CardBoard {
    private Card cardAttached;
    
    public CardSkillField() {
        super();
    }
    
    /**
     *
     * @param card
     * @param isOccupied
     * @param canHover
     * @param cardAttached
     */
    public CardSkillField(Card card, boolean isOccupied, boolean canHover, Card cardAttached) {
        super(card, isOccupied, canHover);
        this.cardAttached = cardAttached;
    }
    
    public Card getCardAttached() {
        return this.cardAttached;
    }
    
    public void setCardAttached(Card CC) {
        this.cardAttached = CC;
    }
    
    public void resetCardSkillField() {
        super.resetCardBoard();
        this.cardAttached.resetCard();
    }
}

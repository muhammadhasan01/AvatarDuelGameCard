/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.gameboard;

import com.avatarduel.model.Card;
import javafx.scene.text.Text;

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
    
    /**
     *
     * @param card
     * @param isOccupied
     * @param canHover
     * @param text
     * @param cardAttached
     */
    public CardSkillField(Card card, boolean isOccupied, boolean canHover, Text text, CardBattleField cardAttached) {
        super(card, isOccupied, canHover, text);
        this.cardAttached = cardAttached;
    }
    
    public CardBattleField getCardAttached() {
        return this.cardAttached;
    }
    
    public void setCardAttached(CardBattleField CC) {
        this.cardAttached = CC;
    }
    
    public void resetCardSkillField() {
        super.resetCardBoard();
        this.cardAttached.resetCardBattleField();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.gameplay;

import com.avatarduel.gameboard.CardBattleField;
import com.avatarduel.gameboard.CardBoard;
import com.avatarduel.gameboard.CardHand;
import com.avatarduel.gameboard.CardInBattleField;
import com.avatarduel.gameboard.CardInHand;
import com.avatarduel.gameboard.CardInSkillField;
import com.avatarduel.gameboard.CardSkillField;

/**
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
    
    public void updateCards() {
        this.cardInHand.updateCardInHand();
        this.cardInBattleField.updateCardInBattleField();
        this.cardInSkillField.updateCardInSkillField();
    }
    
    public void resetCards() {
        this.cardInHand.resetCardInHand();
        this.cardInBattleField.resetCardInBattleField();
        this.cardInSkillField.resetCardInSkillField();
    }
}

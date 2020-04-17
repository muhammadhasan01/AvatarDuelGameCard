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
    
    public boolean isCardInBattleFieldEmpty() {
        return (numOfCardInBattleField == 0);
    }
    
    public boolean isCardInBattleFieldFull() {
        return (numOfCardInBattleField == maxCardInBattleField);
    }
    
    public boolean addCardInBattleField(Card CC) {
       if (isCardInBattleFieldFull()) return false;
       
       for (int i = 0; i < maxCardInBattleField; i++) {
           if (!cardInBattleField[i].getIsOccupied()) {
               cardInBattleField[i].flipIsOccupied();
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
            if (cardInBattleField[i].getIsOccupied()) {
                String position = (cardInBattleField[i].getIsAttacking() ? "(ATTACK)" : "(DEFENSE)");
                cardInBattleField[i].setTextTo("CHARACTER " + position);
                numOfCardInBattleField++;
            } else {
                cardInBattleField[i].setTextTo("");
            }
        }
    }
    
    public void resetCardInBattleField() {
        for (int i = 0; i < maxCardInBattleField; i++) {
            CardBattleField CC = this.cardInBattleField[i];
            CC.setTextTo("");
            if (CC.getIsOccupied()) {
                CC.flipIsOccupied();
            }
        }
    }
    
    public void setTextCardInBattleField(Text[] text) {
        for (int i = 0; i < text.length; i++) {
            this.cardInBattleField[i].setRefText(text[i]);
        }
    }
}

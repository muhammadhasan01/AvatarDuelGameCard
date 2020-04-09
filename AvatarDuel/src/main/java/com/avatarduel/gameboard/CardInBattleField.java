/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.gameboard;

import com.avatarduel.model.Card;
import java.io.IOException;
import javafx.scene.text.Text;

/**
 *
 * @author Muhammad Hasan - 13518012
 */
public class CardInBattleField {
    private final int maxCardInBattleField = 8;
    CardBattleField[] cardInBattleField;
        
    public CardInBattleField() {
        cardInBattleField = new CardBattleField[maxCardInBattleField];
        for (int i = 0; i < maxCardInBattleField; i++) {
            cardInBattleField[i] = new CardBattleField();
        }
    }
    
    public int addCardInBattleField(Card CC) {
       for (int i = 0; i < maxCardInBattleField; i++) {
           if (!cardInBattleField[i].getIsOccupied()) {
               cardInBattleField[i].flipIsOccupied();
               cardInBattleField[i].setTextTo("CHARACTER (ATTACK)");
               cardInBattleField[i].setCard(CC);
               return 1;
           }
       }
       return 0;
    }
    
    public CardBattleField getCardInBattleFieldAt(int pos) throws IOException {
        if (pos < 0 || pos >= maxCardInBattleField)
           throw new IOException("Index card in battle field out of bound");
        
        return cardInBattleField[pos];
    }
    
    public void resetCardInBattleFIeldAt(int pos) throws IOException {
        if (pos < 0 || pos >= maxCardInBattleField)
           throw new IOException("Index card in battle field out of bound");
        
        cardInBattleField[pos].resetCardBattleField();
    }
    
    public void updateCardInBattleField() {
        for (int i = 0; i < maxCardInBattleField; i++) {
            if (cardInBattleField[i].getIsOccupied()) {
                String position = (cardInBattleField[i].getIsAttacking() ? "(ATTACK)" : "(DEFENSE)");
                cardInBattleField[i].setTextTo("CHARACTER " + position);
            } else {
                cardInBattleField[i].setTextTo("");
            }
        }
    }
    
    public void setTextCardInBattleField(Text[] text) {
        for (int i = 0; i < text.length; i++) {
            this.cardInBattleField[i].setRefText(text[i]);
        }
    }
}

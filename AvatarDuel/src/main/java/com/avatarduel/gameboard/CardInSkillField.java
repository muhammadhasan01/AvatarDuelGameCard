package com.avatarduel.gameboard;


import com.avatarduel.gameboard.CardSkillField;
import com.avatarduel.model.Card;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Muhammad Hasan - 13518012
 */
public class CardInSkillField {
    private final int maxCardInSkillField = 8;
    CardSkillField[] cardInSkillField;
        
    public CardInSkillField() {
        cardInSkillField = new CardSkillField[maxCardInSkillField];
        for (int i = 0; i < maxCardInSkillField; i++) {
            cardInSkillField[i] = new CardSkillField();
        }
    }
    
    public int addCardInSkillField(Card CC) {
       for (int i = 0; i < maxCardInSkillField; i++) {
           if (!cardInSkillField[i].getIsOccupied()) {
               cardInSkillField[i].flipIsOccupied();
               cardInSkillField[i].setTextTo("SKILL");
               cardInSkillField[i].setCard(CC);
               return 1;
           }
       }
       return 0;
    }
    
    public CardSkillField getCardInSkillFieldAt(int pos) throws IOException {
        if (pos < 0 || pos >= maxCardInSkillField)
           throw new IOException("Index card in battle field out of bound");
        
        return cardInSkillField[pos];
    }
    
    public void resetCardInBattleFIeldAt(int pos) throws IOException {
        if (pos < 0 || pos >= maxCardInSkillField)
           throw new IOException("Index card in battle field out of bound");
        
        cardInSkillField[pos].resetCardSkillField();
    }    
    
    public void updateCardInSkillField() {
        for (int i = 0; i < maxCardInSkillField; i++) {
            if (cardInSkillField[i].getIsOccupied()) {
                cardInSkillField[i].setTextTo("Status");
            } else {
                cardInSkillField[i].setTextTo("");
            }
        }
    }
}

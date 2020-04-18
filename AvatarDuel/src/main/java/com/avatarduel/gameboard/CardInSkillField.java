package com.avatarduel.gameboard;


import com.avatarduel.gameboard.CardSkillField;
import com.avatarduel.model.Card;
import java.io.IOException;
import javafx.scene.text.Text;

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
    private final int maxCardInSkillField = 6;
    private int numOfCardInSkillField;
    CardSkillField[] cardInSkillField;
        
    public CardInSkillField() {
        cardInSkillField = new CardSkillField[maxCardInSkillField];
        for (int i = 0; i < maxCardInSkillField; i++) {
            cardInSkillField[i] = new CardSkillField();
        }
        numOfCardInSkillField = 0;
    }
    
    public boolean isCardInSkillFieldFull() {
        return (numOfCardInSkillField == maxCardInSkillField);
    }
    
    public boolean addCardInSkillField(Card CC) {
        
        if (isCardInSkillFieldFull()) return false;
        
        for (int i = 0; i < maxCardInSkillField; i++) {
            if (!cardInSkillField[i].getIsOccupied()) {
                cardInSkillField[i].flipIsOccupied();
                cardInSkillField[i].setTextTo("SKILL");
                cardInSkillField[i].setCard(CC);
                numOfCardInSkillField++;
                break;
            }
        }
        return true;
    }
    
    public CardSkillField getCardInSkillFieldAt(int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos >= maxCardInSkillField)
           throw new IndexOutOfBoundsException("Index card in skill field out of bound");
        
        return cardInSkillField[pos];
    }
    
    public void updateCardInSkillField() {
        for (int i = 0; i < maxCardInSkillField; i++) {
            CardSkillField CC = this.cardInSkillField[i];
            CC.resetUnderLine();
            if (CC.getIsOccupied()) {
                CC.setTextTo("SKILL");
            } else {
                CC.setTextTo("");
            }
        }
    }
    
    public void resetCardInSkillField() {
        for (int i = 0; i < maxCardInSkillField; i++) {
            CardSkillField CC = this.cardInSkillField[i];
            CC.resetUnderLine();
            CC.resetCardSkillField();
        }
    }
    
    public void setTextCardInSkillField(Text[] text) {
        for (int i = 0; i < text.length; i++) {
            this.cardInSkillField[i].setRefText(text[i]);
        }
    }
}

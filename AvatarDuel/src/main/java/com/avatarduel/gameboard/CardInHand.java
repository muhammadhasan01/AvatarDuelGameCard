/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.gameboard;

import com.avatarduel.model.Card;
import com.avatarduel.model.Land;
import com.avatarduel.model.Skill;
import com.avatarduel.model.Character;
import javafx.scene.text.Text;

/**
 *
 * @author Muhammad Hasan - 13518012
 */
public class CardInHand {
    private final int maxCardInHand = 10;
    CardHand[] cardInHand;
        
    public CardInHand() {
        cardInHand = new CardHand[maxCardInHand];
        for (int i = 0; i < maxCardInHand; i++) {
            cardInHand[i] = new CardHand();
        }
    }
    
    public int addCardInHand(Card CC) {
       for (int i = 0; i < maxCardInHand; i++) {
           if (!cardInHand[i].getIsOccupied()) {
               cardInHand[i].flipIsOccupied();
               if (CC instanceof Character) {
                   cardInHand[i].setTextTo("CHARACTER");
               } else if (CC instanceof Skill) {
                   cardInHand[i].setTextTo("SKILL");
               } else if (CC instanceof Land) {
                   cardInHand[i].setTextTo("LAND");
               }
               cardInHand[i].setCard(CC);
               return 1;
           }
       }
       return 0;
    }
    
    public CardHand getCardInHandAt(int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos >= maxCardInHand)
           throw new IndexOutOfBoundsException("Index card in battle field out of bound");
        
        return cardInHand[pos];
    }
    
    public void closeCards() {
        for (int i = 0; i < maxCardInHand; i++) {
            this.cardInHand[i].flipIsClosed();
        }
    }
    
    public void updateCardInHand() {
        for (int i = 0; i < maxCardInHand; i++) {
            CardHand CC = this.cardInHand[i];
            Card card = CC.getCard();
            CC.resetUnderLine();
            if (CC.getIsOccupied() && !CC.getIsClosed()) {
                if (card instanceof Land) {
                    this.cardInHand[i].setTextTo("LAND");
                } else if (card instanceof Skill) {
                    this.cardInHand[i].setTextTo("SKILL");
                } else if (card instanceof Character) {
                    this.cardInHand[i].setTextTo("CHARACTER");
                }
            } else {
                CC.setTextTo("");
            }
        }
    }
    
    public void resetCardInHand() {
        for (int i = 0; i < maxCardInHand; i++) {
            CardHand CC = this.cardInHand[i];
            CC.resetUnderLine();
            CC.resetCardHand();
        }
    }
    
    public void setTextCardInHand(Text[] text) {
        for (int i = 0; i < text.length; i++) {
            this.cardInHand[i].setRefText(text[i]);
        }
    }
}

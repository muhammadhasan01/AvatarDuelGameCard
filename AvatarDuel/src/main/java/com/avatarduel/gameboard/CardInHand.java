/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.gameboard;

import com.avatarduel.model.Card;
import java.io.IOException;

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
               cardInHand[i].setCard(CC);
               return 1;
           }
       }
       return 0;
    }
    
    public CardHand getCardInHandAt(int pos) throws IOException {
        if (pos < 0 || pos >= maxCardInHand)
           throw new IOException("Index card in battle field out of bound");
        
        return cardInHand[pos];
    }
    
    public void resetCardInBattleFIeldAt(int pos) throws IOException {
        if (pos < 0 || pos >= maxCardInHand)
           throw new IOException("Index card in battle field out of bound");
        
        cardInHand[pos].resetCardHand();
    }
}

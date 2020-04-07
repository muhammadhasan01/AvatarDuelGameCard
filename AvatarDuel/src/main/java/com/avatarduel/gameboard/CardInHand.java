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
public class CardInHand {
    private final int maxCardInHand = 10;
    CardHand[] cardInHand;
        
    CardInHand() {
        cardInHand = new CardHand[maxCardInHand];
    }
    
    public int addCardInHand(CardHand CC) {
       return 0;
    }
}

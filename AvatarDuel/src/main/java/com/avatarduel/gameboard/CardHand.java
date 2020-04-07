/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.gameboard;

import com.avatarduel.model.Card;

/**
 *
 * @author USER
 */
public class CardHand extends CardBoard {
    CardHand() {
        super();
    }
    
    CardHand(Card card, boolean isOccupied, boolean canHover) {
        super(card, isOccupied, canHover);
    }
    
    public void resetCardHand() {
        super.resetCardBoard();
    }
}

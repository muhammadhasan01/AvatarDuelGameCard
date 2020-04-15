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
public class CardHand extends CardBoard {
    public CardHand() {
        super();
    }
    
    public CardHand(Card card, boolean isOccupied, boolean canHover, Text text) {
        super(card, isOccupied, canHover, text);
    }
    
    public void resetCardHand() {
        super.resetCardBoard();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.gameboard;

import com.avatarduel.model.Card;

/**
 *
 * @author Muhammad Hasan - 13518012
 */
public class CardBoard {
    private Card card;
    private boolean isOccupied;
    private boolean canHover;
    
    CardBoard() {
        this.card = new Card();
        this.isOccupied = false;
        this.canHover = true;
    }
    
    CardBoard(Card card, boolean isOccupied, boolean canHover) {
        this.card = new Card();
        this.isOccupied = isOccupied;
        this.canHover = canHover;
    }
    
    public Card getCard() {
        return this.card;
    }
    
    public boolean getIsOccupied() {
        return this.isOccupied;
    }
    
    public boolean getCanHover() {
        return this.canHover;
    }
    
    public void setCard(Card card) {
        this.card = card;
    }
    
    public void flipIsOccupied() {
        this.isOccupied = !(this.isOccupied);
    }
    
    public void flipCanHover() {
        this.canHover = !(this.canHover);
    }  
}

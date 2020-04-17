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
public class CardHand extends CardBoard {
    private boolean isClosed;
    
    public CardHand() {
        super();
        this.isClosed = false;
    }
    
    public void resetCardHand() {
        super.resetCardBoard();
    }
    
    public boolean getIsClosed() {
        return this.isClosed;
    }
    
    public void flipIsClosed() {
        this.isClosed = !(this.isClosed);
    }
}

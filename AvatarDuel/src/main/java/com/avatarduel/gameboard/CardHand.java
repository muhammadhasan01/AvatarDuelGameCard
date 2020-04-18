package com.avatarduel.gameboard;

/** Class to handle card in hand
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

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
public class CardBoard {
    private Card card;
    private boolean isOccupied;
    private boolean canHover;
    private Text text;
    
    public CardBoard() {
        this.card = new Card();
        this.isOccupied = false;
        this.canHover = true;
        this.text = new Text();
    }
    
    public CardBoard(Card card, boolean isOccupied, boolean canHover, Text text) {
        this.card = new Card();
        this.isOccupied = isOccupied;
        this.canHover = canHover;
        this.text = text;
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
    
    public Text getText() {
        return this.text;
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
    
    public void resetCardBoard() {
        this.card.resetCard();
        this.isOccupied = false;
        this.canHover = true;
        this.text.setText("");
    }
    
    public void setRefText(Text text) {
        this.text = text;
    }
    
    public void setTextTo(String text) {
        this.text.setText(text);
    }
    
    public void flipUnderLine() {
        this.text.setUnderline(!this.text.isUnderline());
    }
}

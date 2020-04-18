package com.avatarduel.gameboard;

import com.avatarduel.model.Card;
import javafx.scene.text.Text;

/** Generic Class for card in gameboard
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
    
    public void resetUnderLine() {
        this.text.setUnderline(false);
    }
}

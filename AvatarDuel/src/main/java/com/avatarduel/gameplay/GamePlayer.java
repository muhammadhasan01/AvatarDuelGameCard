package com.avatarduel.gameplay;

import com.avatarduel.cards.CharacterCards;
import com.avatarduel.cards.LandCards;
import com.avatarduel.cards.SkillCards;
import com.avatarduel.model.Card;
import com.avatarduel.model.Land;
import com.avatarduel.model.Skill;
import com.avatarduel.model.Character;
import com.avatarduel.model.Element;
import com.avatarduel.player.Player;
import java.io.IOException;
import java.util.List;
import javafx.util.Pair;

/** Class to handle player attributes, player cards, and it's text in GUI
 *
 * @author Muhammad Hasan - 13518012
 */
public class GamePlayer {
    private Player player;
    private CardPlayer cardPlayer;
    private GameText gameText;
    private boolean isSummonLand;
    private boolean isLost;
    
    public GamePlayer() {
        this.player = new Player();
        this.cardPlayer = new CardPlayer();
        this.gameText = new GameText();
        this.isSummonLand = false;
        this.isLost = false;
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public CardPlayer getCardPlayer() {
        return this.cardPlayer;
    }
    
    public GameText getGameText() {
        return this.gameText;
    }
    
    public boolean getIsSummonLand() {
        return this.isSummonLand;
    }
    
    public boolean getIsLost() {
        return this.isLost;
    }
    
    public void flipIsLost() {
        this.isLost = !(this.isLost);
    }
    
    public void setIsSummondLand(Boolean bool) {
        this.isSummonLand = bool;
    }
    
    /**
     * build deck with character : skill : land = 2 : 1 : 2
     * @throws IOException 
     */
    public void buildDeck() throws IOException {
        LandCards landCards = new LandCards();
        CharacterCards characterCards = new CharacterCards();
        SkillCards skillCards = new SkillCards();
        
        characterCards.loadCards();
        landCards.loadCards();
        skillCards.loadCards();
        
        List<Character> CC = characterCards.getListCharacter();
        List<Land> LL = landCards.getListLand();
        List<Skill> SS = skillCards.getListSkill();
        
        this.player.buildDeck(CC, SS, LL);
    }
    
    /**
     * Add card to hand from deck
     * If the card is empty, then this player will automatically lost
     */
    public void addFromDeck() {
        List<Card> deckPlayer = this.player.getDeck();
        if (deckPlayer.isEmpty()) {
            this.flipIsLost();
            return;
        }
        Card CC = deckPlayer.remove(0);
        this.getCardPlayer().getCardInHand().addCardInHand(CC);
        this.player.setDeckTextTo(deckPlayer.size());
    }
    
    /**
     * Update the value of power elements at draw phase
     */
    public void updatePower() {
        for (Element element : Element.values()) {
            int maxVal = this.player.getPower(element).getValue();
            player.setPower(element, new Pair<>(maxVal, maxVal));
            gameText.setPowerValue(element, maxVal, maxVal);    
        }
    }
}

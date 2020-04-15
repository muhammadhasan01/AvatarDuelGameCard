/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.gameplay;

import com.avatarduel.cards.CharacterCards;
import com.avatarduel.cards.LandCards;
import com.avatarduel.cards.SkillCards;
import com.avatarduel.gameboard.CardBattleField;
import com.avatarduel.gameboard.CardBoard;
import com.avatarduel.gameboard.CardHand;
import com.avatarduel.gameboard.CardInBattleField;
import com.avatarduel.gameboard.CardInHand;
import com.avatarduel.gameboard.CardInSkillField;
import com.avatarduel.gameboard.CardSkillField;
import com.avatarduel.model.Card;
import com.avatarduel.model.Land;
import com.avatarduel.model.Skill;
import com.avatarduel.model.Character;
import com.avatarduel.model.Element;
import com.avatarduel.player.Player;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Pair;

/**
 *
 * @author Muhammad Hasan - 13518012
 */
public class GamePlay {
    private Player player;
    private int orderPlayer;
    private CardBoard selectedCard;
    private Text statusText;
    private Text otherStatusText;
    private Button changePosition;
    private Text powerAir;
    private Text powerWater;
    private Text powerFire;
    private Text powerEarth;
    private CardView cardView;
    private CardInHand cardInHand;
    private CardInBattleField cardInBattleField;
    private CardInSkillField cardInSkillField;
    
    public GamePlay() {
        this.player = new Player();
        this.orderPlayer = 0;
        this.statusText = new Text();
        this.otherStatusText = new Text();
        this.changePosition = new Button();
        this.selectedCard = new CardBoard();
        this.cardView = new CardView();
        this.cardInHand = new CardInHand();
        this.cardInBattleField = new CardInBattleField();
        this.cardInSkillField = new CardInSkillField();
        this.powerAir = new Text();
        this.powerWater = new Text();
        this.powerFire = new Text();
        this.powerEarth = new Text();
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public int getOrderPlayer() {
        return this.orderPlayer;
    }
    
    public CardBoard getSelectedCard() {
        return this.selectedCard;
    }
    
    public CardInHand getCardInHand() {
        return this.cardInHand;
    }
    
    public CardInBattleField getCardInBattleField() {
        return this.cardInBattleField;
    }
    
    public CardInSkillField getCardInSkillField() {
        return this.cardInSkillField;
    }
    
    public CardBoard getCardHandAt(int pos) {
        try {
            --pos;
            return this.cardInHand.getCardInHandAt(pos);
        } catch (IOException ex) {
            Logger.getLogger(GamePlay.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public CardBoard getCardBattleFieldAt(int pos) {
        try {
            --pos;
            return this.cardInBattleField.getCardInBattleFieldAt(pos);
        } catch (IOException ex) {
            Logger.getLogger(GamePlay.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public CardBoard getCardSkillFieldAt(int pos) {
        try {
            --pos;
            return this.cardInSkillField.getCardInSkillFieldAt(pos);
        } catch (IOException ex) {
            Logger.getLogger(GamePlay.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
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
        
        System.out.println(CC.size() + " and " + LL.size() + " and " + SS.size());
        
        this.player.buildDeck(CC, SS, LL);
    }
    
    public void addFromDeck() {
        List<Card> deckPlayer = this.player.getDeck();
        if (deckPlayer.size() > 0) {
            Card CC = deckPlayer.remove(0);
            this.cardInHand.addCardInHand(CC);
            this.player.setDeckTextTo(deckPlayer.size());
        }
        if (deckPlayer.isEmpty()) {
            statusText.setText("Game Over");
        }
    }
    
    public void setOrderPlayer(int order) {
        this.orderPlayer = order;
    }
    
    public void setCardView(Text name, Text desc, Text atr, ImageView img, ImageView elm) {
        this.cardView = new CardView(name, desc, atr, img, elm);
    }
    
    public void setStatusText(Text text) {
        this.statusText = text;
    }
    
    public void setOtherStatusText(Text text) {
        this.otherStatusText = text;
    }
    
    public void setStatusTextTo(String text) {
        this.statusText.setText(text);
    }
    
    public void setOtherStatusText(String text) {
        this.otherStatusText.setText(text);
    }
    
    public void setSelectedCard(CardBoard CC) {
        this.selectedCard = CC;
    }
    
    public void setButtonChangePosition(Button button) {
        this.changePosition = button;
    }
    
    public void handleHover(CardBoard CC) {
        if (CC.getIsOccupied() && CC.getCanHover()) {
            this.cardView.setCardViewToCard(CC.getCard());
        }
    }
    
    public void updateCards() {
        this.cardInHand.updateCardInHand();
        this.cardInBattleField.updateCardInBattleField();
        this.cardInSkillField.updateCardInSkillField();
    }
    
    public String formatPower(int cur, int max) {
        return String.valueOf(cur) + "/" + String.valueOf(max);
    }
    
    public void handleClickHand(int pos, int turnPhase) {
        CardHand CC = new CardHand();
        
        try {
            CC = this.cardInHand.getCardInHandAt(--pos);
        } catch (IOException ex) {
            Logger.getLogger(GamePlay.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (!CC.getIsOccupied()) return;
        if (!(turnPhase % 5 == 1 || turnPhase % 5 == 3)) return;
        
        Card card = CC.getCard();
        Element element = card.getElement();
        
        int currentAir = this.player.getPowerAir().getKey();
        int maxAir = this.player.getPowerAir().getValue();

        int currentWater = this.player.getPowerWater().getKey();
        int maxWater = this.player.getPowerWater().getValue();

        int currentFire = this.player.getPowerFire().getKey();
        int maxFire = this.player.getPowerFire().getValue();

        int currentEarth = this.player.getPowerEarth().getKey();
        int maxEarth = this.player.getPowerEarth().getValue();
        
        if (card instanceof Land) {
            int currentVal, maxVal;
            
            switch (element) {
                case AIR:
                    this.player.setPowerAir(new Pair<>(currentAir + 1, maxAir + 1));
                    powerAir.setText(formatPower(currentAir + 1, maxAir + 1));
                    setStatusTextTo("Power Air has increased");
                    break;
                case WATER:
                    this.player.setPowerWater(new Pair<>(currentWater + 1, maxWater + 1));
                    powerWater.setText(formatPower(currentWater + 1, maxWater + 1));
                    setStatusTextTo("Power Water has increased");
                    break;
                case FIRE:
                    this.player.setPowerFire(new Pair<>(currentFire + 1, maxFire + 1));
                    powerFire.setText(formatPower(currentFire + 1, maxFire + 1));
                    setStatusTextTo("Power Fire has increased");
                    break;
                case EARTH:
                    this.player.setPowerEarth(new Pair<>(currentEarth + 1, maxEarth + 1));
                    powerEarth.setText(formatPower(currentEarth + 1, maxEarth + 1));
                    setStatusTextTo("Power Earth has increased");
                    break;
                default:
                    break;
            }
            
        } else {
            
            int currentVal = 0;
            int maxVal;
            int curPower = card.getPower();
            
            switch (element) {
                case AIR:
                    if (curPower > currentAir) {
                        setStatusTextTo("Power Air not enough");
                        return;
                    }
                    currentAir -= curPower;
                    this.player.setPowerAir(new Pair<>(currentAir, maxAir));
                    powerAir.setText(formatPower(currentAir, maxAir));
                    break;
                case WATER:
                    if (curPower > currentWater) {
                        setStatusTextTo("Power Water not enough");
                        return;
                    }
                    currentWater -= curPower;
                    this.player.setPowerWater(new Pair<>(currentWater, maxWater));
                    powerWater.setText(formatPower(currentWater, maxWater));
                    break;
                case FIRE:
                    if (curPower > currentFire) {
                        setStatusTextTo("Power Fire not enough");
                        return;
                    }
                    currentFire -= curPower;
                    maxFire = this.player.getPowerFire().getValue();
                    this.player.setPowerFire(new Pair<>(currentFire, maxFire));
                    powerFire.setText(formatPower(currentFire, maxFire));
                    break;
                case EARTH:
                    if (curPower > currentEarth) {
                        setStatusTextTo("Power Earth not enough");
                        return;
                    }
                    currentEarth -= curPower;
                    maxEarth = this.player.getPowerEarth().getValue();
                    this.player.setPowerEarth(new Pair<>(currentEarth, maxEarth));
                    powerEarth.setText(formatPower(currentEarth, maxEarth));
                    break;
                default:
                    break;
            }
            
            boolean isSuccess = false;
            if (card instanceof Skill) {
                if (this.cardInSkillField.addCardInSkillField(card) > 0) {
                    setStatusTextTo("Skill Card successfully summoned!");
                    isSuccess = true;
                } 
            } else if (card instanceof Character) {
                if (this.cardInBattleField.addCardInBattleField(card) > 0) {
                    setStatusTextTo("Character Card successfully summoned!");
                    isSuccess = true;
                }
            }
            
            if (!isSuccess) {
                setStatusTextTo("Failed to select card, Field is already full");
                return;
            }
        }
        CC.flipIsOccupied();
        this.cardInHand.updateCardInHand();
    }
    
    public void handleClickSkillField(int pos, int turnPhase) {
        CardSkillField CC = new CardSkillField();
        
        try {
            CC = this.cardInSkillField.getCardInSkillFieldAt(--pos);
        } catch (IOException ex) {
            Logger.getLogger(GamePlay.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (!CC.getIsOccupied()) return;
        if (!(turnPhase % 5 == 1 || turnPhase % 5 == 3)) return;
        if (!this.selectedCard.getCard().getName().equals("")) return;
        if (!CC.getCardAttached().getCard().getName().equals("")) return;
        
        setStatusTextTo("Skill " + CC.getCard().getName() + " has been selected!");
        
        CC.flipUnderLine();
        this.selectedCard = CC;
    }
    
    public void handleClickBattleField(int pos, int turnPhase) {
        CardBattleField CC = new CardBattleField();
        
        try {
            CC = this.cardInBattleField.getCardInBattleFieldAt(--pos);
        } catch (IOException ex) {
            Logger.getLogger(GamePlay.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (!CC.getIsOccupied()) return;
        
        if (turnPhase % 5 == 1 || turnPhase % 5 == 3) {
            
            if (this.selectedCard.getCard().getName().equals("")) {
                setStatusTextTo("Character " + CC.getCard().getName() + " has been selected!");
                
                CC.flipUnderLine();
                this.selectedCard = CC;
                
            } else if (this.selectedCard instanceof CardSkillField) {
                CardSkillField SS = (CardSkillField) this.selectedCard;
                
                SS.setCardAttached(CC);
                SS.flipUnderLine();
                CC.addCardAttached(SS);
                
                setStatusTextTo("Character " + CC.getCard().getName() + " has been attached by The Selected Skill Card!");
                
                this.selectedCard = new CardBoard();
            }
        } else if (turnPhase % 5 == 2) {
            
            if (this.selectedCard.getCard().getName().equals("")) {
                if (!CC.getIsAttacking()) return;
                if (CC.getIsAttacked()) return;
                this.selectedCard = CC;
                this.selectedCard.flipUnderLine();
                
                setStatusTextTo("Character " + CC.getCard().getName() + " has been selected!");
                
            } else if (this.selectedCard instanceof CardBattleField) {
                
                CardBattleField BB = (CardBattleField) this.selectedCard;
                BB.flipIsAttacked();
                BB.flipUnderLine();
                
                if (CC.getIsAttacking()) {
                    int thisAttack = CC.getCard().getAttack();
                    int selectedAttack = this.selectedCard.getCard().getAttack();
                    
  
                    if (selectedAttack > thisAttack) {
                        
                        CC.setToDead();
                        
                        int dif = thisAttack - selectedAttack;
                        
                        setStatusTextTo("Player " + getOrderPlayer() + " Has received " + dif + " damage!");
                        
                        int curHealth = this.player.getHealth();
                        curHealth = Math.max(0, curHealth - dif);
                        this.player.setHealth(curHealth);
                        this.player.setHealthTextTo(String.valueOf(curHealth));
                        
                        if (curHealth == 0) {
                            setStatusTextTo("Player " + getOrderPlayer() + " has lost");
                        }
                    }
                } else {
                    
                    int thisDefend = CC.getCard().getDefend();
                    int selectedAttack = this.selectedCard.getCard().getAttack();
                    
                    if (selectedAttack > thisDefend) {
                        setStatusTextTo("Card " + CC.getCard().getName() + " has been destroyed!");
                        CC.setToDead();
                    }
                }
                this.selectedCard = new CardBoard();
            }
        }
    }
    
    public void handleClickChangePosition(int turnPhase) {
        if (this.selectedCard.getCard().getName().equals(""))
            return;
        
        if (!(turnPhase % 5 == 1 || turnPhase % 5 == 3))
            return;
        
        if (!(this.selectedCard instanceof CardBattleField))
            return;
        
        CardBattleField CC = (CardBattleField) this.selectedCard;
        setStatusTextTo("Card " + CC.getCard().getName() + " has changed position");
        
        CC.flipIsAttacking();
    }
}

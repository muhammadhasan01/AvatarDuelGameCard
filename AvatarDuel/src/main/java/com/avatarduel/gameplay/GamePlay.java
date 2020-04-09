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
import java.net.URISyntaxException;
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
    private CardBoard selectedCard;
    private Text statusText;
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
        this.statusText = new Text();
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
        try {
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
        } catch (URISyntaxException ex) {
            Logger.getLogger(GamePlay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addFromDeck() {
        List<Card> deckPlayer = this.player.getDeck();
        if (deckPlayer.size() > 0) {
            Card CC = deckPlayer.get(0);
            if (this.cardInHand.addCardInHand(CC) > 0) {
                deckPlayer.remove(0);
                this.player.setDeckTextTo(deckPlayer.size());
            }
        }
        if (deckPlayer.size() == 0) {
            statusText.setText("Game Over");
        }
    }
    
    public void setCardView(Text name, Text desc, Text atr, ImageView img, ImageView elm) {
        this.cardView = new CardView(name, desc, atr, img, elm);
    }
    
    public void setStatusText(Text text) {
        this.statusText = text;
    }
    
    public void handleHover(CardBoard CC) {
        if (CC.getIsOccupied() && CC.getCanHover()) {
            this.cardView.setCardViewToCard(CC.getCard());
        }
    }
    
    public void updateField() {
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
        if (card instanceof Land) {
            int currentVal, maxVal;
            switch (element) {
                case AIR:
                    currentVal = this.player.getPowerAir().getKey() + 1;
                    maxVal = this.player.getPowerAir().getValue() + 1;
                    this.player.setPowerAir(new Pair<>(currentVal, maxVal));
                    powerAir.setText(formatPower(currentVal, maxVal));
                    break;
                case WATER:
                    currentVal = this.player.getPowerWater().getKey() + 1;
                    maxVal = this.player.getPowerWater().getValue() + 1;
                    this.player.setPowerWater(new Pair<>(currentVal, maxVal));
                    powerWater.setText(formatPower(currentVal, maxVal));
                    break;
                case FIRE:
                    currentVal = this.player.getPowerFire().getKey() + 1;
                    maxVal = this.player.getPowerFire().getValue() + 1;
                    this.player.setPowerFire(new Pair<>(currentVal, maxVal));
                    powerFire.setText(formatPower(currentVal, maxVal));
                    break;
                case EARTH:
                    currentVal = this.player.getPowerEarth().getKey() + 1;
                    maxVal = this.player.getPowerEarth().getValue() + 1;
                    this.player.setPowerEarth(new Pair<>(currentVal, maxVal));
                    powerEarth.setText(formatPower(currentVal, maxVal));
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
                    currentVal = this.player.getPowerAir().getKey();
                    if (curPower < currentVal) return;
                    currentVal -= curPower;
                    maxVal = this.player.getPowerAir().getValue();
                    this.player.setPowerAir(new Pair<>(currentVal, maxVal));
                    powerAir.setText(formatPower(currentVal, maxVal));
                    break;
                case WATER:
                    currentVal = this.player.getPowerWater().getKey();
                    if (curPower < currentVal) return;
                    currentVal -= curPower;
                    maxVal = this.player.getPowerAir().getValue();
                    this.player.setPowerAir(new Pair<>(currentVal, maxVal));
                    powerAir.setText(formatPower(currentVal, maxVal));
                    break;
                case FIRE:
                    currentVal = this.player.getPowerFire().getKey();
                    break;
                case EARTH:
                    currentVal = this.player.getPowerEarth().getKey();
                    break;
                default:
                    break;
            }
            
            boolean isSuccess = false;
            if (card instanceof Skill) {
                if (this.cardInSkillField.addCardInSkillField(card) > 0) {
                    isSuccess = true;
                } 
            } else if (card instanceof Character) {
                if (this.cardInBattleField.addCardInBattleField(card) > 0) {
                    isSuccess = true;
                }
            }
            if (!isSuccess) return;
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
        if (!CC.getCardAttached().getName().equals("")) return;
        CC.flipUnderLine();
        this.selectedCard = CC;
        this.selectedCard.flipUnderLine();
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
                this.selectedCard = CC;
                this.selectedCard.flipUnderLine();
            } else if (this.selectedCard instanceof CardSkillField) {
                
            } else {
                return;
            }
        } else if (turnPhase % 5 == 2) {
            if (this.selectedCard.getCard().getName().equals("")) {
                if (!CC.getIsAttacking()) return;
                this.selectedCard = CC;
                this.selectedCard.flipUnderLine();
            } else if (this.selectedCard instanceof CardBattleField) {
                if (CC.getIsAttacking()) {
                    int thisAttack = CC.getCard().getAttack();
                    int selectedAttack = this.selectedCard.getCard().getAttack();
                    if (selectedAttack <= thisAttack) {
                        this.selectedCard = new CardBoard();
                    } else {
                        int dif = thisAttack - selectedAttack;
                        int curHealth = this.player.getHealth();
                        curHealth = Math.max(0, curHealth - dif);
                        if (curHealth == 0) {
                            this.statusText.setText("Game Over");
                        } else {
                            this.player.setHealth(curHealth);
                            this.player.setHealthTextTo(String.valueOf(curHealth));
                        }
                        this.selectedCard.getText().setUnderline(false);
                        this.selectedCard = new CardBoard();
                    }
                } else {
                    int thisDefend = CC.getCard().getDefend();
                    int selectedAttack = this.selectedCard.getCard().getAttack();
                    if (selectedAttack <= thisDefend) {
                        this.selectedCard = new CardBoard();
                    } else {
                        CC.resetCardBoard();
                    }
                }
            } else {
                return;
            }
        } else {
            return;
        }
    }
    
    private void handleClickChangePosition(int turnPhase) {
        if (!(turnPhase % 5 == 1 || turnPhase % 5 == 3)) return;
        if (this.selectedCard.getCard().getName().equals("")) return;
        if (!(this.selectedCard instanceof CardBattleField)) return;
        CardBattleField CC = (CardBattleField) this.selectedCard;
        CC.flipIsAttacking();
    }
}

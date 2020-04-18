package com.avatarduel.gameplay;

import com.avatarduel.gameboard.CardBattleField;
import com.avatarduel.gameboard.CardBoard;
import com.avatarduel.gameboard.CardHand;
import com.avatarduel.gameboard.CardSkillField;
import com.avatarduel.model.Card;
import com.avatarduel.model.Element;
import com.avatarduel.model.Character;
import com.avatarduel.model.Land;
import com.avatarduel.model.Skill;
import com.avatarduel.player.Player;
import javafx.util.Pair;

/** Class to handle gameplay such as method for battling, game over, clicking, and hovering
 *
 * @author Muhammad Hasan - 13518012
 */
public class GamePlay {
    private final int numOfPlayer = 2;
    private GamePlayer[] players;
    private CardBoard selectedCard;
    private CardDisplay cardDisplay;
    private int turn;
    
    public GamePlay() {
        this.players = new GamePlayer[numOfPlayer];
        for (int i = 0; i < numOfPlayer; i++) {
            this.players[i] = new GamePlayer();
        }
        this.selectedCard = new CardBoard();
        this.cardDisplay = new CardDisplay();
        this.turn = 0;
    }
    
    public GamePlayer getGamePlayer(int ord) throws IndexOutOfBoundsException {
        if (ord < 1 || ord > numOfPlayer)
            throw new IndexOutOfBoundsException("Number of player is out of bounds");
        return this.players[ord - 1];
    }
    
    public CardDisplay getCardDisplay() {
        return this.cardDisplay;
    }
    
    public CardHand getCardHandAt(int ord, int pos) {
        return this.players[ord].getCardPlayer().getCardHandAt(pos);
    }
    
    public CardSkillField getCardSkillFieldAt(int ord, int pos) {
        return this.players[ord].getCardPlayer().getCardSkillFieldAt(pos);
    }
    
    public CardBattleField getCardBattleFieldAt(int ord, int pos) {
        return this.players[ord].getCardPlayer().getCardBattleFieldAt(pos);
    }
    
    /**
     * Method to update cards every time it changes phase
     */
    public void updatePhase() {
        this.selectedCard = new CardBoard();
        this.players[turn].setIsSummondLand(false);
        for (int i = 0; i < numOfPlayer; i++) {
            this.players[i].getCardPlayer().updateCards();
        }
    }
    
    public int getTurn() {
        return this.turn;
    }
    
    public void changeTurn() {
        this.turn ^= 1;
    }
    
    public void setSelectedCard(CardBoard CC) {
        this.selectedCard = CC;
    }
    
    public boolean isSelectedCardEmpty() {
        return (this.selectedCard.getCard().getName().equals(""));
    }
    
    /**
     * Method for handling game over
     */
    public void gameOver() {
        GamePlayer currentPlayer = this.players[turn];
        GamePlayer otherPlayer = this.players[1 - turn];
        
        if (!currentPlayer.getIsLost() && !otherPlayer.getIsLost())
            return;
        
        CardPlayer currentCardPlayer = currentPlayer.getCardPlayer();
        CardPlayer otherCardPlayer = otherPlayer.getCardPlayer();
        GameText currentGameText = currentPlayer.getGameText();
        GameText otherGameText = otherPlayer.getGameText();
        
        currentCardPlayer.resetCards();
        otherCardPlayer.resetCards();
        
        if (currentPlayer.getIsLost()) {
            otherGameText.setStatusTextTo("Player " + String.valueOf(2 - turn) + " Win!");
            currentGameText.setStatusTextTo("Player " + String.valueOf(turn + 1) + " Lost");
        } else {
            currentGameText.setStatusTextTo("Player " + String.valueOf(turn + 1) + " Win!");
            otherGameText.setStatusTextTo("Player " + String.valueOf(2 - turn) + " Lost");
        }
    }
    
    /**
     * Handling hovering over a card
     * @param CC The card that is hovered
     */
    public void handleHover(CardBoard CC) {
        
        if (CC instanceof CardHand) {
            CardHand CH = (CardHand) CC;
            if (CH.getIsClosed()) return;
        }
        
        if (CC.getIsOccupied() && CC.getCanHover()) {
            this.cardDisplay.setCardViewToCard(CC.getCard());
        }
    }
    
    /**
     * Handling when a card in hand of a particular player is clicked
     * @param ord The order of the player (one or two)
     * @param pos The position of card in hand
     * @param turnPhase (draw = 0, main = 1, battle = 2, end = 3)
     */
    public void handleClickHand(int ord, int pos, int turnPhase) {
        
        if (this.turn != ord) return;
        if (!(turnPhase % 4 == 1)) return;
        
        CardBoard CC;
        GamePlayer currentGamePlayer = this.players[ord];
        Player currentPlayer = currentGamePlayer.getPlayer();
        GameText currentText = currentGamePlayer.getGameText();
        CardPlayer currentCardPlayer = currentGamePlayer.getCardPlayer();
        
        CC = currentCardPlayer.getCardHandAt(pos);
        
        if (!CC.getIsOccupied()) return;
        
        if (this.selectedCard.getText().isUnderline()) {
            this.selectedCard.resetUnderLine();
            this.selectedCard = new CardBoard();
        }
        
        Card card = CC.getCard();
        Element element = card.getElement();
        String elementName = element.name().toLowerCase();
        
        int currentVal = currentPlayer.getPower(element).getKey();
        int maxVal = currentPlayer.getPower(element).getValue();
        
        if (card instanceof Land) {
            
            if (currentGamePlayer.getIsSummonLand()) {
                currentText.setStatusTextTo("Cannot summond card land twice!");
                return;
            }
            
            currentVal++;
            maxVal++;
            
            currentGamePlayer.setIsSummondLand(true);
            
            currentPlayer.setPower(element, new Pair<>(currentVal, maxVal));
            currentText.setPowerValue(element, currentVal, maxVal);
            currentText.setStatusTextTo("Power " + elementName + " has increased!");
            
        } else {
            
            int curPower = card.getPower();
            
            if (selectedCard == CC) {
                currentText.setStatusTextTo("Card " + card.getName() + " has been removed!");
                CC.flipIsOccupied();
                currentCardPlayer.getCardInHand().updateCardInHand();
                selectedCard = new CardBoard();
                return;
            }
            
            if (curPower > currentVal) {
                currentText.setStatusTextTo("Power " + elementName + " not enough");
                selectedCard = CC;
                return;
            }
            
            boolean isSuccess = false;
            if (card instanceof Skill) {
                if (currentCardPlayer.getCardInSkillField().addCardInSkillField(card)) {
                    currentText.setStatusTextTo("Skill Card successfully summoned!");
                    isSuccess = true;
                } 
            } else if (card instanceof Character) {
                if (currentCardPlayer.getCardInBattleField().addCardInBattleField(card, turnPhase)) {
                    currentText.setStatusTextTo("Character Card successfully summoned!");
                    isSuccess = true;
                }
            }
            
            if (!isSuccess) {
                selectedCard = CC;
                currentText.setStatusTextTo("Failed to select card, Field is already full");
                return;
            }
            
            currentVal -= curPower;
            currentPlayer.setPower(element, new Pair<>(currentVal, maxVal));
            currentText.setPowerValue(element, currentVal, maxVal);
            
        }
        
        CC.flipIsOccupied();
        currentCardPlayer.getCardInHand().updateCardInHand();
    }
    
    /**
     * Handling when a card in skill field of a particular player is clicked
     * @param ord The order of the player
     * @param pos The position of card in skill field
     * @param turnPhase (draw = 0, main = 1, battle = 2, end = 3)
     */
    public void handleClickSkillField(int ord, int pos, int turnPhase) {
        
        if (this.turn != ord) return;
        if (!(turnPhase % 4 == 1)) return;
        
        CardSkillField CC;
        GamePlayer currentGamePlayer = this.players[ord];
        GameText currentText = currentGamePlayer.getGameText();
        CardPlayer currentCardPlayer = currentGamePlayer.getCardPlayer();
        
        CC = currentCardPlayer.getCardSkillFieldAt(pos);
        String cardName = CC.getCard().getName();
        
        if (!CC.getIsOccupied()) return;
        
        if (this.selectedCard == CC) {
            if (CC.isCardAttached()) {
                CC.removeCardAttached();
            }
            CC.flipIsOccupied();
            currentCardPlayer.getCardInSkillField().updateCardInSkillField();
            currentText.setStatusTextTo("Card skill " + cardName + " has been removed");
            this.selectedCard = new CardBoard();
            return;
        }
        
        if (!this.isSelectedCardEmpty()) return;
        
        if (CC.isCardAttached()) {
            currentText.setStatusTextTo("Card skill has already been used");
            return;
        }
        
        currentText.setStatusTextTo("Card skill " + cardName + " has been selected!");
        
        CC.flipUnderLine();
        this.selectedCard = CC;
    }
    
    /**
     * Handling when a card in battle field of a particular player is clicked
     * @param ord The order of the player
     * @param pos The position of card in battle field
     * @param turnPhase (draw = 0, main = 1, battle = 2, end = 3)
     */
    public void handleClickBattleField(int ord, int pos, int turnPhase) {
        
        CardBattleField CC;
        GamePlayer currentGamePlayer = this.players[ord];
        Player currentPlayer = currentGamePlayer.getPlayer();
        GameText currentText = currentGamePlayer.getGameText();
        CardPlayer currentCardPlayer = currentGamePlayer.getCardPlayer();
        
        CC = currentCardPlayer.getCardBattleFieldAt(pos);
        
        if (!CC.getIsOccupied()) return;
        
        String cardName = CC.getCard().getName();
        
        if (turnPhase % 4 == 1) {
            
            if (this.isSelectedCardEmpty()) {
                
                if (this.turn != ord) return;
                
                CC.flipIsAttacking();
                
                currentText.setStatusTextTo("Character " + cardName + " has changed to "
                 + (CC.getIsAttacking() ? "attack" : "defense") + " position");
                
            } else if (this.selectedCard instanceof CardSkillField) {
                CardSkillField SS = (CardSkillField) this.selectedCard;
                
                SS.setCardAttached(CC);
                SS.flipUnderLine();
                CC.addCardAttached(SS);
                
                currentText.setStatusTextTo("Character " + cardName + " has been attached by The Selected Skill Card!");
                
                this.selectedCard = new CardBoard();
            }
        } else if (turnPhase % 4 == 2) {
            
            GamePlayer otherGamePlayer = this.players[1 - ord];
            Player otherPlayer = otherGamePlayer.getPlayer();
            GameText otherText = otherGamePlayer.getGameText();
            CardPlayer otherCardPlayer = otherGamePlayer.getCardPlayer();
            
            if (this.isSelectedCardEmpty()) {
                if (this.turn != ord) return;
                if (!CC.getIsAttacking()) {
                    currentText.setStatusTextTo("Cannot use card to attack when card is in defense position");
                    return;
                }
                
                if (turnPhase - CC.getTurnWhenSummon() <= 1) {
                    currentText.setStatusTextTo("Character " + cardName + " cannot attack yet");
                    return;
                }
                
                if (CC.getIsAttacked()) {
                    currentText.setStatusTextTo("Character " + cardName + " has already attacked");
                    return;
                }
                
                // Use Direct Attack if possible
                if (otherCardPlayer.getCardInBattleField().isCardInBattleFieldEmpty()) {
                    int currentAttack = CC.getCard().getAttack();
                    int otherHP = otherPlayer.getHealth();
                    otherHP = Math.max(0, otherHP - currentAttack);
                    
                    otherText.setStatusTextTo("Player " + String.valueOf(2 - this.turn) +
                            " received " + String.valueOf(currentAttack) + " damage");
                    
                    otherPlayer.setHealth(otherHP);
                    otherPlayer.setHealthTextTo(String.valueOf(otherHP));
                    
                    CC.flipIsAttacked();
                    
                    if (otherHP == 0) {
                        otherGamePlayer.flipIsLost();
                        gameOver();
                    }
                    
                    return;
                }
                
                this.selectedCard = CC;
                this.selectedCard.flipUnderLine();
                
                currentText.setStatusTextTo("Character " + cardName + " has been selected!");
                
            } else if (this.selectedCard instanceof CardBattleField) {
                
                if (this.selectedCard == CC) {
                    CC.flipUnderLine();
                    currentText.setStatusTextTo("Character " + cardName + " has been unselected!");
                    this.selectedCard = new CardBoard();
                    return;
                }
                
                CardBattleField BB = (CardBattleField) this.selectedCard;
                
                if (CC.getIsAttacking()) {
                    int currentAttack = CC.getCard().getAttack();
                    int selectedAttack = this.selectedCard.getCard().getAttack();
  
                    if (selectedAttack > currentAttack) {
                        
                        CC.setToDead();
                        
                        int dif = selectedAttack - currentAttack;
                        
                        currentText.setStatusTextTo("Player " + String.valueOf(ord + 1) + " Has received " + dif + " damage!");
                        
                        int curHealth = currentPlayer.getHealth();
                        curHealth = Math.max(0, curHealth - dif);
                        currentPlayer.setHealth(curHealth);
                        currentPlayer.setHealthTextTo(String.valueOf(curHealth));
                        
                        if (curHealth == 0) {
                            currentGamePlayer.flipIsLost();
                            gameOver();
                        }
                        
                    } else {
                        currentText.setStatusTextTo("Attack value is not enough to attack card " + cardName);
                        return;
                    }
                } else {
                    
                    int thisDefend = CC.getCard().getDefend();
                    int selectedAttack = this.selectedCard.getCard().getAttack();
                    
                    if (selectedAttack > thisDefend) {
                        currentText.setStatusTextTo("Card " + cardName + " has been destroyed!");
                        CC.setToDead();
                        
                    } else {
                        currentText.setStatusTextTo("Attack value is not enough to attack card " + cardName);
                        return;
                    }
                }
                
                currentCardPlayer.getCardInBattleField().decreaseNumOfCardInBattleField();
                BB.flipIsAttacked();
                this.selectedCard.flipUnderLine();
                this.selectedCard = new CardBoard();
            }
        }
    }
}

package com.avatarduel.gui;

import com.avatarduel.gameplay.GamePlay;
import com.avatarduel.gameplay.GamePlayer;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author K03 - Group 04
 */
public class GUIController implements Initializable {
    private final int numOfPlayer = 2;
    private final int nullPhase = -999;
    
    private int curPhase = nullPhase;
    private int curPlayer = 0;
    
    private GamePlay gamePlay;
    
    /* Declaration Controllers of Card Display */
    @FXML
    private Text cardName;
    @FXML
    private Text cardDescription;
    @FXML
    private Text cardAttribute;
    @FXML
    private ImageView cardImage;
    @FXML
    private ImageView cardElement;
    
    /* Declaration for GamePhase */
    private List<Text> phases;
    @FXML
    private Text drawPhase;
    @FXML
    private Text mainPhase;
    @FXML
    private Text battlePhase;
    @FXML
    private Text endPhase;
    
    
    /* Methods for Phases */
    private void flipPhase(Text phase) {
        phase.setUnderline(!phase.isUnderline());
    }
    
    /* Declaration and Method for Button EndTurn */
    @FXML
    private Button endTurn;
    @FXML
    private void handleButtonEndTurn(ActionEvent event) {
        
        if (curPhase == nullPhase) {
            curPhase = 0;
            startGame();
            return;
        }
        
        flipPhase(phases.get(curPhase % 4));
        curPhase++;
        flipPhase(phases.get(curPhase % 4));
        
        if (curPhase % 4 == 0) {
            for (int i = 1; i <= numOfPlayer; i++) {
                gamePlay.getGamePlayer(i).getCardPlayer().flipCloseCardInHand();
                if (i == curPlayer + 1) {
                    gamePlay.getGamePlayer(i).addFromDeck();
                    gamePlay.getGamePlayer(i).updatePower();
                }
            }
            gamePlay.gameOver();
        } else if (curPhase % 4 == 3) {
            curPlayer = 1 - curPlayer;
            gamePlay.changeTurn();
        }
        
        gamePlay.updatePhase();
    }
    
    /* Declaration Controllers and Methods for Player One */
    @FXML
    private Text playerOneHP;
    @FXML
    private Text playerOneDeck;
    @FXML
    private Text statusTextOne;
    @FXML
    private Text cardInHandPlayerOne_1;
    @FXML
    private void handleHoverCardInHandPlayerOne_1() {
        gamePlay.handleHover(gamePlay.getCardHandAt(0, 1));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_1() {
        gamePlay.handleClickHand(0, 1, curPhase);
    }
    @FXML
    private Text cardInHandPlayerOne_2;
    @FXML
    private void handleHoverCardInHandPlayerOne_2() {
        gamePlay.handleHover(gamePlay.getCardHandAt(0, 2));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_2() {
        gamePlay.handleClickHand(0, 2, curPhase);
    }
    @FXML
    private Text cardInHandPlayerOne_3;
    @FXML
    private void handleHoverCardInHandPlayerOne_3() {
        gamePlay.handleHover(gamePlay.getCardHandAt(0, 3));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_3() {
        gamePlay.handleClickHand(0, 3, curPhase);
    }
    @FXML
    private Text cardInHandPlayerOne_4;
    @FXML
    private void handleHoverCardInHandPlayerOne_4() {
        gamePlay.handleHover(gamePlay.getCardHandAt(0, 4));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_4() {
        gamePlay.handleClickHand(0, 4, curPhase);
    }
    @FXML
    private Text cardInHandPlayerOne_5;
    @FXML
    private void handleHoverCardInHandPlayerOne_5() {
        gamePlay.handleHover(gamePlay.getCardHandAt(0, 5));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_5() {
        gamePlay.handleClickHand(0, 5, curPhase);
    }
    @FXML
    private Text cardInHandPlayerOne_6;
    @FXML
    private void handleHoverCardInHandPlayerOne_6() {
        gamePlay.handleHover(gamePlay.getCardHandAt(0, 6));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_6() {
        gamePlay.handleClickHand(0, 6, curPhase);
    }
    @FXML
    private Text cardInHandPlayerOne_7;
    @FXML
    private void handleHoverCardInHandPlayerOne_7() {
        gamePlay.handleHover(gamePlay.getCardHandAt(0, 7));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_7() {
        gamePlay.handleClickHand(0, 7, curPhase);
    }
    @FXML
    private Text cardInHandPlayerOne_8;
    @FXML
    private void handleHoverCardInHandPlayerOne_8() {
        gamePlay.handleHover(gamePlay.getCardHandAt(0, 8));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_8() {
        gamePlay.handleClickHand(0, 8, curPhase);
    }
    @FXML
    private Text cardInHandPlayerOne_9;
    @FXML
    private void handleHoverCardInHandPlayerOne_9() {
        gamePlay.handleHover(gamePlay.getCardHandAt(0, 9));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_9() {
        gamePlay.handleClickHand(0, 9, curPhase);
    }
    @FXML
    private Text cardInHandPlayerOne_10;
    @FXML
    private void handleHoverCardInHandPlayerOne_10() {
        gamePlay.handleHover(gamePlay.getCardHandAt(0, 10));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_10() {
        gamePlay.handleClickHand(0, 10, curPhase);
    }
    @FXML
    private Text cardInBattleFieldPlayerOne_1;
    @FXML
    private void handleHoverCardInBattleFieldPlayerOne_1() {
        gamePlay.handleHover(gamePlay.getCardBattleFieldAt(0, 1));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerOne_1() {
        gamePlay.handleClickBattleField(0, 1, curPhase);
    }
    @FXML
    private Text cardInBattleFieldPlayerOne_2;
    @FXML
    private void handleHoverCardInBattleFieldPlayerOne_2() {
        gamePlay.handleHover(gamePlay.getCardBattleFieldAt(0, 2));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerOne_2() {
        gamePlay.handleClickBattleField(0,  2, curPhase);
    }
    @FXML
    private Text cardInBattleFieldPlayerOne_3;
    @FXML
    private void handleHoverCardInBattleFieldPlayerOne_3() {
        gamePlay.handleHover(gamePlay.getCardBattleFieldAt(0, 3));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerOne_3() {
        gamePlay.handleClickBattleField(0,  3, curPhase);
    }
    @FXML
    private Text cardInBattleFieldPlayerOne_4;
    @FXML
    private void handleHoverCardInBattleFieldPlayerOne_4() {
        gamePlay.handleHover(gamePlay.getCardBattleFieldAt(0, 4));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerOne_4() {
        gamePlay.handleClickBattleField(0,  4, curPhase);
    }
    @FXML
    private Text cardInBattleFieldPlayerOne_5;
    @FXML
    private void handleHoverCardInBattleFieldPlayerOne_5() {
        gamePlay.handleHover(gamePlay.getCardBattleFieldAt(0, 5));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerOne_5() {
        gamePlay.handleClickBattleField(0,  5, curPhase);
    }
    @FXML
    private Text cardInBattleFieldPlayerOne_6;
    @FXML
    private void handleHoverCardInBattleFieldPlayerOne_6() {
        gamePlay.handleHover(gamePlay.getCardBattleFieldAt(0, 6));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerOne_6() {
        gamePlay.handleClickBattleField(0,  6, curPhase);
    }
    @FXML
    private Text cardInSkillFieldPlayerOne_1;
    @FXML
    private void handleHoverCardInSkillFieldPlayerOne_1() {
        gamePlay.handleHover(gamePlay.getCardSkillFieldAt(0, 1));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerOne_1() {
        gamePlay.handleClickSkillField(0, 1, curPhase);
    }
    @FXML
    private Text cardInSkillFieldPlayerOne_2;
    @FXML
    private void handleHoverCardInSkillFieldPlayerOne_2() {
        gamePlay.handleHover(gamePlay.getCardSkillFieldAt(0, 2));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerOne_2() {
        gamePlay.handleClickSkillField(0, 2, curPhase);
    }
    @FXML
    private Text cardInSkillFieldPlayerOne_3;
    @FXML
    private void handleHoverCardInSkillFieldPlayerOne_3() {
        gamePlay.handleHover(gamePlay.getCardSkillFieldAt(0, 3));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerOne_3() {
        gamePlay.handleClickSkillField(0, 3, curPhase);
    }
    @FXML
    private Text cardInSkillFieldPlayerOne_4;
    @FXML
    private void handleHoverCardInSkillFieldPlayerOne_4() {
        gamePlay.handleHover(gamePlay.getCardSkillFieldAt(0, 4));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerOne_4() {
        gamePlay.handleClickSkillField(0, 4, curPhase);
    }
    @FXML
    private Text cardInSkillFieldPlayerOne_5;
    @FXML
    private void handleHoverCardInSkillFieldPlayerOne_5() {
        gamePlay.handleHover(gamePlay.getCardSkillFieldAt(0, 5));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerOne_5() {
        gamePlay.handleClickSkillField(0, 5, curPhase);
    }
    @FXML
    private Text cardInSkillFieldPlayerOne_6;
    @FXML
    private void handleHoverCardInSkillFieldPlayerOne_6() {
        gamePlay.handleHover(gamePlay.getCardSkillFieldAt(0, 6));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerOne_6() {
        gamePlay.handleClickSkillField(0, 6, curPhase);
    }
    @FXML
    private Text powerElementAirPlayerOne;
    @FXML
    private Text powerElementWaterPlayerOne;
    @FXML
    private Text powerElementFirePlayerOne;
    @FXML
    private Text powerElementEarthPlayerOne;
    @FXML
    private Text powerElementEnergyPlayerOne;

    
    /* Declaration Controller for Player Two */
    @FXML
    private Text playerTwoHP;
    @FXML
    private Text playerTwoDeck;
    @FXML
    private Text cardInHandPlayerTwo_1;
    @FXML
    private Text statusTextTwo;
    @FXML
    private void handleHoverCardInHandPlayerTwo_1() {
        gamePlay.handleHover(gamePlay.getCardHandAt(1, 1));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_1() {
        gamePlay.handleClickHand(1, 1, curPhase);
    }
    @FXML
    private Text cardInHandPlayerTwo_2;
    @FXML
    private void handleHoverCardInHandPlayerTwo_2() {
        gamePlay.handleHover(gamePlay.getCardHandAt(1, 2));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_2() {
        gamePlay.handleClickHand(1, 2, curPhase);
    }
    @FXML
    private Text cardInHandPlayerTwo_3;
    @FXML
    private void handleHoverCardInHandPlayerTwo_3() {
        gamePlay.handleHover(gamePlay.getCardHandAt(1, 3));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_3() {
        gamePlay.handleClickHand(1, 3, curPhase);
    }
    @FXML
    private Text cardInHandPlayerTwo_4;
    @FXML
    private void handleHoverCardInHandPlayerTwo_4() {
        gamePlay.handleHover(gamePlay.getCardHandAt(1, 4));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_4() {
        gamePlay.handleClickHand(1, 4, curPhase);
    }
    @FXML
    private Text cardInHandPlayerTwo_5;
    @FXML
    private void handleHoverCardInHandPlayerTwo_5() {
        gamePlay.handleHover(gamePlay.getCardHandAt(1, 5));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_5() {
        gamePlay.handleClickHand(1, 5, curPhase);
    }
    @FXML
    private Text cardInHandPlayerTwo_6;
    @FXML
    private void handleHoverCardInHandPlayerTwo_6() {
        gamePlay.handleHover(gamePlay.getCardHandAt(1, 6));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_6() {
        gamePlay.handleClickHand(1, 6, curPhase);
    }
    @FXML
    private Text cardInHandPlayerTwo_7;
    @FXML
    private void handleHoverCardInHandPlayerTwo_7() {
        gamePlay.handleHover(gamePlay.getCardHandAt(1, 7));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_7() {
        gamePlay.handleClickHand(1, 7, curPhase);
    }

    @FXML
    private Text cardInHandPlayerTwo_8;
    @FXML
    private void handleHoverCardInHandPlayerTwo_8() {
        gamePlay.handleHover(gamePlay.getCardHandAt(1, 8));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_8() {
        gamePlay.handleClickHand(1, 8, curPhase);
    }
    @FXML
    private Text cardInHandPlayerTwo_9;
    @FXML
    private void handleHoverCardInHandPlayerTwo_9() {
        gamePlay.handleHover(gamePlay.getCardHandAt(1, 9));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_9() {
        gamePlay.handleClickHand(1, 9, curPhase);
    }
    @FXML
    private Text cardInHandPlayerTwo_10;
    @FXML
    private void handleHoverCardInHandPlayerTwo_10() {
        gamePlay.handleHover(gamePlay.getCardHandAt(1, 10));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_10() {
        gamePlay.handleClickHand(1, 10, curPhase);
    }
    @FXML
    private Text cardInBattleFieldPlayerTwo_1;
    @FXML
    private void handleHoverCardInBattleFieldPlayerTwo_1() {
        gamePlay.handleHover(gamePlay.getCardBattleFieldAt(1, 1));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerTwo_1() {
        gamePlay.handleClickBattleField(1, 1, curPhase);
    }
    @FXML
    private Text cardInBattleFieldPlayerTwo_2;
    @FXML
    private void handleHoverCardInBattleFieldPlayerTwo_2() {
        gamePlay.handleHover(gamePlay.getCardBattleFieldAt(1, 2));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerTwo_2() {
        gamePlay.handleClickBattleField(1, 2, curPhase);
    }
    @FXML
    private Text cardInBattleFieldPlayerTwo_3;
    @FXML
    private void handleHoverCardInBattleFieldPlayerTwo_3() {
        gamePlay.handleHover(gamePlay.getCardBattleFieldAt(1, 3));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerTwo_3() {
        gamePlay.handleClickBattleField(1, 3, curPhase);
    }
    @FXML
    private Text cardInBattleFieldPlayerTwo_4;
    @FXML
    private void handleHoverCardInBattleFieldPlayerTwo_4() {
        gamePlay.handleHover(gamePlay.getCardBattleFieldAt(1, 4));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerTwo_4() {
        gamePlay.handleClickBattleField(1, 4, curPhase);
    }
    @FXML
    private Text cardInBattleFieldPlayerTwo_5;
    @FXML
    private void handleHoverCardInBattleFieldPlayerTwo_5() {
        gamePlay.handleHover(gamePlay.getCardBattleFieldAt(1, 5));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerTwo_5() {
        gamePlay.handleClickBattleField(1, 5, curPhase);
    }
    @FXML
    private Text cardInBattleFieldPlayerTwo_6;
    @FXML
    private void handleHoverCardInBattleFieldPlayerTwo_6() {
        gamePlay.handleHover(gamePlay.getCardBattleFieldAt(1, 6));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerTwo_6() {
        gamePlay.handleClickBattleField(1, 6, curPhase);
    }
    @FXML
    private Text cardInSkillFieldPlayerTwo_1;
    @FXML
    private void handleHoverCardInSkillFieldPlayerTwo_1() {
        gamePlay.handleHover(gamePlay.getCardSkillFieldAt(1, 1));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerTwo_1() {
        gamePlay.handleClickSkillField(1, 1, curPhase);
    }
    @FXML
    private Text cardInSkillFieldPlayerTwo_2;
    @FXML
    private void handleHoverCardInSkillFieldPlayerTwo_2() {
        gamePlay.handleHover(gamePlay.getCardSkillFieldAt(1, 2));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerTwo_2() {
        gamePlay.handleClickSkillField(1, 2, curPhase);
    }
    @FXML
    private Text cardInSkillFieldPlayerTwo_3;
    @FXML
    private void handleHoverCardInSkillFieldPlayerTwo_3() {
        gamePlay.handleHover(gamePlay.getCardSkillFieldAt(1, 3));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerTwo_3() {
        gamePlay.handleClickSkillField(1, 3, curPhase);
    }
    @FXML
    private Text cardInSkillFieldPlayerTwo_4;
    @FXML
    private void handleHoverCardInSkillFieldPlayerTwo_4() {
        gamePlay.handleHover(gamePlay.getCardSkillFieldAt(1, 4));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerTwo_4() {
        gamePlay.handleClickSkillField(1, 4, curPhase);
    }
    @FXML
    private Text cardInSkillFieldPlayerTwo_5;
    @FXML
    private void handleHoverCardInSkillFieldPlayerTwo_5() {
        gamePlay.handleHover(gamePlay.getCardSkillFieldAt(1, 5));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerTwo_5() {
        gamePlay.handleClickSkillField(1, 5, curPhase);
    }
    @FXML
    private Text cardInSkillFieldPlayerTwo_6;
    @FXML
    private void handleHoverCardInSkillFieldPlayerTwo_6() {
        gamePlay.handleHover(gamePlay.getCardSkillFieldAt(1, 6));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerTwo_6() {
        gamePlay.handleClickSkillField(1, 6, curPhase);
    }
    @FXML
    private Text powerElementAirPlayerTwo;
    @FXML
    private Text powerElementWaterPlayerTwo;
    @FXML
    private Text powerElementFirePlayerTwo;
    @FXML
    private Text powerElementEarthPlayerTwo;
    @FXML
    private Text powerElementEnergyPlayerTwo;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Initializing");

        // Initialize Game Play
        gamePlay = new GamePlay();
        GamePlayer[] player = new GamePlayer[numOfPlayer];
        
        for (int i = 0; i < numOfPlayer; i++) {
            player[i] = new GamePlayer();
        }
        
        player[0] = gamePlay.getGamePlayer(1);
        player[1] = gamePlay.getGamePlayer(2);
        
        // Initialize Phases
        phases = new ArrayList<>();
        phases.add(drawPhase);
        phases.add(mainPhase);
        phases.add(battlePhase);
        phases.add(endPhase);
        
        
        // Initialize Text Arrays
        Text[][] textPlayerCardInHands = {
            {
                cardInHandPlayerOne_1,
                cardInHandPlayerOne_2,
                cardInHandPlayerOne_3,
                cardInHandPlayerOne_4,
                cardInHandPlayerOne_5,
                cardInHandPlayerOne_6,
                cardInHandPlayerOne_7,
                cardInHandPlayerOne_8,
                cardInHandPlayerOne_9,
                cardInHandPlayerOne_10
            }, {
                cardInHandPlayerTwo_1,
                cardInHandPlayerTwo_2,
                cardInHandPlayerTwo_3,
                cardInHandPlayerTwo_4,
                cardInHandPlayerTwo_5,
                cardInHandPlayerTwo_6,
                cardInHandPlayerTwo_7,
                cardInHandPlayerTwo_8,
                cardInHandPlayerTwo_9,
                cardInHandPlayerTwo_10
            }
        };
        
        Text[][] textPlayerCardInSkillFields = {
            {
                cardInSkillFieldPlayerOne_1,
                cardInSkillFieldPlayerOne_2,
                cardInSkillFieldPlayerOne_3,
                cardInSkillFieldPlayerOne_4,
                cardInSkillFieldPlayerOne_5,
                cardInSkillFieldPlayerOne_6
            }, {
                cardInSkillFieldPlayerTwo_1,
                cardInSkillFieldPlayerTwo_2,
                cardInSkillFieldPlayerTwo_3,
                cardInSkillFieldPlayerTwo_4,
                cardInSkillFieldPlayerTwo_5,
                cardInSkillFieldPlayerTwo_6
            }
        };
        
        Text[][] textPlayerCardInBattleFields = {
            {
                cardInBattleFieldPlayerOne_1,
                cardInBattleFieldPlayerOne_2,
                cardInBattleFieldPlayerOne_3,
                cardInBattleFieldPlayerOne_4,
                cardInBattleFieldPlayerOne_5,
                cardInBattleFieldPlayerOne_6
            }, {
                cardInBattleFieldPlayerTwo_1,
                cardInBattleFieldPlayerTwo_2,
                cardInBattleFieldPlayerTwo_3,
                cardInBattleFieldPlayerTwo_4,
                cardInBattleFieldPlayerTwo_5,
                cardInBattleFieldPlayerTwo_6
            }
        };
        
        Text[][] textPlayerPower = {
            { 
                powerElementAirPlayerOne,
                powerElementWaterPlayerOne,
                powerElementFirePlayerOne,
                powerElementEarthPlayerOne,
                powerElementEnergyPlayerOne
            }, {
                powerElementAirPlayerTwo,
                powerElementWaterPlayerTwo,
                powerElementFirePlayerTwo,
                powerElementEarthPlayerTwo,
                powerElementEnergyPlayerTwo
            }
        };
        
        Text[] textPlayerStatus = {
            statusTextOne,
            statusTextTwo
        };
        
        Text[] textPlayerHP = {
            playerOneHP,
            playerTwoHP
        };
        
        Text[] textPlayerDeck = {
            playerOneDeck,
            playerTwoDeck
        };
        
        // Link Gameplay with FXML Controller
        gamePlay.getCardDisplay().setCardDisplay(cardName, cardDescription, cardAttribute, cardImage, cardElement);
        
        for (int i = 0; i < numOfPlayer; i++) {
            try {
                player[i].buildDeck();
                player[i].getCardPlayer().getCardInHand().setTextCardInHand(textPlayerCardInHands[i]);
                player[i].getCardPlayer().getCardInSkillField().setTextCardInSkillField(textPlayerCardInSkillFields[i]);
                player[i].getCardPlayer().getCardInBattleField().setTextCardInBattleField(textPlayerCardInBattleFields[i]);
                player[i].getGameText().setStatusText(textPlayerStatus[i]);
                player[i].getGameText().setPowerText(textPlayerPower[i][0], textPlayerPower[i][1],
                        textPlayerPower[i][2], textPlayerPower[i][3], textPlayerPower[i][4]);
                player[i].getPlayer().setHealthText(textPlayerHP[i]);
                player[i].getPlayer().setDeckText(textPlayerDeck[i]);
            } catch (IOException ex) {
                Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Method to setup necessary adjustments when game is started
     */
    private void startGame() {
        for (int i = 1; i <= numOfPlayer; i++) {
            for (int j = 1; j <= 8; j++) {
                gamePlay.getGamePlayer(i).addFromDeck();
            }
        }
        
        endTurn.setText("END TURN");
        statusTextOne.setText("");
        drawPhase.setUnderline(true);
        
        gamePlay.getGamePlayer(1).addFromDeck();
        gamePlay.getGamePlayer(2).getCardPlayer().flipCloseCardInHand();
        gamePlay.updatePhase();
    }
}

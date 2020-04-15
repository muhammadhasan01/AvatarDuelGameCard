/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.gui;

import com.avatarduel.gameboard.CardBoard;
import com.avatarduel.gameplay.GamePlay;
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
 * @author USER
 */
public class GUIController implements Initializable {
    private final int numOfPlayer = 2;
    private final int maxCardInHand = 10;
    private final int maxCardInBattleField = 8;
    private final int maxCardInSkillField = 8;
    private final int nullPhase = -999;
    
    private int curPhase = nullPhase;
    private int curPlayer = 0;
    private CardBoard selectedCard;
    
    private GamePlay[] player;
    
    /* Declaration Controllers of Card Loader */
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
    private Text main1Phase;
    @FXML
    private Text battlePhase;
    @FXML
    private Text main2Phase;
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
        
        flipPhase(phases.get(curPhase));
        curPhase = (curPhase + 1) % 5;
        flipPhase(phases.get(curPhase));
        
        for (int i = 0; i < numOfPlayer; i++) {
            player[i].updateCards();
        }
        
        if (curPhase == 0) {
            player[curPlayer].addFromDeck();
        } else if (curPhase == 4) {
            curPlayer ^= 1;
        }
    }
    
    /* Declaration and Method for Change Position */
    @FXML
    private Button changePosition;
    
    @FXML
    private void handleButtonChangePosition(ActionEvent event) {
        player[curPlayer].handleClickChangePosition(curPhase);
    }
    
    /* Declaration and Method for Attack Button */
    @FXML
    private Button directAttackButton;
    
    @FXML
    private void handleDirectAttackButton(ActionEvent event) {
        // TODO
    }
    
    /* Declaration for Status Gameplay */
    @FXML
    private Text statusTextOne;
    
    @FXML
    private Text statusTextTwo;
    
    /* Declaration Controllers and Methods for Player One */
    @FXML
    private Text playerOneHP;
    @FXML
    private Text playerOneDeck;
    @FXML
    private Text cardInHandPlayerOne_1;
    @FXML
    private void handleHoverCardInHandPlayerOne_1() {
        player[0].handleHover(player[0].getCardHandAt(1));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_1() {
        player[0].handleClickHand(1, curPhase);
    }

    @FXML
    private Text cardInHandPlayerOne_2;
    @FXML
    private void handleHoverCardInHandPlayerOne_2() {
        player[0].handleHover(player[0].getCardHandAt(2));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_2() {
        player[0].handleClickHand(2, curPhase);
    }

    @FXML
    private Text cardInHandPlayerOne_3;
    @FXML
    private void handleHoverCardInHandPlayerOne_3() {
        player[0].handleHover(player[0].getCardHandAt(3));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_3() {
        player[0].handleClickHand(3, curPhase);
    }

    @FXML
    private Text cardInHandPlayerOne_4;
    @FXML
    private void handleHoverCardInHandPlayerOne_4() {
        player[0].handleHover(player[0].getCardHandAt(4));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_4() {
        player[0].handleClickHand(4, curPhase);
    }

    @FXML
    private Text cardInHandPlayerOne_5;
    @FXML
    private void handleHoverCardInHandPlayerOne_5() {
        player[0].handleHover(player[0].getCardHandAt(5));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_5() {
        player[0].handleClickHand(5, curPhase);
    }

    @FXML
    private Text cardInHandPlayerOne_6;
    @FXML
    private void handleHoverCardInHandPlayerOne_6() {
        player[0].handleHover(player[0].getCardHandAt(6));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_6() {
        player[0].handleClickHand(6, curPhase);
    }

    @FXML
    private Text cardInHandPlayerOne_7;
    @FXML
    private void handleHoverCardInHandPlayerOne_7() {
        player[0].handleHover(player[0].getCardHandAt(7));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_7() {
        player[0].handleClickHand(7, curPhase);
    }

    @FXML
    private Text cardInHandPlayerOne_8;
    @FXML
    private void handleHoverCardInHandPlayerOne_8() {
        player[0].handleHover(player[0].getCardHandAt(8));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_8() {
        player[0].handleClickHand(8, curPhase);
    }

    @FXML
    private Text cardInHandPlayerOne_9;
    @FXML
    private void handleHoverCardInHandPlayerOne_9() {
        player[0].handleHover(player[0].getCardHandAt(9));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_9() {
        player[0].handleClickHand(9, curPhase);
    }

    @FXML
    private Text cardInHandPlayerOne_10;
    @FXML
    private void handleHoverCardInHandPlayerOne_10() {
        player[0].handleHover(player[0].getCardHandAt(10));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_10() {
        player[0].handleClickHand(10, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerOne_1;
    @FXML
    private void handleHoverCardInBattleFieldPlayerOne_1() {
        player[0].handleHover(player[0].getCardBattleFieldAt(1));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerOne_1() {
        player[0].handleClickBattleField(1, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerOne_2;
    @FXML
    private void handleHoverCardInBattleFieldPlayerOne_2() {
        player[0].handleHover(player[0].getCardBattleFieldAt(2));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerOne_2() {
        player[0].handleClickBattleField(2, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerOne_3;
    @FXML
    private void handleHoverCardInBattleFieldPlayerOne_3() {
        player[0].handleHover(player[0].getCardBattleFieldAt(3));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerOne_3() {
        player[0].handleClickBattleField(3, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerOne_4;
    @FXML
    private void handleHoverCardInBattleFieldPlayerOne_4() {
        player[0].handleHover(player[0].getCardBattleFieldAt(4));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerOne_4() {
        player[0].handleClickBattleField(4, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerOne_5;
    @FXML
    private void handleHoverCardInBattleFieldPlayerOne_5() {
        player[0].handleHover(player[0].getCardBattleFieldAt(5));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerOne_5() {
        player[0].handleClickBattleField(5, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerOne_6;
    @FXML
    private void handleHoverCardInBattleFieldPlayerOne_6() {
        player[0].handleHover(player[0].getCardBattleFieldAt(6));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerOne_6() {
        player[0].handleClickBattleField(6, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerOne_7;
    @FXML
    private void handleHoverCardInBattleFieldPlayerOne_7() {
        player[0].handleHover(player[0].getCardBattleFieldAt(7));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerOne_7() {
        player[0].handleClickBattleField(7, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerOne_8;
    @FXML
    private void handleHoverCardInBattleFieldPlayerOne_8() {
        player[0].handleHover(player[0].getCardBattleFieldAt(8));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerOne_8() {
        player[0].handleClickBattleField(8, curPhase);
    }
    
    @FXML
    private Text cardInStatusFieldPlayerOne_1;
    @FXML
    private void handleHoverCardInSkillFieldPlayerOne_1() {
        player[0].handleHover(player[0].getCardSkillFieldAt(1));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerOne_1() {
        player[0].handleClickSkillField(1, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerOne_2;
    @FXML
    private void handleHoverCardInSkillFieldPlayerOne_2() {
        player[0].handleHover(player[0].getCardSkillFieldAt(2));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerOne_2() {
        player[0].handleClickSkillField(2, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerOne_3;
    @FXML
    private void handleHoverCardInSkillFieldPlayerOne_3() {
        player[0].handleHover(player[0].getCardSkillFieldAt(3));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerOne_3() {
        player[0].handleClickSkillField(3, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerOne_4;
    @FXML
    private void handleHoverCardInSkillFieldPlayerOne_4() {
        player[0].handleHover(player[0].getCardSkillFieldAt(4));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerOne_4() {
        player[0].handleClickSkillField(4, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerOne_5;
    @FXML
    private void handleHoverCardInSkillFieldPlayerOne_5() {
        player[0].handleHover(player[0].getCardSkillFieldAt(5));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerOne_5() {
        player[0].handleClickSkillField(5, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerOne_6;
    @FXML
    private void handleHoverCardInSkillFieldPlayerOne_6() {
        player[0].handleHover(player[0].getCardSkillFieldAt(6));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerOne_6() {
        player[0].handleClickSkillField(6, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerOne_7;
    @FXML
    private void handleHoverCardInSkillFieldPlayerOne_7() {
        player[0].handleHover(player[0].getCardSkillFieldAt(7));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerOne_7() {
        player[0].handleClickSkillField(1, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerOne_8;
    @FXML
    private void handleHoverCardInSkillFieldPlayerOne_8() {
        player[0].handleHover(player[0].getCardSkillFieldAt(8));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerOne_8() {
        player[0].handleClickSkillField(8, curPhase);
    }
    
    @FXML
    private Text powerElementAirPlayerOne;
//    jobdesc 4 : 
//    isi semua elemen gan, (jangan lupa @FXML-nya + pastikan sesuai waktu ngelinknya ke FXML)
//    dibagian player dua dibawah juga janlup isi, tinggal ganti playerOne jadi PlayerTwo
//    @FXML
//    private Text powerElement<Water/Fire/Earth>PlayerOne
    
    /* Declaration Controller for Player Two */
    @FXML
    private Text playerTwoHP;
    @FXML
    private Text playerTwoDeck;
    @FXML
    private Text cardInHandPlayerTwo_1;
    @FXML
    private void handleHoverCardInHandPlayerTwo_1() {
        player[1].handleHover(player[1].getCardHandAt(1));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_1() {
        player[1].handleClickHand(1, curPhase);
    }

    @FXML
    private Text cardInHandPlayerTwo_2;
    @FXML
    private void handleHoverCardInHandPlayerTwo_2() {
        player[1].handleHover(player[1].getCardHandAt(2));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_2() {
        player[1].handleClickHand(2, curPhase);
    }

    @FXML
    private Text cardInHandPlayerTwo_3;
    @FXML
    private void handleHoverCardInHandPlayerTwo_3() {
        player[1].handleHover(player[1].getCardHandAt(3));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_3() {
        player[1].handleClickHand(3, curPhase);
    }

    @FXML
    private Text cardInHandPlayerTwo_4;
    @FXML
    private void handleHoverCardInHandPlayerTwo_4() {
        player[1].handleHover(player[1].getCardHandAt(4));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_4() {
        player[1].handleClickHand(4, curPhase);
    }

    @FXML
    private Text cardInHandPlayerTwo_5;
    @FXML
    private void handleHoverCardInHandPlayerTwo_5() {
        player[1].handleHover(player[1].getCardHandAt(5));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_5() {
        player[1].handleClickHand(5, curPhase);
    }

    @FXML
    private Text cardInHandPlayerTwo_6;
    @FXML
    private void handleHoverCardInHandPlayerTwo_6() {
        player[1].handleHover(player[1].getCardHandAt(6));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_6() {
        player[1].handleClickHand(6, curPhase);
    }

    @FXML
    private Text cardInHandPlayerTwo_7;
    @FXML
    private void handleHoverCardInHandPlayerTwo_7() {
        player[1].handleHover(player[1].getCardHandAt(7));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_7() {
        player[1].handleClickHand(7, curPhase);
    }

    @FXML
    private Text cardInHandPlayerTwo_8;
    @FXML
    private void handleHoverCardInHandPlayerTwo_8() {
        player[1].handleHover(player[1].getCardHandAt(8));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_8() {
        player[1].handleClickHand(8, curPhase);
    }

    @FXML
    private Text cardInHandPlayerTwo_9;
    @FXML
    private void handleHoverCardInHandPlayerTwo_9() {
        player[1].handleHover(player[1].getCardHandAt(9));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_9() {
        player[1].handleClickHand(9, curPhase);
    }

    @FXML
    private Text cardInHandPlayerTwo_10;
    @FXML
    private void handleHoverCardInHandPlayerTwo_10() {
        player[1].handleHover(player[1].getCardHandAt(10));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_10() {
        player[1].handleClickHand(10, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerTwo_1;
        @FXML
    private void handleHoverCardInBattleFieldPlayerTwo_1() {
        player[1].handleHover(player[1].getCardBattleFieldAt(1));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerTwo_1() {
        player[1].handleClickBattleField(1, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerTwo_2;
    @FXML
    private void handleHoverCardInBattleFieldPlayerTwo_2() {
        player[1].handleHover(player[1].getCardBattleFieldAt(2));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerTwo_2() {
        player[1].handleClickBattleField(2, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerTwo_3;
    @FXML
    private void handleHoverCardInBattleFieldPlayerTwo_3() {
        player[1].handleHover(player[1].getCardBattleFieldAt(3));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerTwo_3() {
        player[1].handleClickBattleField(3, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerTwo_4;
    @FXML
    private void handleHoverCardInBattleFieldPlayerTwo_4() {
        player[1].handleHover(player[1].getCardBattleFieldAt(4));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerTwo_4() {
        player[1].handleClickBattleField(4, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerTwo_5;
    @FXML
    private void handleHoverCardInBattleFieldPlayerTwo_5() {
        player[1].handleHover(player[1].getCardBattleFieldAt(5));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerTwo_5() {
        player[1].handleClickBattleField(5, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerTwo_6;
    @FXML
    private void handleHoverCardInBattleFieldPlayerTwo_6() {
        player[1].handleHover(player[1].getCardBattleFieldAt(6));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerTwo_6() {
        player[1].handleClickBattleField(6, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerTwo_7;
    @FXML
    private void handleHoverCardInBattleFieldPlayerTwo_7() {
        player[1].handleHover(player[1].getCardBattleFieldAt(7));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerTwo_7() {
        player[1].handleClickBattleField(7, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerTwo_8;
    @FXML
    private void handleHoverCardInBattleFieldPlayerTwo_8() {
        player[1].handleHover(player[1].getCardBattleFieldAt(8));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerTwo_8() {
        player[1].handleClickBattleField(8, curPhase);
    }
    // jobdesc 2 - lengkapin juga player two (jangan lupa @FXML + nyambungin ke FXML-nya)
    
    @FXML
    private Text cardInStatusFieldPlayerTwo_1;
    @FXML
    private void handleHoverCardInSkillFieldPlayerTwo_1() {
        player[1].handleHover(player[1].getCardSkillFieldAt(1));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerTwo_1() {
        player[1].handleClickSkillField(1, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerTwo_2;
    @FXML
    private void handleHoverCardInSkillFieldPlayerTwo_2() {
        player[1].handleHover(player[1].getCardSkillFieldAt(2));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerTwo_2() {
        player[1].handleClickSkillField(2, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerTwo_3;
    @FXML
    private void handleHoverCardInSkillFieldPlayerTwo_3() {
        player[1].handleHover(player[1].getCardSkillFieldAt(3));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerTwo_3() {
        player[1].handleClickSkillField(3, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerTwo_4;
    @FXML
    private void handleHoverCardInSkillFieldPlayerTwo_4() {
        player[1].handleHover(player[1].getCardSkillFieldAt(4));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerTwo_4() {
        player[1].handleClickSkillField(4, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerTwo_5;
    @FXML
    private void handleHoverCardInSkillFieldPlayerTwo_5() {
        player[1].handleHover(player[1].getCardSkillFieldAt(5));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerTwo_5() {
        player[1].handleClickSkillField(5, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerTwo_6;
    @FXML
    private void handleHoverCardInSkillFieldPlayerTwo_6() {
        player[1].handleHover(player[1].getCardSkillFieldAt(6));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerTwo_6() {
        player[1].handleClickSkillField(6, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerTwo_7;
    @FXML
    private void handleHoverCardInSkillFieldPlayerTwo_7() {
        player[1].handleHover(player[1].getCardSkillFieldAt(7));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerTwo_7() {
        player[1].handleClickSkillField(1, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerTwo_8;
    @FXML
    private void handleHoverCardInSkillFieldPlayerTwo_8() {
        player[1].handleHover(player[1].getCardSkillFieldAt(8));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerTwo_8() {
        player[1].handleClickSkillField(8, curPhase);
    }
    
    @FXML
    private Text powerElementAirPlayerTwo;
    @FXML
    private Text powerElementWaterPlayerTwo;
    @FXML
    private Text powerElementFirePlayerTwo;
    @FXML
    private Text powerElementEarthPlayerTwo;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Initializing");

        // Initialize Player
        player = new GamePlay[numOfPlayer];
        for (int i = 0; i < numOfPlayer; i++) {
            try {
                player[i] = new GamePlay();
                player[i].setOrderPlayer(i + 1);
                player[i].buildDeck();
                player[i].setCardView(cardName, cardDescription, cardAttribute, cardImage, cardElement);
                player[i].setSelectedCard(selectedCard);
                player[i].setButtonChangePosition(changePosition);
            } catch (IOException ex) {
                Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        /* Initialize Text Arrays */
        Text[] playerOneCardInHands = {
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
        };
        
        Text[] playerTwoCardInHands = {
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
        };
        
        /* Link player with controller */
        player[0].setStatusText(statusTextOne);
        player[1].setStatusText(statusTextTwo);
        
        player[0].setOtherStatusText(statusTextTwo);
        player[1].setOtherStatusText(statusTextOne);
        
        player[0].getPlayer().setHealthText(playerOneHP);
        player[1].getPlayer().setHealthText(playerTwoHP);
        
        player[0].getPlayer().setDeckText(playerOneDeck);
        player[1].getPlayer().setDeckText(playerTwoDeck);
        
        player[0].getCardInHand().setTextCardInHand(playerOneCardInHands);
        player[1].getCardInHand().setTextCardInHand(playerTwoCardInHands);
        
        
        /* Add Phases */
        phases = new ArrayList<>();
        phases.add(drawPhase); phases.add(main1Phase);
        phases.add(battlePhase); phases.add(main2Phase);
        phases.add(endPhase);
    }
    
    private void startGame() {
        for (int i = 0; i < numOfPlayer; i++) {
            for (int j = 0; j < 8; j++) {
                player[i].addFromDeck();
            }
        }
        
        endTurn.setText("END TURN");
        statusTextOne.setText("");
        drawPhase.setUnderline(true);
        
        player[0].addFromDeck();
        for (int i = 0; i < numOfPlayer; i++) {
            player[i].updateCards();
        }
    }
}

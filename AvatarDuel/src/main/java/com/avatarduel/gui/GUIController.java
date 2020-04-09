/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.gui;

import com.avatarduel.gameboard.CardBoard;
import com.avatarduel.gameplay.GamePlay;
import com.avatarduel.model.Card;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class GUIController implements Initializable {
    private final int numOfPlayer = 2;
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
    @FXML
    private Button endTurn;
    
    /* Methods for Phases */
    private void flipPhase(Text phase) {
        phase.setUnderline(!phase.isUnderline());
    }
    
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
    private Button attackButton;
    
    @FXML
    private void handleButtonAttackButton(ActionEvent event) {
        // TODO
    }
    
    /* Declaration for Status Gameplay */
    @FXML
    private Text statusText;
    
    /* Declaration Controllers and Methods for Player One */
    @FXML
    private Text playerOneHP;
    @FXML
    private Text playerOneDeck;
    @FXML
    private Text cardInHandPlayerOne_1;
    @FXML
    private void handleHoverCardInHandPlayerOne_1() {
        player[curPlayer].handleHover(player[curPlayer].getCardHandAt(1));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_1() {
        player[curPlayer].handleClickHand(1, curPhase);
    }
//    jobdesc 1:
//    Isi X dari 2 ampe 10 ya (jangan lupa @FXML-nya + pastikan sesuai waktu ngelinknya ke FXML)
//    Di bagian player dua dibawah juga janlup isi, tinggal ganti PlayerOne jadi PlayerTwo
//    @FXML
//    private Text cardInHandPlayerOne_X;
//    @FXML
//    private void handleHoverCardInHandPlayerOne_X() {
//        player[curPlayer].handleHover(player[curPlayer].getCardHandAt(X));
//    }
//    @FXML
//    private void handleClickCardInHandPlayerOne_X() {
//        player[curPlayer].handleClickHand(X, curPhase);
//    }
    
    @FXML
    private Text cardInBattleFieldPlayerOne_1;
    @FXML
    private void handleHoverCardInBattleFieldPlayerOne_1() {
        player[curPlayer].handleHover(player[curPlayer].getCardBattleFieldAt(1));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerOne_1() {
        player[curPlayer].handleClickBattleField(1, curPhase);
    }
//    jobdesc 2:
//    Isi X dari 2 ampe 10 ya (jangan lupa @FXML-nya + pastikan sesuai waktu ngelinknya ke FXML)
//    Di bagian player dua dibawah juga janlup isi, tinggal ganti PlayerOne jadi PlayerTwo
//    @FXML
//    private Text cardBattleFieldPlayerOne_1;
//    @FXML
//    private void handleHoverCardInBattleFieldPlayerOne_X() {
//        player[curPlayer].handleHover(player[curPlayer].getCardBattleFieldAt(X));
//    }
//    @FXML
//    private void handleClickCardInBattleFieldPlayerOne_X() {
//        player[curPlayer].handleClickBattleField(X, curPhase);
//    }
    
    @FXML
    private Text cardInStatusFieldPlayerOne_1;
    @FXML
    private void handleHoverCardInSkillFieldPlayerOne_1() {
        player[curPlayer].handleHover(player[curPlayer].getCardSkillFieldAt(1));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerOne_1() {
        player[curPlayer].handleClickSkillField(1, curPhase);
    }
//    jobdesc 3:
//    Isi X dari 2 ampe 10 ya (jangan lupa @FXML-nya + pastikan sesuai waktu ngelinknya ke FXML)
//    Di bagian player dua dibawah juga janlup isi, tinggal ganti PlayerOne jadi PlayerTwo
//    @FXML
//    private Text cardStatusFieldPlayerOne_1;
//    @FXML
//    private void handleHoverCardInStatusFieldPlayerOne_X() {
//        player[curPlayer].handleHover(player[curPlayer].getCardSkillFieldAt(1));
//    }
//    @FXML
//    private void handleClickCardInSkillFieldPlayerOne_X() {
//        player[curPlayer].handleClickSkilField(X, curPhase);
//    }
    
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
    // jobdesc 1 - lengkapin juga player two (jangan lupa @FXML + nyambungin ke FXML-nya)
    
    @FXML
    private Text cardInBattleFieldPlayerTwo_1;
    // jobdesc 2 - lengkapin juga player two (jangan lupa @FXML + nyambungin ke FXML-nya)
    
    @FXML
    private Text cardInStatusFieldPlayerTwo_1;
    // jobdesc 3 - lengkapin juga player two (jangan lupa @FXML + nyambungin ke FXML-nya)
    
    @FXML
    private Text powerElementAirPlayerTwo;
    // jobdesc 4 - lengkapin juga player two (jangan lupa @FXML + nyambungin ke FXML-nya)
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Initializing");

        // Initialize Player
        player = new GamePlay[numOfPlayer];
        for (int i = 0; i < numOfPlayer; i++) {
            try {
                player[i] = new GamePlay();
                player[i].buildDeck();
                player[i].setCardView(cardName, cardDescription, cardAttribute, cardImage, cardElement);
                player[i].setStatusText(statusText);
                player[i].setSelectedCard(selectedCard);
                player[i].setButtonChangePosition(changePosition);
            } catch (IOException ex) {
                Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        /* Link player with controller */
        player[0].getPlayer().setHealthText(playerOneHP);
        player[1].getPlayer().setHealthText(playerTwoHP);
        
        player[0].getPlayer().setDeckText(playerOneDeck);
        player[1].getPlayer().setDeckText(playerTwoDeck);
        
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
        drawPhase.setUnderline(true);
        
        player[0].addFromDeck();
        for (int i = 0; i < numOfPlayer; i++) {
            player[i].updateCards();
        }
    }
}

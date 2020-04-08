/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.gui;

import com.avatarduel.cards.CharacterCards;
import com.avatarduel.cards.LandCards;
import com.avatarduel.cards.SkillCards;
import com.avatarduel.gameplay.GamePlay;
import com.avatarduel.model.Card;
import com.avatarduel.model.Character;
import com.avatarduel.model.Element;
import com.avatarduel.model.Land;
import com.avatarduel.model.Skill;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
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
    
    private GamePlay[] player;
    
    private Card selectedCard;
    
    @FXML
    
    /* Declaration Controllers of Card Loader */
    private Text cardDescription;
    private Text cardAttribute;
    private ImageView cardImage;
    private ImageView cardElement;
    
    /* Declaration for GamePhase */
    private Text drawPhase;
    private Text main1Phase;
    private Text battlePhase;
    private Text main2Phase;
    private Text endPhase;
    
    /* Methods for Phases */
    private void flipPhase(Text phase) {
        phase.setUnderline(!phase.isUnderline());
    }
    
    /* Declaration for Status Gameplay */
    private Text statusGame;
    
    /* Methods for Status Gameplay */
    private void setStatusGame(String status) {
        System.out.println("Status Game");
        statusGame.setText(status);
    }
    
    /* Declaration for Button End Turn */
    private Button endTurn;
    
    /* Method for Button End Turn */
    private void handleEndTurn() {
        System.out.println("Button End Turn");
    }
    
    /* Declaration Controllers and Methods for Player One */
    private Text playerOneHP;
    
    private Text cardInHandPlayerOne_1;
    private Text cardInHandPlayerOne_2;
    private Text cardInHandPlayerOne_3;
    private Text cardInHandPlayerOne_4;
    private Text cardInHandPlayerOne_5;
    private Text cardInHandPlayerOne_6;
    private Text cardInHandPlayerOne_7;
    private Text cardInHandPlayerOne_8;
    private Text cardInHandPlayerOne_9;
    private Text cardInHandPlayerOne_10;
    
    private void handleHoverCardInHandPlayerOne_1() {
        
    }
    private void handleClickCardInHandPlayerOne_1() {
        
    }
    /* jobdesc 1 - isi dengan
    *  private Text CardInHandPlayerOne_X (X-nya dari 2 ampe 10)
    *  private void handleHoverCard
    */
    
    private Text cardAttackFieldPlayerOne_1;
    private Text cardAttackFieldPlayerOne_2;
    private Text cardAttackFieldPlayerOne_3;
    private Text cardAttackFieldPlayerOne_4;
    private Text cardAttackFieldPlayerOne_5;
    private Text cardAttackFieldPlayerOne_6;
    private Text cardAttackFieldPlayerOne_7;
    private Text cardAttackFieldPlayerOne_8;


    /* jobdesc 2 - isi dengan
    *  private Text CardAttackFieldPlayerOne_X (X-nya dari 2 ampe 8)
    */
    
    private Text cardStatusFieldPlayerOne_1;
    private Text cardStatusFieldPlayerOne_2;
    private Text cardStatusFieldPlayerOne_3;
    private Text cardStatusFieldPlayerOne_4;
    private Text cardStatusFieldPlayerOne_5;
    private Text cardStatusFieldPlayerOne_6;
    private Text cardStatusFieldPlayerOne_7;
    private Text cardStatusFieldPlayerOne_8;

    /* jobdesc 3 - Isi dengan
    *  private Text CardStatusFieldPlayerOne_X (X-nya dari 2 ampe 8)
    */
    
    private Text powerElementAirPlayerOne;
    private Text powerElementWaterPlayerOne;
    private Text powerElementFirePlayerOne;
    private Text powerElementEarthPlayerOne;
    /* jobdesc 4 - Isi dengan
    *  private Text powerElement<Water/Fire/Earth>playerOne (isi semua elemen)
    */
    
    /* Declaration Controller for Player Two */
    private Text playerTwoHP;
    private Text cardInHandPlayerTwo_1;
    /* jobdesc 1 - isi dengan
    *  private Text CardInHandPlayerTwo_X (X-nya dari 2 ampe 10)
    */
    
    private Text cardAttackFieldPlayerTwo_1;
    /* jobdesc 2 - isi dengan
    *  private Text CardAttackFieldPlayerTwo_X (X-nya dari 2 ampe 8)
    */
    
    private Text cardStatusFieldPlayerTwo_1;
    /* jobdesc 3 - isi dengan
    *  private Text CardStatusFieldPlayerTwo_X (X-nya dari 2 ampe 8)
    */
    
    private Text powerElementAirPlayerTwo;
    /* jobdesc 4 - isi dengan
    *  private Text powerElement<Water/Fire/Earth>playerTwo (isi semua elemen)
    */
    
    /* Methods Controller for Player One */
    private void setPlayerOneHP(String hp) {
        hp = hp + "/80";
        playerOneHP.setText(hp);
    }
    
    
    /* Methods Controller for Player Two */
    private void setPlayerTwoHP(String hp) {
        hp = hp + "/80";
        playerTwoHP.setText(hp);
    }
    
    /* Method Controller for hover and click */
    private void handleHover() {
        
    }
    
    private void handleClick() {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Initializing");

        selectedCard = new Card();

        player = new GamePlay[numOfPlayer];
        for (int i = 0; i < numOfPlayer; i++) {
            try {
                player[i] = new GamePlay();
                player[i].buildDeck();
            } catch (IOException ex) {
                Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.gui;

import com.avatarduel.model.Card;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Muhammad Hasan - 13518012
 */
public class GUIController implements Initializable {
    
    public Card selectedCard;
    
    /* Declaration Controllers of Card Loader */
    @FXML
    private Text cardDescription;
    private Text cardAttribute;
    private ImageView cardImage;
    private ImageView cardElement;
    
    /* Methods for Card Description */
    private void handleCardDescription() {
        System.out.println("Card Description");
    }
    private void handleCardAttribute() {
        System.out.println("Card Attribute");
    }
    private void handleCardImage() {
        System.out.println("Card Image");
        Image image = new Image(getClass().getResourceAsStream("/com/avatarduel/card/image/character/Aang.png"));
        cardImage.setImage(image);
    }
    private void handleCardElement() {
        System.out.println("Card Element");
    }
    
    /* Declaration for Status Gameplay */
    private Text statusGame;
    
    /* Methods for Status Gameplay */
    private void handleStatusGame() {
        System.out.println("Status Game");
    }
    
    /* Declaration for Button End Turn */
    private Button endTurn;
    
    /* Method for Button End Turn */
    private void handleEndTurn() {
        System.out.println("Button End Turn");
    }
    
    /* Declaration Controller for Player One */
    private Text playerOneHP;
    private Text cardInHandPlayerOne_1;
    
    private Text cardAttackFieldPlayerOne_1;
    
    private Text cardStatusFieldPlayerOne_1;
    
    private Text powerElementAirPlayerOne;
    
    /* Declaration Controller for Player Two */
    private Text playerTwoHP;
    private Text cardInHandPlayerTwo_1;
    
    private Text cardAttackFieldPlayerTwo_1;
    
    private Text cardStatusFieldPlayerTwo_1;
    
    private Text powerElementAirPlayerTwo;
    
    /* Methods Controller for Player One */
    private void handlePlayerOneHP() {
        
    }
    private void handleCardInHandPlayerOne_1() {
        
    }
    
    private void handleCardAttackFieldPlayerOne_1() {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Did I do something here ?");
    }    
    
}

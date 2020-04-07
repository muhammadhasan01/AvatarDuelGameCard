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
    private final String pathElementAir = "/com/avatarduel/images/AirElement.png";
    private final String pathElementWater = "/com/avatarduel/images/WaterElement.png";
    private final String pathElementFire = "/com/avatarduel/images/FireElement.png";
    private final String pathElementEarth = "/com/avatarduel/images/EarthElement.png";
    
    private final int numOfPlayer = 2; 
    private final int undefinedReturnValue = -13518012;
    
    private GamePlay[] player;
    private Card selectedCard;
    
    /* Declaration Controllers of Card Loader */
    @FXML
    private Text cardDescription;
    private Text cardAttribute;
    private ImageView cardImage;
    private ImageView cardElement;
    
    /* Methods for Card Description */
    private void setCardDescription(String desc) {
        System.out.println("Card Description");
        cardDescription.setText(desc);
    }
    
    private void setCardAttribute(int atk, int def, int power) {
        if (atk == undefinedReturnValue) {
            cardAttribute.setText("");
            return;
        }
        System.out.println("Card Attribute");
        String attribute = "ATK : " + String.valueOf(atk);
        attribute += "/DEF : " + String.valueOf(def);
        attribute += "/POW : " + String.valueOf(power);
        cardAttribute.setText(attribute);
    }
    
    private void setCardImage(String pathImage) {
        System.out.println("Card Image");
        Image image = new Image(getClass().getResourceAsStream(pathImage));
        cardImage.setImage(image);
    }
    
    private void setCardElement(Element element) {
        System.out.println("Card Element");
        Image image = null;
        switch (element) {
            case AIR:
                image = new Image(getClass().getResourceAsStream(pathElementAir));
                break;
            case WATER:
                image = new Image(getClass().getResourceAsStream(pathElementWater));
                break;
            case EARTH:
                image = new Image(getClass().getResourceAsStream(pathElementEarth));
                break;
            case FIRE:
                image = new Image(getClass().getResourceAsStream(pathElementFire));
                break;
            default:
                break;
        }
        cardElement.setImage(image);
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
    private void setPlayerOneHP(String hp) {
        hp = hp + "/80";
        playerOneHP.setText(hp);
    }
    
    /* Methods Controller for Player Two */
    private void setPlayerTwoHP(String hp) {
        hp = hp + "/80";
        playerTwoHP.setText(hp);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            System.out.println("Initializing");
            
            selectedCard = new Card();
            
            LandCards landCards = new LandCards();
            CharacterCards characterCards = new CharacterCards();
            SkillCards skillCards = new SkillCards();
            
            characterCards.loadCards();
            landCards.loadCards();
            skillCards.loadCards();
            
            List<Character> CC = characterCards.getListCharacter();
            List<Land> LL = landCards.getListLand();
            List<Skill> SS = skillCards.getListSkill();
            
            player = new GamePlay[numOfPlayer];
            for (int i = 0; i < numOfPlayer; i++) {
                player[i] = new GamePlay();
                player[i].buildDeck(CC, SS, LL);
            }
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

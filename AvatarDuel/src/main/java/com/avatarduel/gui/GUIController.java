/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Muhammad Hasan - 13518012
 */
public class GUIController implements Initializable {

    @FXML
    private Button button;
    
    @FXML
    private TextField description;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @FXML
    private ImageView cardImage;
    
    @FXML
    private void handleImage() {
        System.out.println("Image has been changed");
        Image image = new Image(getClass().getResourceAsStream("/com/avatarduel/card/image/character/Aang.png"));
        cardImage.setImage(image);
    }
    
    @FXML
    private Text cardDescription;
    
    @FXML
    private void handleCardDescription() {
        System.out.println("ya gmn ya");
    }
    
    @FXML
    private Text txt;
    
    @FXML
    private void handleText() {
        System.out.println("Text has been hovered");
        // System.out.println(txt);
    }
    
    @FXML
    private Image imageCard;
    
    @FXML
    private void getDescriptionImage() {
       // System.out.println("Description ?");
       description.setText("This description has changed!");
    }  
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

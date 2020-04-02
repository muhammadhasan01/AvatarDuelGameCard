/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
        button.setText("You clicked Me!");
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

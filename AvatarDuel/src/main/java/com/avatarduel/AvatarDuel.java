package com.avatarduel;

import com.avatarduel.cards.CharacterCards;
import com.avatarduel.cards.LandCards;
import com.avatarduel.cards.SkillCards;
import com.avatarduel.model.Character;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class AvatarDuel extends Application {
  
  public LandCards landCards = new LandCards();
  public CharacterCards characterCards = new CharacterCards();
  public SkillCards skillCards = new SkillCards();

  @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/GUI.fxml"));
        
    Scene scene = new Scene(root);
    
    characterCards.loadCards();
    landCards.loadCards();
    skillCards.loadCards();

    stage.setTitle("Avatar Duel");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
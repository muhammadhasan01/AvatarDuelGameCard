package com.avatarduel;

import com.avatarduel.cards.CharacterCards;
import com.avatarduel.cards.LandCards;
import com.avatarduel.cards.SkillCards;
import com.avatarduel.model.Card;
import com.avatarduel.model.Character;
import com.avatarduel.model.Land;
import com.avatarduel.model.Skill;
import com.avatarduel.player.Player;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class AvatarDuel extends Application {
    
  private final int numberOfPlayers = 2;
  
  public Player[] players = new Player[numberOfPlayers]; 
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
    
    List<Character> CC = characterCards.getListCharacter();
    List<Land> LL = landCards.getListLand();
    List<Skill> SS = skillCards.getListSkill();
    
    Card x = CC.get(0);
    System.out.println(x.getAttack());
    
    for (int i = 0; i < numberOfPlayers; i++) {
        players[i] = new Player();
        players[i].buildDeck(CC, SS, LL);
    }

    stage.setTitle("Avatar Duel");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
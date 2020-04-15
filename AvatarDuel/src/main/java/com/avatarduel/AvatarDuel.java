package com.avatarduel;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class AvatarDuel extends Application {
  

  @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/GUIAvatarDuel.fxml"));
        
    Scene scene = new Scene(root);

    stage.setTitle("Avatar Duel");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
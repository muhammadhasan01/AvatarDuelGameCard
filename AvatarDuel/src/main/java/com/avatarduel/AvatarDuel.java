package com.avatarduel;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/** Main Class to Launch Avatar Duel
 * 
 * @author Muhammad Hasan - 13518012
 */
public class AvatarDuel extends Application {
  

    /** Method to start loading GUI and set scene
     * 
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
      Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/GUIAvatarDuel.fxml"));

      Scene scene = new Scene(root);

      stage.setTitle("Avatar Duel");
      stage.setScene(scene);
      stage.show();
    }

    /** Main Method to launch application
     * 
     * @param args 
     */
    public static void main(String[] args) {
      launch();
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.gui;

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
    
    private int curPhase = -1;
    private int curPlayer = 0;
    
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
    @FXML
    private Button changePosition;
    
    /* Methods for Phases */
    private void flipPhase(Text phase) {
        phase.setUnderline(!phase.isUnderline());
    }
    
    @FXML
    private void handleButton(ActionEvent event) {
        if (curPhase == -1) {
            curPhase = 0;
            startGame();
            return;
        }
        flipPhase(phases.get(curPhase));
        curPhase = (curPhase + 1) % 5;
        flipPhase(phases.get(curPhase));
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

    @FXML
    private Text cardInHandPlayerOne_2;
    @FXML
    private void handleHoverCardInHandPlayerOne_2() {
        player[curPlayer].handleHover(player[curPlayer].getCardHandAt(2));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_2() {
        player[curPlayer].handleClickHand(2, curPhase);
    }

    @FXML
    private Text cardInHandPlayerOne_3;
    @FXML
    private void handleHoverCardInHandPlayerOne_3() {
        player[curPlayer].handleHover(player[curPlayer].getCardHandAt(3));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_3() {
        player[curPlayer].handleClickHand(3, curPhase);
    }

    @FXML
    private Text cardInHandPlayerOne_4;
    @FXML
    private void handleHoverCardInHandPlayerOne_4() {
        player[curPlayer].handleHover(player[curPlayer].getCardHandAt(4));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_4() {
        player[curPlayer].handleClickHand(4, curPhase);
    }

    @FXML
    private Text cardInHandPlayerOne_5;
    @FXML
    private void handleHoverCardInHandPlayerOne_5() {
        player[curPlayer].handleHover(player[curPlayer].getCardHandAt(5));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_5() {
        player[curPlayer].handleClickHand(5, curPhase);
    }

    @FXML
    private Text cardInHandPlayerOne_6;
    @FXML
    private void handleHoverCardInHandPlayerOne_6() {
        player[curPlayer].handleHover(player[curPlayer].getCardHandAt(6));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_6() {
        player[curPlayer].handleClickHand(6, curPhase);
    }

    @FXML
    private Text cardInHandPlayerOne_7;
    @FXML
    private void handleHoverCardInHandPlayerOne_7() {
        player[curPlayer].handleHover(player[curPlayer].getCardHandAt(7));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_7() {
        player[curPlayer].handleClickHand(7, curPhase);
    }

    @FXML
    private Text cardInHandPlayerOne_8;
    @FXML
    private void handleHoverCardInHandPlayerOne_8() {
        player[curPlayer].handleHover(player[curPlayer].getCardHandAt(8));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_8() {
        player[curPlayer].handleClickHand(8, curPhase);
    }

    @FXML
    private Text cardInHandPlayerOne_9;
    @FXML
    private void handleHoverCardInHandPlayerOne_9() {
        player[curPlayer].handleHover(player[curPlayer].getCardHandAt(9));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_9() {
        player[curPlayer].handleClickHand(9, curPhase);
    }

    @FXML
    private Text cardInHandPlayerOne_10;
    @FXML
    private void handleHoverCardInHandPlayerOne_10() {
        player[curPlayer].handleHover(player[curPlayer].getCardHandAt(10));
    }
    @FXML
    private void handleClickCardInHandPlayerOne_10() {
        player[curPlayer].handleClickHand(10, curPhase);
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
    
    @FXML
    private Text cardInBattleFieldPlayerOne_2;
    @FXML
    private void handleHoverCardInBattleFieldPlayerOne_2() {
        player[curPlayer].handleHover(player[curPlayer].getCardBattleFieldAt(2));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerOne_2() {
        player[curPlayer].handleClickBattleField(2, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerOne_3;
    @FXML
    private void handleHoverCardInBattleFieldPlayerOne_3() {
        player[curPlayer].handleHover(player[curPlayer].getCardBattleFieldAt(3));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerOne_3() {
        player[curPlayer].handleClickBattleField(3, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerOne_4;
    @FXML
    private void handleHoverCardInBattleFieldPlayerOne_4() {
        player[curPlayer].handleHover(player[curPlayer].getCardBattleFieldAt(4));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerOne_4() {
        player[curPlayer].handleClickBattleField(4, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerOne_5;
    @FXML
    private void handleHoverCardInBattleFieldPlayerOne_5() {
        player[curPlayer].handleHover(player[curPlayer].getCardBattleFieldAt(5));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerOne_5() {
        player[curPlayer].handleClickBattleField(5, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerOne_6;
    @FXML
    private void handleHoverCardInBattleFieldPlayerOne_6() {
        player[curPlayer].handleHover(player[curPlayer].getCardBattleFieldAt(6));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerOne_6() {
        player[curPlayer].handleClickBattleField(6, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerOne_7;
    @FXML
    private void handleHoverCardInBattleFieldPlayerOne_7() {
        player[curPlayer].handleHover(player[curPlayer].getCardBattleFieldAt(7));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerOne_7() {
        player[curPlayer].handleClickBattleField(7, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerOne_8;
    @FXML
    private void handleHoverCardInBattleFieldPlayerOne_8() {
        player[curPlayer].handleHover(player[curPlayer].getCardBattleFieldAt(8));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerOne_8() {
        player[curPlayer].handleClickBattleField(8, curPhase);
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
    @FXML
    private Text cardInStatusFieldPlayerOne_2;
    @FXML
    private void handleHoverCardInSkillFieldPlayerOne_2() {
        player[curPlayer].handleHover(player[curPlayer].getCardSkillFieldAt(2));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerOne_2() {
        player[curPlayer].handleClickSkillField(2, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerOne_3;
    @FXML
    private void handleHoverCardInSkillFieldPlayerOne_3() {
        player[curPlayer].handleHover(player[curPlayer].getCardSkillFieldAt(3));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerOne_3() {
        player[curPlayer].handleClickSkillField(3, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerOne_4;
    @FXML
    private void handleHoverCardInSkillFieldPlayerOne_4() {
        player[curPlayer].handleHover(player[curPlayer].getCardSkillFieldAt(4));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerOne_4() {
        player[curPlayer].handleClickSkillField(4, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerOne_5;
    @FXML
    private void handleHoverCardInSkillFieldPlayerOne_5() {
        player[curPlayer].handleHover(player[curPlayer].getCardSkillFieldAt(5));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerOne_5() {
        player[curPlayer].handleClickSkillField(5, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerOne_6;
    @FXML
    private void handleHoverCardInSkillFieldPlayerOne_6() {
        player[curPlayer].handleHover(player[curPlayer].getCardSkillFieldAt(6));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerOne_6() {
        player[curPlayer].handleClickSkillField(6, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerOne_7;
    @FXML
    private void handleHoverCardInSkillFieldPlayerOne_7() {
        player[curPlayer].handleHover(player[curPlayer].getCardSkillFieldAt(7));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerOne_7() {
        player[curPlayer].handleClickSkillField(1, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerOne_8;
    @FXML
    private void handleHoverCardInSkillFieldPlayerOne_8() {
        player[curPlayer].handleHover(player[curPlayer].getCardSkillFieldAt(8));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerOne_8() {
        player[curPlayer].handleClickSkillField(8, curPhase);
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
    @FXML
    private void handleHoverCardInHandPlayerTwo_1() {
        player[curPlayer].handleHover(player[curPlayer].getCardHandAt(1));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_1() {
        player[curPlayer].handleClickHand(1, curPhase);
    }

    @FXML
    private Text cardInHandPlayerTwo_2;
    @FXML
    private void handleHoverCardInHandPlayerTwo_2() {
        player[curPlayer].handleHover(player[curPlayer].getCardHandAt(2));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_2() {
        player[curPlayer].handleClickHand(2, curPhase);
    }

    @FXML
    private Text cardInHandPlayerTwo_3;
    @FXML
    private void handleHoverCardInHandPlayerTwo_3() {
        player[curPlayer].handleHover(player[curPlayer].getCardHandAt(3));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_3() {
        player[curPlayer].handleClickHand(3, curPhase);
    }

    @FXML
    private Text cardInHandPlayerTwo_4;
    @FXML
    private void handleHoverCardInHandPlayerTwo_4() {
        player[curPlayer].handleHover(player[curPlayer].getCardHandAt(4));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_4() {
        player[curPlayer].handleClickHand(4, curPhase);
    }

    @FXML
    private Text cardInHandPlayerTwo_5;
    @FXML
    private void handleHoverCardInHandPlayerTwo_5() {
        player[curPlayer].handleHover(player[curPlayer].getCardHandAt(5));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_5() {
        player[curPlayer].handleClickHand(5, curPhase);
    }

    @FXML
    private Text cardInHandPlayerTwo_6;
    @FXML
    private void handleHoverCardInHandPlayerTwo_6() {
        player[curPlayer].handleHover(player[curPlayer].getCardHandAt(6));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_6() {
        player[curPlayer].handleClickHand(6, curPhase);
    }

    @FXML
    private Text cardInHandPlayerTwo_7;
    @FXML
    private void handleHoverCardInHandPlayerTwo_7() {
        player[curPlayer].handleHover(player[curPlayer].getCardHandAt(7));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_7() {
        player[curPlayer].handleClickHand(7, curPhase);
    }

    @FXML
    private Text cardInHandPlayerTwo_8;
    @FXML
    private void handleHoverCardInHandPlayerTwo_8() {
        player[curPlayer].handleHover(player[curPlayer].getCardHandAt(8));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_8() {
        player[curPlayer].handleClickHand(8, curPhase);
    }

    @FXML
    private Text cardInHandPlayerTwo_9;
    @FXML
    private void handleHoverCardInHandPlayerTwo_9() {
        player[curPlayer].handleHover(player[curPlayer].getCardHandAt(9));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_9() {
        player[curPlayer].handleClickHand(9, curPhase);
    }

    @FXML
    private Text cardInHandPlayerTwo_10;
    @FXML
    private void handleHoverCardInHandPlayerTwo_10() {
        player[curPlayer].handleHover(player[curPlayer].getCardHandAt(10));
    }
    @FXML
    private void handleClickCardInHandPlayerTwo_10() {
        player[curPlayer].handleClickHand(10, curPhase);
    }
    // jobdesc 1 - lengkapin juga player two (jangan lupa @FXML + nyambungin ke FXML-nya)
    
    @FXML
    private Text cardInBattleFieldPlayerTwo_1;
        @FXML
    private void handleHoverCardInBattleFieldPlayerTwo_1() {
        player[curPlayer].handleHover(player[curPlayer].getCardBattleFieldAt(1));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerTwo_1() {
        player[curPlayer].handleClickBattleField(1, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerTwo_2;
    @FXML
    private void handleHoverCardInBattleFieldPlayerTwo_2() {
        player[curPlayer].handleHover(player[curPlayer].getCardBattleFieldAt(2));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerTwo_2() {
        player[curPlayer].handleClickBattleField(2, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerTwo_3;
    @FXML
    private void handleHoverCardInBattleFieldPlayerTwo_3() {
        player[curPlayer].handleHover(player[curPlayer].getCardBattleFieldAt(3));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerTwo_3() {
        player[curPlayer].handleClickBattleField(3, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerTwo_4;
    @FXML
    private void handleHoverCardInBattleFieldPlayerTwo_4() {
        player[curPlayer].handleHover(player[curPlayer].getCardBattleFieldAt(4));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerTwo_4() {
        player[curPlayer].handleClickBattleField(4, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerTwo_5;
    @FXML
    private void handleHoverCardInBattleFieldPlayerTwo_5() {
        player[curPlayer].handleHover(player[curPlayer].getCardBattleFieldAt(5));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerTwo_5() {
        player[curPlayer].handleClickBattleField(5, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerTwo_6;
    @FXML
    private void handleHoverCardInBattleFieldPlayerTwo_6() {
        player[curPlayer].handleHover(player[curPlayer].getCardBattleFieldAt(6));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerTwo_6() {
        player[curPlayer].handleClickBattleField(6, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerTwo_7;
    @FXML
    private void handleHoverCardInBattleFieldPlayerTwo_7() {
        player[curPlayer].handleHover(player[curPlayer].getCardBattleFieldAt(7));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerTwo_7() {
        player[curPlayer].handleClickBattleField(7, curPhase);
    }
    
    @FXML
    private Text cardInBattleFieldPlayerTwo_8;
    @FXML
    private void handleHoverCardInBattleFieldPlayerTwo_8() {
        player[curPlayer].handleHover(player[curPlayer].getCardBattleFieldAt(8));
    }
    @FXML
    private void handleClickCardInBattleFieldPlayerTwo_8() {
        player[curPlayer].handleClickBattleField(8, curPhase);
    }
    // jobdesc 2 - lengkapin juga player two (jangan lupa @FXML + nyambungin ke FXML-nya)
    
    @FXML
    private Text cardInStatusFieldPlayerTwo_1;
    @FXML
    private void handleHoverCardInSkillFieldPlayerTwo_1() {
        player[curPlayer].handleHover(player[curPlayer].getCardSkillFieldAt(1));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerTwo_1() {
        player[curPlayer].handleClickSkillField(1, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerTwo_2;
    @FXML
    private void handleHoverCardInSkillFieldPlayerTwo_2() {
        player[curPlayer].handleHover(player[curPlayer].getCardSkillFieldAt(2));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerTwo_2() {
        player[curPlayer].handleClickSkillField(2, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerTwo_3;
    @FXML
    private void handleHoverCardInSkillFieldPlayerTwo_3() {
        player[curPlayer].handleHover(player[curPlayer].getCardSkillFieldAt(3));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerTwo_3() {
        player[curPlayer].handleClickSkillField(3, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerTwo_4;
    @FXML
    private void handleHoverCardInSkillFieldPlayerTwo_4() {
        player[curPlayer].handleHover(player[curPlayer].getCardSkillFieldAt(4));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerTwo_4() {
        player[curPlayer].handleClickSkillField(4, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerTwo_5;
    @FXML
    private void handleHoverCardInSkillFieldPlayerTwo_5() {
        player[curPlayer].handleHover(player[curPlayer].getCardSkillFieldAt(5));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerTwo_5() {
        player[curPlayer].handleClickSkillField(5, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerTwo_6;
    @FXML
    private void handleHoverCardInSkillFieldPlayerTwo_6() {
        player[curPlayer].handleHover(player[curPlayer].getCardSkillFieldAt(6));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerTwo_6() {
        player[curPlayer].handleClickSkillField(6, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerTwo_7;
    @FXML
    private void handleHoverCardInSkillFieldPlayerTwo_7() {
        player[curPlayer].handleHover(player[curPlayer].getCardSkillFieldAt(7));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerTwo_7() {
        player[curPlayer].handleClickSkillField(1, curPhase);
    }
    @FXML
    private Text cardInStatusFieldPlayerTwo_8;
    @FXML
    private void handleHoverCardInSkillFieldPlayerTwo_8() {
        player[curPlayer].handleHover(player[curPlayer].getCardSkillFieldAt(8));
    }
    @FXML
    private void handleClickCardInSkillFieldPlayerTwo_8() {
        player[curPlayer].handleClickSkillField(8, curPhase);
    }
    
    // jobdesc 3 - lengkapin juga player two (jangan lupa @FXML + nyambungin ke FXML-nya)
    
    @FXML
    private Text powerElementAirPlayerTwo;
    // jobdesc 4 - lengkapin juga player two (jangan lupa @FXML + nyambungin ke FXML-nya)
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Initializing");

        player = new GamePlay[numOfPlayer];
        for (int i = 0; i < numOfPlayer; i++) {
            try {
                player[i] = new GamePlay();
                player[i].buildDeck();
                player[i].setCardView(cardName, cardDescription, cardAttribute, cardImage, cardElement);
                player[i].setStatusText(statusText);
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
    }
}

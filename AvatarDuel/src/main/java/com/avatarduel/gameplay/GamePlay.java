/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.gameplay;

import com.avatarduel.gameboard.CardInBattleField;
import com.avatarduel.gameboard.CardInHand;
import com.avatarduel.gameboard.CardInSkillField;
import com.avatarduel.model.Card;
import com.avatarduel.model.Land;
import com.avatarduel.model.Skill;
import com.avatarduel.model.Character;
import com.avatarduel.player.Player;
import java.util.List;

/**
 *
 * @author Muhammad Hasan - 13518012
 */
public class GamePlay {
    private Player player;
    private CardInHand cardInHand;
    private CardInBattleField cardInBattleField;
    private CardInSkillField cardInSkillField;
    
    public GamePlay() {
        player = new Player();
        this.cardInHand = new CardInHand();
        this.cardInBattleField = new CardInBattleField();
        this.cardInSkillField = new CardInSkillField();
    }
    
    public CardInHand getCardInHand() {
        return this.cardInHand;
    }
    
    public CardInBattleField getCardInBattleField() {
        return this.cardInBattleField;
    }
    
    public CardInSkillField getCardInSkillField() {
        return this.cardInSkillField;
    }
    
    public void buildDeck(List<Character> CC, List<Skill> SS, List<Land> LL) {
        this.player.buildDeck(CC, SS, LL);
    }
    
    public void addFromDeck() {
        List<Card> deckPlayer = this.player.getDeck();
        if (deckPlayer.size() > 0) {
            this.cardInHand.addCardInHand(deckPlayer.remove(0));
        }
    }
}

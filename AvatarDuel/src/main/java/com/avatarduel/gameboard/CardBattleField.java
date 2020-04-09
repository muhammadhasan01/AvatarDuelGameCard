/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.gameboard;

import com.avatarduel.model.Card;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.text.Text;

/**
 *
 * @author Muhammad Hasan - 13518012
 */
public class CardBattleField extends CardBoard {
    private boolean isAttacking;
    private boolean isAttacked;
    private boolean isDead;
    private List<CardSkillField> cardAttached;
    
    public CardBattleField() {
        super();
        this.isAttacking = true;
        this.isAttacked = false;
        this.isDead = false;
        this.cardAttached = new ArrayList<>();
    }
    
    public CardBattleField(Card card, boolean isOccupied, boolean canHover, Text text, boolean isAttacking, boolean isAttacked, boolean isDead) {
        super(card, isOccupied, canHover, text);
        this.isAttacking = isAttacking;
        this.isAttacked = isAttacked;
        this.isDead = isDead;
    }
    
    public boolean getIsAttacking() {
        return this.isAttacking;
    }
    
    public boolean getIsAttacked() {
        return this.isAttacked;
    }
    
    public boolean getIsDead() {
        return this.isDead;
    }
    
    public List<CardSkillField> getCardAttached() {
        return this.cardAttached;
    }
    
    public void flipIsAttacking() {
        this.isAttacking = !(this.isAttacking);
    }
    
    public void flipIsAttacked() {
        this.isAttacked = !(this.isAttacked);
    }
    
    public void flipIsDead() {
        this.isDead = !(this.isDead);
    }
    
    public void resetCardBattleField() {
        super.resetCardBoard();
        this.isAttacking = true;
        this.isAttacked = false;
        this.isDead = false;
    }
    
    public void addCardAttached(CardSkillField CC) {
        Card card = this.getCard();
        Card skill = this.getCard();
        card.setAttack(card.getAttack() + skill.getAttack());
        card.setDefend(card.getDefend() + skill.getDefend());
        card.setPower(card.getPower() + skill.getPower());
        this.cardAttached.add(CC);
    }
}

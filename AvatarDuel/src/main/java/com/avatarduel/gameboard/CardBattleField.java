/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.gameboard;

import com.avatarduel.model.Card;

/**
 *
 * @author Muhammad Hasan
 */
public class CardBattleField extends CardBoard {
    private boolean isAttacking;
    private boolean isAttacked;
    private boolean isDead;
    
    public CardBattleField() {
        super();
        this.isAttacking = true;
        this.isAttacked = false;
        this.isDead = false;
    }
    
    CardBattleField(Card card, boolean isOccupied, boolean canHover, boolean isAttacking, boolean isAttacked, boolean isDead) {
        super(card, isOccupied, canHover);
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
}

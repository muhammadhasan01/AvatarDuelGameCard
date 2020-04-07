/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.model;

/**
 *
 * @author Muhammad Hasan - 13518012
 */
public class Character extends Card {
    private int Attack;
    private int Defend;
    private int Power;
    
    public Character() {
        super();
        this.Attack = this.Defend = this.Power = 0;
    }

    public Character(String name, String description, String imagePath, Element element, int atk, int def, int pow) {
        super(name, description, imagePath, element);
        this.Attack = atk;
        this.Defend = def;
        this.Power = pow;
    }
    
    @Override
    public int getAttack() {
        return this.Attack;
    }
    
    @Override
    public int getDefend() {
        return this.Defend;
    }
    
    @Override
    public int getPower() {
        return this.Power;
    }
    
    @Override
    public void setAttack(int atk) {
        this.Attack = atk;
    }
    
    @Override
    public void setDefend(int def) {
        this.Defend = def;
    }
    
    @Override
    public void setPower(int pow) {
        this.Power = pow;
    }
}

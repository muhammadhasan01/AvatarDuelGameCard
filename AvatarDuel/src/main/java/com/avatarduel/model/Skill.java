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
public class Skill extends Card {
    private int Attack;
    private int Defend;
    private int Power;
    
    public Skill() {
        super();
        this.Attack = this.Defend = this.Power = 0;
    }

    /**
     *
     * @param name
     * @param description
     * @param imagePath
     * @param element
     * @param atk
     * @param def
     * @param pow
     */
    public Skill(String name, String description, String imagePath, Element element, int atk, int def, int pow) {
        super(name, description, imagePath, element);
        this.Attack = atk;
        this.Defend = def;
        this.Power = pow;
    }
    
    public int getAttack() {
        return this.Attack;
    }
    
    public int getDefend() {
        return this.Defend;
    }
    
    public int getPower() {
        return this.Power;
    }
    
    public void setAttack(int atk) {
        this.Attack = atk;
    }
    
    public void setDeffend(int def) {
        this.Defend = def;
    }
    
    public void setPower(int pow) {
        this.Power = pow;
    }    
}
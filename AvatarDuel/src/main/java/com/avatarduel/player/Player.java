/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.player;

import com.avatarduel.model.Card;
import com.avatarduel.model.Land;
import com.avatarduel.model.Character;
import com.avatarduel.model.Skill;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Muhammad Hasan - 13518012
 */
public class Player {
    private final int healthMax = 80;
    private final int deckMax = 60;
    
    private int health;
    private int powerAir;
    private int powerWater;
    private int powerFire;
    private int powerEarth;
    private boolean turn;
    private List<Card> deck;
    
    public Player() {
        this.health = healthMax;
        this.powerAir = this.powerEarth = this.powerFire = this.powerEarth = 0;
        this.turn = false;
        this.deck = new ArrayList<>();
    }
    
    public Player(int h, int a, int w, int f, int e, boolean t) {
        this.health = h;
        this.powerAir = a;
        this.powerWater = w;
        this.powerFire = f;
        this.powerEarth = e;
        this.turn = t;
        this.deck = new ArrayList<>();
    }

    /**
     * build deck with character : skill : land = 2 : 1 : 2
     * @param CC
     * @param SS
     * @param LL
     */
    public void buildDeck(List<Character> CC, List<Skill> SS, List<Land> LL) {
        Random rand = new Random();
        for (int i = 0; i < 2 * (deckMax / 5); i++) {
            addCard(CC.get(rand.nextInt(CC.size())));
        }
        for (int i = 0; i < (deckMax / 5); i++) {
            addCard(SS.get(rand.nextInt(SS.size())));
        }
        for (int i = 0; i < 2 * (deckMax / 5); i++) {
            addCard(LL.get(rand.nextInt(LL.size())));
        }
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public int getPowerAir() {
        return this.powerAir;
    }
    
    public int getPowerWater() {
        return this.powerWater;
    }
    
    public int getPowerFire() {
        return this.powerFire;
    }
    
    public int getPowerEarth() {
        return this.powerEarth;
    }
    
    public boolean getTurn() {
        return this.turn;
    }
    
    public List<Card> getDeck() {
        return this.deck;
    }
    
    public void setHealth(int h) {
        this.health = h;
    }
    
    public void setPowerAir(int a) {
        this.powerAir = a;
    }
    
    public void setPowerWater(int w) {
        this.powerWater = w;
    }
    
    public void setPowerFire(int f) {
        this.powerFire = f;
    }
    
    public void setPowerEarth(int e) {
        this.powerEarth = e;
    }
    
    public void flipTurn() {
        this.turn = !(this.turn);
    }
    
    public void addCard(Card CC) {
        this.deck.add(CC);
    }
}

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
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javafx.scene.text.Text;
import javafx.util.Pair;

/**
 *
 * @author Muhammad Hasan - 13518012
 */
public class Player {
    private final int healthMax = 80;
    private final int deckMax = 60;
    
    private int health;
    private Text healthText;
    private Pair<Integer, Integer> powerAir;
    private Pair<Integer, Integer> powerWater;
    private Pair<Integer, Integer> powerFire;
    private Pair<Integer, Integer> powerEarth;
    private boolean turn;
    private List<Card> deck;
    private Text deckText;
    
    public Player() {
        this.health = healthMax;
        healthText = new Text();
        this.powerAir = this.powerEarth = this.powerFire = this.powerEarth = new Pair<Integer, Integer>(0, 0);
        this.turn = false;
        this.deck = new ArrayList<>();
        this.deckText = new Text();
    }
    
    public Player(int h, Pair<Integer, Integer> a, Pair<Integer, Integer> w, Pair<Integer, Integer> f, Pair<Integer, Integer> e, boolean t) {
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
            addCard(new Character(CC.get(rand.nextInt(CC.size()))));
        }
        for (int i = 0; i < (deckMax / 5); i++) {
            addCard(new Skill(SS.get(rand.nextInt(SS.size()))));
        }
        for (int i = 0; i < 2 * (deckMax / 5); i++) {
            addCard(new Land(LL.get(rand.nextInt(LL.size()))));
        }
        Collections.shuffle(this.deck);
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public Pair<Integer, Integer> getPowerAir() {
        return this.powerAir;
    }
    
    public Pair<Integer, Integer> getPowerWater() {
        return this.powerWater;
    }
    
    public Pair<Integer, Integer> getPowerFire() {
        return this.powerFire;
    }
    
    public Pair<Integer, Integer> getPowerEarth() {
        return this.powerEarth;
    }
    
    public Text getDeckText() {
        return this.deckText;
    }
    
    public boolean getTurn() {
        return this.turn;
    }
    
    public List<Card> getDeck() {
        return this.deck;
    }
    
    public Text getHealthText() {
        return this.healthText;
    }
    
    public void setHealth(int h) {
        this.health = h;
    }
    
    public void setPowerAir(Pair<Integer, Integer> a) {
        this.powerAir = a;
    }
    
    public void setPowerWater(Pair<Integer, Integer> w) {
        this.powerWater = w;
    }
    
    public void setPowerFire(Pair<Integer, Integer> f) {
        this.powerFire = f;
    }
    
    public void setPowerEarth(Pair<Integer, Integer> e) {
        this.powerEarth = e;
    }
    
    public void flipTurn() {
        this.turn = !(this.turn);
    }
    
    public void addCard(Card CC) {
        this.deck.add(CC);
    }
    
    public void setHealthText(Text text) {
        this.healthText = text;
    } 
    
    public void setHealthTextTo(String text) {
        this.healthText.setText(text);
    }
    
    public void setDeckText(Text text) {
        this.deckText = text;
    }
    
    public void setDeckTextTo(int num) {
        this.deckText.setText(String.valueOf(num) + "/60");
    }
}

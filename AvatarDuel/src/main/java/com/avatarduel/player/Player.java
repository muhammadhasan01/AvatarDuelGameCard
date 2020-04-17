/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.player;

import com.avatarduel.model.Card;
import com.avatarduel.model.Land;
import com.avatarduel.model.Character;
import com.avatarduel.model.Element;
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
    private Pair<Integer, Integer> powerEnergy;
    private List<Card> deck;
    private Text deckText;
    
    public Player() {
        this.health = healthMax;
        healthText = new Text();
        this.powerAir = this.powerEarth = this.powerFire = this.powerWater = this.powerEnergy = new Pair<>(0, 0);
        this.deck = new ArrayList<>();
        this.deckText = new Text();
    }

    /**
     * build deck with character : skill : land = 2 : 1 : 2
     * @param CC List of Card Character
     * @param SS List of Card Skill
     * @param LL List of Card Land
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
    
    public Pair<Integer, Integer> getPower(Element element) {
        Pair<Integer, Integer> ret = null;
        switch (element) {
                case AIR:
                    ret = this.powerAir;
                    break;
                case WATER:
                    ret = this.powerWater;
                    break;
                case FIRE:
                    ret = this.powerFire;
                    break;
                case EARTH:
                    ret = this.powerEarth;
                    break;
                case ENERGY:    
                    ret = this.powerEnergy;
                default:
                    break;
        }
        return ret;
    }
    
    public Text getDeckText() {
        return this.deckText;
    }
    
    public List<Card> getDeck() {
        return this.deck;
    }
    
    public int getDeckSize() {
        return this.deck.size();
    }
    
    public Text getHealthText() {
        return this.healthText;
    }
    
    public void setHealth(int h) {
        this.health = h;
    }
    
    public void setPower(Element element, Pair<Integer, Integer> p) {
        switch (element) {
                case AIR:
                    this.powerAir = p;
                    break;
                case WATER:
                    this.powerWater = p;
                    break;
                case FIRE:
                    this.powerFire = p;
                    break;
                case EARTH:
                    this.powerEarth = p;
                    break;
                case ENERGY:
                    this.powerEnergy = p;
                default:
                    break;
        }
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

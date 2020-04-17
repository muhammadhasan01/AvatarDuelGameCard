/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.gameplay;

import com.avatarduel.model.Element;
import javafx.scene.text.Text;

/**
 *
 * @author Muhammad Hasan - 13518012
 */
public class GameText {
    private Text statusText;
    private Text powerAir;
    private Text powerWater;
    private Text powerFire;
    private Text powerEarth;
    private Text powerEnergy;
    
    public GameText() {
        this.statusText = new Text();
        this.powerAir = new Text();
        this.powerWater = new Text();
        this.powerFire = new Text();
        this.powerEarth = new Text();
    }
    
    public void setStatusText(Text text) {
        this.statusText = text;
    }
    
    public void setStatusTextTo(String text) {
        this.statusText.setText(text);
    }
    
    public void setPowerText(Text air, Text water, Text fire, Text earth, Text energy) {
        this.powerAir = air;
        this.powerEarth = water;
        this.powerFire = fire;
        this.powerEarth = earth;
        this.powerEnergy = energy;
    }
    
    public void setPowerValue(Element element, int cur, int max) {
        switch (element) {
                case AIR:
                    this.powerAir.setText(String.valueOf(cur) + "/" + String.valueOf(max));
                    break;
                case WATER:
                    this.powerWater.setText(String.valueOf(cur) + "/" + String.valueOf(max));
                    break;
                case FIRE:
                    this.powerFire.setText(String.valueOf(cur) + "/" + String.valueOf(max));
                    break;
                case EARTH:
                    this.powerEarth.setText(String.valueOf(cur) + "/" + String.valueOf(max));
                    break;
                case ENERGY:    
                    this.powerEnergy.setText(String.valueOf(cur) + "/" + String.valueOf(max));
                default:
                    break;
        }
    }
}

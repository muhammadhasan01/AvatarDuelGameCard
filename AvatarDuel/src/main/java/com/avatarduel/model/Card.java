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
public class Card {
    
    private final int undefinedReturnValue = -13518012;
    
    protected String name;
    protected String description;
    protected String imagePath;
    protected Element element;
    
    public Card() {
        this.name = this.description = this.imagePath = "";
        this.element = Element.AIR;
    }
    
    public Card(String name, String desc, String path, Element element) {
        this.name = name;
        this.description = desc;
        this.imagePath = path;
        this.element = element;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public String getImagePath() {
        return this.imagePath;
    }
    
    public Element getElement() {
        return this.element;
    }
    
    public int getAttack() {
        return undefinedReturnValue;
    }
    
    public int getDefend() {
        return undefinedReturnValue;
    }
    
    public int getPower() {
        return undefinedReturnValue;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDescription(String desc) {
        this.description = desc;
    }
    
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    public void setElement(Element element) {
        this.element = element;
    }
    
    public void setAttack(int x) {
        // do nothing
    }
    
    public void setDefend(int x) {
        // do nothing
    }
    
    public void setPower(int x) {
        // do nothing
    }
    
    public void resetCard() {
        this.name = this.description = this.imagePath = "";
        this.element = Element.AIR;
    }
}

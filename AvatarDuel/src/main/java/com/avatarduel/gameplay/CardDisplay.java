/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.gameplay;

import com.avatarduel.model.Card;
import com.avatarduel.model.Element;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 *
 * @author Muhammad Hasan - 13518012
 */
public class CardDisplay {
    private final String pathElementAir = "/com/avatarduel/images/AirElement.png";
    private final String pathElementWater = "/com/avatarduel/images/WaterElement.png";
    private final String pathElementFire = "/com/avatarduel/images/FireElement.png";
    private final String pathElementEarth = "/com/avatarduel/images/EarthElement.png";
    private final String pathElementEnergy = "/com/avatarduel/images/EnergyElement.png";
    
    private final int undefinedReturnValue = -13518012;
    
    Text cardName;
    Text cardDescription;
    Text cardAttribute;
    ImageView cardImage;
    ImageView cardElement;
    
    public CardDisplay() {
        this.cardName = new Text();
        this.cardDescription = new Text();
        this.cardAttribute = new Text();
        this.cardImage = new ImageView();
        this.cardElement = new ImageView();
    }
    
   
    public void setCardDisplay(Text name, Text desc, Text attr, ImageView img, ImageView elm) {
        this.cardName = name;
        this.cardDescription = desc;
        this.cardAttribute = attr;
        this.cardImage = img;
        this.cardElement = elm;    
    }
    
    public void setCardViewToCard(Card CC) {
        this.setCardName(CC.getName());
        this.setCardDescription(CC.getDescription());
        
        this.setCardAttribute(CC.getAttack(), CC.getDefend(), CC.getPower());
        this.setCardImage(CC.getImagePath());
        this.setCardElement(CC.getElement());
    }
    
    private void setCardName(String name) {
        cardName.setText(name);
    }
    
    private void setCardDescription(String desc) {
        cardDescription.setText(desc);
    }
    
    private void setCardAttribute(int atk, int def, int power) {
        if (atk == undefinedReturnValue) {
            cardAttribute.setText("");
            return;
        }
        String attribute = "ATK : " + String.valueOf(atk);
        attribute += "\tDEF : " + String.valueOf(def);
        attribute += "\tPOW : " + String.valueOf(power);
        cardAttribute.setText(attribute);
    }
    
    private void setCardImage(String pathImage) {
        if (pathImage.charAt(pathImage.length() - 1) == '"')
            pathImage = pathImage.substring(0, pathImage.length() - 1);
        Image image = new Image(getClass().getResourceAsStream(pathImage));
        cardImage.setImage(image);
    }
    
    private void setCardElement(Element element) {
        Image image = null;
        switch (element) {
            case AIR:
                image = new Image(getClass().getResourceAsStream(pathElementAir));
                break;
            case WATER:
                image = new Image(getClass().getResourceAsStream(pathElementWater));
                break;
            case EARTH:
                image = new Image(getClass().getResourceAsStream(pathElementEarth));
                break;
            case FIRE:
                image = new Image(getClass().getResourceAsStream(pathElementFire));
                break;
            case ENERGY:
                image = new Image(getClass().getResourceAsStream(pathElementEnergy));
                break;
            default:
                break;
        }
        cardElement.setImage(image);
    }
}

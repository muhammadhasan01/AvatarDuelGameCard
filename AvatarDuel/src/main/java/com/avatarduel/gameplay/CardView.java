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
public class CardView {
    private final String pathElementAir = "/com/avatarduel/images/AirElement.png";
    private final String pathElementWater = "/com/avatarduel/images/WaterElement.png";
    private final String pathElementFire = "/com/avatarduel/images/FireElement.png";
    private final String pathElementEarth = "/com/avatarduel/images/EarthElement.png";
    
    private final int undefinedReturnValue = -13518012;
    
    Text cardDescription;
    Text cardAttribute;
    ImageView cardImage;
    ImageView cardElement;
    
    public CardView() {
        this.cardDescription = new Text();
        this.cardAttribute = new Text();
        this.cardImage = new ImageView();
        this.cardElement = new ImageView();
    }
    
    public CardView(Text desc, Text attr, ImageView img, ImageView elm) {
        this.cardDescription = desc;
        this.cardAttribute = attr;
        this.cardImage = img;
        this.cardElement = elm;    
    }
    
    public void setCardViewToCard(Card CC) {
        this.setCardDescription(CC.getDescription());
        this.setCardAttribute(CC.getAttack(), CC.getDefend(), CC.getPower());
        this.setCardImage(CC.getImagePath());
    }
    
    private void setCardDescription(String desc) {
        System.out.println("Card Description");
        cardDescription.setText(desc);
    }
    
    private void setCardAttribute(int atk, int def, int power) {
        if (atk == undefinedReturnValue) {
            cardAttribute.setText("");
            return;
        }
        System.out.println("Card Attribute");
        String attribute = "ATK : " + String.valueOf(atk);
        attribute += "/DEF : " + String.valueOf(def);
        attribute += "/POW : " + String.valueOf(power);
        cardAttribute.setText(attribute);
    }
    
    private void setCardImage(String pathImage) {
        System.out.println("Card Image");
        Image image = new Image(getClass().getResourceAsStream(pathImage));
        cardImage.setImage(image);
    }
    
    private void setCardElement(Element element) {
        System.out.println("Card Element");
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
            default:
                break;
        }
        cardElement.setImage(image);
    }
}

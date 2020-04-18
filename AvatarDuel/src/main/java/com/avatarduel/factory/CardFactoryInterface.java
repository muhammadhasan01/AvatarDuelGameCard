/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.factory;

import com.avatarduel.model.Card;
import com.avatarduel.model.Element;
import com.avatarduel.model.Land;
import com.avatarduel.model.Skill;
import com.avatarduel.model.Character;

/**
 *
 * @author Muhammad Hasan - 13518012
 */
public interface CardFactoryInterface {
/**
     * 
     * @param name
     * @param desc
     * @param path Path for image file
     * @param element
     * @return Create a new instance of card
     */
    public Card makeCard(String name, String desc, String path, Element element);
    
    /**
     * 
     * @param name
     * @param desc
     * @param path Path for image file
     * @param element
     * @return Create a new instance of land
     */
    public Land makeLand(String name, String desc, String path, Element element);
    
    /**
     * 
     * @param name
     * @param desc
     * @param path Path for image file
     * @param element
     * @param atk
     * @param def
     * @param pow
     * @return Create a new instance of Character
     */
    public Character makeCharacter(String name, String desc, String path, Element element, int atk, int def, int pow);
    
    /**
     * 
     * @param name
     * @param desc
     * @param path Path for image file
     * @param element
     * @param atk
     * @param def
     * @param pow
     * @return Create a new instance of skill
     */
    public Skill makeSkill(String name, String desc, String path, Element element, int atk, int def, int pow);
}

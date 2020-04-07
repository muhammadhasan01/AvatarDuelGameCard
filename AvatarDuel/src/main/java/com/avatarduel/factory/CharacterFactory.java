/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.factory;

import com.avatarduel.model.Card;
import com.avatarduel.model.Element;
import com.avatarduel.model.Character;

/**
 *
 * @author Muhammad Hasan - 13518012
 */
public class CharacterFactory implements CardFactory {
    @Override
    public Card makeCard(String name, String desc, String path, Element element) {
        return new Card(name, desc, path, element);
    }
    
    public Character makeCard(String name, String desc, String path, Element element, int atk, int def, int pow) {
        return new Character(name, desc, path, element, atk, def, pow);
    }
}

package com.avatarduel.factory;

import com.avatarduel.model.Card;
import com.avatarduel.model.Land;
import com.avatarduel.model.Skill;
import com.avatarduel.model.Element;
import com.avatarduel.model.Character;

/** Factory Class for building cards
 *
 * @author Muhammad Hasan - 13518012
 */
public class CardFactory implements CardFactoryInterface {
    @Override
    public Card makeCard(String name, String desc, String path, Element element) {
        return new Card(name, desc, path, element);
    }
    
    @Override
    public Land makeLand(String name, String desc, String path, Element element) {
        return new Land(name, desc, path, element);
    }
    
    @Override
    public Character makeCharacter(String name, String desc, String path, Element element, int atk, int def, int pow) {
        return new Character(name, desc, path, element, atk, def, pow);
    }
    
    @Override
    public Skill makeSkill(String name, String desc, String path, Element element, int atk, int def, int pow) {
        return new Skill(name, desc, path, element, atk, def, pow);
    }
}

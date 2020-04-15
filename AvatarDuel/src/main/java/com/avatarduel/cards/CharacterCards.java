/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.cards;

import com.avatarduel.factory.CardFactory;
import com.avatarduel.model.Element;
import com.avatarduel.model.Character;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Muhammad Hasan - 13518012
 */
public class CharacterCards extends ListCards {
    
    private static final String CHARACTER_CSV_FILE_PATH = "/com/avatarduel/card/data/character.csv";
   
    public List<Character> characters;
    
    @Override
    public void loadCards() {
        List<String[]> Rows = new ArrayList<>();
        try {
            Rows = loadCSV(CHARACTER_CSV_FILE_PATH);
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(LandCards.class.getName()).log(Level.SEVERE, null, ex);
        }
        characters = new ArrayList<>();
        CardFactory cardFactory = new CardFactory();
        Rows.forEach((row) -> {
            row[7] = row[7].substring(0, row[7].length() - 1);
            Character CC = cardFactory.makeCharacter(row[1], row[3], row[4], Element.valueOf(row[2]),
            Integer.parseInt(row[5]), Integer.parseInt(row[6]), Integer.parseInt(row[7]));
            characters.add(CC);
        });
    }
    /**
     * 
     * @param idx The specified index on where to get the Land from list of Character
     * @return Character at index = idx from list of Character
     * @throws IndexOutOfBoundsException 
     */
    public Character getCharacterAt(int idx) throws IndexOutOfBoundsException {
        if (idx < 0 || idx >= characters.size())
            throw new IndexOutOfBoundsException("Index out of bound on list of characters");
        return characters.get(idx);
    }
    
    public List<Character> getListCharacter() {
        return characters;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.cards;

import com.avatarduel.factory.CharacterFactory;
import com.avatarduel.model.Element;
import com.avatarduel.model.Character;
import com.avatarduel.util.CSVReader;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Muhammad Hasan - 13518012
 */
public class CharacterCards {
    
    private static final String CHARACTER_CSV_FILE_PATH = "/com/avatarduel/card/data/character.csv";
   
    public List<Character> characters;
    
    public void loadCards() throws IOException, URISyntaxException {
        characters = new ArrayList<>();
        File CSVFile = new File(getClass().getResource(CHARACTER_CSV_FILE_PATH).toURI());
        CSVReader Reader = new CSVReader(CSVFile, "\t");
        Reader.setSkipHeader(true);
        List<String[]> Rows = Reader.read();
        CharacterFactory characterFactory = new CharacterFactory();
        Rows.forEach((row) -> {
            row[7] = row[7].substring(0, row[7].length() - 1);
            Character CC = characterFactory.makeCard(row[1], row[3], row[4], Element.valueOf(row[2]),
            Integer.parseInt(row[5]), Integer.parseInt(row[6]), Integer.parseInt(row[7]));
            characters.add(CC);
        });
    }
    
    public Character getCharacterAt(int idx) throws IOException {
        if (idx < 0 || idx > characters.size()) throw new IOException("Index out of bound");
        return characters.get(idx);
    }
    
    public List<Character> getListCharacter() {
        return characters;
    }
}

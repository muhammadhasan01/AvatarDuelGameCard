/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.cards;

import com.avatarduel.factory.CardFactory;
import com.avatarduel.model.Element;
import com.avatarduel.model.Land;
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
public class LandCards extends ListCards {
    
    private static final String LAND_CSV_FILE_PATH = "/com/avatarduel/card/data/land.csv";
    
    public List<Land> lands;
    
    @Override
    public void loadCards() {
        List<String[]> Rows = new ArrayList<>();
        try {
            Rows = loadCSV(LAND_CSV_FILE_PATH);
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(LandCards.class.getName()).log(Level.SEVERE, null, ex);
        }
        lands = new ArrayList<>();
        CardFactory cardFactory = new CardFactory();
        Rows.forEach((row) -> {
            Land CC = cardFactory.makeLand(row[1], row[3], row[4], Element.valueOf(row[2]));
            lands.add(CC);
        });
    }
    
    /**
     * 
     * @param idx The specified index on where to get the Land from list of Land
     * @return Land at index = idx from list of Lands
     * @throws IndexOutOfBoundsException
     */
    public Land getLandAt(int idx) throws IndexOutOfBoundsException {
        if (idx < 0 || idx >= lands.size())
            throw new IndexOutOfBoundsException("Index out of bound in list of lands");
        return lands.get(idx);
    }
    
    public List<Land> getListLand() {
        return lands;
    }
}

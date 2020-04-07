/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.cards;

import com.avatarduel.factory.LandFactory;
import com.avatarduel.model.Element;
import com.avatarduel.model.Land;
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
public class LandCards {
    
    private static final String LAND_CSV_FILE_PATH = "/com/avatarduel/card/data/land.csv";
    
    public List<Land> lands;
    
    public void loadCards() throws IOException, URISyntaxException {
        lands = new ArrayList<>();
        File CSVFile = new File(getClass().getResource(LAND_CSV_FILE_PATH).toURI());
        CSVReader Reader = new CSVReader(CSVFile, "\t");
        Reader.setSkipHeader(true);
        List<String[]> Rows = Reader.read();
        LandFactory landFactory;
        landFactory = new LandFactory();
        Rows.forEach((row) -> {
            Land CC = landFactory.makeCard(row[1], row[3], row[4], Element.valueOf(row[2]));
            lands.add(CC);
        });
    }
    
    public Land getLandAt(int idx) throws IOException {
        if (idx < 0 || idx > lands.size()) throw new IOException("Index out of bound");
        return lands.get(idx);
    }
    
    public List<Land> getListLand() {
        return lands;
    }
}

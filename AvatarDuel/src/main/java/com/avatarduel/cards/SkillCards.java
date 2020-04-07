/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.cards;

import com.avatarduel.factory.SkillFactory;
import com.avatarduel.model.Element;
import com.avatarduel.model.Skill;
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
public class SkillCards {
    
    private static final String SKILL_CSV_FILE_PATH = "/com/avatarduel/card/data/skill_aura.csv";
    
    public List<Skill> skills;
    
    public void loadCards() throws IOException, URISyntaxException {
        skills = new ArrayList<>();
        File CSVFile = new File(getClass().getResource(SKILL_CSV_FILE_PATH).toURI());
        CSVReader Reader = new CSVReader(CSVFile, "\t");
        Reader.setSkipHeader(true);
        List<String[]> Rows = Reader.read();
        SkillFactory landFactory;
        landFactory = new SkillFactory();
        Rows.forEach((String[] row) -> {
            row[7] = row[7].substring(0, row[7].length() - 1);
            Skill CC = landFactory.makeCard(row[1], row[3], row[4], Element.valueOf(row[2]),
                    Integer.parseInt(row[5]), Integer.parseInt(row[6]), Integer.parseInt(row[7]));
            skills.add(CC);
        });
    }
    
    public Skill getSkillAt(int idx) throws IOException {
        if (idx < 0 || idx > skills.size()) throw new IOException("Index out of bound");
        return skills.get(idx);
    }
    
    public List<Skill> getListSkill() {
        return skills;
    }
}

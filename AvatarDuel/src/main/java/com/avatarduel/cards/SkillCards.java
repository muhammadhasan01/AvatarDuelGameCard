package com.avatarduel.cards;

import com.avatarduel.factory.CardFactory;
import com.avatarduel.model.Element;
import com.avatarduel.model.Skill;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Class to build cards of skill
 *
 * @author Muhammad Hasan - 13518012
 */
public class SkillCards extends ListCards {
    
    private static final String SKILL_CSV_FILE_PATH = "/com/avatarduel/card/data/skill_aura.csv";
    
    public List<Skill> skills;
    
    @Override
    public void loadCards() {
        List<String[]> Rows = new ArrayList<>();
        try {
            Rows = loadCSV(SKILL_CSV_FILE_PATH);
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(LandCards.class.getName()).log(Level.SEVERE, null, ex);
        }
        skills = new ArrayList<>();
        CardFactory cardFactory = new CardFactory();
        Rows.forEach((row) -> {
            row[7] = row[7].substring(0, row[7].length() - 1);
            Skill CC = cardFactory.makeSkill(row[1], row[3], row[4], Element.valueOf(row[2]),
                    Integer.parseInt(row[6]), Integer.parseInt(row[7]), Integer.parseInt(row[5]));
            skills.add(CC);
        });
    }
    
     /**
     * 
     * @param idx The specified index on where to get the Skill from list of Skill
     * @return Skill at index = idx from list of Skills
     * @throws IndexOutOfBoundsException
     */
    public Skill getSkillAt(int idx) throws IndexOutOfBoundsException {
        if (idx < 0 || idx >= skills.size()) throw new IndexOutOfBoundsException("Index out of bound");
        return skills.get(idx);
    }
    
    public List<Skill> getListSkill() {
        return skills;
    }
}

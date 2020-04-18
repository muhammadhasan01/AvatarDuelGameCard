package com.avatarduel.gameboard;

import com.avatarduel.model.Card;
import java.util.ArrayList;
import java.util.List;

/** Class to handle card in Battle Field 
 * 
 * @author Muhammad Hasan - 13518012
 */
public class CardBattleField extends CardBoard {
    private boolean isAttacking;
    private boolean isAttacked;
    private List<CardSkillField> cardAttached;
    private int turnWhenSummon;
    
    public CardBattleField() {
        super();
        this.isAttacking = true;
        this.isAttacked = false;
        this.cardAttached = new ArrayList<>();
        this.turnWhenSummon = 0;
    }
    
    public boolean getIsAttacking() {
        return this.isAttacking;
    }
    
    public boolean getIsAttacked() {
        return this.isAttacked;
    }
    
    public List<CardSkillField> getCardAttached() {
        return this.cardAttached;
    }
    
    public int getTurnWhenSummon() {
        return this.turnWhenSummon;
    }
    
    public void flipIsAttacking() {
        this.isAttacking = !(this.isAttacking);
        if (this.isAttacking) {
            this.setTextTo("CHARACTER (ATTACK)");
        } else {
            this.setTextTo("CHARACTER (DEFENSE)");
        }
    }
    
    public void flipIsAttacked() {
        this.isAttacked = !(this.isAttacked);
    }
    
    public void resetIsAttacked() {
        this.isAttacked = false;
    }
    
    public void setTurnWhenSummon(int turn) {
        this.turnWhenSummon = turn;
    }
    
    public void resetCardBattleField() {
        super.resetCardBoard();
        this.isAttacking = true;
        this.isAttacked = false;
    }
    
    /** Adds a skill card to attach to this card battle field
     * 
     * @param CC Card that will be attached 
     */
    public void addCardAttached(CardSkillField CC) {
        Card card = this.getCard();
        Card skill = CC.getCard();
        int currentAttack = card.getAttack();
        int currentDefend = card.getDefend();
        int skillAttack = skill.getAttack();
        int skillDefend = skill.getDefend();
        card.setAttack(currentAttack + skillAttack);
        card.setDefend(currentDefend + skillDefend);
        this.cardAttached.add(CC);
    }
    
    /** Remove a specific card that is attached to this card battle field
     * 
     * @param CC Card that will be removed from attachment
     */
    public void removeCardAttached(CardSkillField CC) {
        for (int i = 0; i < this.cardAttached.size(); i++) {
            if (this.cardAttached.get(i) == CC) {
                Card card = this.getCard();
                Card skill = CC.getCard();
                int currentAttack = card.getAttack();
                int currentDefend = card.getDefend();
                int skillAttack = skill.getAttack();
                int skillDefend = skill.getDefend();
                card.setAttack(currentAttack - skillAttack);
                card.setDefend(currentDefend - skillDefend);
                this.cardAttached.remove(i);
                break;
            }
        }
    }
    
    /**
     * Method to reset card battle field and destroy every card skill that is attached to it
     */
    public void setToDead() {
        this.resetCardBattleField();
        for (CardSkillField CC : this.cardAttached) {
            CC.resetCardSkillField();
        }
    }
}

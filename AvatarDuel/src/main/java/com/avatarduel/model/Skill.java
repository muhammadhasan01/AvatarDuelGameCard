package com.avatarduel.model;

/** Class to handle card skill
 *
 * @author Muhammad Hasan - 13518012
 */
public class Skill extends Card {
    private int Attack;
    private int Defend;
    private int Power;
    
    public Skill() {
        super();
        this.Attack = this.Defend = this.Power = 0;
    }
    
    public Skill(Skill SS) {
        super(SS);
        this.Attack = SS.getAttack();
        this.Defend = SS.getDefend();
        this.Power = SS.getPower();
    }

    public Skill(String name, String description, String imagePath, Element element, int atk, int def, int pow) {
        super(name, description, imagePath, element);
        this.Attack = atk;
        this.Defend = def;
        this.Power = pow;
    }
    
    @Override
    public int getAttack() {
        return this.Attack;
    }
    
    @Override
    public int getDefend() {
        return this.Defend;
    }
    
    @Override
    public int getPower() {
        return this.Power;
    }
    
    public void setAttack(int atk) {
        this.Attack = atk;
    }
    
    /**
     *
     * @param def
     */
    public void setDefend(int def) {
        this.Defend = def;
    }
    
    public void setPower(int pow) {
        this.Power = pow;
    }    
}

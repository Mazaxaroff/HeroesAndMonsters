package org.heroesAndMonsters.models;

public class Player extends Creature {
    private int countOfHills;
    private final int maxHealth;

    public Player() {
        this.countOfHills = 4;
        this.maxHealth = this.getHealth();
    }

    public void hillUp() {
        if (this.countOfHills > 0) {
            this.setHealth(this.getHealth() + (int) (this.maxHealth * 0.3));
        }
    }


}

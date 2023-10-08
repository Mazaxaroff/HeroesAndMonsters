package org.heroesAndMonsters.models;

import lombok.Getter;
import lombok.Setter;
import org.heroesAndMonsters.services.InputService;

@Getter
@Setter
public class Player extends Creature {
    private int countOfHills;
    private final int maxHealth;

    public Player() {
        InputService inputService = new InputService();
        this.setName(inputService.inputName());
        this.setAttack(inputService.inputAttack());
        this.setDefense(inputService.inputDefense());
        this.setHealth(inputService.inputHealth());
        this.setDamageMin(inputService.inputMinDamage());
        this.setDamageMax(inputService.inputMaxDamage(this.getDamageMin()));
        this.setAlive(true);
        this.setCountOfHills(4);
        this.maxHealth = this.getHealth();
    }

    public void hillUp() {
        if (this.countOfHills > 0) {
            this.setHealth(this.getHealth() + (int) (this.maxHealth * 0.3));
            countOfHills--;
        }
    }


}

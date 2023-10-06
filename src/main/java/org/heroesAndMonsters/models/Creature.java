package org.heroesAndMonsters.models;

import lombok.Data;
import org.heroesAndMonsters.gameplay.Dialog;
import org.heroesAndMonsters.services.RandomNumberService;


@Data
public class Creature {
    private String name;
    private int attack;
    private int defense;
    private int health;
    private int damageMin;
    private int damageMax;
    private boolean isAlive;
    RandomNumberService randomNumberService = new RandomNumberService();
    Dialog dialog = new Dialog();

    public Creature() {
    }

    public void hit(Creature creature) {
        int cubeMin = 1;
        int cubeMax = 6;
        int attackModifier = attack - (creature.getDefense() + 1);
        int cubeFace;
        do {
            cubeFace = randomNumberService.get(cubeMin, cubeMax);
            attackModifier--;
            if (cubeFace >= 5) {
                int damage = randomNumberService.get(damageMin, damageMax);
                creature.setHealth(creature.getHealth() - damage);
                dialog.hit(name, creature.getName(), damage, creature.getHealth());
                if (creature.getHealth() <= 0) {
                    creature.die();
                }
                break;
            }
        } while (attackModifier > 0);
    }

    public void die() {
        this.setAlive(false);
    }
}

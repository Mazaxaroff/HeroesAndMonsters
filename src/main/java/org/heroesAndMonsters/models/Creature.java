package org.heroesAndMonsters.models;

import lombok.Data;
import org.heroesAndMonsters.services.InputService;

import java.util.Random;

@Data
public class Creature {
    private String name;
    private int attack;
    private int defense;
    private int health;
    private int damageMin;
    private int damageMax;
    private boolean isAlive;

    public Creature() {
        InputService inputService = new InputService();
        this.setName(inputService.inputName());
        this.setAttack(inputService.inputAttack());
        this.setDefense(inputService.inputDefense());
        this.setHealth(inputService.inputHealth());
        this.setDamageMin(inputService.inputMinDamage());
        this.setDamageMax(inputService.inputMaxDamage(this.getDamageMin()));
        this.isAlive = true;
    }

    public void getInfo() {
        System.out.printf("Имя - %s, атака - %d, защита - %d, здоровье - %d, минимальный урон - %d, " +
                "максимальный урон - %d \n", this.name, this.attack, this.defense, this.health, this.damageMin, this.damageMax);
    }

    public void hit(Creature creature) {
        Random random = new Random();
        int attackModifier = this.attack - (creature.defense + 1);
        int cubeFace;
        do {
            cubeFace = random.nextInt(1, 6);
            if (cubeFace >= 5) {
                creature.setHealth(creature.health - random.nextInt(this.damageMin, this.damageMax));
                if (creature.health <= 0) {
                    creature.die();
                }
                attackModifier--;
            }
        } while (attackModifier > 0);
    }

    public void die() {
        this.setAlive(false);
    }
}

package org.heroesAndMonsters.gameplay;

import org.heroesAndMonsters.models.Creature;
import org.heroesAndMonsters.models.Monster;
import org.heroesAndMonsters.models.Player;
import org.heroesAndMonsters.services.InputService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    Player player;
    List<Monster> bestiary = new ArrayList<>();

    Map<String, Integer> graveyard = new HashMap<>();

    Dialog dialog = new Dialog();
    InputService inputService = new InputService();

    public void start() {
        System.out.println(dialog.LETS_START);
        prepare();
        while (!bestiary.isEmpty() && player.isAlive()) {
            battle(selectFromBestiary());
        }
        if (player.isAlive()) {
            dialog.resultOfTheGame(graveyard);
        }
    }

    private void prepare() {
        player = new Player();
        dialog.heroIsReady(player);
        for (int i = 0; i < player.getAttack(); i++) {
            bestiary.add(new Monster());
        }
    }

    private void battle(Monster monster) {
        dialog.monsterIsComing(monster);
        dialog.battleBegin(player.getName(), monster.getName());

        while (player.isAlive() && monster.isAlive()) {
            player.hit(monster);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (monster.isAlive()) {
                monster.hit(player);
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (player.getHealth() < player.getMaxHealth() / 2 && player.isAlive() && player.getCountOfHills() > 0) {
                dialog.youNeedToHillUp();
                if (inputService.yesOrNot()) {
                    player.hillUp();
                    dialog.successfulHillUp(player.getHealth(), player.getCountOfHills());
                }
            }
        }
        if (!monster.isAlive() || !player.isAlive()) {
            dialog.resultOfTheBattle(player, monster);
            if (!monster.isAlive()) {
                goToGrave(monster);
                bestiary.remove(monster);
            } else if (!player.isAlive()) {
                dialog.resultOfTheGame(graveyard);
            }
        }
    }

    private Monster selectFromBestiary() {
        return bestiary.get(0);
    }

    private void goToGrave(Creature creature) {
        if (graveyard.containsKey(creature.getName())) {
            graveyard.put(creature.getName(), graveyard.get(creature.getName()) + 1);
        } else graveyard.put(creature.getName(), 1);
    }


}

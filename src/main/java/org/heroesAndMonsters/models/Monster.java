package org.heroesAndMonsters.models;

public class Monster extends Creature {
    private final String[] NAMES = {"Гоблин", "Утопец", "Зомби", "Вампир", "Призрак", "Оборотень", "Мумия", "Гидра",
            "Дракон", "Голем", "Демон"};
    private final int BOTTOM = 0;
    private final int MAX_ATTACK_OR_DEFENSE = 30;
    private final int MIN_HEALTH = 10;
    private final int MAX_HEALTH = 300;
    private final int MIN_DAMAGE = 1;
    private final int MAX_DAMAGE = 30;

    public Monster() {
        this.setName(NAMES[randomNumberService.get(0, NAMES.length - 1)]);
        this.setAttack(randomNumberService.get(BOTTOM, MAX_ATTACK_OR_DEFENSE));
        this.setDefense(randomNumberService.get(BOTTOM, MAX_ATTACK_OR_DEFENSE));
        this.setHealth(randomNumberService.get(MIN_HEALTH, MAX_HEALTH));
        this.setDamageMin(randomNumberService.get(MIN_DAMAGE, MAX_DAMAGE));
        this.setDamageMax(randomNumberService.get(this.getDamageMin(), MAX_DAMAGE));
        this.setAlive(true);
    }

}

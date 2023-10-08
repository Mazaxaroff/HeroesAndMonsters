package org.heroesAndMonsters.services;

import java.util.Random;

public class RandomNumberService {
    Random random = new Random();
    public int get(int min, int max) {
        return random.nextInt(min, max + 1);
    }
}

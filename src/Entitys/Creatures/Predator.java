package Entitys.Creatures;

import Entitys.Entity;
import GameMap.*;

import java.util.List;

public class Predator extends Creature {
    private int damage;
    public Predator() {
        switch (stamina) {
            case 2:
                design = "\uD83D\uDC0A";
                damage = 2;
                break;
            case 3:
                design = "\uD83D\uDC3A";
                damage = 4;
                break;
            case 4:
                design = "\uD83D\uDC05";
                damage = 8;
                break;
        }
    }

    @Override
    public void makeMove(GameMap gameMap) {
        Class<? extends Entity> required = Herbivore.class;
        List<Coordinates> path = breadthFirstSearch.breadthFS(gameMap, this, required);
        if (path.isEmpty()) {
            satiety--;
            if (satiety == 0)
                gameMap.getMap().remove(coordinates);
            return;
        }
        if (conditionOfDeath(gameMap, path)) {
            if (path.size() == 1) {
                Coordinates target = path.getLast();
                gameMap.moveEntity(this, target);
                return;
            }
            Coordinates target = path.get(stamina);
            gameMap.moveEntity(this, target);
        } else {
            Coordinates target = path.getLast();
            Herbivore herbivore = (Herbivore) gameMap.getMap().get(target);
            gameMap.moveEntity(this, path.get(path.size() - 2));
            herbivore.setHitPoint(herbivore.getHitPoint() - damage);
            if (herbivore.getHitPoint() <= 0) {
                gameMap.getMap().remove(target);
                satiety = 3;
            }
        }
    }
}

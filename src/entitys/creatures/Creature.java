package entitys.creatures;

import entitys.BreadthFirstSearch;
import entitys.Entity;
import game_map.*;

import java.util.List;
import java.util.Random;

public abstract class Creature extends Entity {
    protected BreadthFirstSearch breadthFirstSearch;
    protected int stamina;
    protected int hitPoint;
    protected int satiety = 3;

    public Creature() {
        breadthFirstSearch = new BreadthFirstSearch();
        stamina = new Random().nextInt(3) + 2;
        switch (stamina) {
            case 2:
                hitPoint = 14;
                break;
            case 3:
                hitPoint = 8;
                break;
            case 4:
                hitPoint = 5;
                break;
        }
    }

    public int getStamina() {
        return stamina;
    }

    protected void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    protected int getHitPoint() {
        return hitPoint;
    }

    public abstract void makeMove(GameMap gameMap);

    protected boolean conditionOfDeath(GameMap gameMap, List<Coordinates> path) {
        if (path.size() - 1 < stamina)
            return false;
        if (gameMap.getMap().get(path.get(stamina)) == null) {
            satiety--;
            if (satiety == 0)
                gameMap.getMap().remove(coordinates);
            return true;
        }
        return false;
    }
}

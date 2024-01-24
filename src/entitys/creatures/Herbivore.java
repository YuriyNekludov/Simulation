package entitys.creatures;

import entitys.Entity;
import entitys.static_objects.Grass;
import game_map.*;

import java.util.List;

public class Herbivore extends Creature {
    public Herbivore() {
        switch (stamina) {
            case 2:
                design = "\uD83D\uDC18";
                break;
            case 3:
                design = "\uD83D\uDC04";
                break;
            case 4:
                design = "\uD83E\uDD93";
                break;
        }
    }

    @Override
    public void makeMove(GameMap gameMap) {
        Class<? extends Entity> required = Grass.class;
        List<Coordinates> path = breadthFirstSearch.breadthFS(gameMap, this, required);
        if (path.isEmpty()) {
            satiety--;
            if (satiety == 0)
                gameMap.getMap().remove(coordinates);
            return;
        }
        if (conditionOfDeath(gameMap, path)) {
            Coordinates target = path.get(stamina);
            gameMap.moveEntity(this, target);
        } else {
            Coordinates target = path.getLast();
            gameMap.moveEntity(this, target);
            satiety = 3;
        }
    }
}

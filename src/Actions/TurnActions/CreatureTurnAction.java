package Actions.TurnActions;

import Entitys.Creatures.Creature;
import Entitys.Creatures.Herbivore;
import Entitys.Creatures.Predator;
import Entitys.Entity;
import GameMap.*;

import java.util.ArrayList;
import java.util.List;

public class CreatureTurnAction extends TurnAction {
    @Override
    public void moveEntities(GameMap gameMap) {
        List<Entity> entities = new ArrayList<>();
        gameMap.getMap().forEach((coordinates, entity) -> {
            if (entity instanceof Creature)
                entities.add(entity);
        });
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) != null)
                ((Creature) entities.get(i)).makeMove(gameMap);
        }
    }

    @Override
    public void refreshEntities(GameMap gameMap) {
        refresh(gameMap, Herbivore.class, CREATURE_COUNT);
        refresh(gameMap, Predator.class, CREATURE_COUNT);
    }
}

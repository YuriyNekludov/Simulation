package actions.turn_actions;

import entitys.creatures.Creature;
import entitys.creatures.Herbivore;
import entitys.creatures.Predator;
import entitys.Entity;
import game_map.*;

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

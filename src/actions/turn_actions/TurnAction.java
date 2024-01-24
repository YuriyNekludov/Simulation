package actions.turn_actions;

import actions.Action;
import entitys.Entity;
import entitys.static_objects.Grass;
import game_map.*;

import java.util.Map;

public abstract class TurnAction extends Action {
    public abstract void moveEntities(GameMap gameMap);

    public abstract void refreshEntities(GameMap gameMap);

    public void refreshGrass(GameMap gameMap) {
        refresh(gameMap, Grass.class, GRASS_COUNT);
    }

    protected void refresh(GameMap gameMap, Class<? extends Entity> entityClass, int maxValue) {
        int count = 0;
        for (Map.Entry<Coordinates, Entity> entry : gameMap.getMap().entrySet()) {
            if (entry.getValue().getClass().equals(entityClass))
                count++;
        }
        if (maxValue > count) {
            int difference = maxValue - count;
            for (int i = 0; i < difference; i++) {
                gameMap.addEntity(entityFactory(entityClass));
            }
        }
    }
}

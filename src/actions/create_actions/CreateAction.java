package actions.create_actions;

import actions.Action;
import entitys.Entity;
import game_map.GameMap;

public abstract class CreateAction extends Action {
    public abstract void createEntities(GameMap gameMap);

    protected void create(GameMap gameMap, Class<? extends Entity> entityClass, int maxValue) {
        for (int i = 0; i < maxValue; i++) {
            gameMap.addEntity(entityFactory(entityClass));
        }
    }
}

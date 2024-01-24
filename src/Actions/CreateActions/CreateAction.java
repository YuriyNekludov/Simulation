package Actions.CreateActions;

import Actions.Action;
import Entitys.Creatures.Herbivore;
import Entitys.Creatures.Predator;
import Entitys.Entity;
import GameMap.GameMap;

public abstract class CreateAction extends Action {
    public abstract void createEntities(GameMap gameMap);

    protected void create(GameMap gameMap, Class<? extends Entity> entityClass, int maxValue) {
        for (int i = 0; i < maxValue; i++) {
            gameMap.addEntity(entityFactory(entityClass));
        }
    }
}

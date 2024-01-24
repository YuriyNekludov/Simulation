package Actions.CreateActions;

import Entitys.StaticObjects.Grass;
import GameMap.GameMap;

public class GrassCreateAction extends CreateAction {
    @Override
    public void createEntities(GameMap gameMap) {
        create(gameMap, Grass.class, GRASS_COUNT);
    }
}

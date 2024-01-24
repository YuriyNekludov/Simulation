package actions.create_actions;

import entitys.static_objects.Grass;
import game_map.GameMap;

public class GrassCreateAction extends CreateAction {
    @Override
    public void createEntities(GameMap gameMap) {
        create(gameMap, Grass.class, GRASS_COUNT);
    }
}

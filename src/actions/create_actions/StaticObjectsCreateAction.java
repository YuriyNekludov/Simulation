package actions.create_actions;

import entitys.static_objects.Rock;
import entitys.static_objects.Tree;
import game_map.GameMap;

public class StaticObjectsCreateAction extends CreateAction {
    @Override
    public void createEntities(GameMap gameMap) {
        create(gameMap, Rock.class, TREE_ROCK_COUNT);
        create(gameMap, Tree.class, TREE_ROCK_COUNT);
    }
}

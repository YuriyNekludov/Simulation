package Actions.CreateActions;

import Entitys.StaticObjects.Rock;
import Entitys.StaticObjects.Tree;
import GameMap.GameMap;

public class StaticObjectsCreateAction extends CreateAction {
    @Override
    public void createEntities(GameMap gameMap) {
        create(gameMap, Rock.class, TREE_ROCK_COUNT);
        create(gameMap, Tree.class, TREE_ROCK_COUNT);
    }
}

package Actions.CreateActions;

import Entitys.Creatures.Herbivore;
import Entitys.Creatures.Predator;
import GameMap.GameMap;

public class CreatureCreateAction extends CreateAction {
    @Override
    public void createEntities(GameMap gameMap) {
       create(gameMap, Herbivore.class, CREATURE_COUNT);
       create(gameMap, Predator.class, CREATURE_COUNT);
    }
}

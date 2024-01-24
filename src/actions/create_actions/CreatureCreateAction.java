package actions.create_actions;

import entitys.creatures.Herbivore;
import entitys.creatures.Predator;
import game_map.GameMap;

public class CreatureCreateAction extends CreateAction {
    @Override
    public void createEntities(GameMap gameMap) {
       create(gameMap, Herbivore.class, CREATURE_COUNT);
       create(gameMap, Predator.class, CREATURE_COUNT);
    }
}

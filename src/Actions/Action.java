package Actions;


import Entitys.Creatures.Herbivore;
import Entitys.Creatures.Predator;
import Entitys.Entity;
import Entitys.StaticObjects.Grass;
import Entitys.StaticObjects.Rock;
import Entitys.StaticObjects.Tree;

public abstract class Action {
    protected static final int CREATURE_COUNT = 12;
    protected static final int GRASS_COUNT = 15;
    protected static final int TREE_ROCK_COUNT = 12;

    protected Entity entityFactory(Class<? extends Entity> entityClass) {
        return switch (entityClass.getSimpleName()) {
            case "Grass" -> new Grass();
            case "Predator" -> new Predator();
            case "Herbivore" -> new Herbivore();
            case "Tree" -> new Tree();
            case "Rock" -> new Rock();
            default -> throw new IllegalStateException("Unexpected value: " + entityClass.getSimpleName());
        };
    }
}

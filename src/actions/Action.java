package actions;


import entitys.creatures.Herbivore;
import entitys.creatures.Predator;
import entitys.Entity;
import entitys.static_objects.Grass;
import entitys.static_objects.Rock;
import entitys.static_objects.Tree;

public abstract class Action {
    protected static final int CREATURE_COUNT = 12;
    protected static final int GRASS_COUNT = 15;
    protected static final int ROCK_COUNT = 12;
    protected static final int TREE_COUNT = 16;

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

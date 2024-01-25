package game_map;

import entitys.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameMap {
    private final int width;
    private final int height;
    private Map<Coordinates, Entity> map;

    public GameMap(int width, int height) {
        map = new HashMap<>();
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Map<Coordinates, Entity> getMap() {
        return map;
    }

    public void addEntity(Entity entity) {
        do {
            setEntityCoordinates(entity);
        } while (map.containsKey(entity.getCoordinates()));
        map.put(entity.getCoordinates(), entity);
    }

    public void moveEntity(Entity entity, Coordinates coordinates) {
        Coordinates temp = entity.getCoordinates();
        entity.setCoordinates(coordinates);
        map.put(coordinates, entity);
        map.remove(temp);
    }

    private void setEntityCoordinates(Entity entity) {
        Random random = new Random();
        Coordinates coordinates = new Coordinates(random.nextInt(width), random.nextInt(height));
        entity.setCoordinates(coordinates);
    }
}

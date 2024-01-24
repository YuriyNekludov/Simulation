package GameMap;

import Entitys.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameMap {
    private final int width;
    private final int height;
    private Map<Coordinates, Entity> map;

    public GameMap() {
        map = new HashMap<>();
        width = 15;
        height = 15;
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
        while (true) {
            setEntityCoordinates(entity);
            if (map.get(entity.getCoordinates()) != null)
                continue;
            map.put(entity.getCoordinates(), entity);
            break;
        }
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

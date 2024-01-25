package entitys;

import entitys.creatures.Creature;
import game_map.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearch {

    public List<Coordinates> breadthFS(GameMap gameMap, Creature searcher, Class<? extends Entity> required) {
        Queue<Coordinates> queue = new LinkedList<>();
        Map<Coordinates, Coordinates> comeFrom = new HashMap<>();
        queue.add(searcher.getCoordinates());
        comeFrom.put(searcher.getCoordinates(), null);
        Coordinates target = null;
        while (!queue.isEmpty()) {
            Coordinates count = queue.poll();
            if (isTarget(gameMap, count, required)) {
                target = count;
                break;
            }
            for (Coordinates next : getNeighbors(count)) {
                if (checkValidCoordinates(gameMap, next, required) && !comeFrom.containsKey(next)) {
                    queue.add(next);
                    comeFrom.put(next, count);
                }
            }
        }
        List<Coordinates> path = new LinkedList<>();
        Coordinates temp = target;
        while(temp != null) {
            path.addFirst(temp);
            temp = comeFrom.get(temp);
        }
            return path;
    }

    private List<Coordinates> getNeighbors(Coordinates coordinates) {
        List<Coordinates> neighbors = new ArrayList<>();
        int x = coordinates.getX(), y = coordinates.getY();
        int[][] temp = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] stepCoordinates : temp) {
            Coordinates step = new Coordinates(x + stepCoordinates[0], y + stepCoordinates[1]);
            neighbors.add(step);
        }
        return neighbors;
    }

    private boolean checkValidCoordinates (GameMap gameMap, Coordinates coordinates, Class<? extends Entity> required) {
        return coordinates.getX() >= 0 && coordinates.getX() <= gameMap.getWidth() &&
                coordinates.getY() >= 0 && coordinates.getY() <= gameMap.getHeight() &&
                (gameMap.getMap().get(coordinates) == null ||
                        gameMap.getMap().get(coordinates).getClass().equals(required));
    }

    private boolean isTarget(GameMap gameMap, Coordinates coordinates, Class<? extends Entity> required) {
        return gameMap.getMap().get(coordinates) != null &&
                gameMap.getMap().get(coordinates).getClass().equals(required);
    }
}

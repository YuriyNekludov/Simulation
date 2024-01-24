package Entitys;

import Entitys.Creatures.Creature;
import GameMap.*;

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
        Map<Coordinates, Integer> stepValue = new HashMap<>();
        queue.add(searcher.getCoordinates());
        comeFrom.put(searcher.getCoordinates(), null);
        stepValue.put(searcher.getCoordinates(), 0);
        Coordinates target = null;
        while (!queue.isEmpty()) {
            Coordinates count = queue.poll();
            if (gameMap.getMap().get(count) != null && gameMap.getMap().get(count).getClass().equals(required)) {
                target = count;
                break;
            }
            for (Coordinates next : getNeighbors(count)) {
                int step = stepValue.get(count) + 1;
                if (checkValidCoordinates(gameMap, next, required) && !comeFrom.containsKey(next)) {
                    queue.add(next);
                    comeFrom.put(next, count);
                    stepValue.put(next, step);
                }
            }
        }
        List<Coordinates> path = new LinkedList<>();
        if (target == null) {
            for (Map.Entry<Coordinates, Integer> entry : stepValue.entrySet()) {
                if (entry.getValue() == searcher.getStamina()) {
                    path.add(entry.getKey());
                    break;
                }
            }
            return path;
        }
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

    private int heuristic(Coordinates start, Coordinates next) {
        return Math.abs(start.getX() - next.getX()) + Math.abs(start.getY() - next.getY());
    }
}

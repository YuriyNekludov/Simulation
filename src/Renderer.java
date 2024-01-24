import GameMap.*;

public class Renderer {
    public void renderGameMap(GameMap gameMap) {
        for (int rows = 0; rows < gameMap.getWidth(); rows++) {
            for (int cols = 0; cols < gameMap.getHeight(); cols++) {
                Coordinates temp = new Coordinates(rows, cols);
                if (gameMap.getMap().get(temp) == null) {
                    System.out.print("__ ");
                    continue;
                }
                System.out.print(gameMap.getMap().get(temp) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

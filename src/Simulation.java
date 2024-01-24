import Actions.CreateActions.CreateAction;
import Actions.CreateActions.CreatureCreateAction;
import Actions.CreateActions.GrassCreateAction;
import Actions.CreateActions.StaticObjectsCreateAction;
import Actions.TurnActions.CreatureTurnAction;
import Actions.TurnActions.TurnAction;
import GameMap.GameMap;

public class Simulation extends Thread {
    private static GameMap gameMap;
    private int turnCount;
    private CreateAction[] initActions;
    private static TurnAction turnAction;
    private static Renderer renderer;
    private static boolean isStarted;

    public Simulation() {
        gameMap = new GameMap();
        initActions = new CreateAction[]{new CreatureCreateAction(),
                new GrassCreateAction(), new StaticObjectsCreateAction()};
        turnAction = new CreatureTurnAction();
        renderer = new Renderer();
        isStarted = false;
    }

    @Override
    public void run() {
        while (isStarted) {
            nextTurn();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public void startSimulation() {
        isStarted = true;
        this.start();
    }

    public void pauseSimulation() {
        isStarted = false;
    }

    public void nextTurn() {
        if (turnCount == 0) {
            for (CreateAction action : initActions) {
                action.createEntities(gameMap);
            }
            renderer.renderGameMap(gameMap);
        }
        if (turnCount % 3 == 0 && turnCount != 0) {
            turnAction.refreshGrass(gameMap);
            renderer.renderGameMap(gameMap);
        }
        if (turnCount % 5 == 0 && turnCount != 0) {
            turnAction.refreshEntities(gameMap);
            renderer.renderGameMap(gameMap);
        }
        turnAction.moveEntities(gameMap);
        renderer.clearConsole();
        renderer.renderGameMap(gameMap);
        turnCount++;
    }
}
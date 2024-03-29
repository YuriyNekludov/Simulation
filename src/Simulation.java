import actions.create_actions.CreateAction;
import actions.create_actions.CreatureCreateAction;
import actions.create_actions.GrassCreateAction;
import actions.create_actions.StaticObjectsCreateAction;
import actions.turn_actions.CreatureTurnAction;
import actions.turn_actions.TurnAction;
import game_map.GameMap;

public class Simulation extends Thread {
    private GameMap gameMap;
    private int turnCount;
    private CreateAction[] initActions;
    private TurnAction turnAction;
    private Renderer renderer;
    private boolean isStarted;

    public Simulation() {
        gameMap = new GameMap(13, 13);
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
                Thread.currentThread().interrupt();
                isStarted = false;
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
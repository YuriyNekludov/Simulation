import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Welcome to Simulation!\nFor exit press eny key.");
        Simulation simulation = new Simulation();
        Scanner scanner = new Scanner(System.in);
        simulation.startSimulation();
        String end = scanner.nextLine();
        if (end != null) {
            simulation.pauseSimulation();
        }
        scanner.close();
    }
}


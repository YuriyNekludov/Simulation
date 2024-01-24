import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("""
                Welcome to
                
                S I M U L A T I O N
                
                For start press any key.
                After if you wanna exit press any key too.
                """);
        Scanner scanner = new Scanner(System.in);
        String start = scanner.nextLine();
        if (start != null) {
            Simulation simulation = new Simulation();
            simulation.startSimulation();
            String end = scanner.nextLine();
            if (end != null) {
                simulation.pauseSimulation();
            }
        }
        scanner.close();
    }
}


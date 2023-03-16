import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            int width = 0, height = 0, generation = 0, speed = 0;
            String population = "";

            ArgumentParser argParser = new ArgumentParser(args);
            Scanner sc = new Scanner(System.in);

             width = argParser.getWidth();
             height = argParser.getHeight();
             generation = argParser.getGeneration();
             speed = argParser.getSpeed();
             population = argParser.getPopulation();

            if (args.length == 0) {
                System.out.println("Wellcome to Game of Life!");
                System.out.println("Type in the width size, the available values are: 10, 20, 40, 80 ");
                System.out.print("Type in your chose: ");
                width = sc.nextInt();

                ClearConsole.clearConsole();
            }

            if (width != 10 && width != 20 && width != 40 && width != 80) {
                System.out.println("The width is out of range!");
                System.exit(0);
            }


            if (args.length == 0) {
                System.out.println("Type in the height size, the available values are: 10, 20, 40 ");
                System.out.print("Type in your chose: ");
                height = sc.nextInt();

                ClearConsole.clearConsole();
            }

            if (height != 10 && height != 20 && height != 40) {
                System.out.println("The height is out of range!");
                System.exit(0);
            }


            if (args.length == 0) {
                System.out.println("Type in the generation size, the available values are: >= 0 (0 for infinito)");
                System.out.print("Type in the max number of generation: ");
                generation = sc.nextInt();

                ClearConsole.clearConsole();
            }

            if (generation < 0) {
                System.out.println("Invalid value for generation!");
                System.exit(0);
            }

            if (args.length == 0) {
                System.out.println("Type in the speed of each generation, the available values are: 250, 1000");
                System.out.print("Type in the speed: ");
                speed = sc.nextInt();

                ClearConsole.clearConsole();
            }

            if (speed < 250 || speed > 1000) {
                System.out.println("Invalid value for speed!");
                System.exit(0);
            }

            if (args.length == 0) {
                System.out.println("Type in the population, the available values are: 1 or 0, it skip lines using # ");
                System.out.print("Type in the population: ");
                population = sc.next();

                ClearConsole.clearConsole();
            }

            if (population.length() > width * height) {
                System.out.println("The population is out of range!");
                System.exit(0);
            }

            int[][] grid = new int[height][width];
            GolGrid golGrid = new GolGrid(width, height, generation, speed, population, grid);

            System.out.println("Generation: 1");
            golGrid.identifyPopulation();
            golGrid.printPopulation();
            System.out.println();

            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted: " + e.getMessage());
            }

            GolRunner golRunner = new GolRunner(golGrid, generation, speed);
            golRunner.run();

        }
}

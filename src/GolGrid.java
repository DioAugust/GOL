public class GolGrid {
    private int width;
    private int height;
    private int generation;
    private int speed;
    private int[][] grid;
    private String population;

    public GolGrid(int width, int height, int generation, int speed, String population, int[][] grid) {
        this.width = width;
        this.height = height;
        this.generation = generation;
        this.speed = speed;
        this.population = population;
        this.grid = grid;
    }

    public int[][] identifyPopulation() {
        String[] sections = population.split("#");
        int row = 0;
        for (String section : sections) {
            int col = 0;
            for (char c : section.toCharArray()) {
                if (c == '1') {
                    grid[row][col] = 1;
                } else {
                    grid[row][col] = 0;
                }
                col++;
            }
            row++;
        }

        return grid;
    }

    public void printPopulation() {
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 1) {
                    System.out.print("\u001B[42m ");
                } else {
                    System.out.print("\u001B[47m ");
                }
            }
            System.out.println("\u001B[0m");
        }
        System.out.println();
    }

    private int countLiveNeighbors(int[][] population, int row, int col) {
        int count = 0;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < population.length && j >= 0 && j < population[0].length && (i != row || j != col)) {
                        count += population[i][j];

                }
            }
        }

        return count;
    }

    public void updatePopulation() {
        int[][] nextGen = new int[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int neighbors = countLiveNeighbors(grid, row, col);

                if (grid[row][col] == 1) {
                    if (neighbors < 2 || neighbors > 3) {
                        nextGen[row][col] = 0;
                    } else {
                        nextGen[row][col] = 1;
                    }
                } else {
                    if (neighbors == 3) {
                        nextGen[row][col] = 1;
                    } else {
                        nextGen[row][col] = 0;
                    }
                }
            }
        }

        grid = nextGen;

        printPopulation();
    }

}
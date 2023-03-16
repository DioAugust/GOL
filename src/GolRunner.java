public class GolRunner {
    private GolGrid golGrid;
    private int generation;
    private int speed;

    public GolRunner(GolGrid golGrid, int generation, int speed) {
        this.golGrid = golGrid;
        this.generation = generation;
        this.speed = speed;
    }

    public void run() {
        int generations = 1;
        boolean isInfinito = false;

        while (generations < generation || isInfinito) {
            System.out.println();
            System.out.println("Generation: " + (generations + 1));
            System.out.println();
            golGrid.updatePopulation();
            System.out.println();

            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            generations++;
        }
    }
}

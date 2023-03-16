public class ArgumentParser {
    private int width;
    private int height;
    private int generation;
    private int speed;
    private String population;

    public ArgumentParser(String[] args) {
        for (String arg : args) {
            String[] parts = arg.split("=");
            if (parts.length == 2) {
                switch (parts[0]) {
                    case "g":
                        generation = Integer.parseInt(parts[1]);
                        break;
                    case "w":
                        width = Integer.parseInt(parts[1]);
                        break;
                    case "h":
                        height = Integer.parseInt(parts[1]);
                        break;
                    case "s":
                        speed = Integer.parseInt(parts[1]);
                        break;
                    case "p":
                        population = parts[1];
                        break;
                    default:
                        System.out.println("Unknown parameter: " + parts[0]);
                        break;
                }
            } else {
                System.out.println("Invalid argument: " + arg);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getGeneration() {
        return generation;
    }

    public int getSpeed() {
        return speed;
    }

    public String getPopulation() {
        return population;
    }
}

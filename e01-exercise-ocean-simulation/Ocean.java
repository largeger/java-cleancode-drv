import java.util.ArrayList;
import java.util.List;

class Ocean {
    private Cell[][] grid;
    private List<Fish> fishes;
    private List<Shark> sharks;
    private List<Rock> rocks;

    public Ocean(int rows, int cols) {
        grid = new Cell[rows][cols];
        fishes = new ArrayList<>();
        sharks = new ArrayList<>();
        rocks = new ArrayList<>();
        initialize();
    }

    public void initialize() {
        // Initialize the grid with empty cells and add initial entities
    }

    public void timeStep() {
        // Update all entities
    }

    public void addPlankton() {
        // Add plankton to the ocean
    }

    public boolean checkEndCondition() {
        // Check if the simulation should end
        return false;
    }
}

class Cell {
    private Entity content;

    public Entity getContent() {
        return content;
    }

    public void setContent(Entity content) {
        this.content = content;
    }
}

abstract class Entity {
}

class Fish extends Entity {
    private int weight;
    private int age;
    private float[] direction_gene = new float[8];

    public void timeStep() {
        move();
        eatPlankton();
        reproduce();
    }

    public void move() {
        // Implement movement logic
    }

    public void eatPlankton() {
        // Implement eating logic
    }

    public void reproduce() {
        // Implement reproduction logic
    }
}

class Shark extends Entity {
    private int weight;
    private int age;

    public void timeStep() {
        move();
        huntFish();
        reproduce();
    }

    public void move() {
        // Implement movement logic
    }

    public void huntFish() {
        // Implement hunting logic
    }

    public void reproduce() {
        // Implement reproduction logic
    }
}

class Plankton extends Entity {
    private int weight;
}

class Rock extends Entity {
}

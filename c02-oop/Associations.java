public class Associations {

    static class Engine {
        private String model;
        
        public Engine(String model) {
            this.model = model;
        }

        public void start() {
            System.out.println("Engine " + model + " started");
        }
    }

    static class Driver {
        private String name;

        public Driver(String name) {
            this.name = name;
        }

        public void drive() {
            System.out.println(name + " is driving");
        }
    }


    static class Car {
        private String brand;
        private Engine engine;  // Composition: Engine cannot exist without a car
        private Driver driver;  // Aggregation: Driver can exist without a car

        public Car(String brand, String engineModel) {
            this.brand = brand;
            this.engine = new Engine(engineModel); // <-- This is where the composition "simulated" happens
        }

        public void setDriver(Driver driver) {
            this.driver = driver;  // <-- This is where the aggregation "simulated" happens
        }

        public void start() {
            System.out.println("Car " + brand + " is starting");
            engine.start();
            if (driver != null) {
                driver.drive();
            }
            
        }
    }

    public static void main(String[] args) {
        Car myCar = new Car("VW", "1.6l Diesel");
        myCar.start();

        Driver johnDoe = new Driver("John Doe");
        myCar.setDriver(johnDoe);

        myCar.start();
    }
    
}

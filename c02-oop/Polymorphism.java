public class Polymorphism {
    // Base Class
    interface Animal {
        // Abstract method to be implemented by derived classes
        void speak();
    }

    // Derived Class Dog
    static class Dog implements Animal {
        @Override
        public void speak() {
            System.out.println("Woof Woof!");
        }
    }

    // Derived Class Cat
    static class Cat implements Animal {
        @Override
        public void speak() {
            System.out.println("Meow!");
        }
    }

    public static void main(String[] args) {

        // Create an array of Animal objects
        Animal[] animals = new Animal[2];
        animals[0] = new Dog();
        animals[1] = new Cat();

        // Iterate through the array and call the speak method
        for (Animal animal : animals) {
            animal.speak();
        }
    }
}
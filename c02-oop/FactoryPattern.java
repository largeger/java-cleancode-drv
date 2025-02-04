public class FactoryPattern {

    static class Point {
        private double x, y;
        
        private Point(double x, double y) {   // Private constructor!!!
            this.x = x;
            this.y = y;
        }

        //Factory method #1
        public static Point fromCartesian(float x, float y) {
            return new Point(x, y);
        }

        //Factory method #2
        public static Point fromPolar(double rho, double theta) {
            return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
        }

        public void display() {
            System.out.println("x: " + x + ", y: " + y);
        }
    }

    public static void main(String[] args) {
        Point p1 = Point.fromCartesian(3, 4);
        Point p2 = Point.fromPolar(5.0, Math.PI / 4.0f);

        p1.display();
        p2.display();
    }
}

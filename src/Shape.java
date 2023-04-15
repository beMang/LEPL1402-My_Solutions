public abstract class Shape {
    public abstract double getArea(double d);
    public abstract double getPerimeter(double d);

    public class Circle extends Shape{

        @Override
        public double getArea(double d) {
            return Math.PI*d*d;
        }

        @Override
        public double getPerimeter(double d) {
            return Math.PI*d*2;
        }
    }

    public class Square extends Shape{

        @Override
        public double getArea(double d) {
            return d*d;
        }

        @Override
        public double getPerimeter(double d) {
            return 4*d;
        }
    }
}


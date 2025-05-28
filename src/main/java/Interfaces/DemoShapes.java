package Interfaces;

import java.awt.*;

interface Shape { 
    double area();
    default double perimeter() { return 0; }   // default impl

    static Shape ofCircle(double r) {          // static factory
        return new Circle(r);
    }

    static Shape factory(int typeOfShape, double param) {      
        if( typeOfShape == 1)// static factory
            return new Circle(param);
        else 
            return new Circle(param);
    }
}

class Circle implements Shape {
    private final double radius;               // instance variable
    Circle(double r) { this.radius = r; }
    public double area() { return Math.PI*radius*radius; }
    public double perimeter() { return 2*Math.PI*radius; }

    /* static nested helper */
    static class Metrics {
        static int circlesMade;                // class variable
    }
}

/* interface nested in a class */
class Printer {
    interface Pretty { void prettyPrint(); }
}

public class DemoShapes {
    public static void main(String[] args) {
        Shape s = Shape.ofCircle(5);
        System.out.println("Area = " + s.area());          // virtual dispatch
        System.out.println("Perim = " + s.perimeter());

        ((Printer.Pretty)() -> System.out.println("Nice circle"))
                .prettyPrint();
        Circle.Metrics.circlesMade++;
    }
}

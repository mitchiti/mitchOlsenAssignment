package org.example;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

class Circle {

    private Point centre;
    private double radius;

    public Circle() {
        Point p = new Point();
        this(p, 1);

    }

    public Circle(Point c1, double r1) {

        center = c1;
        radius = r1;
        //r1 = IntersectionTest.prompt();
    }

    public Point getCentre() {
        return center;
    }

    public double getRadius() {
        //int r1;
        //int r2;

        //IntersectionTest input = new IntersectionTest();
        //input.prompt(r1, r2);
        //r1 = input.prompt(r1);
        return this.radius;
    }

    public double calArea() {
        //double areaSecondCircle;
        //Circle area = new calArea();
        //double r1 = radius;

        IntersectionTest radius = new IntersectionTest(areaFirstCircle, areaSecondCircle);

        double areaFirstCircle = (PI * pow(radius, 2));
        double areaSecondCircle = (PI * pow(radius, 2));
    }
}

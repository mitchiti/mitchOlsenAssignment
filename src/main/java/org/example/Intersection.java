package org.example;

import static java.lang.Math.pow;

class Intersection {
    private Circle circleA;
    private Circle circleB;

    public Intersection() {
        Circle c1 = new Circle();
        this(c1, c1);
    }

    public Intersection(Circle circleA, Circle circleB) {
        this.circleA = circleA;
        this.circleB = circleB;
    }

    public Circle getCircleA() {
        return circleA;
    }

    public Circle getCircleB() {
        return circleB;
    }

    public double calIntersectionArea() {
        double r1 = circleA.getRadius();
        double r2 = circleB.getRadius();

        Point p1 = circleA.getCentre();
        Point p2 = circleB.getCentre();
        double d = p1.calDistance(p2);

        double d1 = ((pow(r1, 2)) - (pow(r2, 2)) + (pow(d, 2)) / 2 * d);
        double d2 = ((pow(r2, 2)) - (pow(r1, 2)) + (pow(d, 2)) / 2 * d);
        return
        double areaOfIntersection = ((Math.pow(r1, 2)) * (1 / Math.cos(d1 / r1)) - (d1 * (Math.sqrt((Math.pow(r1, 2))))) * (Math.pow(d1, 2)) + (Math.pow(r2, 2)) * (1 / Math.cos(d2 / r2)) - (d2 * (Math.sqrt((Math.pow(r2, 2))))) * (Math.pow(d2, 2)));
    }

}

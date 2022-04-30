package org.example;

import java.util.Scanner;

class IntersectionTest {
    private static Intersection intersection;

    public static void main(String[] args) {

        System.out.println("\n*** Intersection Area Calculation ***");

        prompt();

        displayCircleAreas();

        displayIntersectionArea();
    }

    private static void prompt() {
        //creates the Intersection object using the input values

        //IntersectionTest input = new IntersectionTest();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nEnter the Coordinate of the centre point (x, y) and radius of the first circle");
        int x1 = keyboard.nextInt();
        keyboard.nextLine();
        int y1 = keyboard.nextInt();
        keyboard.nextLine();
        int r1 = keyboard.nextInt();

        System.out.println("\nEnter the Coordinate of centre point (x, y) and radius of the second circle");
        int x2 = keyboard.nextInt();
        keyboard.nextLine();
        int y2 = keyboard.nextInt();
        keyboard.nextLine();
        int r2 = keyboard.nextInt();

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);

//        Circle radius = new Circle(r1, r2);
        Circle circle1 = new Circle(p1, r1);
        Circle circle2 = new Circle(p2, r2);
        double area = circle1.calArea();

        intersection = new Intersection(circle1, circle2);

    }


    private static void displayCircleAreas() {
        //double areaFirstCircle;

        //Circle area = new Circle();
        //double areaFirstCircle = area.calArea(r1);
        //double areaSecondCircle = area.calArea(r2);

        Circle circle1 = intersection.getCircleA();
        Circle circle2 = intersection.getCircleB();

        double areaFirstCircle = circle1.calArea();
        double areaSecondCircle = circle2.calArea();

        System.out.printf("/nThe area of the first circle is %.2f", areaFirstCircle);
        System.out.printf("The area of the second circle is %.2f", areaSecondCircle);
    }


    private static void displayIntersectionArea() {
//        double areaOfIntersection = Intersection.calIntersectionArea();

        System.out.printf("The intersection area of the two circle is %.2f", areaOfIntersection);

    }
}

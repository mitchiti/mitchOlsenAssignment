import java.util.Scanner;
import static java.lang.Math.*;

class IntersectionTest
{
    private static Intersection intersection;

    public static void main(String[] args)
    {

        while (true) {
            System.out.println("\n*** Intersection Area Calculation ***");
            System.out.println();

            prompt();

            displayCircleAreas();

            double r1 = intersection.getCircleA().getRadius();
            double r2 = intersection.getCircleB().getRadius();
            double d = intersection.getCircleA().getCentre().calDistance(intersection.getCircleB().getCentre());
            if ((((r1 - r2) < d)) && ((d < (r1 + r2)))) {
                displayIntersectionArea();
            }

            new IntersectionDraw(intersection);
        }
    }

    private static void prompt()
    {
        //creates the Intersection object using the input values

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Coordinate of the centre point (x, y) and radius of the first circle");
        int x1 = input.nextInt();
        int y1 = input.nextInt();
        int r1 = input.nextInt();

        System.out.println("Enter the Coordinate of centre point (x, y) and radius of the second circle");
        int x2 = input.nextInt();
        int y2 = input.nextInt();
        int r2 = input.nextInt();

        Point p1 = new Point(x1,y1);
        Point p2 = new Point(x2,y2);
        Circle circle1 = new Circle(p1,r1);
        Circle circle2 = new Circle(p2,r2);

        intersection = new Intersection(circle1, circle2);

    }


    private static void displayCircleAreas()
    {
        Circle circle1 = intersection.getCircleA();
        Circle circle2 = intersection.getCircleB();

        double areaFirstCircle = circle1.calArea();
        double areaSecondCircle = circle2.calArea();

        System.out.printf("The area of the first circle is %.2f\n", areaFirstCircle);
        System.out.printf("The area of the second circle is %.2f\n", areaSecondCircle);
    }


    private static void displayIntersectionArea()
    {
        double areaOfIntersection = intersection.calIntersectionArea();

        System.out.printf("The intersection area of the two circle is %.2f\n", areaOfIntersection);

    }
}

class Intersection
{
    private  Circle circleA;
    private  Circle circleB;

    public Intersection(Circle circleA, Circle circleB)
    {
        this.circleA = circleA;
        this.circleB = circleB;
    }

    public Circle getCircleA()
    {
        return circleA;
    }

    public Circle getCircleB()
    {
        return circleB;
    }

    public double calIntersectionArea()
    {
        double r1 = circleA.getRadius();
        double r2 = circleB.getRadius();

        Point p1 = circleA.getCentre();
        Point p2 = circleB.getCentre();
        double d = p1.calDistance(p2);

        double d1 = (pow(r1, 2) - pow(r2, 2) + pow(d, 2)) / (2 * d);
        double d2 = (pow(r2, 2) - pow(r1, 2) + pow(d, 2)) / (2 * d);
        return (pow(r1, 2) * acos(d1 / r1)) - (d1 * sqrt(pow(r1, 2) - pow(d1, 2)))
             + (pow(r2, 2) * acos(d2 / r2)) - (d2 * sqrt(pow(r2, 2) - pow(d2, 2)));
    }

}

class Circle
{

    private Point centre;
    private double radius;

    public Circle(Point c1, double r1)
    {

        centre = c1;
        radius = r1;
        //r1 = IntersectionTest.prompt();
    }

    public Point getCentre()
    {
        return centre;
    }

    public double getRadius()
    {
        return this.radius;
    }

    public double calArea()
    {
        return (PI * pow(radius, 2));
    }
}

class Point
{
    private double x;
    private double y;

    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;

    }

    public double getX()
    {
        return this.x;
    }

    public double getY()
    {
        return this.y;
    }

    public double calDistance (Point p2)
    {
        double x2 = p2.getX();
        double y2 = p2.getY();

        double d = sqrt((pow(x - x2, 2)) + (pow(y - y2, 2)));
        return d;
    }
}
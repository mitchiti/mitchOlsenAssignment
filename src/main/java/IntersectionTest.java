import java.util.Scanner;
import static java.lang.Math.*;

class IntersectionTest
{
    private static Intersection intersection;

    public static void main(String[] args)
    {

        System.out.println("\n*** Intersection Area Calculation ***");
        System.out.println();

        prompt();

        displayCircleAreas();

        // if (r1-r2 < d < r1+r2)
        displayIntersectionArea();
    }

    private static void prompt()
    {
        //creates the Intersection object using the input values

        //IntersectionTest input = new IntersectionTest();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Coordinate of the centre point (x, y) and radius of the first circle");
        int x1 = input.nextInt();
//        keyboard.nextLine();
        int y1 = input.nextInt();
//        String val = input.nextLine();
        int r1 = input.nextInt();

        System.out.println("Enter the Coordinate of centre point (x, y) and radius of the second circle");
        int x2 = input.nextInt();
//        keyboard.nextLine();
        int y2 = input.nextInt();
//        keyboard.nextLine();
        int r2 = input.nextInt();
//
        Point p1 = new Point(x1,y1);
        Point p2 = new Point(x2,y2);
        //Circle radius = new Circle(r1,r2);
        Circle circle1 = new Circle(p1,r1);
        Circle circle2 = new Circle(p2,r2);
//        double area = circle1.calArea();

        intersection = new Intersection(circle1, circle2);

    }


    private static void displayCircleAreas()
    {
        //double areaFirstCircle;

        //Circle area = new Circle();
        //double areaFirstCircle = area.calArea(r1);
        //double areaSecondCircle = area.calArea(r2);

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

//    public Intersection()
//    {
//        Circle c1 = new Circle();
//        this(c1,c1);
//    }

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

        double d1 = ((pow(r1, 2)) - (pow(r2, 2)) + (pow(d, 2)) / 2 * d);
        double d2 = ((pow(r2, 2)) - (pow(r1, 2)) + (pow(d, 2)) / 2 * d);
        return ((Math.pow(r1, 2)) * (1 / Math.cos(d1 / r1)) - (d1 * (Math.sqrt((Math.pow(r1, 2))))) * (Math.pow(d1, 2)) + (Math.pow(r2, 2)) * (1 / Math.cos(d2 / r2)) - (d2 * (Math.sqrt((Math.pow(r2, 2))))) * (Math.pow(d2, 2)));
    }

}

class Circle
{

    private Point centre;
    private double radius;

//    public Circle()
//    {
//        Point p = new Point();
//        this(p,1);
//
//    }

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
//        //double areaSecondCircle;
//        //Circle area = new calArea();
//        //double r1 = radius;
//
//        IntersectionTest radius = new IntersectionTest(areaFirstCircle, areaSecondCircle);

//        double areaFirstCircle = (PI * pow(radius, 2));
//        double areaSecondCircle = (PI * pow(radius, 2));
        return (PI * pow(radius, 2));
    }
}

class Point
{
    private double x;
    private double y;

    public Point()
    {
        this(0,0);
    }

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
        // d = sqrt((pow(x1 - x2, 2) + (pow(y1 - y2, 2))
        // return d;
        // check if there two circles overlap

        double x2 = p2.getX();
        double y2 = p2.getY();

        double d = (sqrt((pow(x - x2, 2)) + (pow(y - y2, 2))));
        return d;
        //if (d > r1 + r2)
        //	System.out.println("The program has terminated due to no overlap of the two circles");
        //else if (d + r2 <= r1)
        //	System.out.println("The program has terminated due to circle two being entirely inside circle one. The area of intersection is the areasw of C2 = ");
        //else



    }
}
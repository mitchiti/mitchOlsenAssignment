package org.example;

import static java.lang.Math.*;

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
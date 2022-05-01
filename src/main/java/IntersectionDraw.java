import javax.swing.*;
import java.awt.*;

public class IntersectionDraw extends JFrame {

    Intersection intersection;
    double scale;

    public IntersectionDraw(Intersection intersection){
        this.intersection = intersection;
        setTitle("Display The Intersection");
        setCanvasSize();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Circle circleA = intersection.getCircleA();
        Circle circleB = intersection.getCircleB();
        double x1 = circleA.getCentre().getX();
        double y1 = circleA.getCentre().getY();
        double r1 = circleA.getRadius();
        double x2 = circleB.getCentre().getX();
        double y2 = circleB.getCentre().getY();
        double r2 = circleB.getRadius();


        g2d.drawOval((int)((x1) * scale + 25), (int)((y1) * scale + 50),
                (int)(r1 * 2 * scale), (int)(r1 * 2 * scale));
        g2d.drawOval((int)((x2) * scale + 25), (int)((y2) * scale + 50),
                (int)(r2 * 2 * scale), (int)(r2 * 2 * scale));

        g2d.drawString(String.format("The area of the first circle is %.2f", circleA.calArea()), 10,900);
        g2d.drawString(String.format("The area of the second circle is %.2f", circleB.calArea()), 10,920);
        g2d.drawString(String.format("The intersection area of the two circle is %.2f", intersection.calIntersectionArea()), 10, 940);

    }

    private void setCanvasSize(){
        double minX = Math.min(intersection.getCircleA().getCentre().getX() - intersection.getCircleA().getRadius(),
                intersection.getCircleB().getCentre().getX() - intersection.getCircleB().getRadius());
        double maxX = Math.max(intersection.getCircleA().getCentre().getX() + intersection.getCircleA().getRadius(),
                intersection.getCircleB().getCentre().getX() + intersection.getCircleB().getRadius());
        double minY = Math.min(intersection.getCircleA().getCentre().getY() - intersection.getCircleA().getRadius(),
                intersection.getCircleB().getCentre().getY() - intersection.getCircleB().getRadius());
        double maxY = Math.max(intersection.getCircleA().getCentre().getY() + intersection.getCircleA().getRadius(),
                intersection.getCircleB().getCentre().getY() + intersection.getCircleB().getRadius());

        scale = Math.min(800 / (maxX - minX), 800 / (maxY - minY));

        setSize(900,1200);

    }

    public static void main(String[] args) {

        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1);
        Circle circle1 = new Circle(p1,2);
        Circle circle2 = new Circle(p2,1);

        Intersection intersection = new Intersection(circle1, circle2);

        new IntersectionDraw(intersection);

    }
}
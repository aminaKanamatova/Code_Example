/*************************************************************************
 *  DO NOT MODIFY OR SUBMIT THIS FILE.
 *
 *  Taken from Section 3.2, An Introduction to Programming (in Java)
 *  by Robert Sedgewick and Kevin Wayne
 *
 *  Compilation:  javac -cp .:algs4.jar Point.java
 *  Execution:    java -cp .:algs4.jar Point < input.txt
 *
 *  Immutable data type for 2D points with floating-point coordinates.
 *
 *************************************************************************/
import edu.princeton.cs.algs4.*;

public class Point { 
    private final double x;   // Cartesian
    private final double y;   // coordinates
   
    // creates and initialize a point with given (x, y)
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
       returns the Euclidean distance between this point and that
       @param that Is the other point.
    */
    public double distanceTo(Point that) {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    // draws this point to standard drawing
    public void draw() {
        StdDraw.point(x, y);
    }

    /**
       Draws the line segment between the current object ant that to standard drawing.
       @param that Is the other point.
    */       
    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // returns a string representation of this point
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // reads in a TSP file and plots the points to standard drawing
    public static void main(String[] args) {

        // get dimensions
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.setPenRadius(0.005);

        // read in and plot points one at at time
        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            Point p = new Point(x, y);
            p.draw();
        }
    }
}

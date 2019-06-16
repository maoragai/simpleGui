import java.util.ArrayList;

/**
 * rectangle class declaration.
 */
class Rectangle {
    private Point upperLeft1;



    private double width1, height1;

    /**
     * Create a new rectangle with location and width/height.
     * @param upper the upper left Point of the rectangle
     * @param width the witdth of the rectangle
     * @param height the height of the rectangle
     */
    public Rectangle(Point upper, double width, double height) {
        upperLeft1 = upper;
        width1 = width;
        height1 = height;
    }

    /**
     * Return a (possibly empty) List of intersection points
     * with the specified line.
     * @param line the line with which the rectangle might intersect
     * @return array of points
     */
    public ArrayList<Point> intersectionPoints(Line line) {
        ArrayList<Point> list = new ArrayList<Point>();
        //declaring inner variables to simplify code
        double x = upperLeft1.getX();
        double y = upperLeft1.getY();
        //building 4 lines represent the 4 edged of the THIS rectangle
        Line bottom = new Line(x, y + height1, x + width1, y + height1);
        Line top = new Line(x, y, x + width1, y);
        Line left = new Line(x, y, x, y + height1);
        Line right = new Line(x + width1, y, x + width1, y + height1);
        //checking intersection with the edges
        //if a line intersects we shall add the intersection point
        //to the array
        if (line.isIntersecting(bottom)) {
            list.add(line.intersectionWith(bottom));
        }
        if (line.isIntersecting(top)) {
            list.add(line.intersectionWith(top));
        }
        if (line.isIntersecting(left)) {
            list.add(line.intersectionWith(left));
        }
        if (line.isIntersecting(right)) {
            list.add(line.intersectionWith(right));
        }
        if (list.size() == 0) {
            return null;
        }
        return list;

    }

    /**
     * Return the width and height of the rectangle.
     * @return the width of the rectangle
     */
    public double getWidth() {
        return this.width1;
    }

    /**
     * the width of the rectangle.
     * @return the width of the rectangle
     */
    public double getHeight() {
        return this.height1;
    }

    /**
     * Returns the upper-left point of the rectangle.
     * @return get the upperleft point of the rectangle
     */
    public Point getUpperLeft() {
        return upperLeft1;
    }

    public void setWidth1(double width1) {
        this.width1 = width1;
    }
}
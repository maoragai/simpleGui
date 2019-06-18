import java.util.ArrayList;


/**
 * line class declaration.
 */
public class Line {
    private Double infinity = Double.POSITIVE_INFINITY;
    private Double negInfinity = Double.NEGATIVE_INFINITY;

    /**
     * startpoint setter.
     *
     * @param start the point to set as startpoint
     */
    public void setStartPoint(Point start) {
        this.startPoint = start;
    }

    /**
     * endpoint setter.
     *
     * @param end the point to set as endpoint
     */
    public void setEndPoint(Point end) {
        this.endPoint = end;
    }

    private Point startPoint, endPoint;

    /**
     * Line constructor.
     *
     * @param start start point object
     * @param end   end point object
     */
    public Line(Point start, Point end) {
        startPoint = start;
        endPoint = end;
    }

    /**
     * Line constructor.
     *
     * @param x1 start point x position
     * @param y1 start point y position
     * @param x2 end point x position
     * @param y2 end point y position
     */
    public Line(double x1, double y1, double x2, double y2) {
        // Point startPoint, endPoint;
        this.startPoint = new Point(x1, y1);

        this.endPoint = new Point(x2, y2);
    }

    /**
     * gets the line's length.
     *
     * @return line 's length
     */
    public double length() {
        return startPoint.distance(endPoint);
    }

    /**
     * gets the middle point of the line.
     *
     * @return line 's middle point
     */
    public Point middle() {
        Point middlePoint = new Point((startPoint.getX() + endPoint.getX()) / 2,
                (startPoint.getY() + endPoint.getY()) / 2);
        return middlePoint;
    }

    /**
     * gets the line's start point object.
     *
     * @return line 's start point object
     */
    public Point getStartPoint() {

        return startPoint;
    }

    /**
     * gets the line's end point object.
     *
     * @return line 's end point object
     */
    public Point getEndPoint() {
        return endPoint;
    }

    /**
     * checks if two lines intersect.
     *
     * @param other line to check if this intersects with
     * @return true if intersect, false if doesn't
     */
    public boolean isIntersecting(Line other) {
        return intersectionWith(other) != null;
    }

    /**
     * returnst intersection point between two lines.
     *
     * @param other other line object
     * @return intersection Point object
     */
    public Point intersectionWith(Line other) {
        //finding line slopes
        double slopeLine1 = (this.endPoint.getY() - this.startPoint.getY())
                / (this.endPoint.getX() - this.startPoint.getX());
        double slopeLine2 = (other.endPoint.getY() - other.startPoint.getY())
                / (other.endPoint.getX() - other.startPoint.getX());
        //declaring intersection points
        double intersectionX;
        double line1YIntersection, line2YIntersection;
        double intersectionY;

        //building equations based on
        //y-y1=m*(x-x1)
        line1YIntersection = slopeLine1 * (-1) * this.startPoint.getX() + this.startPoint.getY();
        line2YIntersection = slopeLine2 * (-1) * other.startPoint.getX() + other.startPoint.getY();
        //finding intersection parameters
        intersectionX = (line2YIntersection - line1YIntersection) / (slopeLine1 - slopeLine2);
        intersectionY = slopeLine1 * intersectionX + line1YIntersection;
        //handling edge cases
        if (slopeLine1 == slopeLine2) {
            return null;
        }
        if ((slopeLine1 == infinity) || (slopeLine1 == negInfinity)) {
            intersectionX = this.startPoint.getX();
            intersectionY = slopeLine2 * intersectionX + line1YIntersection;
        }
        if ((slopeLine2 == infinity) || (slopeLine2 == negInfinity)) {
            intersectionX = other.startPoint.getX();
            intersectionY = slopeLine1 * intersectionX + line1YIntersection;
        }
        if (slopeLine1 == 0) {
            intersectionY = this.startPoint.getY();
        }
        if (slopeLine2 == 0) {
            intersectionY = other.startPoint.getY();
        }
        //checking if the point is within the range
        double maxY = Math.min(Math.max(this.startPoint.getY(), this.endPoint.getY()),
                Math.max(other.startPoint.getY(), other.endPoint.getY()));
        double maxX = Math.min(Math.max(this.startPoint.getX(), this.endPoint.getX()),
                Math.max(other.startPoint.getX(), other.endPoint.getX()));

        double minY = Math.max(Math.min(this.startPoint.getY(), this.endPoint.getY()),
                Math.min(other.startPoint.getY(), other.endPoint.getY()));
        double minX = Math.max(Math.min(this.startPoint.getX(), this.endPoint.getX()),
                Math.min(other.startPoint.getX(), other.endPoint.getX()));
        //in case the intersection Point parameters stand in the required terms
        //build and return the point
        if ((intersectionY <= maxY) && (intersectionY >= minY)
                && (intersectionX <= maxX) && (intersectionX >= minX)) {
            Point intersection = new Point(intersectionX, intersectionY);
            return intersection;
        } else {
            return null;
        }
    }

    /**
     * checks if two lines are the same line.
     *
     * @param other other line object
     * @return true ig the lines are equal, false if they aren't equal
     */
    public boolean equals(Line other) {
        //check if the points of the lines are equal or the line is flipped
        return this.startPoint.equals(other.startPoint) && this.endPoint.equals(other.endPoint)
                || this.startPoint.equals(other.endPoint) && this.endPoint.equals(other.startPoint);
    }

    /**
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     * has to be checked
     *
     * @param rect the rectangular shape that the line intersects with
     * @return closest point of intersection
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        double minLength;
        int minPos;

        ArrayList points = rect.intersectionPoints(this);
        if (points == null) {
            return null;
        }
        if (points.size() == 0) {
            return null;
        } else {
            //applying the distance of the bottom rectangle line
            //from the start point of the line
            minLength = this.startPoint.distance((Point) points.get(0));
            minPos = 0;
            //comparing finding the minimal distance from the startpoint of the line
            for (int i = 0; i < points.size(); i++) {
                if (this.startPoint.distance((Point) points.get(i)) < minLength) {
                    minLength = this.startPoint.distance((Point) points.get(i));
                    minPos = i;
                }
            }
            //returning the closest intersection point
            return (Point) points.get(minPos);
        }

    }


}
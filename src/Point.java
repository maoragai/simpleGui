/**
 * Point class declaration.
 */
public class Point {

    private double pointX;
    private double pointY;

    /**
     * point constructor.
     *
     * @param x point's x position
     * @param y point's y position
     */
    public Point(double x, double y) {
        pointX = x;
        pointY = y;
    }

    /**
     * returns the distance between two points.
     *
     * @param other other point object
     * @return the distance between the points
     */
    public double distance(Point other) {
        return Math.sqrt((other.getX() - pointX) * (other.getX() - pointX)
                + (other.getY() - pointY) * (other.getY() - pointY));
    }

    /**
     * checks if two points are equal.
     *
     * @param other other point object
     * @return true if the points are equal, false if arent
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        return (other.getX() == pointX) && (other.getY() == pointY);
    }

    /**
     * return points x position.
     *
     * @return points x position
     */
    public double getX() {
        return pointX;
    }

    /**
     * return points y position.
     *
     * @return points y position
     */
    public double getY() {
        return pointY;
    }

    /**
     * x setter.
     *
     * @param x the x value to set
     */
    public void setX(double x) {
        this.pointX = x;
    }

    /**
     * y setter.
     *
     * @param y the y value to set
     */
    public void setY(double y) {
        this.pointY = y;
    }
}
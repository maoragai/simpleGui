/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {


    private   double dx1, dy1;

    /**
     * Velocity object constructor.
     *
     * @param dx velocity in the x direction
     * @param dy velocity in the y direction
     */
    public Velocity(double dx, double dy) {
        dx1 = dx;
        dy1 = dy;
    }

    /**
     * converts polar velocity into direct velocity.
     *
     * @param angle angle of the velocity vector
     * @param speed size of the velocity vector
     * @return converted velocity object
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.cos(angle - 90);
        double dy = speed * Math.sin(angle - 90);
        return new Velocity(dx, dy);
    }

    /**
     * calculates the balls new position.
     *
     * @param p current ball position
     * @return new ball position
     */
    public Point applyToPoint(Point p) {
        p.setX(p.getX() + dx1); //= p.point_x + dx1;
        p.setY(p.getY() + dy1); //= p.point_y + dy1;
        return p;
    }

    /**
     * dx1 setter.
     * @return the dy velocity
     */
    public double getDx() {
        return dx1;
    }

    /**
     * set dx velocity.
     * @param dx the dx velocity to set
     */
    public void setDx(double dx) {
        this.dx1 = dx;
    }

    /**
     * dy getter.
     * @return the dy velocity
     */
    public double getDy() {
        return dy1;
    }

    /**
     * dy1 setter.
     * @param dy the dy to set
     */
    public void setDy(double dy) {
        this.dy1 = dy;
    }
}
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * Ball class .
 */
public class Ball implements Sprite {
    private Point place;
    private int radius;
    private Color color1;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;
    private int bottomBorder = 200, topBorder = 0, leftBorder = 0, rightBorder = 200;

    /**
     * comment. Ball constructor
     *
     * @param x     x position
     * @param y     y position
     * @param r     ball radius
     * @param color ball color
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        Point p = new Point(x, y);
        place = p;
        radius = r;
        color1 = color;
    }

    /**
     * Ball constructor.
     *
     * @param center Point object
     * @param r      radius
     * @param color  color
     */
    public Ball(Point center, int r, java.awt.Color color) {
        place = center;
        radius = r;
        color1 = color;
    }

    /**
     * get x position.
     *
     * @return x position
     */
    public double getX() {
        return this.place.getX();
    }

    /**
     * get y position.
     *
     * @return y position
     */
    public double getY() {
        return this.place.getY();
    }

    /**
     * get ball radius.
     *
     * @return ball radius
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * get ball color.
     *
     * @return ball color
     */
    public java.awt.Color getColor() {
        return this.color1;
    }


    /**
     * drawing the ball on specified drawSurface.
     *
     * @param surface the DrawSurface to Draw on
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(color1);
        surface.fillCircle((int) place.getX(), (int) place.getY(), radius);
        surface.setColor(Color.black);
        surface.drawCircle((int) place.getX(), (int) place.getY(), radius);

    }

    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * set Velocity for the ball.
     *
     * @param dx dx change in the velocity
     * @param dy dy change in the velocity
     */
    public void setVelocity(double dx, double dy) {
        Velocity v = new Velocity(dx, dy);
        velocity = v;
    }

    /**
     * set Ball borders which it should not cross.
     *
     * @param bottom bottom border
     * @param top    top Border
     * @param left   left border
     * @param right  right border
     */
    public void setBorders(int bottom, int top, int left, int right) {
        this.bottomBorder = bottom;
        this.topBorder = top;
        this.leftBorder = left;
        this.rightBorder = right;
    }

    /**
     * get velocity method.
     *
     * @return ball 's velocity object
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * set vilocity of the ball using Velocity object.
     *
     * @param v Velocity object
     */
    public void setVelocity(Velocity v) {
        velocity = v;
    }

    /**
     * changing the ball's position by 1 step.
     */
    public void moveOneStep() {
        //equation
        Line tarj = new Line(this.getX(), this.getY(),
                this.getX() + this.velocity.getDx() * rightBorder,
                this.getY() + this.velocity.getDy() * bottomBorder);
        CollisionInfo infor = this.gameEnvironment.getClosestCollision(tarj);
        tarj.setEndPoint(infor.getCollisionPoint());
        //ball hits right or left border
        if ((this.place.getX() != tarj.getEndPoint().getX())
                && (Math.abs(this.place.getX() - tarj.getEndPoint().getX()) <= Math.abs(this.velocity.getDx()))
                || (this.place.getY() != tarj.getEndPoint().getY())
                && (Math.abs(this.place.getY() - tarj.getEndPoint().getY()) <= Math.abs(this.velocity.getDy()))) {
            this.setVelocity(infor.getCollisionObject().hit(this, tarj.getEndPoint(), this.velocity));
        }
        this.place = this.getVelocity().applyToPoint(this.place);
    }

    /**
     * adds this ball to a certain GameEnvironment.
     *
     * @param g the GameEnvironment to join to
     */
    public void setGameEnvironment(GameEnvironment g) {
        this.gameEnvironment = g;
    }

    /**
     * adds this ball to a certain GameLevel.
     *
     * @param g the GameLevel to join to
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Remove from game.
     *
     * @param gameLevel the game level
     */
    public void removeFromGame(GameLevel gameLevel) {

        gameLevel.removeSprite(this);
    }

}
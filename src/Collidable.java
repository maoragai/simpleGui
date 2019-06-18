import biuoop.DrawSurface;

/**
 * collideable interface.
 */
public interface Collidable {
    /**
     * Return the "collision shape" of the object.
     *
     * @return rectangular shape of the collidable
     */
    Rectangle getCollisionRectangle();

    /**
     * // Notify the object that we collided with it at collisionPoint with
     * // a given velocity.
     * // The return is the new velocity expected after the hit (based on
     * // the force the object inflicted on us).
     *
     * @param hitter          the hitter
     * @param collisionPoint  the point that the collision occurred in
     * @param currentVelocity the velocity of the ball at the collision moment
     * @return new Velocity for the Ball
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

    /**
     * draw on the specified surface.
     *
     * @param surface specified surface to draw on
     */
    void drawOn(DrawSurface surface);
}
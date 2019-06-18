/**
 * collision info class declaration.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * collision info constructor.
     *
     * @param p the point of collision with an object
     * @param c the object the ball colliding with
     */
    public CollisionInfo(Point p, Collidable c) {
        this.collisionPoint = p;
        this.collisionObject = c;
    }

    /**
     * the point at which the collision occurs.
     *
     * @return the point at which the collision occurs.
     */
    public Point getCollisionPoint() {
        return this.collisionPoint;
    }

    /**
     * the collidable object involved in the collision.
     *
     * @return the collidable object involved in the collision.
     */
    public Collidable getCollisionObject() {
        return this.collisionObject;
    }
}
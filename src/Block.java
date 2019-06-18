import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Block class.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Color color1;
    private Rectangle shape;
    //initialized hit counter to value
    private int hitPoints = 1;
    private List<HitListener> hitListeners = new ArrayList<HitListener>();

    /**
     * Block constructor.
     *
     * @param rectangle the shape of the created Block
     */
    public Block(Rectangle rectangle) {
        this.shape = rectangle;
    }

    /**
     * Gets hit points.
     *
     * @return the hit points
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * set the hit counter number.
     *
     * @param hP number of hits to count.
     */
    public void setHitPoints(int hP) {
        this.hitPoints = hP;
    }

    /**
     * color getter.
     *
     * @return the color of this Block
     */
    public Color getColor1() {
        return color1;
    }

    /**
     * getter to the rectangular shape of the block.
     *
     * @return rectangular shape of the Block gonna be hit
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.shape;
    }

    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     *
     * @param collisionPoint  the Point of the collision
     * @param currentVelocity th current Ball velocity
     * @return the new Velocity
     */
    @Override
    public Velocity hit(Ball ball, Point collisionPoint, Velocity currentVelocity) {
        if (hitPoints != 0) {
            hitPoints--;
        }
        this.notifyHit(ball);

        if ((collisionPoint.getX() == shape.getUpperLeft().getX())
                || (collisionPoint.getX() == shape.getUpperLeft().getX() + shape.getWidth())) {
            currentVelocity.setDx((-1) * currentVelocity.getDx());
        }
        if ((collisionPoint.getY() == shape.getUpperLeft().getY())
                || (collisionPoint.getY() == shape.getUpperLeft().getY() + shape.getHeight())) {
            currentVelocity.setDy((-1) * currentVelocity.getDy());
        }
        return currentVelocity;
    }

    /**
     * set the Block color.
     *
     * @param color color to set for the Block
     */
    public void setColor(Color color) {
        this.color1 = color;
    }


    /**
     * drawing the ball on specified drawSurface.
     *
     * @param surface the DrawSurface to Draw on
     */
    public void drawOn(DrawSurface surface) {
        Rectangle r = this.shape;


        surface.setColor(color1);

        surface.fillRectangle((int) r.getUpperLeft().getX(), (int) r.getUpperLeft().getY(),
                (int) r.getWidth(), (int) r.getHeight());
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) r.getUpperLeft().getX(),
                (int) r.getUpperLeft().getY(), (int) r.getWidth(), (int) r.getHeight());
        surface.setColor(Color.LIGHT_GRAY);
        //if (hitPoints > 0) {
         //   surface.drawText((int) (r.getUpperLeft().getX() + (r.getWidth() / 2)),
          //          (int) (r.getUpperLeft().getY() + (r.getHeight() / 2)), Integer.toString(this.hitPoints), 25);
        //}
        //if (hitPoints == 0) {
          //  surface.drawText((int) (r.getUpperLeft().getX() + (r.getWidth() / 2)),
            //        (int) (r.getUpperLeft().getY() + (r.getHeight() / 2)), Character.toString('X'), 25);
        //}
    }

    /**
     * add this Block to a certain game.
     *
     * @param g the game to be added to
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * notify the sprite that time has passed.
     */
    public void timePassed() {
    }

    /**
     * Remove from game.
     *
     * @param gameLevel the game level
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    /**
     * Add hl as a listener to hit events.
     *
     * @param h the hit listener
     */
    @Override
    public void addHitListener(HitListener h) {
        hitListeners.add(h);
    }

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl the hit listener to remove
     */
    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }

    /**
     * called when this block is being hit.
     * @param hitter the ball that hits this block
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }


}

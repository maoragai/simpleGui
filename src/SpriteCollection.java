import biuoop.DrawSurface;

import java.util.ArrayList;

/**
 * splriteCollection decleration.
 */
public class SpriteCollection {
    private ArrayList<Sprite> sprites = new ArrayList<Sprite>();

    /**
     * add a specified sprite to the sprite collection.
     *
     * @param s the sprite to add to the colection.
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * remove a specific sprite.
     *
     * @param s the sprite to remove
     */
    public void removeSprite(Sprite s) {
        sprites.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     *
     * @param dt the amount of time since last call
     */
    public void notifyAllTimePassed(double dt) {
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).timePassed(dt);
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d the draw surface to draw on
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).drawOn(d);
        }
    }
}
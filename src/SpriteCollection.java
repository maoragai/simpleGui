import biuoop.DrawSurface;

import java.util.ArrayList;

/**
 * splriteCollection decleration.
 */
public class SpriteCollection {
    private ArrayList<Sprite> sprites = new ArrayList<Sprite>();

    /**
     * add a specified sprite to the sprite collection.
     * @param s the sprite to add to the colection.
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * remove a specific sprite.
     * @param s the sprite to remove
     */
    public void removeSprite(Sprite s) {
        sprites.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     * @param d the draw surface to draw on
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).drawOn(d);
        }
    }
}
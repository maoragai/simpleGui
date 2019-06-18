import java.util.ArrayList;

/**
 * GameEnvironment declaration.
 */
public class GameEnvironment {
    private ArrayList<Collidable> col = new ArrayList<>();

    /**
     * add the given collidable to the environment.
     *
     * @param c collidable to add
     */
    public void addCollidable(Collidable c) {
        col.add(c);
    }

    /**
     * Remove collifable.
     *
     * @param c the c
     */
    public void removeCollifable(Collidable c) {
        col.remove(c);
    }

    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory the direction line of the object
     * @return collision info object
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point closest;
        Point tempo;
        Collidable object;

        if (col.size() == 0) {
            return null;
        }
        //initializing the closest point
        closest = trajectory.closestIntersectionToStartOfLine(col.get(0).getCollisionRectangle());
        object = col.get(0);
        //finding the closest point wihing the co array
        for (int i = 0; i < col.size(); i++) {
            if (trajectory.closestIntersectionToStartOfLine(col.get(i).getCollisionRectangle()) != null) {
                tempo = trajectory.closestIntersectionToStartOfLine(col.get(i).getCollisionRectangle());
                if (closest == null) {
                    closest = tempo;
                    object = col.get(i);
                } else if (trajectory.getStartPoint().distance(tempo) < trajectory.getStartPoint().distance(closest)) {
                    closest = tempo;
                    object = col.get(i);
                }
            }

        }
        //return the found objects

        return new CollisionInfo(closest, object);
    }

}
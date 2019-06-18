import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.ArrayList;


/**
 * Passle class declaration.
 */
public class Paddle implements Sprite, Collidable {
    private Block paddleShape;
    private ArrayList<Block> section = new ArrayList<>();



    private int moveStep = 20;
    private biuoop.KeyboardSensor keyboard;
    private Block leftest, rightest;

    /**
     * constructor of the Paddle object.
     *
     * @param keyboard   keyboard object
     * @param paddleShap the block object to become the paddle
     */
    public Paddle(KeyboardSensor keyboard, Block paddleShap) {
        this.keyboard = keyboard;
        this.paddleShape = paddleShap;

        double sectionWidth = (paddleShape.getCollisionRectangle().getWidth()) / 5;
        double sectionHeight = paddleShape.getCollisionRectangle().getHeight();
        for (int i = 0; i < 5; i++) {
            Point p = new Point(this.paddleShape.getCollisionRectangle().getUpperLeft().getX()
                    + i * sectionWidth, this.paddleShape.getCollisionRectangle().getUpperLeft().getY());
            section.add(new Block(new Rectangle(p, sectionWidth, sectionHeight)));
            section.get(i).getCollisionRectangle().getUpperLeft().setX(
                    this.paddleShape.getCollisionRectangle()
                            .getUpperLeft().getX() + i * sectionWidth);
            section.get(i).getCollisionRectangle().getUpperLeft().setY(
                    this.paddleShape.getCollisionRectangle().getUpperLeft().getY());
        }

    }

    /**
     * moving the paddle position one left turn.
     */
    public void moveLeft() {
        for (int i = 0; i < 5; i++) {
            section.get(i).getCollisionRectangle().getUpperLeft().setX(
                    this.paddleShape.getCollisionRectangle().getUpperLeft().getX()
                            + i * (this.paddleShape.getCollisionRectangle().getWidth() / 5) - moveStep);
            section.get(i).getCollisionRectangle().getUpperLeft().setY(
                    this.paddleShape.getCollisionRectangle().getUpperLeft().getY());
        }
        this.paddleShape.getCollisionRectangle().getUpperLeft().setX(
                this.paddleShape.getCollisionRectangle().getUpperLeft().getX() - moveStep);
    }

    /**
     * moving the paddle position one right turn.
     */
    public void moveRight() {
        for (int i = 0; i < 5; i++) {
            section.get(i).getCollisionRectangle().getUpperLeft().setX(
                    this.paddleShape.getCollisionRectangle().getUpperLeft().getX()
                            + i * (this.paddleShape.getCollisionRectangle().getWidth() / 5) + moveStep);
            section.get(i).getCollisionRectangle().getUpperLeft().setY(
                    this.paddleShape.getCollisionRectangle().getUpperLeft().getY());
        }
        this.paddleShape.getCollisionRectangle().getUpperLeft().setX(
                this.paddleShape.getCollisionRectangle().getUpperLeft().getX() + moveStep);
    }

    /**
     * Sets move step.
     *
     * @param mS the move step
     */
    public void setMoveStep(int mS) {
        this.moveStep = mS;
    }
    /**
     * note the object that the time has passed.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * draw the object on a specified drawSurface.
     *
     * @param d specified drawSurface
     */
    public void drawOn(DrawSurface d) {
        Rectangle r = this.getCollisionRectangle();
        d.setColor(Color.yellow);
        d.fillRectangle((int) r.getUpperLeft().getX(),
                (int) r.getUpperLeft().getY(), (int) r.getWidth(), (int) r.getHeight());
        d.setColor(Color.black);
        d.drawRectangle((int) r.getUpperLeft().getX(),
                (int) r.getUpperLeft().getY(), (int) r.getWidth(), (int) r.getHeight());
    }

    /**
     * get the rectangular shape of the paddle.
     *
     * @return the rectangular shape of the paddle
     */
    public Rectangle getCollisionRectangle() {
        return this.paddleShape.getCollisionRectangle();
    }


    /**
     * .
     *@param b ball
     * @param collisionPoint  the point that the collision occurred in
     * @param currentVelocity the velocity of the ball at the collision moment
     * @return the new velocity for the ball
     */
    public Velocity hit(Ball b, Point collisionPoint, Velocity currentVelocity) {
        Rectangle shape;
        double originaldy = currentVelocity.getDy();
        double originaldx = currentVelocity.getDx();

        for (int i = 0; i < 5; i++) {
            shape = section.get(i).getCollisionRectangle();
            int hitFlag = 0;
            //
            if ((collisionPoint.getX() >= shape.getUpperLeft().getX())
                    && (collisionPoint.getX() <= shape.getUpperLeft().getX() + shape.getWidth())) {

                if ((collisionPoint.getY() >= shape.getUpperLeft().getY())
                        && (collisionPoint.getY() <= shape.getUpperLeft().getY() + shape.getHeight())) {
                    hitFlag = 1;
                    currentVelocity.setDy((-1) * currentVelocity.getDy());
                    if (i == 0) {
                        currentVelocity.setDx((-1 * 3));
                        currentVelocity.setDy((-1 * Math.sqrt(3)));
                    }
                    if (i == 4) {
                        currentVelocity.setDx(3);
                        currentVelocity.setDy(-1 * Math.sqrt(3));
                    }
                }
            }
            if (hitFlag == 1) {
                return currentVelocity;
            }

        }
        //  return currentVelocity;
        return currentVelocity;
    }

    /**
     * Add this paddle to the game.
     *
     * @param g the game to add this paddle to
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * Set paddle width.
     *
     * @param w the w
     */
    public void setPaddleWidth(int w) {
        this.paddleShape.getCollisionRectangle().setWidth1(w);
    }
}
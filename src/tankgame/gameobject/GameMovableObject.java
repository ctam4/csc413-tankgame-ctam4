package tankgame.gameobject;

import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.Math;

public abstract class GameMovableObject extends GameObject {
    protected int vx, vy, angle, offsetX, offsetY, maxX, maxY;

    protected GameMovableObject(BufferedImage image, int x, int y, int vx, int vy, int angle, int offsetX, int offsetY, int maxX, int maxY) {
        super(image, x, y);
        this.vx = vx;
        this.vy = vy;
        this.angle = angle;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public abstract void update();

    protected boolean validPosition(int x, int y) {
        return (x >= 0 && x < this.maxX - this.image.getWidth() && y >= 0 && y < this.maxY - this.image.getHeight());
    }

    @Override
    public void draw(Graphics g) {
        AffineTransform rotation = AffineTransform.getTranslateInstance(this.x + this.offsetX, this.y + this.offsetY);
        rotation.rotate(Math.toRadians(this.angle), this.image.getWidth() / 2.0, this.image.getHeight() / 2.0);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.image, rotation, null);
    }
}

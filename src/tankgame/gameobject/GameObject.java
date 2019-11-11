package tankgame.gameobject;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.Math;

import tankgame.Launcher;

public abstract class GameObject {
    protected Launcher app;

    protected BufferedImage image;
    protected int x, y;

    protected GameObject(Launcher app, BufferedImage image, int x, int y) {
        this.app = app;
        this.image = image;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.drawImage(this.image, this.x, this.y, (int) Math.round(this.image.getWidth() * this.app.getScale()), (int) Math.round(this.image.getHeight() * this.app.getScale()), null);
    }
}

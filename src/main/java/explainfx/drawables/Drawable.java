package explainfx.drawables;

import explainfx.panels.CanvasPanel;
import javafx.scene.Group;

public abstract class Drawable extends Group {

    private CanvasPanel canvasPanel;
    private float x, y;
    private float width, height;

    public Drawable(CanvasPanel canvasPanel, float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.canvasPanel = canvasPanel;

        this.setOnMouseEntered(e -> {
            canvasPanel.setSelectedDrawable(this);
        });
    }

    //----------Getters and setters-------------//

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

}

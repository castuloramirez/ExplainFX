package explainfx.panels;

import explainfx.ExplainFX;
import explainfx.drawables.Drawable;
import explainfx.managers.DrawableManager;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CanvasPanel extends Group {

    private ExplainFX explainFX;
    private DrawableManager drawableManager;

    private Canvas canvas;

    private double mouseX, mouseY;
    private Drawable selectedDrawable;

    private final int canvasSize = 3000;

    public CanvasPanel(ExplainFX explainFX, DrawableManager drawableManager) {
        this.explainFX = explainFX;
        this.drawableManager = drawableManager;
        this.setOnMouseMoved(e -> {
            mouseX = e.getX();
            mouseY = e.getY();

            System.out.println("Mouse Coords: " + mouseX + ", " + mouseY);
        });

        createUI();
        addComponent();
    }

    public void createUI() {
        canvas = new Canvas(canvasSize, canvasSize);
        this.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.ROYALBLUE);
        gc.fillRect(0, 0, 10005, 10050);
    }

    private void addComponent() {
        //this.getChildren().add(canvas);
    }

    public void setSelectedDrawable(Drawable drawable) {
        this.selectedDrawable = drawable;
    }

}

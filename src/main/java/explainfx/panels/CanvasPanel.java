package explainfx.panels;

import explainfx.ExplainFX;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CanvasPanel extends Group {

    private ExplainFX explainFX;

    private Canvas canvas;


    public CanvasPanel(ExplainFX explainFX) {
        this.explainFX = explainFX;
        

        createUI();
        addComponent();
    }

    public void createUI() {
        canvas = new Canvas(1200, 900);
        this.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.ROYALBLUE);
        gc.fillRect(0, 0, 10005, 10050);
    }

    private void addComponent() {


        //this.getChildren().add(canvas);
    }

}

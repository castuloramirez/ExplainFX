package explainfx.drawables;

import explainfx.panels.CanvasPanel;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Optional;

public class TextDrawable extends Drawable {

    private Text text;
    private CanvasPanel canvasPanel;

    public TextDrawable(CanvasPanel canvasPanel, double x, double y) {
        super(canvasPanel, x, y, 0, 0);

        this.canvasPanel = canvasPanel;

        this.setLayoutX(x);
        this.setLayoutY(y);

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Enter text");
        dialog.setHeaderText(null);
        dialog.setContentText("Text: ");

        Optional<String> input = dialog.showAndWait();
        String userInput = input.get();

        text = new Text(userInput);
        text.setFont(Font.font(text.getFont().getFamily(), canvasPanel.drawableSize * 5));

        this.getChildren().add(text);

        this.setOnMouseEntered(e -> {
            text.setStroke(hoveredColor);
            canvasPanel.setSelectedDrawable(this);
        });

        this.setOnMouseExited(e -> {
            text.setStroke(drawableColor);
            canvasPanel.setSelectedDrawable(null);
        });
    }

    public TextDrawable(CanvasPanel canvasPanel, double x, double y, String copiedText) {
        super(canvasPanel, x, y, 0, 0);
        this.canvasPanel = canvasPanel;

        this.setLayoutX(x);
        this.setLayoutY(y);

        text = new Text(copiedText);
        text.setFont(Font.font(text.getFont().getFamily(), canvasPanel.drawableSize * 5));

        this.setOnMouseEntered(e -> {
            text.setStroke(hoveredColor);
            canvasPanel.setSelectedDrawable(this);
        });

        this.setOnMouseExited(e -> {
            text.setStroke(drawableColor);
            canvasPanel.setSelectedDrawable(null);
        });

        this.getChildren().add(text);
    }

    public TextDrawable duplicate(double x, double y) {
        return new TextDrawable(canvasPanel, x, y, text.getText());
    }



}
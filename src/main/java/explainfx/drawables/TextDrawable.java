package explainfx.drawables;

import explainfx.panels.CanvasPanel;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Optional;

public class TextDrawable extends Drawable {

    private Text text;
    private CanvasPanel canvasPanel;

    public TextDrawable(String textdata, CanvasPanel canvasPanel, double x, double y) {
        super(canvasPanel, x, y, 0, 0);

        this.canvasPanel = canvasPanel;

        this.setLayoutX(x);
        this.setLayoutY(y);

        text = new Text(textdata);
        text.setFill(drawableColor);
        text.setFont(Font.font(text.getFont().getFamily(), canvasPanel.drawableSize * 5));

        this.getChildren().add(text);

        this.setOnMouseEntered(e -> {
            text.setFill(hoveredColor);
            canvasPanel.setSelectedDrawable(this);
        });

        this.setOnMouseExited(e -> {
            text.setFill(drawableColor);
            canvasPanel.setSelectedDrawable(null);
        });

        this.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                System.out.println("Text double click!");
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Enter text");
                dialog.setHeaderText(null);
                dialog.setContentText("Text: ");

                dialog.showAndWait();

                String updatedText = dialog.getResult();
                text.setText(updatedText);
            }
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
            text.setFill(hoveredColor);
            canvasPanel.setSelectedDrawable(this);
        });

        this.setOnMouseExited(e -> {
            text.setFill(drawableColor);
            canvasPanel.setSelectedDrawable(null);
        });

        this.getChildren().add(text);
    }

    public void update(double width, double height) {

        int factor = (int) (width + height) / 30;
        System.out.println(factor);

        text.setFont(Font.font(text.getFont().getFamily(), canvasPanel.drawableSize * factor));
    }

    public TextDrawable duplicate(double x, double y) {
        return new TextDrawable(canvasPanel, x, y, text.getText());
    }



}
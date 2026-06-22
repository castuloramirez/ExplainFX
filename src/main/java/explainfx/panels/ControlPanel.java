package explainfx.panels;

import explainfx.ExplainFX;
import explainfx.ui.CustomButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ControlPanel extends VBox {

    private ExplainFX explainFX;

    private HBox toolbox;
    private HBox propertyBox;

    public CustomButton viewModeButton, drawModeButton, textModeButton, squareModeButton, circleModeButton, clearButton;
    private Slider sizeSlider;
    private Label sliderLabel;
    private ColorPicker colorPicker;

    public ArrayList<Button> controlPanelButtons;
    public ControlPanel(ExplainFX explainFX) {
        this.explainFX = explainFX;

        this.setStyle("-fx-background-color: #141414;" +
                "-fx-background-radius: 20;" +
                "-fx-border-radius: 20;" +
                "-fx-border-color: rgba(80, 80, 80, 0.80);" +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 64, 0.3, 0, 6);");
        this.setMaxWidth(500);

        controlPanelButtons = new ArrayList<>(6);

        createUI();
        createListeners();
        addComponents();
    }

    public void createUI() {
        toolbox = new HBox(10);
        toolbox.setPadding(new Insets(0, 0, 10, 0));
        propertyBox = new HBox(10);

        viewModeButton = new CustomButton(this, "/cursor.png", "VIEW", "View mode (V)");
        drawModeButton = new CustomButton(this,"/marker.png", "DRAW", "Draw (D)");
        textModeButton = new CustomButton(this,"/text.png", "TEXT", "Text (T)");
        squareModeButton = new CustomButton(this,"/square.png", "SQUARE", "Square (S)");
        circleModeButton = new CustomButton(this,"/circle.png", "CIRCLE", "Circle (C)");
        clearButton = new CustomButton(this,"/clear_icon.png", "CLEAR","Clear all drawings");

        colorPicker = new ColorPicker();


        sizeSlider = new Slider(2, 20, 5);
        sizeSlider.setShowTickLabels(true);
        sizeSlider.setShowTickMarks(true);
        sizeSlider.setMajorTickUnit(4);
        sliderLabel = new Label("Stroke Size");

    }

    private void createListeners() {

        clearButton.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Clear canvas");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to clear all the drawings?");

            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) explainFX.getCanvasPanel().clearAllDrawables();
            });


        });

        colorPicker.setOnAction(e -> {
            explainFX.getCanvasPanel().setDrawableColor(colorPicker.getValue());
        });
    }

    public void addComponents() {
        toolbox.setAlignment(Pos.CENTER);
        toolbox.getChildren().add(viewModeButton);
        toolbox.getChildren().add(drawModeButton);
        toolbox.getChildren().add(textModeButton);
        toolbox.getChildren().add(squareModeButton);
        toolbox.getChildren().add(circleModeButton);
        toolbox.getChildren().add(clearButton);

        controlPanelButtons.add(viewModeButton);
        controlPanelButtons.add(drawModeButton);
        controlPanelButtons.add(textModeButton);
        controlPanelButtons.add(squareModeButton);
        controlPanelButtons.add(circleModeButton);

        VBox box = new VBox(5);
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(sliderLabel, explainFX.getCanvasPanel().strokeSizePreviewCircle);

        propertyBox.getChildren().add(box);
        propertyBox.getChildren().add(sizeSlider);
        propertyBox.setAlignment(Pos.CENTER);

        propertyBox.getChildren().add(new Label("Color: "));
        propertyBox.getChildren().add(colorPicker);

        this.setPadding(new Insets(20, 20, 20, 20));
        this.getChildren().add(toolbox);
        this.getChildren().add(propertyBox);
    }

    public ExplainFX getExplainFX() {
        return explainFX;
    }

}

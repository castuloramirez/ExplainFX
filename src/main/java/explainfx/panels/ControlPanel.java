package explainfx.panels;

import explainfx.ExplainFX;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ControlPanel extends VBox {

    private ExplainFX explainFX;

    private HBox toolbox;
    private HBox propertyBox;

    private Button normalButton, markerButton , textButton, squareButton, circleButton, clearButton;
    private Slider sizeSlider;
    private Label sliderLabel;
    private ColorPicker colorPicker;

    public ControlPanel(ExplainFX explainFX) {
        this.explainFX = explainFX;

        this.setStyle("-fx-background-color: #141414;" +
                "-fx-background-radius: 20;" +
                "-fx-border-radius: 20;" +
                "-fx-border-color: rgba(80, 80, 80, 0.80);" +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 64, 0.3, 0, 6);");
        this.setMaxWidth(500);

        createUI();
        createListeners();
        addComponents();
    }

    public void createUI() {
        toolbox = new HBox(10);
        toolbox.setPadding(new Insets(0, 0, 10, 0));
        propertyBox = new HBox(10);

        normalButton = createIconButton("/cursor.png", "Cursor mode");
        markerButton = createIconButton("/marker.png", "Draw");
        textButton = createIconButton("/text.png", "Add text");
        squareButton = createIconButton("/square.png", "Draw Square");
        circleButton = createIconButton("/circle.png", "Draw circle");
        clearButton = createIconButton("/clear_icon.png", "Clear all drawings");

        colorPicker = new ColorPicker();


        sizeSlider = new Slider(2, 15, 5);
        sizeSlider.setShowTickLabels(true);
        sizeSlider.setShowTickMarks(true);
        sizeSlider.setMajorTickUnit(2);
        sliderLabel = new Label("Stroke Size");

    }

    private void createListeners() {

        normalButton.setOnAction(e -> explainFX.getCanvasPanel().setDrawableState(CanvasPanel.DrawableState.NONE));

        markerButton.setOnAction(e -> {
            explainFX.getCanvasPanel().setDrawableState(CanvasPanel.DrawableState.STROKE);
        });


        textButton.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Enter text");
            dialog.setHeaderText(null);
            dialog.setContentText("Text: ");

            dialog.showAndWait();
            explainFX.getCanvasPanel().setInputTextData(dialog.getResult());
            explainFX.getCanvasPanel().setDrawableState(CanvasPanel.DrawableState.TEXT);
        });

        squareButton.setOnAction(e -> {
            explainFX.getCanvasPanel().setDrawableState(CanvasPanel.DrawableState.SHAPE_SQUARE);
        });

        circleButton.setOnAction(e -> {
            explainFX.getCanvasPanel().setDrawableState(CanvasPanel.DrawableState.SHAPE_CIRCLE);
        });

        sizeSlider.valueProperty().addListener(((observable, oldValue, newValue) -> {
            explainFX.getCanvasPanel().setDrawableSize(newValue.intValue());
        }));

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
        toolbox.getChildren().add(normalButton);
        toolbox.getChildren().add(markerButton);
        toolbox.getChildren().add(textButton);
        toolbox.getChildren().add(squareButton);
        toolbox.getChildren().add(circleButton);
        toolbox.getChildren().add(clearButton);

        propertyBox.getChildren().add(sliderLabel);
        propertyBox.getChildren().add(sizeSlider);
        propertyBox.setAlignment(Pos.CENTER);

        propertyBox.getChildren().add(new Label("Color: "));
        propertyBox.getChildren().add(colorPicker);

        this.setPadding(new Insets(20, 20, 20, 20));
        this.getChildren().add(toolbox);
        this.getChildren().add(propertyBox);
    }

    public Button createIconButton(String iconPath, String tooltipText) {
        Button button = new Button();
        button.setTooltip(new Tooltip(tooltipText));

        button.setMaxWidth(50);
        button.setMaxHeight(50);

        ImageView icon = new ImageView(new Image(String.valueOf(getClass().getResource(iconPath))));
        icon.setFitWidth(30);
        icon.setFitHeight(30);

        button.setGraphic(icon);

        return button;
    }

}

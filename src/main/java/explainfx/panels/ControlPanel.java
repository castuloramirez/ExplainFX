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

    private Button normalButton, markerButton , textButton, squareButton, circleButton, arrowButton;
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

        normalButton = createIconButton("/cursor.png");
        markerButton = createIconButton("/marker.png");
        textButton = createIconButton("/text.png");
        squareButton = createIconButton("/square.png");
        circleButton = createIconButton("/circle.png");

        colorPicker = new ColorPicker();


        sizeSlider = new Slider(2, 15, 5);
        sizeSlider.setShowTickLabels(true);
        sizeSlider.setShowTickMarks(true);
        sizeSlider.setMajorTickUnit(2);
        sliderLabel = new Label("Size");
    }

    private void createListeners() {

        normalButton.setOnAction(e -> explainFX.getCanvasPanel().setDrawableState(CanvasPanel.DrawableState.NONE));

        markerButton.setOnAction(e -> {
            explainFX.getCanvasPanel().setDrawableState(CanvasPanel.DrawableState.STROKE);
        });


        textButton.setOnAction(e -> {
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

        propertyBox.getChildren().add(sliderLabel);
        propertyBox.getChildren().add(sizeSlider);
        propertyBox.setAlignment(Pos.CENTER);

        propertyBox.getChildren().add(new Label("Color: "));
        propertyBox.getChildren().add(colorPicker);

        this.setPadding(new Insets(20, 20, 20, 20));
        this.getChildren().add(toolbox);
        this.getChildren().add(propertyBox);
    }

    public Button createIconButton(String iconPath) {
        Button button = new Button();
        button.setMaxWidth(50);
        button.setMaxHeight(50);

        ImageView icon = new ImageView(new Image(String.valueOf(getClass().getResource(iconPath))));
        icon.setFitWidth(35);
        icon.setFitHeight(35);

        button.setGraphic(icon);

        return button;
    }

}

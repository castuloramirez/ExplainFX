package explainfx.ui;

import explainfx.panels.CanvasPanel;
import explainfx.panels.ControlPanel;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CustomButton extends Button {

    private ControlPanel controlPanel;
    public String iconPath;
    public String function;
    public String tooltipText;

    public CustomButton(ControlPanel controlPanel, String iconPath, String function, String tooltipText) {

        this.controlPanel = controlPanel;
        this.iconPath = iconPath;

        this.setTooltip(new Tooltip(tooltipText));

        this.setStyle("-fx-background-color: #2d2d2d;");

        this.setMaxWidth(50);
        this.setMaxHeight(50);

        ImageView icon = new ImageView(new Image(String.valueOf(getClass().getResource(iconPath))));
        icon.setFitWidth(30);
        icon.setFitHeight(30);

        this.setGraphic(icon);

        this.setOnAction(e -> {

            for (Button currentButton : controlPanel.controlPanelButtons) currentButton.setStyle("-fx-background-color: #2d2d2d;");

            switch(function) {
                case "VIEW" -> {
                    this.setStyle("-fx-background-color: #20497a;");
                    controlPanel.getExplainFX().getCanvasPanel().setDrawableState(CanvasPanel.DrawableState.VIEW_MODE);
                }
                case "DRAW" -> {
                    this.setStyle("-fx-background-color: #207a47;");
                    controlPanel.getExplainFX().getCanvasPanel().setDrawableState(CanvasPanel.DrawableState.DRAW_MODE);
                }
                case "SQUARE" -> {
                    this.setStyle("-fx-background-color: #5c7a20;");
                    controlPanel.getExplainFX().getCanvasPanel().setDrawableState(CanvasPanel.DrawableState.SQUARE_MODE);
                }
                case "CIRCLE" ->  {
                    this.setStyle("-fx-background-color: #7a5220;");
                    controlPanel.getExplainFX().getCanvasPanel().setDrawableState(CanvasPanel.DrawableState.CIRCLE_MODE);
                }
                case "TEXT" -> {
                    this.setStyle("-fx-background-color: #70207a;");
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Enter text");
                    dialog.setHeaderText(null);
                    dialog.setContentText("Text: ");

                    dialog.showAndWait();
                    controlPanel.getExplainFX().getCanvasPanel().setInputTextData(dialog.getResult());
                    controlPanel.getExplainFX().getCanvasPanel().setDrawableState(CanvasPanel.DrawableState.TEXT_MODE);
                }
            }
        });
    }

}

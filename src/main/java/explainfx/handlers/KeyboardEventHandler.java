package explainfx.handlers;

import explainfx.panels.CanvasPanel;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyboardEventHandler {

    private CanvasPanel canvasPanel;

    public KeyboardEventHandler(CanvasPanel canvasPanel) {
        this.canvasPanel = canvasPanel;
    }

    public void handleKeyPressed(KeyEvent e) {

        switch (e.getCode()) {
            case KeyCode.V -> canvasPanel.explainFX.getControlPanel().viewModeButton.fire();
            case KeyCode.D -> canvasPanel.explainFX.getControlPanel().drawModeButton.fire();
            case KeyCode.S -> canvasPanel.explainFX.getControlPanel().squareModeButton.fire();
            case KeyCode.C -> canvasPanel.explainFX.getControlPanel().circleModeButton.fire();
            case KeyCode.T -> canvasPanel.explainFX.getControlPanel().textModeButton.fire();
        }

    }

}

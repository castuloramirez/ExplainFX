package explainfx.managers;

import explainfx.drawables.Drawable;

import java.util.ArrayList;

public class DrawableManager {


    public enum DrawableType{
        STROKE,
        TEXT,
        IMAGE,
        SHAPE_SQUARE,
        SHAPE_CIRCLE,
        SHAPE_ARROW
    }

    public ArrayList<Drawable> drawables;

    public DrawableManager() {
        drawables = new ArrayList<>(20);
    }

    public void createDrawable(DrawableType drawableType, float x, float y, float width, float height) {
        switch (drawableType) {
            case STROKE -> System.out.println("Stroke created");
            case TEXT -> System.out.println("Text created");
            case IMAGE -> System.out.println("Image created");
            case SHAPE_SQUARE -> System.out.println("Square created");
            case SHAPE_CIRCLE -> System.out.println("Circle created");
            case SHAPE_ARROW -> System.out.println("Arrow shape created");
        }
    }

}

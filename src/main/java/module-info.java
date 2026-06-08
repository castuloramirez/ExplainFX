module explainfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires atlantafx.base;
    requires java.desktop;


    opens explainfx to javafx.fxml;
    exports explainfx;
}
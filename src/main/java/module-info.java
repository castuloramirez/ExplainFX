module explainfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires atlantafx.base;


    opens explainfx to javafx.fxml;
    exports explainfx;
}
module assignment7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens assignment7 to javafx.fxml;
    exports assignment7;
}
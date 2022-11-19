module io.github.tlundcomputing.jeopardybutnot {
    requires javafx.controls;
    requires javafx.fxml;


    opens io.github.tlundcomputing.jeopardybutnot to javafx.fxml;
    exports io.github.tlundcomputing.jeopardybutnot;
}
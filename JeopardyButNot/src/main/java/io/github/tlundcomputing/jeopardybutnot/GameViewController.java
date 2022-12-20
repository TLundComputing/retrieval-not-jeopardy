package io.github.tlundcomputing.jeopardybutnot;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class GameViewController {

    @FXML
    private Label dataToShow;

    private ArrayList<String> recievedData;

    @FXML
    private void recieveData(){
        Stage stage = (Stage) dataToShow.getScene().getWindow();
        recievedData = (ArrayList<String>) stage.getUserData();
    }

    @FXML
    private void initialize(){
        recieveData();
        dataToShow.setText(Arrays.toString(recievedData.toArray()));
    }

}

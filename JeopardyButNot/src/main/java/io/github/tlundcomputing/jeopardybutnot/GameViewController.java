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

    public void setData(ArrayList<String> theData){
        recievedData = theData;
        dataToShow.setText(Arrays.toString(recievedData.toArray()));
    }

}

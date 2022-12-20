package io.github.tlundcomputing.jeopardybutnot;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class GameViewController {

    @FXML
    private Label dataToShow;
    @FXML
    private GridPane pane;

    private ArrayList<String> recievedData;

    public void setData(ArrayList<String> theData){
        recievedData = theData;
    }

    @FXML
    private void initialize(){
        Button[][] buttons = new Button[4][3];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j ++){
                buttons[i][j] = new Button();
                pane.add(buttons[i][j], i, j);
            }
        }
    }

}

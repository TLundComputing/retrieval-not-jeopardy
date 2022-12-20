package io.github.tlundcomputing.jeopardybutnot;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class GameViewController {


    @FXML
    private GridPane pane;

    Node[][] nodes = new Node[5][3];

    public void setData(ArrayList<String> theData){
        int step = 1;
        for(int i = 0; i < 3; i++){
            nodes[0][i] = new Label(theData.get(0).split(",")[step]);
            step += 2;
        }
        for(int row = 1; row < 5; row ++){
            step = 1;
            for(int column = 0; column < 3; column++){
                String[] data = theData.get(row).split(",");
                MyButton button = new MyButton(new String[]{data[0], data[step], data[step+1]});
                button.setOnAction(event -> button.processClick());
                nodes[row][column] = button;
                step += 2;
            }
        }
        for(int x = 0; x < 5; x++){
            for(int y = 0; y < 3; y++){
                pane.add(nodes[x][y], x, y);
            }
        }
    }

}

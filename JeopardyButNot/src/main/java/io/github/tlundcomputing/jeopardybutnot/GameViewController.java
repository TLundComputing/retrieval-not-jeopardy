package io.github.tlundcomputing.jeopardybutnot;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GameViewController {


    @FXML
    private GridPane pane;

    @FXML
    private Label title;

    Node[][] nodes;

    public void startGame(ArrayList<String> theData){
        nodes = new Node[5][3];

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

    public void startGrid(ArrayList<String> theData){
        nodes = new Node[4][3];
    }

    public void setData(ArrayList<String> theData){
        if(theData.get(0).split(",")[0].equalsIgnoreCase("difficulty")){
            startGrid(theData);
        } else if (theData.get(0).split(",")[0].equalsIgnoreCase("points")) {
            startGame(theData);
        } else {
            Alert box = new Alert(Alert.AlertType.ERROR);
            box.setHeaderText("Wrong Document!");
            box.setContentText("You have chosen an incompatible document. Go back and try again.");
            System.exit(0);
        }
    }

}

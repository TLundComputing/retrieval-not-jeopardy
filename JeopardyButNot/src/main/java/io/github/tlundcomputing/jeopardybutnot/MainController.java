package io.github.tlundcomputing.jeopardybutnot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class MainController {

    @FXML
    private Label title;

    private ArrayList<String> dataToSend;

    @FXML
    protected void getTemplate(){
        Alert infoBox = new Alert(Alert.AlertType.INFORMATION);
        infoBox.setTitle("Get the template");
        infoBox.setHeaderText("Getting the template");
        infoBox.setContentText("After this Dialog you will get to save the template. Once you have filled it out reupload it to the application using the \"Load Previous\" button.");
        infoBox.showAndWait();
        try {
            FileChooser choice = new FileChooser();
            choice.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV File", "*.csv"));
            File file = choice.showSaveDialog(title.getScene().getWindow());
            File template = new File(MainController.class.getResource("Game Template.csv").toURI());
            Files.copy(template.toPath(), file.toPath());
            infoBox.setAlertType(Alert.AlertType.INFORMATION);
            infoBox.setHeaderText("Success");
            infoBox.setContentText("Template Download is complete");
            infoBox.showAndWait();
        } catch(URISyntaxException | IOException | NullPointerException e){
            infoBox.setAlertType(Alert.AlertType.ERROR);
            infoBox.setHeaderText("Error");
            infoBox.setContentText("An error has occurred:\n" + e.getMessage());
            infoBox.showAndWait();
        }
    }

    @FXML
    protected void loadTemplate(){
        Alert loadInfo = new Alert(Alert.AlertType.INFORMATION);
        loadInfo.setTitle("Load up your completed Template");
        loadInfo.setHeaderText("Time to retrieve your template file");
        loadInfo.setContentText("In the next window navigate to and locate the template file you have completed.");
        loadInfo.showAndWait();
        try{
            FileChooser save = new FileChooser();
            save.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV File", "*.csv"));
            File template = save.showOpenDialog(title.getScene().getWindow());
            FileReader read = new FileReader(template);
            BufferedReader buff = new BufferedReader(read);
            Scanner scan = new Scanner(buff);
            ArrayList<String> data = new ArrayList<>();
            while(scan.hasNextLine()){
                data.add(scan.nextLine().trim());
            }
            buff.close();
            read.close();
            loadInfo.setHeaderText("Success");
            loadInfo.setContentText("Template upload is complete");
            loadInfo.showAndWait();
            dataToSend = data;
            sendData();
        } catch(IOException e){
            loadInfo.setAlertType(Alert.AlertType.ERROR);
            loadInfo.setHeaderText("Error");
            loadInfo.setContentText("An error has occured\n" + e.getMessage());
            loadInfo.showAndWait();
        }
    }

    protected void sendData(){
        Stage stage = (Stage) title.getScene().getWindow();
        stage.close();
        try{
            //stage.setUserData(dataToSend);
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("game-view.fxml"));
            Parent root = loader.load();
            GameViewController controller = loader.getController();
            controller.setData(dataToSend);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e){
            System.err.println(String.format("Error: %s", e.getMessage()));
            e.printStackTrace();
        }
    }

}
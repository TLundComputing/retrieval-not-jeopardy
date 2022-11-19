package io.github.tlundcomputing.jeopardybutnot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

public class MainController {

    @FXML
    private Label title;

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

}
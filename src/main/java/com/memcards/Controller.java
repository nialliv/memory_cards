package com.memcards;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.nio.file.Path;

public class Controller {
    FileChooser fileChooser = new FileChooser();
    ExcelFile excelFile = new ExcelFile();

    @FXML
    private MenuItem clearListItem;

    @FXML
    private Button forgotButton;

    @FXML
    private ListView<String> listView;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Button rememberButton;

    @FXML
    private Text translateText;

    @FXML
    private Text wordText;

    @FXML
    void clearListItemAction(ActionEvent event) {
        listView.getItems().clear();
    }

    @FXML
    void forgotButtonAction(ActionEvent event) {

    }

    @FXML
    void menuOpenFile(ActionEvent event) {
        Path path = fileChooser.showOpenDialog(new Stage()).toPath();
        excelFile.loadItems(path);
        listView.getItems().addAll(excelFile.getItems().keySet());
    }

    @FXML
    void rememberButtonAction(ActionEvent event) {

    }

    @FXML
    void menuSaveAs(ActionEvent event) {
        Path path = fileChooser.showSaveDialog(new Stage()).toPath();
        excelFile.writeItemsToFile(path);
    }

}

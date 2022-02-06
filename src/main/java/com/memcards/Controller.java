package com.memcards;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.nio.file.Path;
import java.util.Objects;

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
    private Button wordText;

    @FXML
    void clearListItemAction(ActionEvent event) {
        listView.getItems().clear();
    }

    @FXML
    void forgotButtonAction(ActionEvent event) {
        String tmp = listView.getItems().remove(0);
        listView.getItems().add(tmp);
        wordText.setText(listView.getItems().get(0));
    }

    @FXML
    void menuOpenFile(ActionEvent event) {
        Path path = fileChooser.showOpenDialog(new Stage()).toPath();
        excelFile.loadItems(path);
        listView.getItems().addAll(excelFile.getItems().keySet());
        wordText.setText(listView.getItems().get(0));
    }

    @FXML
    void rememberButtonAction(ActionEvent event) {
        listView.getItems().remove(0);
        wordText.setText(listView.getItems().get(0));
    }

    @FXML
    void menuSaveAs(ActionEvent event) {
        Path path = fileChooser.showSaveDialog(new Stage()).toPath();
        excelFile.writeItemsToFile(path, listView.getItems().toArray());
    }

    @FXML
    void showTranslate(ActionEvent event) {
        if (Objects.equals(wordText.getText(), listView.getItems().get(0))) {
            wordText.setText(excelFile.getItems().get(listView.getItems().get(0)));
        } else {
            wordText.setText(listView.getItems().get(0));
        }
    }

}

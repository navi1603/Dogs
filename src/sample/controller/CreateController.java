package sample.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.Data;
import sample.model.Dog;

@Data
public class CreateController {
    private Stage dialogStage;
    private Dog dog;

    @FXML
    private TextField nickName;

    @FXML
    private void ok() {
        if (nickName != null && !nickName.getText().isEmpty()) {
            dog.setName(new SimpleStringProperty(nickName.getText()));
            dialogStage.close();
        }
    }

    @FXML
    private void cansel() {
        dialogStage.close();
    }
}
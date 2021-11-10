package sample.controller;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Data;
import sample.AppFx;
import sample.model.Dog;


@Data
public class BaseController {

    @FXML
    private TableView <Dog> dogs;
    @FXML
    private TableColumn <Dog, String> nameList;
    @FXML
    private TextField name;
    @FXML
    private TextField breed;
    @FXML
    private TextField age;
    @FXML
    private TextField city;
    @FXML
    private TextField levelOfTraining;
    private AppFx appFX;


    @FXML
    private void initialize() {
       // nameList.setCellValueFactory(new PropertyValueFactory<Dog, String>("name"));
        nameList.setCellValueFactory(cellData ->  cellData.getValue().getName());

        dogs.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDogsInformation((Dog) newValue));
    }

    public void setAppFX(AppFx appFX) {
        this.appFX = appFX;
        dogs.setItems(appFX.getListDog());
    }

    private void showDogsInformation(Dog dog) {
        if (dog != null) {
            name.setText(dog.getName() != null ? dog.getName().getValue() : null);
            breed.setText(dog.getBreed() != null ? dog.getBreed().getValue() : null);
            age.setText(dog.getAge() != null ? String.valueOf(dog.getAge().get()) : null);
            city.setText(dog.getCity() != null ? dog.getCity().getValue() : null);
            levelOfTraining.setText(dog.getLevelOfTraining() != null ? String.valueOf(dog.getLevelOfTraining().get()) : null);
        } else {
            name.setText("");
            breed.setText("");
            age.setText("");
            city.setText("");
            levelOfTraining.setText("");
        }
    }
    @FXML
    private void delete() {
        int selectedIndex = dogs.getSelectionModel().getSelectedIndex();
        dogs.getItems().remove(selectedIndex);
    }

    @FXML
    private void edit() {
        int selectedIndex = dogs.getSelectionModel().getSelectedIndex();
        dogs.getItems().set(selectedIndex, new Dog(name.getText(), breed.getText(), Integer.valueOf(age.getText()), city.getText(), Integer.valueOf(levelOfTraining.getText())));
    }

    @FXML
    private void create() {
        Dog someDog = new Dog();
        appFX.showCreateWindow(someDog);
        if (someDog.getName() != null && !someDog.getName().getValue().isEmpty()) {
            appFX.getListDog().add(someDog);
        }
    }
}

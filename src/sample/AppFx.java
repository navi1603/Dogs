package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import sample.controller.BaseController;
import sample.controller.CreateController;
import sample.model.Dog;

import java.io.IOException;
import java.io.InputStream;

@Data
@EqualsAndHashCode(callSuper = false)
public class AppFx extends Application {

    private Stage primaryStage;
    private AnchorPane rootLayout;
    private ObservableList listDog = FXCollections.observableArrayList();

    public AppFx() {
        listDog.add(new Dog("Fluffy", "Pug", 8, "Odessa", 2));
        listDog.add(new Dog("Archie", "Poodle", 3, "Lviv", 6));
        listDog.add(new Dog("Willie", "Bulldog", 5, "Kiev", 4));
        listDog.add(new Dog("Hector", "Shepherd", 9, "Minsk", 6));
        listDog.add(new Dog("Duncan", "Dachshund", 1, "Hogwarts", 9));
    }

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Dogs application");
        showBaseWindow();
    }

    public void showBaseWindow() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AppFx.class.getResource("/maket/rootWindow.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            InputStream iconStream = getClass().getResourceAsStream("/icons/someImage.png");
            Image image = new Image(iconStream);
            primaryStage.getIcons().add(image);
            BaseController controller = loader.getController();
            controller.setAppFX(this);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCreateWindow(Dog dog) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AppFx.class.getResource("/maket/new.fxml"));
            AnchorPane page = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Wow Wow Wow");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            dialogStage.setScene(new Scene(page));
            CreateController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setDog(dog);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




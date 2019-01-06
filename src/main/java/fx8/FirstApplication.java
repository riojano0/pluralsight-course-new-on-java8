package fx8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FirstApplication extends Application {

    //Stage: Top Level Window
    //Scene: A stage must hold a scene, a scene must reside in a stage
    //A Scene holds all the graphical components, shapes, etc

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label message = new Label("Hello World");
        message.setFont(new Font(100));
        Label message2 = new Label("Hello World");
        message2.setFont(new Font(50));

        VBox vBox = new VBox(message, message2);


        primaryStage.setScene(new Scene(vBox));
        primaryStage.setTitle("Hello");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

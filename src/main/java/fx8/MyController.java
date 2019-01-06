package fx8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MyController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void okAction(ActionEvent event) {
        System.out.println("Clicked Ok");
        System.out.println("Username = " + username.getText());
        System.out.println("Password = " + password.getText());
    }

    public void cancelAction(ActionEvent event) {
        System.out.println("Clicked Cancel");
        username.setText("");
        password.setText("");
    }
}

package sample.Controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class ControllerRegistration {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button registrationButton;

    @FXML
    private CheckBox checkBoxAdminRegistration;

    @FXML
    private TextField userName;

    @FXML
    void initialize() {

        ConnectionDateBase dbConnection = new ConnectionDateBase();

        registrationButton.setOnAction(actionEvent -> {
            User user = new User();
            user.setLogin(loginField.getText());
            user.setPassword(passwordField.getText());
            user.setName(userName.getText());
            user.setAdmin_status(checkBoxAdminRegistration.isSelected());
            try {
                dbConnection.registerUser(user);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }
}

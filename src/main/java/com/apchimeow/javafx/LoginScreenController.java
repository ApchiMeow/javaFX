package com.apchimeow.javafx;

import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class LoginScreenController {

    @FXML
    public static Label info;

    private Main main = new Main();
    @FXML
    private Button loginBtnLogin;
    @FXML
    private TextField loginTextField;
    @FXML
    private PasswordField loginPasswordField;
    @FXML
    public void initialize(){
        loginBtnLogin.setOnAction(new EventHandler< ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                main.loginValidate(loginTextField.getText(), loginPasswordField.getText());
                info.setText("Hello, World.");
            }
        });
    }
}

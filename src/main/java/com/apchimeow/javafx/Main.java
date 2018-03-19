package com.apchimeow.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {

    @FXML
    private Label info;

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
                loginValidate(loginTextField.getText(), loginPasswordField.getText());
            }
        });
    }

//    public TextField getLoginTextField() {
//        return loginTextField;
//    }

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://darthkiler.xyz/u536919158_jywer";

    private static final String USER = "u536919158_qejyp";
    private static final String PASS = "010203qWe";

    private static Connection conn = null;

    private static Stage window = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{
        boolean connectionToBd = false;
        System.out.println("Делаем интерфейс window...");
        Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
        window.setTitle("LogIn");
        Scene loginScreenScene = new Scene(root, 250, 350);
        window.setScene(loginScreenScene);
        window.setResizable(false);
        window.centerOnScreen();
        System.out.println("Показываем интерфейс window.");
        window.show();
        while (!connectionToBd) {
            try {
                //Register JDBC driver
                Class.forName(JDBC_DRIVER);

                //STEP 3: Open a connection
                System.out.println("Подключаемся к БД...");
                info.setText("Подключение...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Подключено к БД.");
                info.setText("Подключение готово!");
                connectionToBd = true;

            } catch (SQLException e) {
                //Handle errors for JDBC
                info.setText("Ошибка подключения.");
                e.printStackTrace();
            }

        }
    }

    @FXML
    public void mainWindow() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/imagetest.fxml"));
        window.setTitle("Game");
        window.setScene(new Scene(root, 640, 480));
        window.setResizable(false);
        window.centerOnScreen();
        window.show();
    }

    @FXML
    public void loginValidate(String loginTextField, String loginPasswordField){
        try {
            //STEP 4: Execute a query
            System.out.println("Делаем запрос на валидность данных...");
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT name, pass FROM users WHERE name LIKE '" + loginTextField + "' AND pass LIKE '" + loginPasswordField + "';";
            System.out.println("Получили данные с сервера.");
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Проверяем на совпадение...");
            while (rs.next()) {
                //Retrieve by column name
                String name = rs.getString("name");
                String pass = rs.getString("pass");
                if (name.equals(loginTextField)) {
                    if (pass.equals(loginPasswordField)) {
                        System.out.println("Есть совпадение");
//                        info.setText("Привет, " + getLoginTextField().getText());
                        try {
                            System.out.println("Открываем новое окно и закрываем подключение к БД");
                            mainWindow();
                            stmt.close();
                            conn.close();
                            try{
                                if(stmt!=null)
                                    stmt.close();
                            }catch(SQLException se2){
                            }// nothing we can do
                            try{
                                if(conn!=null)
                                    conn.close();
                            }catch(SQLException se){
                                se.printStackTrace();
                            }
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
                if (!(name.equals(loginTextField))) {
                    System.out.println("Имя не найдено");
                }
                if (!(pass.equals(loginPasswordField))) {
                    System.out.println("Пароль не найден");
                }
            }
            rs.close();
//            stmt.close();
//            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

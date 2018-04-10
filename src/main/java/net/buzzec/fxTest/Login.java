package net.buzzec.fxTest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;

public class Login extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("JavaFX Welcome");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25));

        Text sceneTitle = new Text("Welcome");
        sceneTitle.setId("welcome-text");
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label username =  new Label("Username");
        grid.add(username, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label password = new Label("Password");
        grid.add(password, 0, 2);

        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 2);

        final Text actionTarget = new Text();
        actionTarget.setId("action-target");
        grid.add(actionTarget, 1, 6);

        Button button = new Button("Sign in");
        button.setOnAction(event -> {
            actionTarget.setText("Sign in button pressed");
        });
        HBox hBoxButton = new HBox(10);
        hBoxButton.setAlignment(Pos.BOTTOM_RIGHT);
        hBoxButton.getChildren().add(button);
        grid.add(hBoxButton, 1, 4);

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);

        URL css = getClass().getResource("login.css");
        assert css != null;
        scene.getStylesheets().add(css.toExternalForm());

//        primaryStage.initModality(Modality.APPLICATION_MODAL);

        primaryStage.showAndWait();
    }
}
